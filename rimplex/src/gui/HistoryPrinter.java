package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JTextArea;
import javax.swing.RepaintManager;

/**
 * Handles printing of the history of calculations for Rimplex calculator.
 * 
 * @author Corwin Willms
 * @version Sprint 3
 */
public class HistoryPrinter implements Printable {

	JTextArea historyList;

	public static void printComponent(JTextArea h) {
		new HistoryPrinter(h).doPrint();
	}

	/**
	 * Constructor
	 * 
	 * @param text the JTextArea containing the history of calculations.
	 */
	public HistoryPrinter(JTextArea text) {
		this.historyList = text;
	}

	/**
	 * Starts printing process by creating a PrinterJob and displaying the print
	 * dialog for the user. Prints depending on user input in the print dialog.
	 */
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

	/**
	 * Overrides normal print method for JTextArea printing
	 */
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
}
