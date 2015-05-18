
import javax.swing.SwingUtilities;

import Core.SaoriUI;


public class Main {
	public static void main(String[] args) {
				SwingUtilities.invokeLater(()->{
					@SuppressWarnings("unused")
					SaoriUI saori = new SaoriUI();
				});

	}
}
