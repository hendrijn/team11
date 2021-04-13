package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * Handles the history window.
 * 
 * @author Jacquelyn Hendricks
 * @version v2
 */
public class HistoryDisplay extends JFrame implements Finals
{
  private static HistoryDisplay history = null;
  JButton open;
  JButton close;
  JTextArea list;

  private HistoryController listener;

  /**
   * Default constructor.
   */
  private HistoryDisplay()
  {
    setupFrame();
    setSize(40, 420);
    ImageIcon icon = new ImageIcon(
        "C:\\Users\\Brooke\\git\\team11\\rimplex\\src\\gui\\iconRimplex.png");
    setIconImage(icon.getImage());
    setVisible(true);
    setLocation(450, 100);
  }

  private void setupFrame()
  {
    Container contentPane = getContentPane();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane.setLayout(new BorderLayout());

    addComponents();

    contentPane.add(open, BorderLayout.WEST);
    contentPane.add(close, BorderLayout.EAST);
    contentPane.add(list, BorderLayout.CENTER);
  }

  private void addComponents()
  {
    listener = new HistoryController();

    open = new JButton(">");
    close = new JButton("<");
    list = new JTextArea();

    open.addActionListener(listener);
    close.addActionListener(listener);

    close.setVisible(false);
    list.setVisible(false);
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
}
