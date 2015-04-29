package Saori.Event;

import Saori.SaoriUI;

public class StandingEvent implements Event {
	private SaoriUI ui;
	public StandingEvent(SaoriUI ui){
		System.out.println("Y");
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
	public void dragHandler() {
		// TODO Auto-generated method stub

	}

}
