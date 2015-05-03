package Saori.Clock;
/**
 * AlarmRingingState is check that pressPlus ,pressMinus and pressSet come back to DisplayTimeState
 * @author Wanchanapon Thanwaranurak
 * @version 3/11/2015
 */
public class AlarmRingingState implements ClockState{
	/**
	 * clock is attributes,type is Clock
	 */
	private Clock clock ;
	/**
	 * Constructor for new AlarmRingingState
	 * @param clock is attributes,type is Clock
	 */
	public AlarmRingingState(Clock clock){
		this.clock = clock ;
	}
	/**
	 * updateTime is update method when over time
	 */
	public void updateTime(){
		clock.setShowHr( clock.getAlarmHr() );
		clock.setShowMin( clock.getAlarmMin() );
		clock.setShowSec( clock.getAlarmSec() );
	}
	/**
	 * pressPlus can change time is plus one
	 */
	public void pressPlus() {
		clock.setBlinkHr( false );
		clock.setBlinkMin( false );
		clock.setBlinkSec( false );
		clock.setShowAlarm( false );
		clock.getSound().stop();
		clock.setState( clock.getDisplayTimeState() );
	}
	/**
	 * pressMinus can change time is minus one
	 */
	public void pressMinus() {
		clock.setBlinkHr( false );
		clock.setBlinkMin( false );
		clock.setBlinkSec( false );
		clock.setShowAlarm( false );
		clock.getSound().stop();
		clock.setState( clock.getDisplayTimeState() );
	}
	/**
	 * pressSet can change of state that you want
	 */
	public void pressSet() {
		clock.setBlinkHr( false );
		clock.setBlinkMin( false );
		clock.setBlinkSec( false );
		clock.setShowAlarm( false );
		clock.getSound().stop();
		clock.setState(clock.getDisplayTimeState() );

	}


















}
