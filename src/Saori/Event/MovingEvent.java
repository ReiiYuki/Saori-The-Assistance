package Saori.Event;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

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
		ui.setLocation(x,y);
	}

	@Override
	public void rightClickHandler() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leftClickHandler() {
		// TODO Auto-generated method stub

	}

}
