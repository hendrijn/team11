package gui;

import java.awt.event.*;

import javax.swing.AbstractButton;
import javax.swing.JLabel;

import operations.*;

/**
 * Handles all button functionalities.
 * 
 * @author Jacquelyn Hendricks
 * @version March 23 2021
 */
public class InterfaceController
    implements Finals, ActionListener, KeyListener, MouseListener, FocusListener
{
  private TempContext context = null;
  private String operator = EMPTY;
  private String firstOperand = EMPTY;
  private String secondOperand = EMPTY;
  private String result = EMPTY;

  private boolean shownError = false;

  /**
   * Handles soft button operations.
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    AbstractButton button = (AbstractButton) e.getSource();

    try
    {
      Integer.parseInt(button.getText());
      handleInput(button.getText());
    }
    catch (Throwable t)
    {
      switch (button.getText())
      {
        case RESET:
          resetInterface();
          break;
        case CLEAR:
          ui.getInputLabel().setText(HTML);
          break;
        case ADD:
          handleOperators(ADD);
          break;
        case SUBTRACT:
          handleOperators(SUBTRACT);
          break;
        case MULTIPLY:
          handleOperators(MULTIPLY);
          break;
        case DIVIDE:
          handleOperators(DIVIDE);
          break;
        case HTML + I:
          handleInput(I);
          break;
        case EQUALS:
          try
          {
            equalsButtonHandling(ui);
          }
          catch (NullPointerException nullP)
          {
            firstOperand = EMPTY;
            ui.errorMessage("Please input two valid operands.");
            resetInterface();
          }
          break;
        case DECIMAL:
          handleInput(DECIMAL);
          break;
        case LPAREN:
          handleInput(LPAREN);
          break;
        case RPAREN:
          handleInput(RPAREN);
          break;
        case BACKSPACE:
          String text = ui.getInputLabel().getText();

          // to cover cases when the user backspaces without typing anything
          if (text.length() > HTML.length())
          {
            text = text.substring(0, text.length() - 1);
            ui.getInputLabel().setText(text);
          }
          break;
        case SIGN:
          JLabel input = ui.getInputLabel();
          String in = input.getText();
          handleSign(in);
          break;
        default:
          closeApplication();

      }
    }

  }

  /**
   * Handles when something is typed.
   */
  @Override
  public void keyTyped(KeyEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    System.out.println("you typed");
    char keyChar = e.getKeyChar();
    String keyText = Character.toString(keyChar);
    System.out.println(keyText);
    System.out.println(keyChar);
    try
    {
      Integer.parseInt(keyText);
      handleInput(keyText);
    }
    catch (Throwable t)
    {
      if (e.getKeyChar() == '\n')
      {
        try
        {
          equalsButtonHandling(ui);
        }
        catch (NullPointerException nullP)
        {
          firstOperand = EMPTY;
          ui.errorMessage("Please input two valid operands.");
          resetInterface();
        }
      }
      else
      {
        switch (keyText)
        {
          case ADD:
            handleOperators(ADD);
            break;
          case SUBTRACT:
            handleOperators(SUBTRACT);
            break;
          case PMULTIPLY:
            handleOperators(MULTIPLY);
            break;
          case PDIVIDE:
            handleOperators(DIVIDE);
            break;
          case "i":
            handleInput(I);
            break;
          case DECIMAL:
            handleInput(DECIMAL);
            break;
          case LPAREN:
            handleInput(LPAREN);
            break;
          case RPAREN:
            handleInput(RPAREN);
            break;
          default:
        }
      }

    }
  }

  /**
   * closeApplication - handle all tasks at application close.
   */
  private void closeApplication()
  {
    System.exit(0);
  }

  /**
   * A private helper method for dealing with equalsButtonHandling.
   * 
   * @param ui
   *          The ui of the entire rimplex program.
   */
  private void equalsButtonHandling(NewMainInterface ui)
  {
    HistoryDisplay history = HistoryDisplay.getInstance();
    JLabel exLabel = ui.getExpressionLabel();
    secondOperand = removeFormatting(ui.getInputLabel().getText());

    try
    {
      result = context.evaluate(firstOperand, secondOperand);
      ui.getInputLabel().setText(HTML);
      exLabel.setText(exLabel.getText() + replaceFormatting(secondOperand) + SP + EQUALS);
      ui.getResultLabel().setText(replaceFormatting(result));
      shownError = false;
      history.addCalculation(firstOperand + operator + secondOperand + EQUALS + result);
    }
    catch (IllegalArgumentException e)
    {
      System.out.println(firstOperand + "\t" + secondOperand);
      ui.errorMessage(e.getMessage());
      result = "";
      shownError = true;
    }
    finally
    {
      firstOperand = EMPTY;
      secondOperand = EMPTY;
    }
    if (shownError)
    {
      resetInterface();
    }
    else
    {
      shownError = false;
    }
  }

  /**
   * Helper method to change sign of a number.
   * 
   * @param input
   *          the number to change
   */
  private void handleSign(String input)
  {
    String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "i", ")"};
    NewMainInterface ui = NewMainInterface.getInstance();
    JLabel inLabel = ui.getInputLabel();
    String actual = removeFormatting(input);

    for (int i = 0; i < nums.length; i++)
    {
      if (actual.endsWith(nums[i]))
      {
        String change = operations.SignChangeOperator.changeSign(actual);
        inLabel.setText(replaceFormatting(change));
        break;
      }
    }
  }

  private void handleOperators(String operation)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    JLabel exLabel = ui.getExpressionLabel();
    JLabel inLabel = ui.getInputLabel();
    JLabel resLabel = ui.getResultLabel();

    // handles the input label if in paren
    if (inParentheses(inLabel.getText()))
    {
      handleInput(operation);
      System.out.println("in Parentheses");
      return;
    }
    else
    {
      if (!inLabel.getText().equals(HTML)) // takes user input as firstOperand
      {
        firstOperand = removeFormatting(inLabel.getText());
        updateDisplayWithOperator(operation, ui, exLabel, inLabel, resLabel);
      }
      else if (!result.equals(EMPTY))// takes prev result as firstOperand
      {
        firstOperand = "(" + result + ")";
        updateDisplayWithOperator(operation, ui, exLabel, inLabel, resLabel);
      }
      else
      {
        ui.errorMessage("No previous result");
        resetInterface();
      }
    }
  }

  /**
   * Actually performs the operation handling.
   * 
   * @param operation
   *          the operator
   * @param ui
   *          the interface
   * @param exLabel
   *          the expression label
   * @param inLabel
   *          the input label
   * @param resLabel
   *          the results label
   */
  private void updateDisplayWithOperator(String operation, NewMainInterface ui, JLabel exLabel,
      JLabel inLabel, JLabel resLabel)
  {
    operator = operation; //assigns the indicated operation to the class variable

    switch (operation)
    {
      case ADD:
        context = new TempContext(new AdditionOperator());
        exLabel.setText(replaceFormatting(firstOperand) + SP + operation + SP);
        inLabel.setText(HTML);
        resLabel.setText(HTML);
        break;
      case SUBTRACT:
        context = new TempContext(new SubtractionOperator());
        exLabel.setText(replaceFormatting(firstOperand) + SP + operation + SP);
        inLabel.setText(HTML);
        resLabel.setText(HTML);
        break;
      case MULTIPLY:
        context = new TempContext(new MultiplicationOperator());
        exLabel.setText(replaceFormatting(firstOperand) + SP + operation + SP);
        inLabel.setText(HTML);
        resLabel.setText(HTML);
        break;
      case DIVIDE:
        context = new TempContext(new DivisionOperator());
        exLabel.setText(replaceFormatting(firstOperand) + SP + operation + SP);
        resLabel.setText(HTML);
        inLabel.setText(HTML);
        break;
      default:
        ui.errorMessage("Not a valid operator");
    }
  }

  /**
   * Adds soft or physical keyboard input to the display.
   */
  private void handleInput(String input)
  {
    NewMainInterface ui = NewMainInterface.getInstance();

    String displayText = ui.getInputLabel().getText();
    switch (input)
    {
      case I:
        ui.getInputLabel().setText(displayText + I);
        break;
      default:
        ui.getInputLabel().setText(displayText + input);
        break;

    }
  }

  /**
   * Overrites any html formatting with the correct values for storing.
   * 
   * @param input
   *          the string to change
   * @return the input without html formatting
   */
  private String removeFormatting(String input)
  {
    String newString = EMPTY;
    newString = input.replace(HTML, EMPTY);
    newString = newString.replace(I, "i");
    return newString;
  }

  /**
   * Overrites any html formatting with the correct values for calculations.
   * 
   * @param input
   *          the string to change
   * @return the input without html formatting
   */
  private String replaceFormatting(String input)
  {
    String newString = HTML;
    newString = newString + input.replace("i", I);
    System.out.println(newString);
    return newString;
  }

  private void resetInterface()
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    context = null;
    firstOperand = EMPTY;
    secondOperand = EMPTY;
    result = EMPTY;
    ui.getInputLabel().setText(HTML);
    ui.getExpressionLabel().setText(HTML);
    ui.getResultLabel().setText(HTML);
  }

  /**
   * Takes a String and returns true if there are more open brackets than closed brackets.
   * 
   * @param input
   *          the String to search
   * @return true if there are more open brackets, false if not
   */
  public static boolean inParentheses(String input)
  {
    int left = 0;
    int right = 0;
    for (int i = 0; i < input.length(); i++)
    {
      if (input.charAt(i) == '(')
        left++;
      else if (input.charAt(i) == ')')
        right++;
    }
    if (left > right)
      return true;

    return false;
  }

  @Override
  public void focusLost(FocusEvent e)
  {
    // TODO Auto-generated method stub
    NewMainInterface ui = NewMainInterface.getInstance();
    ui.getInputLabel().requestFocusInWindow();
  }

  @Override
  public void focusGained(FocusEvent e)
  {
    // TODO Auto-generated method stub
    NewMainInterface ui = NewMainInterface.getInstance();
    ui.getInputLabel().requestFocusInWindow();
  }

  // ----------------- Unimplemented -------------//
  @Override
  public void keyPressed(KeyEvent e)
  {
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseClicked(MouseEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void mousePressed(MouseEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e)
  {
    // TODO Auto-generated method stub

  }

}
