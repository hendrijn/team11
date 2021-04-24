package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JWindow;

public class HistoryPrinter implements Printable, ActionListener {

	JWindow windowToPrint;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
            	System.out.println("print w/ no args");
                 job.print();
            } catch (PrinterException ex) {
             /* The job did not successfully complete */
            	System.out.println("print failed");
            }
        }
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		//keeps repeating
		System.out.println("print w/args");
		Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        /* Now print the window and its visible contents */
        windowToPrint.printAll(graphics);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
	}

	public HistoryPrinter(JWindow f) {
        windowToPrint = f;
    }
}
