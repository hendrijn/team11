package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Controls the functionality of the menu items.
 * 
 * @author Jacquelyn Hendricks
 * @version v3
 */
public class MenuController extends Timer implements ActionListener, Finals
{

  private CalculationRecorder recorder = new CalculationRecorder();
  private JMenuItem add, play, pause, stop;

  /**
   * Responds to menu button presses.
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    assignMenuItems(ui);
    JMenuItem itemClicked = (JMenuItem) e.getSource();

    switch (itemClicked.getText())
    {
      case ADDTOREC:
        handleAdding(ui);
        break;
      case START:
        setButtonsEnabled(ui, false);
        setItemsEnabled(add, false);
        setItemsEnabled(pause, true);
        setItemsEnabled(stop, true);
        setItemsEnabled(play, false);
        startPlayback(ui);
        break;
      case PAUSE:
        setItemsEnabled(play, true);
        setItemsEnabled(pause, false);
        break;
      case STOP:
        setButtonsEnabled(ui, true);
        setItemsEnabled(play, true);
        setItemsEnabled(pause, false);
        setItemsEnabled(stop, false);
        setItemsEnabled(add, true);
        break;
      default:
        System.exit(0);
    }
  }

  /**
   * Gets each menu item and assigns it to the right variable.
   * 
   * @param ui
   *          the interface
   */
  private void assignMenuItems(NewMainInterface ui)
  {
    JMenu fileMenu = (JMenu) ui.menuBar.getMenu(0);

    add = fileMenu.getItem(0);
    play = fileMenu.getItem(1);
    pause = fileMenu.getItem(2);
    stop = fileMenu.getItem(3);
  }

  /**
   * Plays the recording on the screen. Recorder is run() located within the calculation recorder.
   * 
   * @param ui
   *          the interface
   */
  private void startPlayback(NewMainInterface ui)
  {
    schedule(recorder, 0, 200);
  }

  /**
   * Handles adding a new calculation to the recording.
   * 
   * @param ui
   *          the interface.
   */
  private void handleAdding(NewMainInterface ui)
  {
    if (ui.getResultLabel().getText().equals(HTML))
      ui.errorMessage("Cannot add incomplete calculation");
    else
    {
      int choice = JOptionPane.showConfirmDialog(null, "Confirm addition", null,
          JOptionPane.YES_NO_OPTION);

      if (choice == JOptionPane.YES_OPTION)
      {
        recorder.add(ui.getExpressionLabel(), ui.getResultLabel());
        setItemsEnabled(play, true);
      }
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

  /**
   * Either enables or disables menu items on the main interface.
   * 
   * @param play2
   *          the menu item.
   * @param isEnabled
   *          true to enable, false to disable
   */
  private void setItemsEnabled(JMenuItem item, boolean isEnabled)
  {
    item.setEnabled(isEnabled);
  }

}
