package Saori.Clock;
/**
 * main class for show DigitalClockUI
 * @author Wanchanapon Thanwaranurak
 * @version 3/11/2015
 */
public class Main {
	/**
	 * to run main for show DigitalClockUI
	 * @param args is argument for run String
	 */
	public static void main(String[] args) {
		DigitalClockUI LED = new DigitalClockUI();
		LED.pack();
		LED.setVisible( true );
	}

}
