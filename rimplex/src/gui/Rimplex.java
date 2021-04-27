package gui;

import java.util.concurrent.TimeUnit;

/**
 * Tests the interface.
 * 
 * @author Jacquelyn Hendricks
 * @version March 23 2021
 */
public class Rimplex
{
  /**
   * main method.
   * 
   * @param args
   *          command line arguments.
   * @throws InterruptedException
   *           if the program is waiting, sleeping, or otherwise occupied and is interrupted.
   */
  public static void main(final String[] args) throws InterruptedException
  {
    // make History Display here
    LogoDisplay logo = LogoDisplay.getInstance();
    logo.setSize(250, 100);
    logo.contentPane.setVisible(true);
    TimeUnit.SECONDS.sleep(3);
    logo.setVisible(false);
    NewMainInterface.getInstance();
  }
}
