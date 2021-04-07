package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class NewMainInterface extends JFrame implements Finals
{
  private static final long serialVersionUID = 5691196863267451960L;

  private static NewMainInterface ui;
  private InterfaceController listener;
  private JPanel northPanel;
  private JPanel eastPanel;
  private JPanel centerPanel;

  JLabel expressionDisplay;
  JLabel resultDisplay;
  JLabel inputDisplay;

  /**
   * Default constructor.
   */
  private NewMainInterface()
  {
    setupFrame();
    setSize(400, 500);
    setTitle("Rimplex");
    setVisible(true); // display this
    centerForm();

  }

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

  private void setupFrame()
  {
    Container contentPane = getContentPane();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    listener = new InterfaceController();

    contentPane.setLayout(new BorderLayout());

    setupNorthPanel();
    setupCenterPanel();
    setUpEastPanel();

    contentPane.add(northPanel, BorderLayout.NORTH);
    contentPane.add(centerPanel, BorderLayout.CENTER);
    contentPane.add(eastPanel, BorderLayout.EAST);
  }

  private void setUpEastPanel()
  {
    eastPanel = new JPanel(new GridLayout(5, 2));

    for (String function : FUNCTIONS)
    {
      JButton btn = new JButton(function);
      btn.setForeground(Color.BLUE);
      increaseSize(btn);
      btn.addActionListener(listener);
      eastPanel.add(btn);
    }
  }

  private void setupCenterPanel()
  {
    centerPanel = new JPanel(new GridLayout(5, 3));

    JButton sign = new JButton(SIGN);
    JButton clearBtn = new JButton(CLEAR);
    JButton backBtn = new JButton(BACKSPACE);

    ArrayList<JButton> btns = new ArrayList<>();
    btns.add(sign);
    btns.add(clearBtn);
    btns.add(backBtn);

    for (JButton btn : btns)
    {
      increaseSize(btn);
      btn.addActionListener(listener);
      btn.setForeground(Color.MAGENTA);
      centerPanel.add(btn);
    }

    for (int i = 1; i < 10; i++)
    {
      JButton btn = new JButton(String.valueOf(i));
      centerPanel.add(btn);
      increaseSize(btn);
      btn.addActionListener(listener);
      centerPanel.add(btn);
    }

    centerPanel.add(new JPanel());

    JButton zeroBtn = new JButton("0");
    increaseSize(zeroBtn);
    zeroBtn.addActionListener(listener);
    centerPanel.add(zeroBtn);

    JButton imagBtn = new JButton(HTML + I);
    increaseSize(imagBtn);
    imagBtn.addActionListener(listener);
    centerPanel.add(imagBtn);
  }

  /**
   * Increases the font size of the button text.
   * 
   * @param button
   *          the button on the calculator
   */
  private void increaseSize(JButton button)
  {
    Font oldFont = button.getFont();
    Font newFont = new Font("Times New Roman", oldFont.getStyle(), 20);
    button.setFont(newFont);
  }

  /**
   * Corwin adds the north items.
   */
  private void setupNorthPanel()
  {
    northPanel = new JPanel(new GridLayout(2, 2));
    northPanel.setBackground(Color.lightGray);

    Border displayB = BorderFactory.createLineBorder(Color.BLUE, 3, true);
    northPanel.setBorder(displayB);

    expressionDisplay = new JLabel(HTML, JLabel.LEFT);
    resultDisplay = new JLabel(HTML, JLabel.RIGHT);
    inputDisplay = new JLabel(HTML, JLabel.RIGHT);
    inputDisplay.setFocusable(true); 
    inputDisplay.addKeyListener(listener);
    
    Font oldFont = expressionDisplay.getFont();
    Font newFont = new Font("Times New Roman", oldFont.getStyle(), 20);
    expressionDisplay.setFont(newFont);
    resultDisplay.setFont(newFont);
    inputDisplay.setFont(newFont);

    northPanel.add(expressionDisplay);
    northPanel.add(resultDisplay);
    // Filler label to make layout work
    northPanel.add(new JLabel());
    northPanel.add(inputDisplay);
  }

  public JLabel getExpressionLabel()
  {
    return expressionDisplay;
  }

  public JLabel getResultLabel()
  {
    return resultDisplay;
  }

  public JLabel getInputLabel()
  {
    return inputDisplay;
  }

  /**
   * Singleton.
   * 
   * @return the one instance of NewMainInterface
   */
  public static NewMainInterface getInstance()
  {
    if (ui == null)
      ui = new NewMainInterface();
    return ui;

  }
}
