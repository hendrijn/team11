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
public class ButtonListener implements Finals, ActionListener, KeyListener
{
  private TempContext context = null;

  private String firstInput = "";

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
        ui.inputField.setText("");
        ui.updateDisplay("", null);
        ui.updateDisplay("", null);
        break;
      case CLEAR:
        ui.inputField.setText("");
        break;
      case ADD:
        firstInput = ui.inputField.getText();
        ui.updateDisplay(SP + ADD + SP, null);
        context = new TempContext(new AdditionOperator());
        break;
      case SUBTRACT:
        // Temporary code to tests updateDisplay functionality
        firstInput = ui.inputField.getText();
        ui.updateDisplay(SP + SUBTRACT + SP, null);
        context = new TempContext(new SubtractionOperator());
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
          ui.inputField.setText("");
          ui.updateDisplay("", null);
          ui.updateDisplay("", null);
        }  
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
   * Handles when something is typed in the text box.
   */
  @Override
  public void keyTyped(KeyEvent e)
  {
    System.out.println("you typed");

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
  
  
  
  /**
   * A private helper method for dealing with equalsButtonHandling.
   * @param ui The ui of the entire rimplex program.
   */
  private void equalsButtonHandling(MainInterface ui) {
    
    String currentInput = ui.inputField.getText();  
    String finalResult = "";
    try
    {
      finalResult = context.evaluate(firstInput, currentInput);
    }
    catch (IllegalArgumentException e)
    {
      ui.errorMessage(e.getMessage());
      ui.inputField.setText("");
      ui.updateDisplay("", null);
      ui.updateDisplay("", null);
      return;
    }
    ui.updateDisplay(" =", finalResult);
    System.out.println("Handle equals functionality");
  }

}
