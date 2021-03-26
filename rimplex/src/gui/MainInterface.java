package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.Border;

/**
 * Serves as the main window for the interface.
 *
 * @author Jacquelyn Hendricks
 * @version March 23 2021
 */
public class MainInterface extends JFrame
{
  // The serial ID for serailization
  private static final long serialVersionUID = 1L;
  private static MainInterface frame;

  private JPanel displayPanel;
  private JPanel inputPanel;
  private JPanel buttonPanel;

  /**
   * Default constructor.
   */
  private MainInterface()
  {
    createComponents();
    setupFrame();
    setSize(600, 300);
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
    ButtonListener listener = new ButtonListener();

    JButton resetButton = new JButton("R");
    JButton addButton = new JButton("+");
    JButton subtractButton = new JButton("-");
    JButton multiplyButton = new JButton("x");
    JButton divideButton = new JButton("÷");

    resetButton.setForeground(Color.RED);

    resetButton.addActionListener(listener);
    addButton.addActionListener(listener);
    subtractButton.addActionListener(listener);
    multiplyButton.addActionListener(listener);
    divideButton.addActionListener(listener);

    buttonPanel.add(resetButton);
    buttonPanel.add(addButton);
    buttonPanel.add(subtractButton);
    buttonPanel.add(multiplyButton);
    buttonPanel.add(divideButton);
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
    addButtons();

    contentPane.add(displayPanel);
    contentPane.add(buttonPanel);
  }

  void updateDisplay(String text, String operator)
  {
	  if (operator.equals("="))
	  {
		  ((JLabel) displayPanel.getComponent(1)).setText(text + operator);
		  ((JLabel) displayPanel.getComponent(0)).setText("");
	  } else {
		  ((JLabel) displayPanel.getComponent(0)).setText(text + operator);
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
