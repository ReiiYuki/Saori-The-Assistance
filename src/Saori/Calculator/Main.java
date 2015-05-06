package Saori.Calculator;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
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
