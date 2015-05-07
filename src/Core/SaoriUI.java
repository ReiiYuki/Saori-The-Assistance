package Core;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import Event.Event;
import Event.FallingEvent;
import Event.ListeningEvent;

import Saori.Clock.Clock;
import Saori.Listener.Core.UIMouseListener;
import Saori.Listener.Core.UIMouseMotionListener;

public class SaoriUI extends JDialog implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3003993878535356408L;
	private SaoriBody body;
	private Event event;
	private Thread thread;
	private ToolUI toolbox;
	private Clock clock;
	public SaoriUI() {
		super();
		initLocation();
		initComponent();
		body.start();
		clock = new Clock();
		toolbox = new ToolUI(this);
		thread = new Thread(this);
		event = new FallingEvent(this);
		thread.start();
	}	
	public void initComponent(){
		setSize(130,150);
		setUndecorated(true);
		JPanel field = new JPanel();
		field.setLayout(new GridLayout(1,1));
		body = new SaoriBody();
		setImage("Resource/Images/saori3.png");
		body.setImage("Resource/Images/saori3.png", "Resource/Images/saori4.png");
		field.add(body);
		setContentPane(field);
		getRootPane().setOpaque(false);
		getContentPane ().setBackground (new Color (0, 0, 0, 0));
		setBackground (new Color (0, 0, 0, 0));
		setAlwaysOnTop(true);
		addMouseListener(new UIMouseListener(this));
		addMouseMotionListener(new UIMouseMotionListener(this));
	}

	public void initLocation(){
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		setLocation((int) (Math.random()*width),0);
	}
	public void changeEvent(Event event){
		if (this.event.getClass()!=ListeningEvent.class)  toolBoxDisappear();
		this.event = event;
	}
	public Clock getClock(){
		return clock;
	}
	public Event getEvent(){
		return event;
	}
	public void setImage(String url){
		body.setIcon(new ImageIcon(ClassLoader.getSystemResource(url)));
	}
	public void setImage(String url1,String url2){
		body.setImage(url1, url2);
	}
	public void restartAnimate(){
		body.restart();
	}
	public void pauseAnimate(){
		body.pause();
	}
	@Override
	public void run() {
		setVisible(true);
		pack();
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
	public static void main(String[] args) {
		SaoriUI s = new SaoriUI();
		s.run();
	}
}
