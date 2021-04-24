package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Taskbar;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class LogoDisplay extends JWindow implements Finals
{

	private static LogoDisplay logoDisplay = null;
	ImageIcon logo;
	Point origin;
	Container contentPane;
	
	private LogoDisplay() 
	{
		ClassLoader cldr = this.getClass().getClassLoader();
	    java.net.URL imgURL = cldr.getResource("gui/iconRimplex.png");
	    ImageIcon icon = new ImageIcon(imgURL);

	    final Taskbar taskbar = Taskbar.getTaskbar();

	    try
	    {
	      // set icon for mac os (and other systems which do support this method)
	      taskbar.setIconImage(icon.getImage());
	    }
	    catch (final UnsupportedOperationException e)
	    {
	      System.out.println("The os does not support: 'taskbar.setIconImage'");
	    }
	    catch (final SecurityException e)
	    {
	      System.out.println("There was a security exception for: 'taskbar.setIconImage'");
	    }

	    setIconImage(icon.getImage());
	    
		setupFrame();
		setSize(1, 1);
		
		this.setVisible(true);
		setLoc(500, 300);
		
	}
	
	void setLoc(int x, int y)
	  {
	    origin = new Point(x, y);
	    setLocation(origin);
	  }
	
	private void setupFrame()
	{
		contentPane = getContentPane();
		contentPane.setPreferredSize(new Dimension(500,250));
		contentPane.setLayout(new BorderLayout());
		
		
		
		ClassLoader cldr = this.getClass().getClassLoader();
	    java.net.URL imgURL = cldr.getResource("gui/logoRimplex.png");
		logo = new ImageIcon(imgURL);
		
		JLabel logoLabel = null;
		
		try {
			BufferedImage logoPic = ImageIO.read(imgURL);
			logoLabel = new JLabel(new ImageIcon(logoPic));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("couldn't get image");
		}
		
		contentPane.add(logoLabel, BorderLayout.CENTER);
	}
	
	/**
	   * Singleton.
	   * 
	   * @return the one instance of NewMainInterface
	 * @throws InterruptedException 
	   */
	  public static LogoDisplay getInstance()
	  {
		  
	    if (logoDisplay == null)
	      logoDisplay = new LogoDisplay();
	    return logoDisplay;

	  }
}
