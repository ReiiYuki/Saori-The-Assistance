package Saori.Event;

import java.awt.event.MouseEvent;

import Saori.SaoriUI;

public class FlyingEvent implements Event{
	private SaoriUI ui;
	public FlyingEvent(SaoriUI ui){
		this.ui=ui;
	}
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftClickHandler() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragHandler(MouseEvent e) {
		// TODO Auto-generated method stub
		ui.setLocation(e.getLocationOnScreen());
	}

}
