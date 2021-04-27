package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Controls the functionality of the menu items.
 * 
 * @author Jacquelyn Hendricks, Corwin Willms
 * @version Sprint 3
 */
public class MenuController implements ActionListener, Finals
{
  private static MenuController instance = null;
  private CalculationRecorder recorder = new CalculationRecorder(1000, this);
  private JMenuItem add, play, pause, stop;
  private int elementsDisplayed = 0;
  private int calcCount = 0;

  boolean isRunning;

  /**
   * Singleton.
   * 
   * @return the one instance of menu controller
   */
  public static MenuController getInstance()
  {
    if (instance == null)
      instance = new MenuController();
    return instance;
  }

  /**
   * Responds to menu button presses.
   */
  @Override
  public void actionPerformed(final ActionEvent e)
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
        pausePlayback(ui);
      }
      else if (item.equals(NewMainInterface.STRINGS.getString("STOP")))
      {
        stopPlayback(ui);
      }
      else if (item.equals(NewMainInterface.STRINGS.getString("PRINT")))
      {
        HistoryDisplay hd = HistoryDisplay.getInstance();
        HistoryPrinter.printComponent(hd.getCalcList());
      }
      else if (item.equals(NewMainInterface.STRINGS.getString("SET_SPEED")))
      {
        handleSetSpeed(ui);
      }
      else
      {
        System.exit(0);
      }
    }
    else
    {
      handlePlayback(ui);
    }
  }

  /**
   * Gets each menu item and assigns it to the right variable.
   * 
   * @param ui
   *          the interface
   */
  private void assignMenuItems(final NewMainInterface ui)
  {
    JMenu fileMenu = (JMenu) ui.menuBar.getMenu(0);

    add = fileMenu.getItem(0);
    play = fileMenu.getItem(1);
    pause = fileMenu.getItem(2);
    stop = fileMenu.getItem(3);
  }

  /**
   * Handles adding a new calculation to the recording.
   * 
   * @param ui
   *          the interface.
   */
  private void handleAdding(final NewMainInterface ui)
  {
    if (ui.getResultLabel().getText().equals(HTML))
      ui.errorMessage(NewMainInterface.STRINGS.getString("INCOMPLETE"));
    else
    {
      int choice = JOptionPane.showConfirmDialog(null,
          NewMainInterface.STRINGS.getString("CONFIRM"), null, JOptionPane.YES_NO_OPTION);

      if (choice == JOptionPane.YES_OPTION)
      {
        recorder.add(ui.getExpressionLabel(), ui.getResultLabel());
        setItemsEnabled(play, true);
      }
    }
  }

  /**
   * Handles playback functionality. This method is called every x seconds as indicated by the user.
   * It keeps track of what calculation we're on, how many elements have been shown on the screen,
   * and whether we have finished playing back all calculations.
   * 
   * @param ui
   *          the interface
   */
  private void handlePlayback(final NewMainInterface ui)
  {
    if (calcCount < recorder.getRecording().size())
    {
      // if we're starting a new calculation...
      if (elementsDisplayed == 0)
        resetDisplay(ui);

      recorder.displayNextElement(calcCount, elementsDisplayed, ui);
      elementsDisplayed++;

      // if all elements in a calculation have been shown...
      if (elementsDisplayed == 4)
      {
        calcCount++;
        elementsDisplayed = 0;
      }
    }
    else
    {
      stopPlayback(ui);
      calcCount = 0;
      elementsDisplayed = 0;
    }
  }

  /**
   * Asks the user for a playback speed and sets the delay in CalculationRecorder.
   * 
   * @param ui
   *          the interface
   */
  private void handleSetSpeed(final NewMainInterface ui)
  {
    String speed = JOptionPane.showInputDialog(NewMainInterface.STRINGS.getString("SPEED"));
    try
    {
      recorder.setDelay(Integer.parseInt(speed) * 1000);
    }
    catch (NumberFormatException nfe)
    {
      ui.errorMessage(NewMainInterface.STRINGS.getString("NOT_VALID"));
    }
  }

  /**
   * Plays the recording on the screen. Start() cues handlePlayback() within actionPerformed().
   * 
   * @param ui
   *          the interface
   */
  private void startPlayback(final NewMainInterface ui)
  {
    isRunning = true;
    recorder.start();
  }

  /**
   * Pauses playback.
   * 
   * @param ui
   *          the interface
   */
  private void pausePlayback(final NewMainInterface ui)
  {
    recorder.stop();
  }

  /**
   * Stops the recording, resets the display, and handles menu item enabling.
   * 
   * @param ui
   *          the interface
   */
  private void stopPlayback(final NewMainInterface ui)
  {
    recorder.stop();
    resetDisplay(ui);
    ui.getInputLabel().setText(HTML);
    setButtonsEnabled(ui, true);
    setItemsEnabled(play, true);
    setItemsEnabled(pause, false);
    setItemsEnabled(stop, false);
    setItemsEnabled(add, true);
    isRunning = false;
  }

  /**
   * Resets the expression and result labels.
   * 
   * @param ui
   *          the interface
   */
  private void resetDisplay(final NewMainInterface ui)
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
  private void setButtonsEnabled(final NewMainInterface ui, final boolean isEnabled)
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
  private void setItemsEnabled(final JMenuItem item, final boolean isEnabled)
  {
    item.setEnabled(isEnabled);
  }
}
