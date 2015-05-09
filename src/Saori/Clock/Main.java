package Saori.Clock;
/**
 * main class for show DigitalClockUI
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public class Main {
	/**
	 * to run main for show DigitalClockUI
	 * @param args is argument for run String
	 */
	public static void main(String[] args) {
		Clock clock = new Clock();
		DigitalClockUI LED = new DigitalClockUI(clock);
		LED.pack();
		LED.setVisible( true );
	}

}
