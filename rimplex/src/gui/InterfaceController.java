package gui;

import java.awt.Color;
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
      int num = Integer.parseInt(button.getText());
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
          ui.getInputLabel().setText(EMPTY);
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
    try
    {
      int num = Integer.parseInt(keyText);
      handleInput(keyText);
    }
    catch (Throwable t)
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
        case EQUALS:
          // try
          // {
          // equalsButtonHandling(ui);
          // }
          // catch (NullPointerException nullP)
          // {
          // firstOperand = "";
          // ui.errorMessage("Please input two valid operands.");
          // ui.clearAll();
          // }
          // ui.inputField.requestFocusInWindow();
          break;
        case "i":
          handleInput(I);
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
      exLabel.setText(exLabel.getText() + secondOperand);
      shownError = false;
    }
    catch (IllegalArgumentException e)
    {
      ui.errorMessage(e.getMessage());
      result = "";
      shownError = true;
    }
    ui.getResultLabel().setText(EQUALS + result);
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
    JLabel exLabel = ui.getExpressionLabel();
    JLabel inLabel = ui.getInputLabel();

    // if (firstOperand.isEmpty())
    // {
    if (inParentheses(operation))
    {
      inLabel.setText(ui.getInputLabel().getText() + operation);
    }
    else
    {
      firstOperand = inLabel.getText().replace(HTML, EMPTY);
    }
    switch (operation)
    {
      case ADD:
        context = new TempContext(new AdditionOperator());
        exLabel.setText(firstOperand + SP + operation + SP);
        inLabel.setText(HTML);
        break;
      case SUBTRACT:
        context = new TempContext(new SubtractionOperator());
        exLabel.setText(firstOperand + SP + operation + SP);
        inLabel.setText(HTML);
        break;
      case MULTIPLY:
        context = new TempContext(new MultiplicationOperator());
        exLabel.setText(firstOperand + SP + operation + SP);
        inLabel.setText(HTML);
        break;
      case DIVIDE:
        context = new TempContext(new DivisionOperator());
        exLabel.setText(firstOperand + SP + operation + SP);
        inLabel.setText(HTML);
        break;
      default:
        ui.errorMessage("Not a valid operator");
    }
    // }
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
