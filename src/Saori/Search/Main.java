package Saori.Search;

import java.awt.EventQueue;

import Saori.Calculator.CalculatorUI;
/**
 * main class for show FindFileUI
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public class Main {
	/**
	 * to run main for show FindFileUI
	 * @param args is argument for run String
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindFileUI findfileUI = new FindFileUI();
					findfileUI.setVisible( true );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}