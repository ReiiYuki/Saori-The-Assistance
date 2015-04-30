package Saori.Event;

import java.awt.event.MouseEvent;

import Saori.SaoriUI;

public class StandingEvent implements Event {
	private SaoriUI ui;
	public StandingEvent(SaoriUI ui){
		System.out.println("Y");
		this.ui=ui;
	}
	@Override
	public void perform() {
		
	}

	@Override
	public void leftClickHandler() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragHandler(MouseEvent e) {
		// TODO Auto-generated method stub
		ui.changeEvent(new FlyingEvent(ui));
	}
	@Override
	public void releaseHandler(){
		ui.changeEvent(new FallingEvent(ui));
	}
}
