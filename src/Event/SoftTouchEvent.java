package Event;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import Core.SaoriUI;

public class SoftTouchEvent implements Event {

	private SaoriUI ui;
	private StopWatch animationCounter;
	public SoftTouchEvent(SaoriUI ui){
		this.ui = ui;
		animationCounter = new StopWatch();
	}

	
	@Override
	public void perform() {
		int screenHeigh = Toolkit.getDefaultToolkit().getScreenSize().height;
		int realScreenHigh = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		int realHeigh = realScreenHigh-(screenHeigh-realScreenHigh)-150;
		int y = (int) ui.getLocation().getY();
		if (y==realHeigh) leaveEvent(new SmartStandingEvent(ui));
		else if (y>realHeigh) {
			y-=1;
			ui.setLocation((int) ui.getLocation().getX(), y);
		}
		else leaveEvent(new FallingEvent(ui));
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
