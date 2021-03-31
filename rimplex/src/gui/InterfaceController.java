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

  private String firstInput = EMPTY;
  
  private boolean shownError = false;

  /**
   * Handles all button operations.
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    MainInterface ui = MainInterface.getInstance();
    AbstractButton button = (AbstractButton) e.getSource();

    switch (button.getText())
    {
      case RESET:
        ui.clearAll();
        ui.inputField.requestFocusInWindow();
        break;
      case CLEAR:
        ui.inputField.setText(EMPTY);
        ui.inputField.requestFocusInWindow();
        break;
      case ADD:
        firstInput = ui.inputField.getText();
        ui.updateDisplay(SP + ADD + SP, null);
        context = new TempContext(new AdditionOperator());
        ui.inputField.requestFocusInWindow();
        break;
      case SUBTRACT:
        firstInput = ui.inputField.getText();
        ui.updateDisplay(SP + SUBTRACT + SP, null);
        context = new TempContext(new SubtractionOperator());
        ui.inputField.requestFocusInWindow();
        break;
      case MULTIPLY:
        System.out.println("Multiply is disabled");
        break;
      case DIVIDE:
        System.out.println("Divide is disabled");
        break;
      case EQUALS:
        try
        {
          equalsButtonHandling(ui);
          
        }
        catch (NullPointerException nullP)
        {
          ui.errorMessage("Please input two valid operands.");
          ui.clearAll();
        }
        ui.inputField.requestFocusInWindow();
        break;
      default:
        closeApplication();
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
    String finalResult = EMPTY;
    try
    {
      finalResult = context.evaluate(firstInput, currentInput);
    }
    catch (IllegalArgumentException e)
    {
      ui.errorMessage(e.getMessage());
      ui.clearAll();
      ui.inputField.requestFocusInWindow();
      return;
    }
 
    ui.updateDisplay(SP + EQUALS, finalResult);
  }

  /**
   * Handles when something is typed in the text box.
   */
  @Override
  public void keyTyped(KeyEvent e)
  {
    MainInterface inst = MainInterface.getInstance();
    inst.addButton.setEnabled(true);
    inst.subtractButton.setEnabled(true);
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
