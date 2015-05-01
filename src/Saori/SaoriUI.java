package Saori;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Saori.Event.Event;
import Saori.Event.FallingEvent;
import Saori.Event.MovingEvent;

public class SaoriUI extends JDialog implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Thread t;
	Event event;
	public JLabel Saori;
	
	public SaoriUI (){
		super();
		setUndecorated(true);
		initComponents();
		setLocation(0,0);
		pack();
		 t = new Thread(this);
		 event = new MovingEvent(this);
		 t.start();
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void initComponents(){
		Container field = this.getContentPane();
		field.setLayout(new GridLayout(1,1));
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("Resource/Images/saori1.png"));
		Saori = new JLabel(im);
		addMouseListener(new MouseActionListener(this));
		addMouseMotionListener(new MouseMovingListener(this));
		
		field.add(Saori);
		
	}
	public void changeEvent(Event nextEvent){
		event = nextEvent;
	}
	public void run(){
		setVisible(true);
		setAlwaysOnTop(true);
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
