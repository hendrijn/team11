package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * Creates the main interface.
 * 
 * @author Jacquelyn Hendricks, Brooke Sindelar, Corwin Willms
 * @version v3
 */
public class NewMainInterface extends JFrame implements Finals
{
  private static final long serialVersionUID = 5691196863267451960L;
  private static final Locale LOCALE = Locale.getDefault();
  private static final String US = "US";
  private static final String EN = "EN";
  private static final String TIMES_NEW_ROMAN = "Times New Roman";
  private static final String NIMBUS_BASE = "nimbusBase";
  private static final String CONTROL = "control";
  private static final String TEXT = "text";
  private static JButton history;
  private static NewMainInterface ui;
  private static String GUI_STRINGS = "gui.Strings";
  private static ResourceBundle STRINGS = ResourceBundle.getBundle(GUI_STRINGS, LOCALE);
  JLabel expressionDisplay, resultDisplay, inputDisplay;
  JMenuBar menuBar;
  JMenu settingsMenu, aboutMenu, fileMenu, langMenu;
  JMenuItem about, add, start, pause, stop, print, speed;
  static JPanel northPanel, eastPanel, centerPanel, bar;
  private InterfaceController listener;

  /**
   * Default constructor.
   */
  private NewMainInterface()
  {
    setSize(670, 550);
    setTitle("Rimplex");

    // For OS X

    ClassLoader cldr = this.getClass().getClassLoader();
    java.net.URL imgURL = cldr.getResource("gui/iconRimplex.png");
    ImageIcon icon = new ImageIcon(imgURL);

    final Taskbar taskbar = Taskbar.getTaskbar();

    try
    {
      // set icon for mac os (and other systems which do support this method)
      taskbar.setIconImage(icon.getImage());
    }
    catch (final UnsupportedOperationException e)
    {
      System.out.println("The os does not support: 'taskbar.setIconImage'");
    }
    catch (final SecurityException e)
    {
      System.out.println("There was a security exception for: 'taskbar.setIconImage'");
    }

    setIconImage(icon.getImage());

    setLookAndFeel();
    setupFrame();

    // if both are false, default color scheme is used
    colorSchemeSelection(false, false, true);
    setVisible(true); // display this
    HistoryController cont = new HistoryController();
    addComponentListener(cont);
    // System.out.println("current working directory is: " + System.getProperty("user.dir"));
  }

  /**
   * Getter for the STRINGS attribute.
   * 
   * @return the STRINGS attribute.
   */
  public ResourceBundle getStrings()
  {
    return STRINGS;
  }

  /**
   * Getter for the history attribute.
   * 
   * @return the history attribute.
   */
  public static JButton getHistory()
  {
    return history;
  }

