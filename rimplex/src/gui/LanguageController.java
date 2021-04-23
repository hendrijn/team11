package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenuItem;

public class LanguageController implements ActionListener, Finals
{

  @Override
  public void actionPerformed(ActionEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();

    if (e.getSource() instanceof JMenuItem)
    {
      JMenuItem item = (JMenuItem) e.getSource();
      switch (item.getText())
      {
        case ENG:
          Locale loc = Locale.getDefault();
          break;
        case FRE:
          Locale locale = Locale.FRANCE;
          break;
        case GER:
          Locale lo = Locale.GERMANY;
          break;
        default:
          Locale local = Locale.getDefault();
          break;
      }
    }
    // TODO Auto-generated method stub

  }

}
