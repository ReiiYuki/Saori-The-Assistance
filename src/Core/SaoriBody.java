package Core;

import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.TimingSource;
import org.jdesktop.core.animation.timing.Animator.Direction;
import org.jdesktop.core.animation.timing.TimingTarget;
import org.jdesktop.swing.animation.timing.sources.SwingTimerTimingSource;

public class SaoriBody extends JLabel implements TimingTarget{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1419502101782826607L;
	private final TimingSource ts = new SwingTimerTimingSource(800,TimeUnit.MILLISECONDS);
	private ImageIcon image1;
	private ImageIcon image2;
	private Animator animate;
	private int state;
	public SaoriBody(){
		super();
	    Animator.setDefaultTimingSource(ts);
	    ts.init();
		animate = new Animator.Builder().setRepeatCount(Animator.INFINITE).setStartDirection(Direction.BACKWARD).addTarget(this).build();
		image1 = new ImageIcon();
		image2 = new ImageIcon();
		state = 0;
		
	}
	public void setImage(String url1,String url2){
		image1 = new ImageIcon(ClassLoader.getSystemResource(url1));
		image2 = new ImageIcon(ClassLoader.getSystemResource(url2));
	}
	public void start(){
		animate.start();
	}
	public void restart(){
		animate.restart();
	}
	public void pause(){
		animate.pause();
	}
	@Override
	public void begin(Animator source) {
		setIcon(image1);

	}

	@Override
	public void end(Animator source) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void repeat(Animator source) {
		// TODO Auto-generated method stub
	}

	@Override
	public void reverse(Animator source) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timingEvent(Animator source, double fraction) {
		if (state == 0){ 
			setIcon(image1);
			state++;
		}
		else {
			setIcon(image2);
			state--;
		}
	}

}
