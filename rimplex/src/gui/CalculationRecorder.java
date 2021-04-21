package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Handles logic for recording calculations.
 * 
 * @author Jacquelyn Hendricks
 * @version v3
 */
public class CalculationRecorder
{
  private ArrayList<String[]> recording;
  private String[] calculation;

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
   * @param firstOperand
   *          first operand
   * @param operator
   *          operator
   * @param secondOperand
   *          second operand
   * @param result
   *          result
   */
  public void add(String firstOperand, String operator, String secondOperand, String result)
  {
    calculation[0] = firstOperand;
    calculation[1] = operator;
    calculation[2] = secondOperand;
    calculation[3] = result;

    recording.add(calculation);
  }

  /**
   * @return the recording
   */
  public ArrayList<String[]> getRecording()
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
}
