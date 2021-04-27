package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * Controls the about page and menu item.
 * 
 * @author Brooke Sindelar - team 11
 * @version Sprint 3
 */
public class AboutController implements ActionListener, Finals
{
  private final String htmlCenter = "<html><center>";
  private final String br = "<br>";
  private final String brBr = "<br><br>";
  
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    NewMainInterface ui = NewMainInterface.getInstance();
    ui.updateLanguage(ui.getStrings().getLocale());
    ClassLoader cldr = this.getClass().getClassLoader();
    java.net.URL imgURL = cldr.getResource("gui/iconRimplex.png");
    ImageIcon icon = new ImageIcon(imgURL);
    JLabel label = new JLabel(htmlCenter + ui.getStrings().getString("ABOUT_LINE1")
        + "&emsp;" + ui.getStrings().getString("ABOUT_LINE2") + brBr
        + htmlCenter + ui.getStrings().getString("ABOUT_LINE3") + br
        + ui.getStrings().getString("ABOUT_LINE4") + brBr + htmlCenter
        + ui.getStrings().getString("ABOUT_LINE5") + br
        + ui.getStrings().getString("ABOUT_LINE6"));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    JOptionPane.showMessageDialog(ui, label, ui.getStrings().getString("ABOUT"),
        JOptionPane.PLAIN_MESSAGE, icon);
  }
}
