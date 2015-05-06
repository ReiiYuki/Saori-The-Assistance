package Event;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import Core.SaoriUI;
public class FallingEvent implements Event {
	
	private SaoriUI ui;
	private int initialY;
	private StopWatch animationCounter;
	public FallingEvent(SaoriUI ui){
		this.ui = ui;
		animationCounter = new StopWatch();
		this.initialY = (int) ui.getLocation().getY();
	}
	@Override
	public void perform() {
		int screenHeigh = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int realScreenHigh = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		int realHeigh = realScreenHigh-(screenHeigh-realScreenHigh)-150;
		int y = (int) ui.getLocation().getY();
		if (y>screenHeigh){
			int x = (int) (Math.random()*screenWidth);
			y = -200;
			initialY = y;
			ui.setLocation(x, y);
		}
		else {
			y-=1;
			ui.setLocation((int) ui.getLocation().getX(), y);
			if (y>300&&y<realHeigh){
				if (y-initialY>300) leaveEvent(new HardTouchEvent(ui));
				else leaveEvent(new SoftTouchEvent(ui));
			}
		}
	}

	@Override
	public void dragHandler(MouseEvent e) {
		leaveEvent(new FlyingEvent(ui));
	}

	@Override
	public void releaseHandler() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterHandler() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leaveEvent(Event event) {
		ui.changeEvent(event);
	}

}
