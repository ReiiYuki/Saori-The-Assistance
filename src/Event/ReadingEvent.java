package Event;

import java.awt.event.MouseEvent;

import Core.SaoriUI;

public class ReadingEvent implements Event {
	private SaoriUI ui;
	private StopWatch animationCounter;
	public ReadingEvent(SaoriUI ui){
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
		
	}

}
