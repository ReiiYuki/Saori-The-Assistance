package Event;

import java.awt.event.MouseEvent;

import Core.SaoriUI;

public class PainEvent implements Event {
	
	private SaoriUI ui;
	private StopWatch stateChangeCounter;
	private int timeToLeave;
	public PainEvent(SaoriUI ui){
		this.ui = ui;
		ui.setImage("Resource/Images/saori11.png");
		stateChangeCounter = new StopWatch();
		stateChangeCounter.start();
		timeToLeave = (int) (Math.random()*40+20);
	}
	
	@Override
	public void perform() {
		if (stateChangeCounter.getElapsed()>timeToLeave) leaveEvent(new SittingEvent(ui));
	}

	@Override
	public void dragHandler(MouseEvent e) {
		leaveEvent(new FlyingEvent(ui));
	}

	@Override
	public void releaseHandler() {
		leaveEvent(new FlyingEvent(ui));
	}

	@Override
	public void enterHandler() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leaveEvent(Event event) {
		// TODO Auto-generated method stub
		ui.changeEvent(event);
	}

}
