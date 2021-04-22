package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class LogoDisplay extends JWindow implements Finals
{

	private static LogoDisplay logoDisplay = null;
	ImageIcon logo;
	
	private LogoDisplay()
	{
		setupFrame();
		setSize(1, 1);
		setVisible(true);
		setLocation(new Point(515, 150));
		System.out.println("happening");
	}
	
	private void setupFrame()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		ClassLoader cldr = this.getClass().getClassLoader();
	    java.net.URL imgURL = cldr.getResource("gui/logoRimplex.png");
		logo = new ImageIcon(imgURL);
		
		/*try {
			BufferedImage myPicture = ImageIO.read(new File("gui/logoRimplex.png"));
			logo = new ImageIcon(myPicture);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("couldn't get image");
		}*/
		
		JLabel logoLabel = new JLabel(logo);
		contentPane.add(logoLabel, BorderLayout.CENTER);
	}
	
	/**
	   * Singleton.
	   * 
	   * @return the one instance of NewMainInterface
	   */
	  public static LogoDisplay getInstance()
	  {
	    if (logoDisplay == null)
	      logoDisplay = new LogoDisplay();
	    return logoDisplay;

	  }
}
