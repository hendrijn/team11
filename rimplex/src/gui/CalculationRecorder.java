package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Handles logic for recording calculations.
 * 
 * @author Jacquelyn Hendricks
 * @version v3
 */
public class CalculationRecorder extends Timer implements Finals
{

  private static final long serialVersionUID = 8592944449515675645L;
  private ArrayList<String[]> recording;
  private String[] calculation;

  /**
   * Constructor.
   * 
   * @param delay
   *          the speed of playback
   * @param listener
   *          the listener
   */
  public CalculationRecorder(final int delay, final ActionListener listener)
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
  void add(final JLabel expressionLabel, final JLabel resultLabel)
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
  void setPanelEnabled(final JPanel panel, final boolean isEnabled)
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
  public void displayNextElement(final int calcCount, final int elementsDisplayed,
      final NewMainInterface ui)
  {
    String calcElement = recording.get(calcCount)[elementsDisplayed];
    if (elementsDisplayed == 0 || elementsDisplayed == 2)
    {
      updateInputLabel(ui, calcElement);
    }
    else if (elementsDisplayed == 1)
    {
      updateExpressionLabel(ui, calcElement);
    }
    else if (elementsDisplayed == 3)
    {
      updateResultLabel(ui, calcElement);
    }
  }

  /**
   * Adds the element to the result field.
   * 
   * @param ui
   *          the interface
   * @param calcElement
   *          the element to display
   */
  private void updateResultLabel(final NewMainInterface ui, final String calcElement)
  {
    ui.getExpressionLabel().setText(
        ui.getExpressionLabel().getText() + SP + ui.getInputLabel().getText() + SP + EQUALS);
    ui.getInputLabel().setText(HTML);
    ui.getResultLabel().setText(calcElement);
  }

  /**
   * Adds the element to the expression field.
   * 
   * @param ui
   *          the interface
   * @param calcElement
   *          the element to display
   */
  private void updateExpressionLabel(final NewMainInterface ui, final String calcElement)
  {
    ui.getExpressionLabel().setText(ui.getInputLabel().getText() + SP + calcElement);
    ui.getInputLabel().setText(HTML);
  }

  /**
   * Adds the element to the input field.
   * 
   * @param ui
   *          the interface
   * @param calcElement
   *          the operand to display
   */
  private void updateInputLabel(final NewMainInterface ui, final String calcElement)
  {
    ui.getInputLabel().setText(calcElement);
  }

}
