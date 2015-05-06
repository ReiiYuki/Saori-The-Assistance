package Event;

import java.awt.event.MouseEvent;

import Core.SaoriUI;

public class StandingEvent implements Event{
	
	private SaoriUI ui;
	private StopWatch stateChangeCounter;
	private int dicisionToAction;
	private int dicisionToLeave;
	public StandingEvent(SaoriUI ui){
		this.ui = ui;
		ui.setImage("Resource/Images/saori7.png", "Resource/Images/saori8.png");
		ui.restartAnimate();
		stateChangeCounter = new StopWatch();
		dicisionToLeave = (int) (Math.random()*40+10);
		dicisionToAction = (int) (Math.random()*2+1);
		stateChangeCounter.start();
	}
	
	@Override
	public void perform() {
		if (stateChangeCounter.getElapsed()>dicisionToLeave) {
			if (dicisionToAction == 1) leaveEvent(new MovingEvent(ui));
			else leaveEvent(new SittingEvent(ui));
		}
	}

	@Override
	public void dragHandler(MouseEvent e) {
		leaveEvent(new FlyingEvent(ui));		
	}

	@Override
	public void releaseHandler() {
	}

	@Override
	public void enterHandler() {
		leaveEvent(new ListeningEvent(ui));
	}

	@Override
	public void leaveEvent(Event event) {
		ui.pauseAnimate();
		ui.changeEvent(event);
	}

}
