package gui;

import java.awt.*;
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
  // The serial ID for serailization
  private static final long serialVersionUID = 1L;
  private static MainInterface frame;

  private JPanel displayPanel;
  private JPanel inputPanel;
  private JPanel buttonPanel;

  private ButtonListener listener = new ButtonListener();

  /**
   * Default constructor.
   */
  private MainInterface()
  {
    createComponents();
    setupFrame();
    setSize(500, 200);
    setVisible(true); // display this
    centerForm();

  }

  /**
   * Adds the buttons to the button panel. We'll need to add the clear and equals button as well.
   * Order adding to the panel matters.
   * 
   * Note: I might redesign how this is done later. Maybe make an abstract kind of button? Put them
   * in an arraylist to avoid so much code duplication? Something like that cuz I feel this might be
   * noncohesive.
   */
  private void addButtons()
  {
    JButton resetButton = new JButton("R");
    JButton addButton = new JButton(ADD);
    JButton subtractButton = new JButton(SUBTRACT);
    JButton multiplyButton = new JButton(MULTIPLY);
    JButton divideButton = new JButton(DIVIDE);
    JButton equalsButton = new JButton(EQUALS);

    resetButton.setForeground(Color.RED);

    resetButton.addActionListener(listener);
    addButton.addActionListener(listener);
    subtractButton.addActionListener(listener);
    multiplyButton.addActionListener(listener);
    divideButton.addActionListener(listener);
    equalsButton.addActionListener(listener);

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
    JTextField input = new JTextField();
    input.setHorizontalAlignment(JTextField.RIGHT);
    input.addKeyListener(listener);

    inputPanel.setLayout(new BorderLayout());
    inputPanel.add(input, BorderLayout.NORTH);
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

  void updateDisplay(String text, String operator)
  {
	  /**
	  if (operator.equals("="))
	  {
		  //Will eventually display result
		  ((JLabel) displayPanel.getComponent(1)).setText(text + operator);
		  
		  //should this be set to nothing or contain full equation???? 
		  ((JLabel) displayPanel.getComponent(0)).setText("");
	  } else {
		  ((JLabel) displayPanel.getComponent(0)).setText(text + operator);
	  } */
	  
    // checks if operand is valid before updating the display.
    if (badOperand(text))
    {
      // Display some sort of error message asking for a valid operand.
      // Maybe in its own hidden JLabel to be added??????
      return;
    }
    if (operator.equals("="))
    {
      // Will eventually display result
      ((JLabel) displayPanel.getComponent(1)).setText(text + operator);

      // should this be set to nothing or contain full equation????
      ((JLabel) displayPanel.getComponent(0)).setText("");
    }
    else
    {
      ((JLabel) displayPanel.getComponent(0)).setText(text + operator);
    }

  }

  private boolean badOperand(String operand)
  {
    return false;
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
