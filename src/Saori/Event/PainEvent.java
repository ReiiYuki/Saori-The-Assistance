package Saori.Event;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Saori.SaoriUI;

public class PainEvent implements Event {
	private SaoriUI ui;
	private StopWatch changeEventTimer;
	private final int randomTime;
	public PainEvent(SaoriUI ui){
		this.ui=ui;
		changeEventTimer = new StopWatch();
		changeEventTimer.start();
		randomTime = (int) (Math.random()*3+7);
		ui.Saori.setIcon(new ImageIcon(ClassLoader.getSystemResource("Resource/Images/saori9.png")));
	}
	@Override
	public void perform() {
		if (changeEventTimer.getElapsed()>randomTime){
			changeEventTimer.stop();
			int dicision = (int) Math.round(Math.random());
			if (dicision == 0) ui.changeEvent(new SittingEvent(ui));
			else ui.changeEvent(new StandingEvent(ui));
		}
	}

	@Override
	public void leftClickHandler() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragHandler(MouseEvent e) {
		ui.changeEvent(new FlyingEvent(ui));
	}

	@Override
	public void releaseHandler() {
		
	}

}
