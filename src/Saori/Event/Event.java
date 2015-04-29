package Saori.Event;

public interface Event {
	public void perform();
	public void rightClickHandler();
	public void leftClickHandler();
	public void changeEvent(Event nextEvent);
}
