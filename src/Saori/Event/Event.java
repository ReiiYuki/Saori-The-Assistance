package Saori.Event;

import java.awt.event.MouseEvent;

public interface Event {
	public void perform();
	public void leftClickHandler();
	public void dragHandler(MouseEvent e);
}
