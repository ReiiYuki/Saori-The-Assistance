package Saori;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Saori.Event.Event;
import Saori.Event.FallingEvent;
import Saori.Event.MovingEvent;

public class SaoriUI extends JFrame implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Thread t;
	Event event;
	
	public SaoriUI (){
		super("Saoriiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		initComponents();
		pack();
		 t = new Thread(this);
		 event = new MovingEvent(this);
		 t.start();
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void initComponents(){
		Container field = this.getContentPane();
		field.setLayout(new GridLayout(1,1));
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("Resource/Images/shime1.png"));
		JLabel label = new JLabel(im);
		addMouseListener(new MouseActionListener(this));
		field.add(label);
	}
	public void changeEvent(Event nextEvent){
		event = nextEvent;
	}
	public void run(){
		setVisible(true);
		try {
			while(true){
				event.perform();
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SaoriUI s = new SaoriUI();
		s.run();
	}
}
