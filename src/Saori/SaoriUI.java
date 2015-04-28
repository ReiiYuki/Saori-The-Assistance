package Saori;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SaoriUI extends JFrame implements Runnable{
	int delay = 500; // milliseconds
	int x = 0;
	int y = 0;
	Thread t;
	
	public SaoriUI (){
		super("Saoriiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		initComponents();
		 // Create a new thread, run() is written in this class (Runnable implemented)
		 t= new Thread(this);
		
		 // Start the thread
		 t.start();
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void initComponents(){
		Container field = this.getContentPane();
		field.setLayout(new GridLayout(1,1));
		JLabel label = new JLabel("dsaasddsa");
		field.add(label);
	}
	public void run(){
		
		setVisible(true);
		try
		{
		
			// Get the width of the screen, so that the frame has to go till end!
			int width=Toolkit.getDefaultToolkit().getScreenSize().width;
			int i =0;
			int mod = 1;
			while(true){
				if (i<=0) {
					  mod = 1;
				}
				if (i>=width){
					mod = -1;
				}
				i += mod;
				setLocation(i,55);
				Thread.sleep(10);
			}
		 	// Start the loop
	
		}catch(Exception e){}
	}
	public static void main(String[] args) {
		SaoriUI s = new SaoriUI();
		s.run();
	}
}
