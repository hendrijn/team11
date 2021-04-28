package gui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.AbstractButton;
import javax.swing.JLabel;

import operations.*;

/**
 * Handles all button functionalities.
 * 
 * @author Jacquelyn Hendricks, Brooke Sindelar, Corwin Willms, Patrick Glebus
 * @version v3
 */
public class InterfaceController
    implements Finals, ActionListener, KeyListener, FocusListener
{
  private static InterfaceController instance;
  private static HistoryDisplay historyDisplay = HistoryDisplay.getInstance();
  private static final String TWO_OPERANDS = "TWO_OPERANDS";
  private TempContext context = null;
  private String operator = EMPTY;
  private String firstOperand = EMPTY;
  private String secondOperand = EMPTY;
  private String result = EMPTY;
  private boolean expFlag = false;
  private final String iString = "i";

  /**
   * Singleton.
   * 
   * @return the one instance of interface controller.
   */
  public static InterfaceController getInstance()
  {
    if (instance == null)
      instance = new InterfaceController();
    return instance;
  }

  /**
   * Handles soft button operations.
   */
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    AbstractButton button = (AbstractButton) e.getSource();

    try
    {
      Integer.parseInt(button.getText());
      handleInput(button.getText());
    }
    catch (NumberFormatException t)
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
            ui.errorMessage(ui.getStrings().getString(TWO_OPERANDS));
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
          handleBackspace(ui);
          break;
        case SIGN:
          JLabel input = ui.getInputLabel();
          String in = input.getText();
          handleSign(in);
          break;
        case INVERSE:
          handleInverse(ui);
          break;
        case RPARTS:
          JLabel rPart = ui.getInputLabel();
          String real = rPart.getText();
          handleReal(real);
          break;
        case IPARTS:
          JLabel iPart = ui.getInputLabel();
          String imag = iPart.getText();
          handleImaginary(imag);
          break;
        case EXP:
          expFlag = true;
          handleOperators(EXP);
          break;
        case LOG:
          handleLog(ui);
          break;
        case SQRT:
          handleSquareRoot(ui);
          break;
        case ">":
          historyDisplay.setSize(500, 340);
          historyDisplay.listPane.setVisible(true);
          historyDisplay.close.setVisible(true);
          NewMainInterface.getHistory().setVisible(false);
          // history.open.setVisible(false);
          break;
        case "<":
          historyDisplay.setSize(1, 1);
          historyDisplay.listPane.setVisible(false);
          historyDisplay.close.setVisible(false);
          NewMainInterface.getHistory().setVisible(true);
          // history.open.setVisible(true);
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
  public void keyTyped(final KeyEvent e)
  {
    // if a recording is being played back, don't accept keyboard presses
    MenuController playback = MenuController.getInstance();
    if (playback.isRunning)
      return;

    NewMainInterface ui = NewMainInterface.getInstance();

    char keyChar = e.getKeyChar();
    String keyText = Character.toString(keyChar);
    try
    {
      Integer.parseInt(keyText);
      handleInput(keyText);
    }
    catch (NumberFormatException t)
    {
      if (keyChar == '\n')
      {
        try
        {
          equalsButtonHandling(ui);
        }
        catch (NullPointerException nullP)
        {
          firstOperand = EMPTY;
          ui.errorMessage(ui.getStrings().getString(TWO_OPERANDS));
          resetInterface();
        }
      }
      else if (keyChar == '\b')
      {
        handleBackspace(ui);
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
          case iString:
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
          case EXP:
            expFlag = true;
            handleOperators(EXP);
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
   * A private helper method for dealing with equalsButtonHandling and exponentiation.
   * 
   * @param ui
   *          The ui of the entire rimplex program.
   */
  private void equalsButtonHandling(final NewMainInterface ui)
  {
    HistoryDisplay history = HistoryDisplay.getInstance();
    JLabel exLabel = ui.getExpressionLabel();
    secondOperand = removeFormatting(ui.getInputLabel().getText());

    try
    {
      if (expFlag)
      {
        ExponentOperator expOp = new ExponentOperator();
        result = expOp.exponentation(firstOperand, secondOperand);
        expFlag = false;
      }
      else
      {
        result = context.evaluate(firstOperand, secondOperand);
      }
      ui.getInputLabel().setText(HTML);
      exLabel.setText(exLabel.getText() + replaceFormatting(secondOperand) + SP + EQUALS);
      ui.getResultLabel().setText(replaceFormatting(result));
      history.addCalculation(
          firstOperand + SP + operator + SP + secondOperand + SP + EQUALS + SP + result);
      firstOperand = EMPTY;
      secondOperand = EMPTY;
    }
    catch (IllegalArgumentException e)
    {
      ui.errorMessage(e.getMessage());
      result = EMPTY;
      secondOperand = EMPTY;
      expFlag = false;
      ui.getInputLabel().setText(HTML);
    }
  }

  /**
   * Backspaces the input field.
   * 
   * @param ui
   *          the user interface to backspace from.
   */
  private void handleBackspace(final NewMainInterface ui)
  {
    String text = ui.getInputLabel().getText();

    // to cover cases when the user backspaces without typing anything
    String cleanText = removeFormatting(text);
    if (cleanText.length() == 1)
    {
      ui.getInputLabel().setText(HTML);
      return;
    }
    if (text.length() > HTML.length())
    {
      if (text.substring(text.length() - I.length()).equals(I))
      {
        text = text.substring(0, text.length() - I.length());
        ui.getInputLabel().setText(text);
      }
      else
      {
        text = text.substring(0, text.length() - 1);
        ui.getInputLabel().setText(text);
      }
    }

  }

  /**
   * Handles the imaginary only functionality.
   * 
   * @param operand
   *          the operand to edit
   */
  private void handleImaginary(final String operand)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    JLabel inLabel = ui.getInputLabel();
    String actual = removeFormatting(operand);
    ImaginaryPartOperator iOp = new ImaginaryPartOperator();

    String change = "";
    try
    {
      change = iOp.evaluate(actual);
    }
    catch (IllegalArgumentException iae)
    {
      ui.errorMessage(iae.getMessage());
    }
    inLabel.setText(replaceFormatting(change));
  }

  /**
   * Adds soft or physical keyboard input to the display.
   * 
   * @param input
   *          the String to add to the display.
   */
  private void handleInput(final String input)
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
   * Handles inverse functionality.
   * 
   * @param ui
   *          the main interface
   */
  private void handleInverse(final NewMainInterface ui)
  {
    String invertNum = ui.getInputLabel().getText();
    String cleaninvertNum = removeFormatting(invertNum);
    if (cleaninvertNum.equals(EMPTY))
    {
      invertNum = ui.getResultLabel().getText();
      cleaninvertNum = removeFormatting(invertNum);
    }
    InverseOperator inverseOP = new InverseOperator();
    String invertedOperand = EMPTY;
    try
    {
      invertedOperand = inverseOP.invert(cleaninvertNum);
    }
    catch (IllegalArgumentException e1)
    {
      ui.errorMessage(e1.getMessage());
      resetInterface();
      return;
    }
    invertedOperand = LPAREN + invertedOperand + RPAREN;
    ui.getInputLabel().setText(replaceFormatting(invertedOperand));
  }

  /**
   * Handles the log functionality.
   * 
   * @param ui
   *          the main interface
   */
  private void handleLog(final NewMainInterface ui)
  {
    String logNum = ui.getInputLabel().getText();
    String cleanLogNum = removeFormatting(logNum);
    if (cleanLogNum.equals(EMPTY))
    {
      logNum = ui.getResultLabel().getText();
      cleanLogNum = removeFormatting(logNum);
    }
    LogarithmOperator logOp = new LogarithmOperator();
    String logOperand = EMPTY;
    try
    {
      logOperand = logOp.log(cleanLogNum);
    }
    catch (IllegalArgumentException e1)
    {
      ui.errorMessage(e1.getMessage());
      resetInterface();
      return;
    }
    logOperand = "(" + logOperand + ")";
    ui.getInputLabel().setText(replaceFormatting(logOperand));
  }

  /**
   * Determines what operator is being performed. Sends the labels to updateDisplayWithOperators to
   * put them on screen.
   * 
   * @param operation
   *          the operation to set
   */
  private void handleOperators(final String operation)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    JLabel exLabel = ui.getExpressionLabel();
    JLabel inLabel = ui.getInputLabel();
    JLabel resLabel = ui.getResultLabel();

    // handles the input label if in paren
    if (inParentheses(inLabel.getText()))
    {
      handleInput(operation);
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
        firstOperand = LPAREN + result + RPAREN;
        updateDisplayWithOperator(operation, ui, exLabel, inLabel, resLabel);
      }
      else
      {
        ui.errorMessage(ui.getStrings().getString("NO_RESULT"));
      }
    }
  }

  /**
   * Handles the real only functionality.
   * 
   * @param operand
   *          the operand to edit
   */
  private void handleReal(final String operand)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    JLabel inLabel = ui.getInputLabel();
    String actual = removeFormatting(operand);
    RealPartOperator r = new RealPartOperator();
    String change = EMPTY;
    try
    {
      change = r.evaluate(actual);
    }
    catch (IllegalArgumentException iae)
    {
      ui.errorMessage(iae.getMessage());
    }
    inLabel.setText(replaceFormatting(change));
  }

  /**
   * Helper method to change sign of a number.
   * 
   * @param input
   *          the number to change
   */
  private void handleSign(final String input)
  {
    String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", iString, RPAREN};
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

  /**
   * Handles the square root functionality.
   * 
   * @param ui
   *          the main interface
   */
  private void handleSquareRoot(final NewMainInterface ui)
  {
    String sqrtNum = ui.getInputLabel().getText();
    String cleansqrtNum = removeFormatting(sqrtNum);
    if (cleansqrtNum.equals(EMPTY))
    {
      sqrtNum = ui.getResultLabel().getText();
      cleansqrtNum = removeFormatting(sqrtNum);
    }
    SquareRootOperator sqrtOp = new SquareRootOperator();
    String sqrtOperand = EMPTY;
    try
    {
      sqrtOperand = sqrtOp.evaluate(cleansqrtNum);
    }
    catch (IllegalArgumentException e1)
    {
      ui.errorMessage(e1.getMessage());
      resetInterface();
      return;
    }
    sqrtOperand = LPAREN + sqrtOperand + RPAREN;
    ui.getInputLabel().setText(replaceFormatting(sqrtOperand));
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
  private void updateDisplayWithOperator(final String operation, final NewMainInterface ui,
      final JLabel exLabel, final JLabel inLabel, final JLabel resLabel)
  {
    operator = operation; // assigns the indicated operation to the class variable

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
      case EXP:
        exLabel.setText(replaceFormatting(firstOperand) + SP + operation + SP);
        resLabel.setText(HTML);
        inLabel.setText(HTML);
        break;
      default:
        ui.errorMessage("Not a valid operator");
    }
  }

  /**
   * Overwrites any html formatting with the correct values for storing.
   * 
   * @param input
   *          the string to change
   * @return the input without html formatting
   */
  private String removeFormatting(final String input)
  {
    String newString = EMPTY;
    newString = input.replace(HTML, EMPTY);
    newString = newString.replace(I, iString);
    return newString;
  }

  /**
   * Overwrites any html formatting with the correct values for calculations.
   * 
   * @param input
   *          the string to change
   * @return the input without html formatting
   */
  private String replaceFormatting(final String input)
  {
    String newString = HTML;
    newString = newString + input.replace(iString, I);
    return newString;
  }

  /**
   * resets the entire interface and operands.
   */
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
  public static boolean inParentheses(final String input)
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

  /**
   * returns the focus of the window.
   */
  @Override
  public void focusLost(final FocusEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    ui.getInputLabel().requestFocusInWindow();
  }

  /**
   * returns the focus of the window.
   */
  @Override
  public void focusGained(final FocusEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    ui.getInputLabel().requestFocusInWindow();
  }

  // ----------------- Unimplemented -------------//
  @Override
  public void keyPressed(final KeyEvent e)
  {
  }

  @Override
  public void keyReleased(final KeyEvent e)
  {
    // TODO Auto-generated method stub

  }

}
