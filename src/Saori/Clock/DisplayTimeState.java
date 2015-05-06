package Saori.Clock;
import java.util.Calendar;

/**
 * DisplayTimeState is real time and can chand state to SettingAlarmState.
 * @author Wanchanapon Thanwaranurak
 * @version 3/11/2015
 */
public class DisplayTimeState implements ClockState{
	/**
	 * time is real time ,type is Calendar
	 */
	private Calendar time;
	/**
	 * clock is attributes,type is Clock
	 */
	private Clock clock ;
	/**
	 * Constructor for new DisplayTimeState
	 * @param clock is attributes,type is Clock
	 */
	@SuppressWarnings("static-access")
	public DisplayTimeState(Clock clock){
		time = time.getInstance();
		this.clock = clock ;
	}
	/**
	 * updateTime is update method when over time
	 */
	@SuppressWarnings("static-access")
	public void updateTime(){
		
		time.setTimeInMillis( System.currentTimeMillis() );
		clock.setShowHr( time.get( Calendar.HOUR_OF_DAY ) );
		clock.setShowMin( time.get( Calendar.MINUTE ) );
		clock.setShowSec( time.get( Calendar.SECOND ) );
		if( clock.getAlarmHr() == time.get( Calendar.HOUR_OF_DAY) && clock.getAlarmMin() == time.get(Calendar.MINUTE) && clock.getAlarmSec() == time.get(Calendar.SECOND) ){
			if( clock.getCalendar().get(Calendar.DAY_OF_WEEK) == clock.getNumSun() || clock.getCalendar().get(Calendar.DAY_OF_WEEK) == clock.getNumMon() || clock.getCalendar().get(Calendar.DAY_OF_WEEK) == clock.getNumTue() || clock.getCalendar().get(Calendar.DAY_OF_WEEK) == clock.getNumWed() || clock.getCalendar().get(Calendar.DAY_OF_WEEK) == clock.getNumThu() || clock.getCalendar().get(Calendar.DAY_OF_WEEK) == clock.getNumFri() || clock.getCalendar().get(Calendar.DAY_OF_WEEK) == clock.getNumSat()){
				clock.setBlinkHr( true );
				clock.setBlinkMin( true );
				clock.setBlinkSec( true );
				clock.soundEffect();
				clock.getSound().start();
				clock.getSound().loop( clock.getSound().LOOP_CONTINUOUSLY );
				clock.setState( clock.getAlarmRingingState() );
				if( clock.getCalendar().get(Calendar.DAY_OF_WEEK) == (clock.getNumSun()))
					clock.setNumSun(0);
				else if( clock.getCalendar().get(Calendar.DAY_OF_WEEK) == (clock.getNumMon()) )
					clock.setNumMon(0);
				else if( clock.getCalendar().get(Calendar.DAY_OF_WEEK) == (clock.getNumTue()) )
					clock.setNumTue(0);
				else if( clock.getCalendar().get(Calendar.DAY_OF_WEEK) == (clock.getNumWed()) )
					clock.setNumWed(0);
				else if( clock.getCalendar().get(Calendar.DAY_OF_WEEK) == (clock.getNumThu()) )
					clock.setNumThu(0);
				else if( clock.getCalendar().get(Calendar.DAY_OF_WEEK) == (clock.getNumFri()) )
					clock.setNumFri(0);
				else
					clock.setNumSat(0);
			}
		}
	}
	/**
	 * pressSet can change of state that you want
	 */
	public void pressSet() {
		clock.setState( clock.getSettingAlarmState() );		
		clock.setShowSetDay( true );
	}
	/**
	 * pressPlus can change time is plus one
	 */
	public void pressPlus() {
		clock.setState( clock.getSettingAlarmState() );
	}
	/**
	 * pressMinus can change time is minus one
	 */
	public void pressMinus() {

	}
}
