package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Controls the functionality of the menu items.
 * 
 * @author Jacquelyn Hendricks
 * @version v3
 */
public class MenuController implements ActionListener, Finals
{

  private CalculationRecorder recorder = new CalculationRecorder(1000, this);
  private JMenuItem add, play, pause, stop;
  private static int elementsDisplayed = 0;
  private static int calcCount = 0;

  /**
   * Responds to menu button presses.
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    assignMenuItems(ui);

    if (e.getSource() instanceof JMenuItem)
    {
      JMenuItem itemClicked = (JMenuItem) e.getSource();
      String item = itemClicked.getText();

      if (item.equals(NewMainInterface.STRINGS.getString("ADDTOREC")))
      {
        handleAdding(ui);
      }
      else if (item.equals(NewMainInterface.STRINGS.getString("START")))
      {
        setButtonsEnabled(ui, false);
        setItemsEnabled(add, false);
        setItemsEnabled(pause, true);
        setItemsEnabled(stop, true);
        setItemsEnabled(play, false);
        startPlayback(ui);
      }
      else if (item.equals(NewMainInterface.STRINGS.getString("PAUSE")))
      {
        setItemsEnabled(play, true);
        setItemsEnabled(pause, false);
      }
      else if (item.equals(NewMainInterface.STRINGS.getString("STOP")))
      {
        setButtonsEnabled(ui, true);
        setItemsEnabled(play, true);
        setItemsEnabled(pause, false);
        setItemsEnabled(stop, false);
        setItemsEnabled(add, true);
      }
      else
      {
        System.exit(0);
      }
    }
    else
    {
      if (calcCount < recorder.getRecording().size())
      {
        recorder.displayNextElement(calcCount, elementsDisplayed, ui);
        elementsDisplayed++;
        // if all elements in a calculation have been shown...
        if (6 / elementsDisplayed == 1)
        {
          calcCount++;
          elementsDisplayed = 0;
          // resetDisplay(ui);
        }
      }
      else
      {
        recorder.stop();
        calcCount = 0;
        elementsDisplayed = 0;
        resetDisplay(ui);
      }
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
    ui.getInputLabel().setText(HTML);
    resetDisplay(ui);
    recorder.start();
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
        resetDisplay(ui);
      }
    }
  }

  /**
   * Resets the expression and result labels.
   * 
   * @param ui
   *          the interface
   */
  private void resetDisplay(NewMainInterface ui)
  {
    ui.getExpressionLabel().setText(HTML);
    ui.getResultLabel().setText(HTML);
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
