package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * Serves as the main window for the interface.
 *
 * @author Jacquelyn Hendricks
 * @version March 23 2021
 */
public class MainInterface extends JFrame implements Finals
{
  // The serial ID for serialization
  private static final long serialVersionUID = 1L;
  private static MainInterface frame;

  private JPanel displayPanel;
  private JPanel inputPanel;
  private JPanel buttonPanel;

  JButton resetButton;
  JButton addButton;
  JButton subtractButton;
  JButton multiplyButton;
  JButton divideButton;
  JButton equalsButton;

  JTextField inputField = new JTextField();

  private ButtonListener listener = new ButtonListener();

  private String input;
  private String result;

  /**
   * Default constructor.
   */
  private MainInterface()
  {
    createComponents();
    setupFrame();
    setSize(600, 200);
    setVisible(true); // display this
    centerForm();

  }

  /**
   * Adds the buttons to the button panel. We'll need to add the clear and equals button as well.
   * Order adding to the panel matters.
   */
  private void addButtons()
  {
     resetButton = new JButton(RESET);
     addButton = new JButton(ADD);
     subtractButton = new JButton(SUBTRACT);
     multiplyButton = new JButton(MULTIPLY);
     divideButton = new JButton(DIVIDE);
     equalsButton = new JButton(EQUALS);
    
     resetButton.setForeground(Color.RED);
    
     resetButton.addActionListener(listener);
     addButton.addActionListener(listener);
     subtractButton.addActionListener(listener);
     multiplyButton.addActionListener(listener);
     divideButton.addActionListener(listener);
     equalsButton.addActionListener(listener);
     
     multiplyButton.setEnabled(false);
     divideButton.setEnabled(false);
    
     buttonPanel.add(resetButton);
     buttonPanel.add(addButton);
     buttonPanel.add(subtractButton);
     buttonPanel.add(multiplyButton);
     buttonPanel.add(divideButton);
     buttonPanel.add(equalsButton);
  }

  /**
   * Adds all necessary components to the displayPane.
   * 
   */
  private void addDisplay()
  {
    Border displayB = BorderFactory.createLineBorder(Color.BLUE, 3, true);
    displayPanel.setBorder(displayB);
    displayPanel.setLayout(new GridLayout(1, 2));
    JLabel displayOps = new JLabel("Operands go here", JLabel.LEFT);
    JLabel displayRes = new JLabel("results go here", JLabel.RIGHT);

    displayPanel.add(displayOps);
    displayPanel.add(displayRes);

  }

  /**
   * Sets up input field.
   */
  private void addInputField()
  {
    inputField.setHorizontalAlignment(JTextField.RIGHT);
    inputField.addKeyListener(listener);

    inputPanel.setLayout(new BorderLayout());
    inputPanel.add(inputField, BorderLayout.NORTH);
  }

  /**
   * centerForm.
   *
   * center form on screen
   */
  private void centerForm()
  {

    Dimension dimScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension dimFrameSize = getSize();

    if (dimFrameSize.height > dimScreenSize.height)
    {
      dimFrameSize.height = dimScreenSize.height;
    }
    if (dimFrameSize.width > dimScreenSize.width)
    {
      dimFrameSize.width = dimScreenSize.width;
    }

    setLocation((dimScreenSize.width - dimFrameSize.width) / 2,
        (dimScreenSize.height - dimFrameSize.height) / 2);

  } // method centerForm

  /**
   * Creates the components. Here is where the different text fields and labels would go.
   */
  private void createComponents()
  {
    buttonPanel = new JPanel();
    displayPanel = new JPanel();
    inputPanel = new JPanel();
  }

  /**
   * Sets up the main frame. Here is where we add the components to the main pane. Order matters
   * here.
   */
  private void setupFrame()
  {
    Container contentPane = getContentPane();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    contentPane.setLayout(new GridLayout(3, 1));

    addDisplay();
    addInputField();
    addButtons();

    contentPane.add(displayPanel);
    contentPane.add(inputPanel);
    contentPane.add(buttonPanel);
  }

  /**
   * Updates the display with user input and results.
   * 
   * @param buttonText
   *          a string containing an operator or '='
   * @param result
   *          a string containing the result of an equation
   */
  void updateDisplay(String buttonText, String result)
  {

    if (result == null && input == null)
    {
      input = ((JTextField) inputPanel.getComponent(0)).getText();
      input = input.concat(buttonText);
      ((JTextField) inputPanel.getComponent(0)).setText("");
      ((JLabel) displayPanel.getComponent(0)).setText(input);
    }
    else
    {
      input = input.concat(((JTextField) inputPanel.getComponent(0)).getText());
      input = input.concat(buttonText);
      ((JTextField) inputPanel.getComponent(0)).setText("");
      ((JLabel) displayPanel.getComponent(0)).setText(input);
      ((JLabel) displayPanel.getComponent(1)).setText(result);
      input = null;
    }

  }

  /**
   * Singleton that only returns one instance of the main frame.
   * 
   * @return the single instance of the main frame
   */
  public static MainInterface getInstance()
  {
    if (frame == null)
      frame = new MainInterface();
    return frame;
  }

}
