package Event;

import java.awt.event.MouseEvent;

import Core.SaoriUI;

public class FlyingEvent implements Event{
	
	private SaoriUI ui;
	private StopWatch animationCounter;
	public FlyingEvent(SaoriUI ui){
		this.ui = ui;
		animationCounter = new StopWatch();
	}
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragHandler(MouseEvent e) {
		ui.setLocation(e.getLocationOnScreen());
	}

	@Override
	public void releaseHandler() {
		leaveEvent(new FallingEvent(ui));
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
