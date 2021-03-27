package gui;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.AbstractButton;

/**
 * Handles all button functionalities.
 * 
 * @author Jacquelyn Hendricks
 * @version March 23 2021
 */
public class ButtonListener implements Finals, ActionListener, KeyListener
{
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
      case "R":
        System.out.println("Handle reset functionality");
        break;
      case ADD:
        // Temporary code to tests updateDisplay functionality
    	  ui.updateDisplay(" + ", null);
        System.out.println("Handle add functionality");
        break;
      case SUBTRACT:
    	// Temporary code to tests updateDisplay functionality
    	ui.updateDisplay(" - ", null);
        System.out.println("Handle subtract functionality");
        break;
      case MULTIPLY:
        System.out.println("Handle multiply functionality");
        break;
      case DIVIDE:
        System.out.println("Handle divide functionality");
        break;
      case EQUALS:
    	  //calculate result here???
    	  //need to save last operator for use in calculation???
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
