package Event;

import java.awt.event.MouseEvent;

import Core.SaoriUI;

public class ListeningEvent implements Event{
	private SaoriUI ui;
	private StopWatch animationCounter;
	public ListeningEvent(SaoriUI ui){
		this.ui = ui;
		animationCounter = new StopWatch();
	}
	@Override
	public void perform() {
		ui.toolBoxAppear();
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
		
	}

	@Override
	public void leaveEvent(Event event) {
		ui.changeEvent(event);
	}
	
}
