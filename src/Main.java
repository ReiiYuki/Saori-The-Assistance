import java.awt.EventQueue;

import Core.SaoriUI;


public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
