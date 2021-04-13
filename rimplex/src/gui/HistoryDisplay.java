package gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Handles the history window.
 * 
 * @author Jacquelyn Hendricks
 * @version v2
 */
public class HistoryDisplay extends JFrame implements Finals
{
  private static HistoryDisplay history = null;

  /**
   * Default constructor.
   */
  private HistoryDisplay()
  {
    setupFrame();
    setSize(520, 500);
    setTitle("Rimplex");
    ImageIcon icon = new ImageIcon(
        "C:\\Users\\Brooke\\git\\team11\\rimplex\\src\\gui\\iconRimplex.png");
    setIconImage(icon.getImage());
    setVisible(true);
  }

  private void setupFrame()
  {
    Container contentPane = getContentPane();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane.setLayout(new BorderLayout());
    contentPane.add(new JLabel("Hi"), BorderLayout.CENTER);
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
