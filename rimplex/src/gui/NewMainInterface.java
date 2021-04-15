package gui;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
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

  static JButton history;

  JLabel expressionDisplay;
  JLabel resultDisplay;
  JLabel inputDisplay;

  /**
   * Default constructor.
   */
  private NewMainInterface()
  {
    HistoryDisplay history = HistoryDisplay.getInstance();
    setupFrame();
    setSize(520, 500);
    setTitle("Rimplex");
    ImageIcon icon = new ImageIcon(
        "C:\\Users\\Brooke\\git\\team11\\rimplex\\src\\gui\\iconRimplex.png");
    setIconImage(icon.getImage());
    setVisible(true); // display this
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

    contentPane.setLayout(new BorderLayout(20, 20));

    setupNorthPanel();
    setupCenterPanel();
    setUpEastPanel();
    JPanel bar = new JPanel();
    bar.setLayout(new GridLayout(1, 1));
    history = new JButton(">");
    HistoryController cont = new HistoryController();
    history.addActionListener(cont);
    bar.add(history);

    contentPane.addComponentListener(cont);

    contentPane.add(northPanel, BorderLayout.NORTH);
    contentPane.add(centerPanel, BorderLayout.WEST);
    contentPane.add(eastPanel, BorderLayout.CENTER);
    contentPane.add(bar, BorderLayout.EAST);
  }

  private void setUpEastPanel()
  {
    GridLayout layout = new GridLayout(5, 2);
    layout.setHgap(20);
    layout.setVgap(20);
    eastPanel = new JPanel(layout);

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
    GridLayout layout = new GridLayout(5, 3);
    layout.setHgap(20);
    layout.setVgap(20);
    centerPanel = new JPanel(layout);

    JToggleButton sign = new JToggleButton(SIGN);
    JButton clearBtn = new JButton(CLEAR);
    JButton backBtn = new JButton(BACKSPACE);

    ArrayList<JButton> btns = new ArrayList<>();
    btns.add(clearBtn);
    btns.add(backBtn);

    for (JButton btn : btns)
    {
      increaseSize(btn);
      btn.addActionListener(listener);
      btn.setForeground(Color.MAGENTA);
      centerPanel.add(btn);
    }
    sign(sign);

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
   * Exactly the same as increaseSize but just for ToggleButton.
   * 
   * @param button
   *          the sign button
   */
  private void sign(JToggleButton button)
  {
    Font oldFont = button.getFont();
    Font newFont = new Font("Times New Roman", oldFont.getStyle(), 20);
    button.setFont(newFont);

    button.addActionListener(listener);
    button.setForeground(Color.MAGENTA);
    centerPanel.add(button);
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
    northPanel.setPreferredSize(new Dimension(400, 100));

    Border displayB = BorderFactory.createLineBorder(Color.BLUE, 3, true);
    northPanel.setBorder(displayB);

    expressionDisplay = new JLabel(HTML, JLabel.LEFT);
    resultDisplay = new JLabel(HTML, JLabel.RIGHT);
    inputDisplay = new JLabel(HTML, JLabel.RIGHT);
    inputDisplay.setFocusable(true);
    inputDisplay.addKeyListener(listener);
    expressionDisplay.addKeyListener(listener);
    resultDisplay.addKeyListener(listener);

    inputDisplay.setFocusable(true);
    inputDisplay.addFocusListener(listener);
    inputDisplay.requestFocusInWindow();

    Font oldFont = expressionDisplay.getFont();
    Font newFont = new Font("Times New Roman", oldFont.getStyle(), 40);
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
