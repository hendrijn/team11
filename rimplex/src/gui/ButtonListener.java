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
        System.out.println("Handle reset functionality");
        break;
      case CLEAR:
        System.out.println("Handle reset functionality");
        break;        
      case ADD:
        ui.updateDisplay(ADD, null);
        context = new TempContext(new AdditionOperator());
        break;
      case SUBTRACT:
        // Temporary code to tests updateDisplay functionality
        ui.updateDisplay(SUBTRACT, null);
        context = new TempContext(new SubtractionOperator());
        break;
      case MULTIPLY:
        System.out.println("Multiply is disabled");
        break;
      case DIVIDE:
        System.out.println("Divide is disabled");
        break;
      case EQUALS:
        // calculate result here???
        // need to save last operator for use in calculation???
        ui.updateDisplay(" =", "correct result");
        System.out.println("Handle equals functionality");
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

}
