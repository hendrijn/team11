package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    ClassLoader cldr = this.getClass().getClassLoader();
    java.net.URL imgURL = cldr.getResource("gui/iconRimplex.png");
    ImageIcon icon = new ImageIcon(imgURL);
    JLabel label = new JLabel("<html><center>Rimplex Calculator &emsp; Copyright © 2021<br><br>"
        + "<html><center>The Rimplex calculator is designed to perform various <br> operations on real, imaginary, and complex numbers.<br><br>"
        + "<html><center>Creators: P. Glebus, J. Hendricks, S. May, <br>B. Sindelar, C. Willms");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    JOptionPane.showMessageDialog(ui, label, "About", JOptionPane.PLAIN_MESSAGE, icon);
  }
}
