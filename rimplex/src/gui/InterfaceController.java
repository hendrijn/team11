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
public class InterfaceController implements Finals, ActionListener, KeyListener
{
  private TempContext context = null;

  private String firstOperand = EMPTY;
  private String secondOperand = EMPTY;
  private String result = EMPTY;

  private boolean shownError = false;

  /**
   * Handles all button operations.
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
        default:
          closeApplication();

      }
    }

  }

  /**
   * Handles when something is typed in the text box.
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
      switch (keyText)
      {
        case ADD:
          if (inParentheses(ui.getInputLabel().getText()))
          {

          }
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
        case EQUALS:

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
    JLabel exLabel = ui.getExpressionLabel();
    secondOperand = ui.getInputLabel().getText().replace(HTML, EMPTY);

    try
    {
      result = context.evaluate(firstOperand, secondOperand);
      ui.getInputLabel().setText(HTML);
      exLabel.setText(exLabel.getText() + secondOperand + SP + EQUALS);
      ui.getResultLabel().setText(result);
      shownError = false;
    }
    catch (IllegalArgumentException e)
    {
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

  private void handleOperators(String operation)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    // not working
    if (inParentheses(ui.getInputLabel().getText()))
    {
      handleInput(operation);
      System.out.println("in Parentheses");
      return;
    }
    JLabel exLabel = ui.getExpressionLabel();
    JLabel inLabel = ui.getInputLabel();
    JLabel resLabel = ui.getResultLabel();

    System.out.println("inLabel text: " + inLabel.getText());
    if (inParentheses(inLabel.getText()))
    {
      inLabel.setText(ui.getInputLabel().getText() + operation);
    }
    else // this is the running calc section. All that doesn't work is ending rn
    {
      if (result.equals(EMPTY)) // takes user input as firstOperand
      {
        firstOperand = inLabel.getText().replace(HTML, EMPTY);
      }
      else // takes prev result as firstOperand
      {
        firstOperand = result;
      }
    }
    switch (operation)
    {
      case ADD:
        context = new TempContext(new AdditionOperator());
        exLabel.setText(HTML + firstOperand + SP + operation + SP);
        inLabel.setText(HTML);
        resLabel.setText(HTML);
        break;
      case SUBTRACT:
        context = new TempContext(new SubtractionOperator());
        exLabel.setText(HTML + firstOperand + SP + operation + SP);
        inLabel.setText(HTML);
        resLabel.setText(HTML);
        break;
      case MULTIPLY:
        context = new TempContext(new MultiplicationOperator());
        exLabel.setText(HTML + firstOperand + SP + operation + SP);
        inLabel.setText(HTML);
        resLabel.setText(HTML);
        break;
      case DIVIDE:
        context = new TempContext(new DivisionOperator());
        exLabel.setText(HTML + firstOperand + SP + operation + SP);
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

}
