package Saori.Event;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

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
		y = (int) ui.getLocation().getY();
		x = (int) ui.getLocation().getX();
	}
	@Override
	public void perform() {
		if (y!= taskHeight-(height-taskHeight)) {
			y+=1;
			ui.setLocation(x,y);
		}
		else if (y>height) {
			int randomX = (int) (Math.random()*width);
			ui.setLocation(randomX,y);
		}
		else ui.changeEvent(new MovingEvent(ui));
	}

	@Override
	public void leftClickHandler() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dragHandler(MouseEvent e) {
		// TODO Auto-generated method stub
		ui.changeEvent(new FlyingEvent(ui));
	}
	@Override
	public void releaseHandler(){
		
	}
}
