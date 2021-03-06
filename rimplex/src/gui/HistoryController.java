package gui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

/**
 * Controls the history window.
 * 
 * @author Jacquelyn Hendricks
 * @version Sprint 3
 */
public class HistoryController implements Finals, ActionListener, ComponentListener, WindowListener
{

  /**
   * Performs the actions when necessary.
   */
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    HistoryDisplay history = HistoryDisplay.getInstance();
    JButton btn = (JButton) e.getSource();

    switch (btn.getText())
    {
      case ">":
        history.setSize(500, 340);
        history.setLocationRelativeTo(btn);
        history.listPane.setVisible(true);
        history.close.setVisible(true);
        NewMainInterface.getHistory().setVisible(false);
        break;
      case "<":
        history.setSize(1, 1);
        history.listPane.setVisible(false);
        history.close.setVisible(false);
        NewMainInterface.getHistory().setVisible(true);
        break;
      default:
        break;

    }
  }

  @Override
  public void componentResized(final ComponentEvent e)
  {
  }

  /**
   * Handles movement of the main interface.
   */
  @Override
  public void componentMoved(final ComponentEvent e)
  {
    HistoryDisplay history = HistoryDisplay.getInstance();
    Component comp = (Component) e.getSource();
    Point shift = comp.getLocationOnScreen();

    history.setLocation(shift.x + 662, shift.y + 200);
  }

  @Override
  public void componentShown(final ComponentEvent e)
  {

  }

  @Override
  public void componentHidden(final ComponentEvent e)
  {

  }

  @Override
  public void windowOpened(WindowEvent e)
  {
  }

  @Override
  public void windowClosing(WindowEvent e)
  {
  }

  @Override
  public void windowClosed(WindowEvent e)
  {
  }

  /**
   * Minimizes the history display.
   */
  @Override
  public void windowIconified(WindowEvent e)
  {
    HistoryDisplay history = HistoryDisplay.getInstance();
    history.setVisible(false);
  }

  /**
   * Maximizes the history display.
   */
  @Override
  public void windowDeiconified(WindowEvent e)
  {
    HistoryDisplay history = HistoryDisplay.getInstance();
    history.setVisible(true);
  }

  @Override
  public void windowActivated(WindowEvent e)
  {
  }

  @Override
  public void windowDeactivated(WindowEvent e)
  {
  }

}
