package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * Controls the functionality of the menu items.
 * 
 * @author Jacquelyn Hendricks
 * @version v3
 */
public class MenuController implements ActionListener, Finals
{

  private CalculationRecorder recorder = new CalculationRecorder();

  /**
   * Responds to menu button presses.
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    JMenuItem itemClicked = (JMenuItem) e.getSource();

    switch (itemClicked.getText())
    {
      case ADDTOREC:
        System.out.println("added");
        break;
      case START:
        setButtonsEnabled(ui, false);
        break;
      case PAUSE:
        System.out.println("paused");
        break;
      case STOP:
        setButtonsEnabled(ui, true);
        break;
      default:
        System.exit(0);
    }
  }

  /**
   * Either enables or disables all buttons on the main interface.
   * 
   * @param ui
   *          the interface.
   * @param isEnabled
   *          true to enable, false to disable
   */
  private void setButtonsEnabled(NewMainInterface ui, boolean isEnabled)
  {
    recorder.setPanelEnabled(ui.bar, isEnabled);
    recorder.setPanelEnabled(ui.centerPanel, isEnabled);
    recorder.setPanelEnabled(ui.eastPanel, isEnabled);
  }

}
