package Saori;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Core.ToolUI;
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
	ToolUI toolBox;
	public JLabel Saori;
	
	public SaoriUI (){
		super();
		setUndecorated(true);
		initComponents();
		setLocation(0,0);
		pack();
		toolBox = new ToolUI();
		t = new Thread(this);
		event = new MovingEvent(this);
		t.start();
	}
	public void initComponents(){
		Container field = this.getContentPane();
		field.setBounds(0, 0, 150, 180);
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
	public void appearTool(){
		toolBox.setLocation(getX(), getY()+100);
		toolBox.setVisible(true);
	}
	public static void main(String[] args) {
		SaoriUI s = new SaoriUI();
		s.run();
	}
}
