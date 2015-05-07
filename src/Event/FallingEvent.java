package Event;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import Core.SaoriUI;
public class FallingEvent implements Event {
	
	private SaoriUI ui;
	public FallingEvent(SaoriUI ui){
		this.ui = ui;
		ui.setImage("Resource/Images/saori3.png", "Resource/Images/saori4.png");
		ui.restartAnimate();
	}
	@Override
	public void perform() {
		int screenHeigh = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int realScreenHigh = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		int realHeigh = realScreenHigh-(screenHeigh-realScreenHigh)-90;
		int y = (int) ui.getLocation().getY();
		if (y>screenHeigh){
			int x = (int) (Math.random()*screenWidth);
			y = -200;
			ui.setLocation(x, y);
		}
		else {
			y+=1;
			ui.setLocation((int) ui.getLocation().getX(), y);
			if (y>=realHeigh){
				ui.setLocation((int) ui.getLocation().getX(), realHeigh);
				leaveEvent(new HardTouchEvent(ui));
			}
			
		}
		int x = (int)ui.getLocationOnScreen().getX();
		if (x> screenWidth) {
			x = 0;
			x+=1;
			ui.setLocation(x,(int)ui.getLocation().getY());
		}
		if (x< 0 ) {
			x = screenWidth;
			x-=1;
			ui.setLocation(x,(int)ui.getLocation().getY());
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
		ui.pauseAnimate();
		ui.changeEvent(event);
	}

}
