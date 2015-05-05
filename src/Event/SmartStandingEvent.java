package Event;

import java.awt.event.MouseEvent;

import Core.SaoriUI;

public class SmartStandingEvent implements Event {

	private SaoriUI ui;
	private StopWatch animationCounter;
	private StopWatch stateChangeCounter;
	public SmartStandingEvent(SaoriUI ui){
		this.ui = ui;
		animationCounter = new StopWatch();
		stateChangeCounter = new StopWatch();
		stateChangeCounter.start();
	}
	
	@Override
	public void perform() {
		if (stateChangeCounter.getElapsed()>1) leaveEvent(new StandingEvent(ui));
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
		leaveEvent(new ListeningEvent(ui));
	}

	@Override
	public void leaveEvent(Event event) {
		ui.changeEvent(event);
	}

}