  /**
   * Handles error message prompting.
   * 
   * @param errorMessage
   *          The error message from the relevant exception.
   */
  protected void errorMessage(final String errorMessage)
  {
    JOptionPane.showMessageDialog(null, errorMessage, errorMessage, JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Creates all frame containers and components. Adds containers to the contentPane. Sets close
   * default and language.
   */
  private void setupFrame()
  {
    Container contentPane = getContentPane();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane.setLayout(new BorderLayout(20, 20));

    listener = InterfaceController.getInstance();

    createMenu();

    setupNorthPanel();
    setupEastPanel();
    setUpCenterPanel();
    setupWestPanel(contentPane);

    updateLanguage(new Locale(EN, US));

    setJMenuBar(menuBar);
    contentPane.add(northPanel, BorderLayout.NORTH);
    contentPane.add(bar, BorderLayout.EAST);
    contentPane.add(eastPanel, BorderLayout.CENTER);
    contentPane.add(centerPanel, BorderLayout.WEST);
  }

  /**
   * Helper method to change color scheme.
   * 
   * @param dark
   *          dark mode enabled.
   * @param light
   *          light mode enabled.
   * @param regular
   *          the normal mode.
   */
  private void colorSchemeSelection(final boolean dark, final boolean light, final boolean regular)
  {
    if (dark)
    {
      UIManager.put(NIMBUS_BASE, Color.DARK_GRAY);
      UIManager.put(CONTROL, Color.BLACK);
      UIManager.put(TEXT, Color.WHITE);
    }
    else if (light)
    {
      UIManager.put(NIMBUS_BASE, Color.WHITE);
      UIManager.put(CONTROL, Color.WHITE);
      UIManager.put(TEXT, Color.BLACK);
    }
    /*
     * else if (regular) { // need to find the color that the background is }
     */
  }

  /**
   * Helper method to make interface look the same across operating systems.
   */
  private void setLookAndFeel()
  {
    boolean done = false;
    try
    {
      UIManager.LookAndFeelInfo[] lfs = UIManager.getInstalledLookAndFeels();
      for (int i = 0; i < lfs.length && !done; i++)
      {
        if ("Nimbus".equals(lfs[i].getName()))
        {
          UIManager.setLookAndFeel(lfs[i].getClassName());
          done = true;
        }
      }
      if (!done)
      {
        String look = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(look);
      }
    }
    catch (ClassNotFoundException exp)
    {
      // will use default
    }
    catch (IllegalAccessException exp)
    {
      // will use default
    }
    catch (InstantiationException exp)
    {
      // will use default
    }
    catch (UnsupportedLookAndFeelException exp)
    {
      // will use default
    }
  }

  /**
   * Creates the history display button in the west panel.
   * 
   * @param contentPane
   *          the main content pane.
   */
  private void setupWestPanel(final Container contentPane)
  {
    bar = new JPanel();
    bar.setLayout(new GridLayout(1, 1));
    history = new JButton(">");
    history.addActionListener(listener);
    bar.add(history);
  }

  /**
   * Creates the center panel that houses all the function buttons.
   */
  private void setUpCenterPanel()
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

  /**
   * Creates the east panel with all numbers and sign, clear, and backspace.
   */
  private void setupEastPanel()
  {
    GridBagLayout layout = new GridBagLayout();
    centerPanel = new JPanel();
    centerPanel.setLayout(layout);
    GridBagConstraints con = new GridBagConstraints();
    centerPanel.setPreferredSize(new Dimension(300, 500));

    Insets inset = new Insets(5, 5, 5, 5);

    JToggleButton sign = new JToggleButton(SIGN);
    JButton clearBtn = new JButton(CLEAR);
    JButton backBtn = new JButton(BACKSPACE);

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

  /**
   * Exactly the same as increaseSize but just for ToggleButton.
   * 
   * @param button
   *          the sign button
   */
  private void sign(final JToggleButton button)
  {
    Font oldFont = button.getFont();
    Font newFont = new Font(TIMES_NEW_ROMAN, oldFont.getStyle(), 30);
    button.setFont(newFont);
  }

  /**
   * Increases the font size of the button text.
   * 
   * @param button
   *          the button on the calculator
   */
  private void increaseSize(final JComponent button)
  {
    Font oldFont = button.getFont();

    if (button instanceof JButton || button instanceof JToggleButton)
    {
      Font newFont = new Font(TIMES_NEW_ROMAN, oldFont.getStyle(), 30);
      button.setFont(newFont);
    }
    else if (button instanceof JMenu || button instanceof JMenuItem)
    {
      Font newFont = new Font(TIMES_NEW_ROMAN, oldFont.getStyle(), 20);
      button.setFont(newFont);
    }
  }

  /**
   * Creates the display in the north panel. Adds three labels for the input, expression, and
   * results.
   */
  private void setupNorthPanel()
  {
    northPanel = new JPanel(new GridLayout(2, 2));
    // northPanel.setBackground(Color.lightGray);
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
    Font newFont = new Font(TIMES_NEW_ROMAN, oldFont.getStyle(), 30);
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
   * Sets language settings for the words on screen.
   * 
   * @param locale
   *          the locale
   */
  public void updateLanguage(final Locale locale)
  {
    NewMainInterface.STRINGS = ResourceBundle.getBundle(GUI_STRINGS, locale);
    settingsMenu.setText(STRINGS.getString("SETTINGS"));
    fileMenu.setText(STRINGS.getString("FILE"));
    aboutMenu.setText(STRINGS.getString("HELP"));
    langMenu.setText(STRINGS.getString("LANG"));
    about.setText(STRINGS.getString("ABOUT"));
    add.setText(STRINGS.getString("ADDTOREC"));
    start.setText(STRINGS.getString("START"));
    stop.setText(STRINGS.getString("STOP"));
    pause.setText(STRINGS.getString("PAUSE"));
    print.setText(STRINGS.getString("PRINT"));
    speed.setText(STRINGS.getString("SET_SPEED"));

  }

  /**
   * Creates the menu bar for the frame.
   */
  private void createMenu()
  {
    MenuController menuListener = MenuController.getInstance();
    AboutController aboutListener = new AboutController();

    menuBar = new JMenuBar();

    fileMenu = new JMenu();
    increaseSize(fileMenu);
    menuBar.add(fileMenu);

    add = new JMenuItem();
    start = new JMenuItem();
    stop = new JMenuItem();
    pause = new JMenuItem();
    print = new JMenuItem();
    JMenuItem[] fileItems = {add, start, pause, stop, print};
    for (JMenuItem item : fileItems)
    {
      increaseSize(item);
      item.addActionListener(menuListener);
      fileMenu.add(item);
      item.setEnabled(false);
    }
    // prevents recording playback
    fileMenu.getItem(0).setEnabled(true);
    fileMenu.getItem(4).setEnabled(true);

    settingsMenu = new JMenu();
    increaseSize(settingsMenu);
    speed = new JMenuItem();
    increaseSize(speed);
    speed.addActionListener(menuListener);
    settingsMenu.add(speed);

    langMenu = new JMenu();
    increaseSize(langMenu);
    settingsMenu.add(langMenu);

    JMenuItem english = new JMenuItem(ENG);
    JMenuItem french = new JMenuItem(FRE);
    JMenuItem german = new JMenuItem(GER);
    increaseSize(english);
    increaseSize(french);
    increaseSize(german);
    english.addActionListener((ActionEvent e) -> {
      updateLanguage(new Locale(EN, US));
    });
    langMenu.add(english);

    french.addActionListener((ActionEvent e) -> {
      updateLanguage(new Locale("fr", "FR"));
    });
    langMenu.add(french);

    german.addActionListener((ActionEvent e) -> {
      updateLanguage(new Locale("de", "DE"));
    });
    langMenu.add(german);
    menuBar.add(settingsMenu);

    aboutMenu = new JMenu();
    increaseSize(aboutMenu);
    about = new JMenuItem();
    increaseSize(about);
    about.addActionListener(aboutListener);
    aboutMenu.add(about);
    menuBar.add(aboutMenu);
  }

  /**
   * Gets the expression label.
   * 
   * @return the expression label
   */
  public JLabel getExpressionLabel()
  {
    return expressionDisplay;
  }

  /**
   * Gets the results label.
   * 
   * @return the results label
   */
  public JLabel getResultLabel()
  {
    return resultDisplay;
  }

  /**
   * Gets the input label.
   * 
   * @return the input label
   */
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
