package Event;

import java.awt.event.MouseEvent;

public interface Event {
	public void perform();
	public void dragHandler(MouseEvent e);
	public void releaseHandler();
	public void enterHandler();
	public void leaveEvent(Event event);
}
