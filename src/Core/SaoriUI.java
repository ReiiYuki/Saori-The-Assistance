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
/**
 * SaoriUI is use for show Saori and Combine Saori to her event which make her realistic.
 * @author Voraton Lertrattanapaisal
 *
 */
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
	/**
	 * Initialize component to SaoriUI.
	 */
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
	/**
	 * Use for initialize location of Saori on the Screen.
	 */
	public void initLocation(){
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		setLocation((int) (Math.random()*width),0);
	}
	/**
	 * Changing the event.
	 * @param event is new event.
	 */
	public void changeEvent(Event event){
		if (this.event.getClass()!=ListeningEvent.class)  toolBoxDisappear();
		this.event = event;
	}
	/**
	 * Getting the clock.
	 * @return the clock.
	 */
	public Clock getClock(){
		return clock;
	}
	/**
	 * Getting event.
	 * @return event.
	 */
	public Event getEvent(){
		return event;
	}
	/**
	 * Setting image of Saori.
	 * 
	 */
	public void setImage(String url){
		body.setIcon(new ImageIcon(ClassLoader.getSystemResource(url)));
	}
	/**
	 * SettiangeI
	 * @param url1
	 * @param url2
	 */
	public void setImage(String url1,String url2){
		body.setImage(url1, url2);
	}
	/**
	 * Restart Animation.
	 */
	public void restartAnimate(){
		body.restart();
	}
	/**
	 * Pause Animation.
	 */
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
	/**
	 * Setting toolbox to visible.
	 */
	public void toolBoxAppear(){
		toolbox.setLocation(getLocationOnScreen());
		toolbox.setVisible(true);
	}
	/**
	 * Disappearing toolbox.
	 */
	public void toolBoxDisappear(){
		toolbox.setVisible(false);
	}
}
