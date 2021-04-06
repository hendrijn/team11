package gui;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.AbstractButton;

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
      System.out.println(num); // send to update display
    }
    catch (Throwable t)
    {
      switch (button.getText())
      {
        case RESET:
          resetInterface();
          break;
        case CLEAR:
          // just clear the lower label
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
          // break;
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
    int keyCode = e.getKeyCode();
    String keyText = KeyEvent.getKeyText(keyCode);
    try
    {
      int num = Integer.parseInt(KeyEvent.getKeyText(keyCode));
      System.out.println(num); // send to update display
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
          // break;
        default:
          closeApplication();

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
  private void equalsButtonHandling(MainInterface ui)
  {

    String currentInput = ui.inputField.getText();
    String finalResult = "";
    try
    {
      finalResult = context.evaluate(firstOperand, currentInput);
      shownError = false;
    }
    catch (IllegalArgumentException e)
    {
      ui.errorMessage(e.getMessage());
      finalResult = "";
      shownError = true;
    }
    ui.updateDisplay(SP + EQUALS, finalResult);
    if (shownError)
    {
      ui.clearAll();
    }
    else
    {
      shownError = false;
    }
    System.out.println("Handle equals functionality");
  }

  private void handleOperators(String operation)
  {
    NewMainInterface ui = NewMainInterface.getInstance();

    // if (isInsideParenthesis) ...
    // here, don't add a space between the prev char and operator
    switch (operation)
    {
      case ADD:
        context = new TempContext(new AdditionOperator());
        // here, update display with space between prev char and operator
        break;
      case SUBTRACT:
        context = new TempContext(new SubtractionOperator());
        // here, update display with space between prev char and operator
        break;
      case MULTIPLY:
        // context = new TempContext(new AdditionOperator());
        // here, update display with space between prev char and operator
        break;
      case DIVIDE:
        // context = new TempContext(new SubtractionOperator());
        // here, update display with space between prev char and operator
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
	  //switch(input)
  }

  private void resetInterface()
  {
    context = null;
    firstOperand = EMPTY;
    secondOperand = EMPTY;
    result = EMPTY;
    // clear text of both labels
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
