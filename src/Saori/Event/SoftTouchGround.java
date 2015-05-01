package Saori.Event;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Saori.SaoriUI;

public class SoftTouchGround implements Event {
	
	private SaoriUI ui;
	private StopWatch changeEventTimer;
	
	public SoftTouchGround(SaoriUI ui){
		this.ui=ui;
		changeEventTimer = new StopWatch();
		changeEventTimer.start();
		ui.Saori.setIcon(new ImageIcon(ClassLoader.getSystemResource("Resource/Images/saori9.png")));
	}
	@Override
	public void perform() {
		if (changeEventTimer.getElapsed()>3) {
			changeEventTimer.stop();
			ui.changeEvent(new StandingEvent(ui));
		}
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
	public void releaseHandler() {
		// TODO Auto-generated method stub

	}

}
