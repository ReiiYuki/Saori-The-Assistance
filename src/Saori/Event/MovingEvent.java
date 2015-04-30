package Saori.Event;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Saori.SaoriUI;

public class MovingEvent implements Event {
	private SaoriUI ui;
	private final int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	private final int taskHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	private final int y = taskHeight-(height-taskHeight);
	private int x;
	private int direction;
	private int randomMoveStep;
	private StopWatch AnimateTimer;
	private StopWatch changeEventTimer;
	public MovingEvent(SaoriUI ui){
		this.ui=ui;
		changeEventTimer = new StopWatch();
		changeEventTimer.start();
		ui.Saori.setIcon(new ImageIcon(ClassLoader.getSystemResource("Resource/Images/saori1.png")));
		randomMoveStep = (int) (Math.random()*10+10);
		x = (int) ui.getLocation().getX();
		direction = 1;
	}
	@Override
	public void perform() {
		if (x<=0) direction = 1;
		if (x>=width) direction = -1;
		x+=direction;
		ui.setLocation(x,y-70);
		if (changeEventTimer.getElapsed()>randomMoveStep) {
			changeEventTimer.stop();
			int decision = (int) Math.round(Math.random()) ;
			if (decision == 0) ui.changeEvent(new SittingEvent(ui));
			else ui.changeEvent(new StandingEvent(ui));
		}
	}

	@Override
	public void leftClickHandler() {
		ui.changeEvent(new StandingEvent(ui));
	}
	
	@Override
	public void dragHandler(MouseEvent e) {
		ui.changeEvent(new FlyingEvent(ui));
	}
	@Override
	public void releaseHandler(){
		
	}
}
