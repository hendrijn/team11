package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JTextArea;
import javax.swing.RepaintManager;

//Removed actionlistener
public class HistoryPrinter implements Printable {

	//JWindow windowToPrint;
	JTextArea historyList;
	
	public static void printComponent(JTextArea h) {
        new HistoryPrinter(h).doPrint();
    }
 
    public HistoryPrinter(JTextArea text) {
        this.historyList = text;
    }
	
    public void doPrint() {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(this);
        if (printJob.printDialog()) {
            try {
                printJob.print();
            } catch (PrinterException pe) {
                System.out.println("Error printing: " + pe);
            }
        }
    }
	
    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return (NO_SUCH_PAGE);
        } else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            RepaintManager currentManager = RepaintManager.currentManager(historyList);
            currentManager.setDoubleBufferingEnabled(false);
            historyList.paint(g2d);
            currentManager = RepaintManager.currentManager(historyList);
            currentManager.setDoubleBufferingEnabled(true);
            return (PAGE_EXISTS);
        }
    }
    
	/**
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
             // The job did not successfully complete 
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

        // Now print the window and its visible contents 
        //windowToPrint.printAll(graphics);

        //g.drawString("Hello world!", 100, 100);
        
        // tell the caller that this page is part of the printed document 
        return PAGE_EXISTS;
	}

	public HistoryPrinter(HistoryDisplay f) {
        //windowToPrint = f;
		historyList = f.getCalcList();
    }*/
}
