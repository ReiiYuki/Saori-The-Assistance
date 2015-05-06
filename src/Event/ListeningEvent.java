package Event;

import java.awt.event.MouseEvent;


import Core.SaoriUI;

public class ListeningEvent implements Event{
	private SaoriUI ui;
	public ListeningEvent(SaoriUI ui){
		this.ui = ui;
		ui.setImage("Resource/Images/saori15.png");
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
