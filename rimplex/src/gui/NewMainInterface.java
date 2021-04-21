package gui;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class NewMainInterface extends JFrame implements Finals
{
  private static final long serialVersionUID = 5691196863267451960L;

  private static NewMainInterface ui;
  private InterfaceController listener;
  JMenuBar menuBar;
  JPanel northPanel, eastPanel, centerPanel, bar;

  static JButton history;

  JLabel expressionDisplay, resultDisplay, inputDisplay;

  /**
   * Default constructor.
   */
  private NewMainInterface()
  {
    HistoryDisplay history = HistoryDisplay.getInstance();
    setupFrame();
    setSize(670, 550);
    setTitle("Rimplex");
    // ImageIcon icon = new ImageIcon(
    // "C:\\Users\\Brooke\\git\\team11\\rimplex\\src\\gui\\iconRimplex.png");

    ClassLoader cldr = this.getClass().getClassLoader();
    java.net.URL imgURL = cldr.getResource("gui/iconRimplex.png");
    ImageIcon icon = new ImageIcon(imgURL);

    setIconImage(icon.getImage());
    setVisible(true); // display this
    System.out.println("current working directory is: " + System.getProperty("user.dir"));
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

    listener = InterfaceController.getInstance();

    contentPane.setLayout(new BorderLayout(20, 20));

    createMenu();

    setupNorthPanel();
    setupCenterPanel();
    setUpEastPanel();
    // setUpSouthPanel();
    bar = new JPanel();
    bar.setLayout(new GridLayout(1, 1));
    history = new JButton(">");
    HistoryController cont = new HistoryController();
    history.addActionListener(cont);
    bar.add(history);

    contentPane.addComponentListener(cont);

    setJMenuBar(menuBar);
    contentPane.add(northPanel, BorderLayout.NORTH);
    contentPane.add(centerPanel, BorderLayout.WEST);
    contentPane.add(eastPanel, BorderLayout.CENTER);
    contentPane.add(bar, BorderLayout.EAST);
    // contentPane.add(southPanel, BorderLayout.SOUTH);
  }

  private void setUpEastPanel()
  {
    GridLayout layout = new GridLayout(5, 3);
    layout.setHgap(20);
    layout.setVgap(20);
    eastPanel = new JPanel(layout);

    for (String function : FUNCTIONS)
    {
      JButton btn = new JButton(function);
      btn.setForeground(Color.BLUE);
      increaseSize(btn);
      btn.addActionListener(listener);
      btn.setPreferredSize(new Dimension(50, 50));
      eastPanel.add(btn);
    }
  }

  private void setupCenterPanel()
  {
    // GridLayout layout = new GridLayout(5, 3);
    GridBagLayout layout = new GridBagLayout();
    // layout.setHgap(20);
    // layout.setVgap(20);
    centerPanel = new JPanel();
    centerPanel.setLayout(layout);
    GridBagConstraints con = new GridBagConstraints();
    centerPanel.setPreferredSize(new Dimension(300, 500));

    Insets inset = new Insets(10, 10, 10, 10);

    JToggleButton sign = new JToggleButton(SIGN);
    JButton clearBtn = new JButton(CLEAR);
    JButton backBtn = new JButton(BACKSPACE);
    JButton realBtn = new JButton(RPARTS);

    ArrayList<JButton> btns = new ArrayList<>();
    btns.add(clearBtn);
    btns.add(backBtn);

    // for (JButton btn : btns)
    // {
    // increaseSize(btn);
    // btn.addActionListener(listener);
    // btn.setForeground(Color.MAGENTA);
    // con.gridx = 0;
    // con.gridy = 0;
    // // con.fill = GridBagConstraints.HORIZONTAL;
    // con.anchor = GridBagConstraints.NORTH;
    // // layout.setConstraints(btn, con);
    // centerPanel.add(btn, con);
    // }

    // setting up the clear button
    increaseSize(clearBtn);
    clearBtn.setPreferredSize(new Dimension(53, 53));
    clearBtn.addActionListener(listener);
    clearBtn.setForeground(Color.MAGENTA);
    con.fill = GridBagConstraints.BOTH;
    con.gridx = 0;
    con.gridy = 0;
    con.weightx = 100;
    con.insets = inset;
    centerPanel.add(clearBtn, con);

    // setting up the backspace button
    increaseSize(backBtn);
    backBtn.setPreferredSize(new Dimension(53, 53));
    backBtn.addActionListener(listener);
    backBtn.setForeground(Color.MAGENTA);
    con.fill = GridBagConstraints.BOTH;
    con.gridx = 1;
    con.gridy = 0;
    con.weightx = 100;
    con.insets = inset;
    centerPanel.add(backBtn, con);

    // setting up the sign button
    sign(sign);
    sign.setPreferredSize(new Dimension(53, 53));
    sign.addActionListener(listener);
    sign.setForeground(Color.MAGENTA);
    con.fill = GridBagConstraints.BOTH;
    con.gridx = 2;
    con.gridy = 0;
    con.weightx = 100;
    con.insets = inset;
    centerPanel.add(sign, con);

    JButton btn = new JButton(String.valueOf(1));
    increaseSize(btn);
    btn.setPreferredSize(new Dimension(60, 60));
    btn.addActionListener(listener);
    con.gridx = 0;
    con.gridy = 1;
    con.fill = GridBagConstraints.BOTH;
    con.insets = inset;
    centerPanel.add(btn, con);

    JButton btn2 = new JButton(String.valueOf(2));
    increaseSize(btn2);
    btn2.setPreferredSize(new Dimension(60, 60));
    btn2.addActionListener(listener);
    con.gridx = 1;
    con.gridy = 1;
    con.fill = GridBagConstraints.BOTH;
    con.insets = inset;
    centerPanel.add(btn2, con);

    JButton btn3 = new JButton(String.valueOf(3));
    increaseSize(btn3);
    btn3.setPreferredSize(new Dimension(60, 60));
    btn3.addActionListener(listener);
    con.gridx = 2;
    con.gridy = 1;
    con.fill = GridBagConstraints.BOTH;
    con.insets = inset;
    centerPanel.add(btn3, con);

    JButton btn4 = new JButton(String.valueOf(4));
    increaseSize(btn4);
    btn4.setPreferredSize(new Dimension(60, 60));
    btn4.addActionListener(listener);
    con.gridx = 0;
    con.gridy = 2;
    con.fill = GridBagConstraints.BOTH;
    con.insets = inset;
    centerPanel.add(btn4, con);

    JButton btn5 = new JButton(String.valueOf(5));
    increaseSize(btn5);
    btn5.setPreferredSize(new Dimension(60, 60));
    btn5.addActionListener(listener);
    con.gridx = 1;
    con.gridy = 2;
    con.fill = GridBagConstraints.BOTH;
    con.insets = inset;
    centerPanel.add(btn5, con);

    JButton btn6 = new JButton(String.valueOf(6));
    increaseSize(btn6);
    btn6.setPreferredSize(new Dimension(60, 60));
    btn6.addActionListener(listener);
    con.gridx = 2;
    con.gridy = 2;
    con.fill = GridBagConstraints.BOTH;
    con.insets = inset;
    centerPanel.add(btn6, con);

    JButton btn7 = new JButton(String.valueOf(7));
    increaseSize(btn7);
    btn7.setPreferredSize(new Dimension(60, 60));
    btn7.addActionListener(listener);
    con.gridx = 0;
    con.gridy = 3;
    con.fill = GridBagConstraints.BOTH;
    con.insets = inset;
    centerPanel.add(btn7, con);

    JButton btn8 = new JButton(String.valueOf(8));
    increaseSize(btn8);
    btn8.setPreferredSize(new Dimension(60, 60));
    btn8.addActionListener(listener);
    con.gridx = 1;
    con.gridy = 3;
    con.fill = GridBagConstraints.BOTH;
    con.insets = inset;
    centerPanel.add(btn8, con);

    JButton btn9 = new JButton(String.valueOf(9));
    increaseSize(btn9);
    btn9.setPreferredSize(new Dimension(60, 60));
    btn9.addActionListener(listener);
    con.gridx = 2;
    con.gridy = 3;
    con.fill = GridBagConstraints.BOTH;
    con.insets = inset;
    centerPanel.add(btn9, con);

    // for (int i = 1; i < 10; i++)
    // {
    // JButton btnx = new JButton(String.valueOf(i));
    // // centerPanel.add(btn);
    // increaseSize(btn);
    // btn.addActionListener(listener);
    // con.gridx = 0;
    // con.gridy = 1;
    // // con.fill = GridBagConstraints.HORIZONTAL;
    // // con.anchor = GridBagConstraints.CENTER;
    // centerPanel.add(btn, con);
    // }

    JButton zeroBtn = new JButton("0");
    increaseSize(zeroBtn);
    zeroBtn.setPreferredSize(new Dimension(60, 60));
    zeroBtn.addActionListener(listener);
    con.gridx = 0;
    con.gridy = 4;
    con.gridwidth = GridBagConstraints.RELATIVE;
    centerPanel.add(zeroBtn, con);

    JButton imagBtn = new JButton(HTML + I);
    increaseSize(imagBtn);
    imagBtn.setPreferredSize(new Dimension(60, 60));
    imagBtn.addActionListener(listener);
    con.gridx = 2;
    con.gridy = 4;
    con.gridwidth = 1;
    centerPanel.add(imagBtn, con);

  }

  // private void setUpSouthPanel()
  // {
  // GridBagLayout layout = new GridBagLayout();
  // southPanel = new JPanel(layout);
  // GridBagConstraints con = new GridBagConstraints();
  //
  // JButton zeroBtn = new JButton("0");
  // increaseSize(zeroBtn);
  // zeroBtn.addActionListener(listener);
  // con.gridx = 0;
  // con.gridy = 0;
  // con.gridwidth = 2;
  // con.weightx = 100;
  // // con.fill = GridBagConstraints.HORIZONTAL;
  // con.anchor = GridBagConstraints.SOUTHWEST;
  // southPanel.add(zeroBtn);
  //
  // JButton imagBtn = new JButton(HTML + I);
  // increaseSize(imagBtn);
  // imagBtn.addActionListener(listener);
  // con.gridx = 3;
  // con.gridy = 0;
  // // con.fill = GridBagConstraints.HORIZONTAL;
  // con.anchor = GridBagConstraints.SOUTH;
  // southPanel.add(imagBtn);
  // }

  /**
   * Exactly the same as increaseSize but just for ToggleButton.
   * 
   * @param button
   *          the sign button
   */
  private void sign(JToggleButton button)
  {
    Font oldFont = button.getFont();
    Font newFont = new Font("Times New Roman", oldFont.getStyle(), 30);
    button.setFont(newFont);
  }

  /**
   * Increases the font size of the button text.
   * 
   * @param button
   *          the button on the calculator
   */
  private void increaseSize(JComponent button)
  {
    Font oldFont = button.getFont();
    Font newFont = new Font("Times New Roman", oldFont.getStyle(), 30);
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

  /**
   * Creates the menu bar for the frame.
   */
  private void createMenu()
  {
    MenuController menuListener = new MenuController();

    menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu(FILE);
    menuBar.add(fileMenu);

    for (String item : FILEMENUITEMS)
    {
      JMenuItem menuItem = new JMenuItem(item);
      increaseSize(menuItem);
      menuItem.addActionListener(menuListener);
      fileMenu.add(menuItem);
      menuItem.setEnabled(false);
    }

    fileMenu.getItem(0).setEnabled(true);

    JMenu aboutMenu = new JMenu(ABOUT);
    menuBar.add(aboutMenu);
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
