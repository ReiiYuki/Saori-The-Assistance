
import javax.swing.SwingUtilities;

import Core.SaoriUI;


public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					SaoriUI saori = new SaoriUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
