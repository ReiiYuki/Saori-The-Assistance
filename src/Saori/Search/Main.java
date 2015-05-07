package Saori.Search;
public class Main {
	/**
	 * to run main for show DigitalClockUI
	 * @param args is argument for run String
	 */
	public static void main(String[] args) {


		FindFile findfile = new FindFile();
		FindFileUI findfileUI = new FindFileUI(findfile);
		findfileUI.pack();
		findfileUI.setVisible( true );
	}
}
