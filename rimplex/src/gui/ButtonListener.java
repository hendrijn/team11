package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

/**
 * Handles all button functionalities.
 * 
 * @author Jacquelyn Hendricks
 * @version March 23 2021
 */
public class ButtonListener implements ActionListener
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
      case "+":
        System.out.println("Handle add functionality");
        break;
      case "-":
        System.out.println("Handle subtract functionality");
        break;
      case "x":
        System.out.println("Handle multiply functionality");
        break;
      case "÷":
        System.out.println("Handle divide functionality");
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

}
