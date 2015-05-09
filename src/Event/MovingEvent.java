package Event;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;


import Core.SaoriUI;
/**
 * MovingEvent is event which is done when Saori is moving.
 * @author Voraton Lertrattanapaisal
 *
 */
public class MovingEvent implements Event {

	private SaoriUI ui;
	private StopWatch stateChangeCounter;
	private int dicisionToAction;
	private int dicisionToLeave;
	private int direction;
	private int x;
	public MovingEvent(SaoriUI ui){
		this.ui = ui;
		ui.setImage("Resource/Images/saori18.png", "Resource/Images/saori19.png");
		ui.restartAnimate();
		dicisionToAction = (int) (Math.random()*2+1);
		dicisionToLeave = (int) (Math.random()*10+10);
		stateChangeCounter = new StopWatch();
		stateChangeCounter.start();
		direction = 1;
		x = (int) ui.getLocation().getX();

	}
	public void perform() { 
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		if (x<-100 ){
			direction = 1;
			ui.setImage("Resource/Images/saori18.png", "Resource/Images/saori19.png");
			ui.restartAnimate();
		}
		if (x>screenWidth+100){
			direction = -1;
			ui.setImage("Resource/Images/saori1.png", "Resource/Images/saori2.png");
			ui.restartAnimate();
		}
		x+=direction;
		ui.setLocation(x+direction, (int) ui.getLocation().getY());
		if (stateChangeCounter.getElapsed()>dicisionToLeave) {
			stateChangeCounter.stop();
			if (dicisionToAction == 1) leaveEvent(new StandingEvent(ui));
			else leaveEvent(new SittingEvent(ui));
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
		leaveEvent(new ListeningEvent(ui));
	}

	@Override
	public void leaveEvent(Event event) {
		ui.pauseAnimate();
		ui.changeEvent(event);
	}

}
