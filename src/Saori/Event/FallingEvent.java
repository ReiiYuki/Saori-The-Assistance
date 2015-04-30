package Saori.Event;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Saori.SaoriUI;

public class FallingEvent implements Event{

	private final int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	private final int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int taskHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	private final int originalHeight;
	private int x;
	private int y;
	private SaoriUI ui;
	public FallingEvent(SaoriUI ui){
		this.ui=ui;
		ui.Saori.setIcon(new ImageIcon(ClassLoader.getSystemResource("Resource/Images/saori5.png")));
		originalHeight = (int) ui.getLocation().getY();
		y = (int) ui.getLocation().getY();
		x = (int) ui.getLocation().getX();
	}
	@Override
	public void perform() {
		System.out.println(ui.getLocation().getY());
		if (y>height) {
			int randomX = (int) (Math.random()*width);
			y=-200;
			ui.setLocation(randomX,y);
		}
		else {
			if (y!= taskHeight-(height-taskHeight)) {
				y+=1;
				ui.setLocation(x,y);
			}
			else {
				if (y-originalHeight>300) ui.changeEvent(new PowerfulTouchGroundEvent(ui));
				else ui.changeEvent(new StandingEvent(ui));
			}
		}
	}

	@Override
	public void leftClickHandler() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dragHandler(MouseEvent e) {
		ui.changeEvent(new FlyingEvent(ui));
	}
	@Override
	public void releaseHandler(){
		
	}
}
