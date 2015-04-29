package Saori.Event;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import Saori.SaoriUI;

public class FallingEvent implements Event{

	private final int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	private final int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int taskHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	private int x;
	private int y;
	private SaoriUI ui;
	public FallingEvent(SaoriUI ui){
		this.ui=ui;
		y = taskHeight-(height-taskHeight);
		x = (int) ui.getLocation().getX();
	}
	@Override
	public void perform() {
		if (y!=taskHeight) {
			y+=1;
			ui.setLocation(x,y);
		}
		else if (y>height) {
			int randomX = (int) (Math.random()*width);
			ui.setLocation(randomX,0);
		}
		else ui.changeEvent(new MovingEvent(ui));
	}

	@Override
	public void leftClickHandler() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dragHandler() {
		// TODO Auto-generated method stub
		
	}
	
}
