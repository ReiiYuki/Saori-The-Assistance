package Core;


import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;


import javax.swing.JLabel;

import Event.Event;
import Event.FallingEvent;
import Event.ListeningEvent;

public class SaoriUI extends JDialog implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3003993878535356408L;
	private JLabel body;
	private Event event;
	private Thread thread;
	private ToolUI toolbox;
	public SaoriUI() {
		super();
		initLocation();
		initComponent();
		toolbox = new ToolUI(this);
		event = new FallingEvent(this);
		thread = new Thread(this);
		thread.start();
	}	
	public void initComponent(){
		setSize(130,150);
		setUndecorated(true);
		JPanel field = new JPanel();
		body = new JLabel();
		setContentPane(field);
		getRootPane().setOpaque(false);
		getContentPane ().setBackground (new Color (0, 0, 0, 0));
		setBackground (new Color (0, 0, 0, 0));
		setAlwaysOnTop(true);
	}
	public void setImage(ImageIcon icon){
		body.setIcon(icon);
	}
	public void initLocation(){
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		setLocation((int) (Math.random()*width),-200);
	}
	public void changeEvent(Event event){
		if (this.event.getClass()!=ListeningEvent.class)  toolBoxDisappear();
		this.event = event;
	}
	@Override
	public void run() {
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
	public void toolBoxAppear(){
		toolbox.setLocation(getLocationOnScreen());
		toolbox.setVisible(true);
	}
	public void toolBoxDisappear(){
		toolbox.setVisible(false);
	}
}
