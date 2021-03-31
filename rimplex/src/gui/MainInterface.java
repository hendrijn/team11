package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import org.junit.platform.commons.util.StringUtils;

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
  JButton clearButton;
  JButton addButton;
  JButton subtractButton;
  JButton multiplyButton;
  JButton divideButton;
  JButton equalsButton;

  JTextField inputField = new JTextField();

  private InterfaceController listener = new InterfaceController();

  private String input;

  /**
   * Default constructor.
   */
  private MainInterface()
  {
    createComponents();
    setupFrame();
    setSize(600, 200);
    setTitle("Rimplex");
    setVisible(true); // display this
    centerForm();

  }

  /**
   * Adds the buttons to the button panel. We'll need to add the clear and equals button as well.
   * Order adding to the panel matters.
   * 
   * Will I change to use a loop?
   */
  private void addButtons()
  {
    resetButton = new JButton(RESET);
    clearButton = new JButton(CLEAR);
    addButton = new JButton(ADD);
    subtractButton = new JButton(SUBTRACT);
    multiplyButton = new JButton(MULTIPLY);
    divideButton = new JButton(DIVIDE);
    equalsButton = new JButton(EQUALS);

    resetButton.setForeground(Color.RED);
    clearButton.setForeground(Color.GREEN);

    resetButton.addActionListener(listener);
    clearButton.addActionListener(listener);
    addButton.addActionListener(listener);
    subtractButton.addActionListener(listener);
    multiplyButton.addActionListener(listener);
    divideButton.addActionListener(listener);
    equalsButton.addActionListener(listener);

    addButton.setEnabled(false);
    subtractButton.setEnabled(false);
    multiplyButton.setEnabled(false);
    divideButton.setEnabled(false);

    buttonPanel.add(resetButton);
    buttonPanel.add(clearButton);
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
    JLabel displayOps = new JLabel(EMPTY, JLabel.LEFT);
    JLabel displayRes = new JLabel(EMPTY, JLabel.RIGHT);

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
	boolean parenthesis = false;
	if (inputField.getText().contains(ADD) || inputField.getText().contains(SUBTRACT))
		parenthesis = true;

    if (result == null && (input == null || input.isEmpty()))
    {
      
      input = "<html>";
      if (parenthesis)
        input = input.concat("(");
      input = input.concat(inputField.getText());
      input = italicizeI(input);
      if (parenthesis)
        input = input.concat(")");
      input = input.concat(buttonText);
      inputField.setText(EMPTY);

      ((JLabel) displayPanel.getComponent(0)).setText(input);
      ((JLabel) displayPanel.getComponent(1)).setText(EMPTY);
    }
    else if (result != null)
    {
    	if (parenthesis)
      	  input = input.concat("(");
      String inputText = ((JTextField) inputPanel.getComponent(0)).getText();
      inputText = italicizeI(inputText);
      input = input.concat(inputText);
      if (parenthesis)
    	  input = input.concat(")");
      input = input.concat(buttonText);
      inputField.setText(EMPTY);
      ((JLabel) displayPanel.getComponent(0)).setText(input);
      String displayResult = "<html>";
      displayResult = displayResult.concat(result);
      displayResult = italicizeI(displayResult);
      displayResult = displayResult.substring(0, displayResult.length() - 1);
      ((JLabel) displayPanel.getComponent(1)).setText(displayResult);
      input = EMPTY;
    }

  }

  /**
   * Makes i italic
   * 
   * @param text
   * @return the input with italic i
   */
  private static String italicizeI(String text)
  {
    String ret = text;
    int index;
    int count = 0;
    for (int i = 0; i < text.length(); i++)
    {
      if (text.charAt(i) == 'i' && text.charAt(i - 1) != '>')
      {
        count++;
      }
    }
    while (count > 0)
    {
      index = text.indexOf("i");
      ret = text.substring(0, index);
      ret = ret.concat("<i>i</i>");
      if (text.substring(index + 1) != null)
        ret = ret.concat(text.substring(index + 1));
      count--;
    }
    return ret;

  }

  /**
   * Resets the display and input fields.
   */
  void clearAll()
  {
    inputField.setText(EMPTY);
    ((JLabel) displayPanel.getComponent(0)).setText(EMPTY);
    ((JLabel) displayPanel.getComponent(1)).setText(EMPTY);
  }

  /**
   * Handles error message prompting.
   * 
   * @param errorMessage
   *          The error message from the relevant exception.
   */
  protected void errorMessage(String errorMessage)
  {
    JOptionPane.showMessageDialog(null, errorMessage, errorMessage, JOptionPane.ERROR_MESSAGE);
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
