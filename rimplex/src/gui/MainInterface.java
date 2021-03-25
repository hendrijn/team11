package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

  private JLabel displayPanel;
  private JTextField inputPanel;
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
    displayPanel = new JLabel("Display Label is here");
  }

  /**
   * Sets up the main frame. Here is where we add the components to the main pane. Order matters
   * here.
   */
  private void setupFrame()
  {
    Container contentPane = getContentPane();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   // contentPane.setLayout(new GridLayout(3, 1));
    contentPane.setLayout(new GridBagLayout());
    
    GridBagConstraints gridC = new GridBagConstraints();
    
    
    //-----------Display Pane--------------------//
    gridC.weightx = 5;
    gridC.weighty = 5;
    
    gridC.anchor = GridBagConstraints.FIRST_LINE_START;
    
    gridC.gridx = 0;
    gridC.gridy = 0;
    
    addButtons();

    displayPanel.setPreferredSize(new Dimension (500,60));
    Font displayFont = displayPanel.getFont();
    displayPanel.setFont(new Font(displayFont.getFontName(), Font.PLAIN, 14));
    displayPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5, true));
    
    add (displayPanel, gridC);
    
    //--------Buttons----------------//
    
    addButtons();
    
    gridC.gridx = 0;
    gridC.gridy = 1;
    
    add (buttonPanel, gridC);
    //contentPane.add(displayPanel);
    //contentPane.add(buttonPanel);
    
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