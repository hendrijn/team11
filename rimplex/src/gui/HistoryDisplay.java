package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;

/**
 * Handles the history window.
 * 
 * @author Jacquelyn Hendricks
 * @version Sprint 3
 */

public class HistoryDisplay extends JWindow implements Finals
{
  static final long serialVersionUID = -1;
  private static HistoryDisplay history = null;
  JButton close;
  JScrollPane listPane;
  Point origin;
  private JTextArea calcList;

  private HistoryController listener;

  /**
   * Default constructor.
   */
  private HistoryDisplay()
  {
    setupFrame();
    setSize(1, 1);
    ImageIcon icon = new ImageIcon(
        "C:\\Users\\Brooke\\git\\team11\\rimplex\\src\\gui\\iconRimplex.png");
    setIconImage(icon.getImage());
    setVisible(true);
  }

  /**
   * Sets up the components of the HistoryDisplay.
   */
  private void setupFrame()
  {
    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());

    addButtons();
    addList();

    contentPane.add(close, BorderLayout.EAST);
    contentPane.add(listPane, BorderLayout.CENTER);
    contentPane.addComponentListener(listener);
  }

  /**
   * Adds the buttons to the display.
   */
  private void addButtons()
  {
    listener = new HistoryController();

    close = new JButton("<");
    close.addActionListener(listener);

    close.setVisible(false);
  }

  /**
   * Adds the text area to the display.
   */
  private void addList()
  {
    calcList = new JTextArea();
    listPane = new JScrollPane(calcList);
    calcList.setEditable(false); // prohibits the user from typing
    listPane.setVisible(false);
  }

  /**
   * Adds the incoming calculation to the list.
   * 
   * @param calc
   *          the calculation
   */
  public void addCalculation(final String calc)
  {
    String prevText = calcList.getText();
    calcList.setText(prevText + "\t" + calc + "\n");
  }

  /**
   * Singleton.
   * 
   * @return the one instance of NewMainInterface
   */
  public static HistoryDisplay getInstance()
  {
    if (history == null)
      history = new HistoryDisplay();
    return history;
  }

  /**
   * Getter for the calcList attribute.
   * 
   * @return the calcList attribute.
   */
  public JTextArea getCalcList()
  {
    return calcList;
  }
}
