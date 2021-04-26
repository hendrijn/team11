package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class AboutController implements ActionListener, Finals
{

  @Override
  public void actionPerformed(ActionEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    ui.updateLanguage(NewMainInterface.STRINGS.getLocale());
    ClassLoader cldr = this.getClass().getClassLoader();
    java.net.URL imgURL = cldr.getResource("gui/iconRimplex.png");
    ImageIcon icon = new ImageIcon(imgURL);
    JLabel label = new JLabel("<html><center>" + NewMainInterface.STRINGS.getString("ABOUT_LINE1")
        + "&emsp;" + NewMainInterface.STRINGS.getString("ABOUT_LINE2") + "<br><br>"
        + "<html><center>" + NewMainInterface.STRINGS.getString("ABOUT_LINE3") + "<br>"
        + NewMainInterface.STRINGS.getString("ABOUT_LINE4") + "<br><br>" + "<html><center>"
        + NewMainInterface.STRINGS.getString("ABOUT_LINE5") + "<br>"
        + NewMainInterface.STRINGS.getString("ABOUT_LINE6"));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    JOptionPane.showMessageDialog(ui, label, NewMainInterface.STRINGS.getString("ABOUT"),
        JOptionPane.PLAIN_MESSAGE, icon);
  }
}
