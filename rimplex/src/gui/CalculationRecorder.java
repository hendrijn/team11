package gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.*;

/**
 * Handles logic for recording calculations.
 * 
 * @author Jacquelyn Hendricks
 * @version v3
 */
public class CalculationRecorder extends TimerTask
{
  private ArrayList<String[]> recording;
  private String[] calculation;
  private static int count = 0;

  /**
   * Constructor.
   */
  public CalculationRecorder()
  {
    recording = new ArrayList<>();
    calculation = new String[4];
  }

  /**
   * Adds a calculation to the recording.
   * 
   * @param expressionLabel
   *          operands and operator
   * @param resultLabel
   *          result
   */
  void add(JLabel expressionLabel, JLabel resultLabel)
  {
    calculation = expressionLabel.getText().split("\\s");
    calculation[3] = resultLabel.getText();

    recording.add(calculation);
  }

  /**
   * @return the recording
   */
  ArrayList<String[]> getRecording()
  {
    return recording;
  }

  /**
   * Sets all components in a frame to be either enabled or disabled.
   * 
   * @param panel
   *          the panel to search
   * @param isEnabled
   *          true to enable, false to disable
   */
  void setPanelEnabled(JPanel panel, boolean isEnabled)
  {
    Component[] components = panel.getComponents();

    for (Component component : components)
    {
      if (component instanceof JPanel)
      {
        setPanelEnabled((JPanel) component, isEnabled);
      }
      component.setEnabled(isEnabled);
    }

  }

  /**
   * Handles tasks in the timer.
   */
  @Override
  public void run()
  {
    count++;
    if (count > 4)
    {
      cancel();
      return;
    }
    System.out.println("Print me");
  }
}
