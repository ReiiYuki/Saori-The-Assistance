package Event;

import java.awt.event.MouseEvent;

import Core.SaoriUI;

public class WritingEvent implements Event {
	private SaoriUI ui;
	private StopWatch animationCounter;
	public WritingEvent(SaoriUI ui){
		this.ui = ui;
		animationCounter = new StopWatch();
	}
	@Override
	public void perform() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragHandler(MouseEvent e) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
