package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        handleAdding(ui);
        break;
      case START:
        setButtonsEnabled(ui, false);
        startPlayback(ui);
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
   * Plays the recording on the screen.
   * 
   * @param ui
   *          the interface
   */
  private void startPlayback(NewMainInterface ui)
  {
    ArrayList<String[]> recording = recorder.getRecording();
    
    for (int i = 0; i < recording.size() - 1; i++)
    {
      String[] calculation = recording.get(i);
      ui.expressionDisplay.setText(calculation[0] + calculation[1] + calculation[2]);
      ui.resultDisplay.setText(calculation[3]);
    }
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
//      recorder.add(uiController.getFirstOperand(), uiController.getOperator(),
//          uiController.getSecondOperand(), uiController.getResult());
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
