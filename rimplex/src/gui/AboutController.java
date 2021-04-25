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
  static final ResourceBundle STRINGS = ResourceBundle.getBundle("gui.Strings",
      Locale.getDefault());

  @Override
  public void actionPerformed(ActionEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    ClassLoader cldr = this.getClass().getClassLoader();
    java.net.URL imgURL = cldr.getResource("gui/iconRimplex.png");
    ImageIcon icon = new ImageIcon(imgURL);
    JLabel label = new JLabel("<html><center>" + STRINGS.getString("ABOUT_LINE1") + "&emsp;"
        + STRINGS.getString("ABOUT_LINE2") + "<br><br>" + "<html><center>"
        + STRINGS.getString("ABOUT_LINE3") + "<br>" + STRINGS.getString("ABOUT_LINE4") + "<br><br>"
        + "<html><center>" + STRINGS.getString("ABOUT_LINE5") + "<br>"
        + STRINGS.getString("ABOUT_LINE6"));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    JOptionPane.showMessageDialog(ui, label, STRINGS.getString("ABOUT"), JOptionPane.PLAIN_MESSAGE,
        icon);
  }
}
