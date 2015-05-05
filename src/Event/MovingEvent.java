package Event;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import Core.SaoriUI;

public class MovingEvent implements Event {

	private SaoriUI ui;
	private StopWatch animationCounter;
	private StopWatch stateChangeCounter;
	private int dicisionToAction;
	private int dicisionToLeave;
	private int direction;
	public MovingEvent(SaoriUI ui){
		this.ui = ui;
		animationCounter = new StopWatch();
		stateChangeCounter = new StopWatch();
		dicisionToLeave = (int) (Math.random()*40+10);
		dicisionToAction = (int) (Math.random()*2+1);
		stateChangeCounter.start();
		if ((int) Math.random()>0) direction = 1;
		else direction = -1;
	}
	
	@Override
	public void perform() {
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (int) ui.getLocation().getX();
		if (x<=0) direction = 1;
		if (x>=screenWidth) direction = -1;
		x+=direction;
		ui.setLocation(x, (int) ui.getLocation().getY());
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
		ui.changeEvent(event);
	}

}
