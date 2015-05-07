package Saori.Search;

import java.awt.EventQueue;

import Saori.Calculator.CalculatorUI;

public class Main {
	/**
	 * to run main for show DigitalClockUI
	 * @param args is argument for run String
	 */
	public static void main(String[] args) {
<<<<<<< HEAD


		FindFile findfile = new FindFile();
		FindFileUI findfileUI = new FindFileUI(findfile);
		findfileUI.pack();
		findfileUI.setVisible( true );
=======
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindFile findfile = new FindFile();
					FindFileUI findfileUI = new FindFileUI(findfile);
					findfileUI.setVisible( true );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
>>>>>>> 4b2dda23385369f5246429c624c47d103a0850ff
	}
}
