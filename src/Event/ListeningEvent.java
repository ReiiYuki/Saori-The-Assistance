package Event;

import java.awt.event.MouseEvent;


import Core.SaoriUI;
/**
 * ListeningEvent is the event which is done when Saori use toolbox.
 * @author Lenovo
 *
 */
public class ListeningEvent implements Event{
	private SaoriUI ui;
	int i;
	public ListeningEvent(SaoriUI ui){
		this.ui = ui;
		ui.setImage("Resource/Images/saori15.png");
		i = 0;
	}
	@Override
	public void perform() {
		if (i==0){
			ui.toolBoxAppear();
		}
		i++;
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
