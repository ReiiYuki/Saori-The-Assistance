package Saori.Search;
public class Main {
	/**
	 * to run main for show DigitalClockUI
	 * @param args is argument for run String
	 */
	public static void main(String[] args) {
<<<<<<< HEAD
		System.out.println("12");

		FindFileUI findfile = new FindFileUI();
		findfile.pack();
		findfile.setVisible( true );

=======
		FindFile findfile = new FindFile();
		FindFileUI findfileUI = new FindFileUI(findfile);
		findfileUI.pack();
		findfileUI.setVisible( true );
>>>>>>> 226ae6b2b8bd59151578113b4f518804a352d8ae
	}
}
