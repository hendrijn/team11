package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;

/**
 * Handles the history window.
 * 
 * @author Jacquelyn Hendricks
 * @version v2
 */

// make component listener on the JFrame
// implement component moved method
public class HistoryDisplay extends JWindow implements Finals, ComponentListener
{
  private static HistoryDisplay history = null;
  JButton open;
  JButton close;
  JScrollPane listPane;
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
    setLocation(515, 110);
  }

  private void setupFrame()
  {
    Container contentPane = getContentPane();
    // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane.setLayout(new BorderLayout());

    addButtons();
    addList();

    // contentPane.add(open, BorderLayout.WEST);
    contentPane.add(close, BorderLayout.EAST);
    contentPane.add(listPane, BorderLayout.CENTER);
  }

  private void addButtons()
  {
    listener = new HistoryController();

    // open = new JButton(">");
    close = new JButton("<");

    // open.addActionListener(listener);
    close.addActionListener(listener);

    close.setVisible(false);
  }

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
  public void addCalculation(String calc)
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

  @Override
  public void componentResized(ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void componentMoved(ComponentEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    Point loc = ui.history.getLocation();
    history.setLocation(loc);

  }

  @Override
  public void componentShown(ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void componentHidden(ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }
}
