package Saori.Event;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import Saori.SaoriUI;

public class MovingEvent implements Event {
	private SaoriUI ui;
	private final int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	private final int taskHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	private final int y = taskHeight-(height-taskHeight);
	private int x;
	private int direction;
	public MovingEvent(SaoriUI ui){
		this.ui=ui;
		x = 0;
		direction = 1;
	}
	@Override
	public void perform() {
		if (x<=0) direction = 1;
		if (x>=width) direction = -1;
		x+=direction;
		ui.setLocation(x,y-70);
	}

	@Override
	public void leftClickHandler() {
		ui.changeEvent(new StandingEvent(ui));
	}
	
	@Override
	public void dragHandler(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
