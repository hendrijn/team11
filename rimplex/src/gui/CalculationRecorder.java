package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.*;

/**
 * Handles logic for recording calculations.
 * 
 * @author Jacquelyn Hendricks
 * @version v3
 */
public class CalculationRecorder extends Timer
{

  private static final long serialVersionUID = 8592944449515675645L;
  private ArrayList<String[]> recording;
  private String[] calculation;

  public CalculationRecorder(int delay, ActionListener listener)
  {
    super(delay, listener);
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
   * Displays the elements in the recording.
   * 
   * @param calcCount
   *          which calculation we're on
   * @param elementsDisplayed
   *          which part of the calculation are we on
   * @param ui
   *          the main interface
   */
  public void displayNextElement(int calcCount, int elementsDisplayed, NewMainInterface ui)
  {
    ui.getInputLabel().setText(recording.get(calcCount)[elementsDisplayed]);

  }

}
