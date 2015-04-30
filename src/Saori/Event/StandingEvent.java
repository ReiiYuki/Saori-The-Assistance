package Saori.Event;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Saori.SaoriUI;

public class StandingEvent implements Event {
	private SaoriUI ui;
	private StopWatch AnimateTimer;
	private StopWatch changeEventTimer;
	private final int randomTime;
	public StandingEvent(SaoriUI ui){
		this.ui=ui;
		changeEventTimer = new StopWatch();
		changeEventTimer.start();
		randomTime = (int) (Math.random()*3+4);
		ui.Saori.setIcon(new ImageIcon(ClassLoader.getSystemResource("Resource/Images/saori7.png")));
	}
	@Override
	public void perform() {
		if (changeEventTimer.getElapsed()>randomTime){
			changeEventTimer.stop();
			int dicision = (int) Math.round(Math.random());
			if (dicision == 0) ui.changeEvent(new MovingEvent(ui));
			else ui.changeEvent(new SittingEvent(ui));
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
	public void releaseHandler(){
		ui.changeEvent(new FallingEvent(ui));
	}
}
