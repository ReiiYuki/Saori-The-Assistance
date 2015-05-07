package Event;

import java.awt.event.MouseEvent;


import Core.SaoriUI;

public class HardTouchEvent implements Event {

	private SaoriUI ui;
	private StopWatch leaveCounter;
	public HardTouchEvent(SaoriUI ui){
		this.ui = ui;
		leaveCounter = new StopWatch();
		ui.setImage("Resource/Images/saori16.png", "Resource/Images/saori17.png");
		ui.restartAnimate();
		leaveCounter.start();
	}

	@Override
	public void perform() {
		if (leaveCounter.getElapsed()>1){
			ui.setLocation((int)ui.getLocationOnScreen().getX(), (int)ui.getLocationOnScreen().getY());
			leaveEvent(new PainEvent(ui));
			leaveCounter.stop();
		}
	}

	@Override
	public void dragHandler(MouseEvent e) {
		leaveEvent(new FlyingEvent(ui));
	}

	@Override
	public void releaseHandler() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterHandler() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leaveEvent(Event event) {
		ui.pauseAnimate();
		ui.changeEvent(event);
	}

}
