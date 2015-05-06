package Event;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;


import Core.SaoriUI;

public class MovingEvent implements Event {

	private SaoriUI ui;
	private StopWatch stateChangeCounter;
	private int dicisionToAction;
	private int dicisionToLeave;
	private int direction;
	public MovingEvent(SaoriUI ui){
		this.ui = ui;
		ui.setImage("Resource/Images/saori1.png", "Resource/Images/saori2.png");
		ui.restartAnimate();
		stateChangeCounter = new StopWatch();
		stateChangeCounter.start();
		direction = 1;
	}
	public void perform() {
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (int) ui.getLocation().getX();
		x+=direction;
		ui.setLocation(x, (int) ui.getLocation().getY());
		if (x<=0){
			direction = 1;
			ui.setImage("Resource/Images/saori18.png", "Resource/Images/saori19.png");
			ui.restartAnimate();
		}
		if (x>=screenWidth){
			direction = -1;
			ui.setImage("Resource/Images/saori1.png", "Resource/Images/saori2.png");
			ui.restartAnimate();
		}
		if (stateChangeCounter.getElapsed()>dicisionToLeave) {
			if (dicisionToAction == 1) leaveEvent(new StandingEvent(ui));
			else leaveEvent(new SittingEvent(ui));
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
		leaveEvent(new ListeningEvent(ui));
	}

	@Override
	public void leaveEvent(Event event) {
		ui.pauseAnimate();
		ui.changeEvent(event);
	}

}
