package Saori.Clock;

import java.util.Calendar;

/**
 * A StopWatch that measures elapsed time between a starting time
 * and stopping time, or until the present time.
 * @author Wanchanapon Thanwaranurak
 * @version 1.0
 */
public class StopWatch implements ClockState{
	/** constant for converting nanoseconds to seconds. */
	private static final double NANOSECONDS = 1.0E-9;
	/** time that the StopWacth was started, in nanoseconds. */
	private long startTime = 0 ;
	/** time that the StopWacth was stopped, in nanoseconds. */
	private long stopTime = 0 ;
	/** Constructor StopWacth was running or stopped. */
	private int min = 0 , sec = 0 ;
	private double 	millisec = 0;
	private boolean running = false ;
	private Clock clock;
	public StopWatch(Clock clock){
		this.clock = clock ;
	}

	/** 
	 * check StopWacth running or stopped.
	 * @return  true if the StopWacth is running, false if StopWacth is stopped.
	 */
	public boolean isRunning(){
		if(running==false)
			return true ;
		else
			return false ;
	}
	

	@Override
	public void pressSet() {
		clock.setState( clock.getDisplayTimeState() );

	}
	@Override
	public void pressPlus() {
		if(isRunning())
			running = true ;
		else
			running = false ;
	}
	@Override
	public void pressMinus() {
		this.millisec = 0 ;
		this.sec = 0 ;
		this.min = 0 ;
		clock.setShowSec(0);
	}
	@Override
	public void updateTime() {
		if(!isRunning()==true){
			clock.setShowSec( (int)(System.currentTimeMillis()%99) );
			this.millisec = this.millisec+0.5 ;
			if(this.millisec >= 1){
				this.millisec = 0 ;
				this.sec++;
			}
			if(this.sec==60){
				this.sec = 0 ;
				this.min++;
			}
		}
		clock.setShowMin(this.sec);
		clock.setShowHr(this.min);
	}
}
