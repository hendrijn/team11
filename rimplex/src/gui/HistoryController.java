package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Controls the history window.
 * 
 * @author Jacquelyn Hendricks
 * @v2
 */
public class HistoryController implements Finals, ActionListener
{
  @Override
  public void actionPerformed(ActionEvent e)
  {
    HistoryDisplay history = HistoryDisplay.getInstance();
    JButton btn = (JButton) e.getSource();

    switch (btn.getText())
    {
      case ">":
        history.setSize(500, 380);
        history.listPane.setVisible(true);
        history.close.setVisible(true);
        // history.open.setVisible(false);
        break;
      case "<":
        history.setSize(1, 1);
        history.listPane.setVisible(false);
        history.close.setVisible(false);
        // history.open.setVisible(true);
        break;

    }
  }

}
