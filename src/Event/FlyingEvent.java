package Event;

import java.awt.event.MouseEvent;

import Core.SaoriUI;

/**
 * FlyingEvent is event that Saori is dragged by mouse.
 * @author Voraton Lertrattanapaisal
 *
 */
public class FlyingEvent implements Event{
	
	private SaoriUI ui;
	public FlyingEvent(SaoriUI ui){
		this.ui = ui;
		ui.setImage("Resource/Images/saori5.png");
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
