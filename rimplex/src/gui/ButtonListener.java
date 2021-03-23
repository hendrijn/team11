package gui;

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
    
    switch(button.getName())
    {
      
    }

  }

}
