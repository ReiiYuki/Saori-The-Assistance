package Event;

import java.awt.event.MouseEvent;

/**
 * Event of Saori which is controlling Saori action.
 * @author Voraton Lertrattanapaisal
 *
 */
public interface Event {
	/**
	 * Doing the action.
	 */
	public void perform();
	/**
	 * Doing the action when Saori was dragged.
	 * @param e is mouse event.
	 */
	public void dragHandler(MouseEvent e);
	/**
	 * Doing the action of Saori when mouse is released.
	 */
	public void releaseHandler();
	/**
	 * Doing the action when mouse is on Saori.
	 */
	public void enterHandler();
	/**
	 * Leave the event to another event.
	 * @param event is next event that Saori do.
	 */
	public void leaveEvent(Event event);
}
