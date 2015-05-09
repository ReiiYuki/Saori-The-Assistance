package Saori.Calculator;

import java.awt.EventQueue;
/**
 * main class for show CalculatorUI
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public class Main {
	/**
	 * to run main for show CalculatorUI
	 * @param args is argument for run String
	 */
	public static void main(String args[]) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorUI c = new CalculatorUI();
					c.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
	}
}