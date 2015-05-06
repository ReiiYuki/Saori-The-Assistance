package Saori.Clock;

/**
 * SettingAlarmState can change the AlarmTime that you want
 * @author Wanchanapon Thanwaranurak
 * @version 3/11/2015
 */
public class SettingAlarmState implements ClockState{
	/**
	 * clock is attributes,type is Clock
	 */
	private Clock clock ;
	/**
	 * Constructor for new SettingAlarmState
	 * @param clock is attributes,type is Clock
	 */
	public SettingAlarmState(Clock clock){
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
	 * pressSet can change of state that you want
	 */
	public void pressSet() {
		clock.setBlinkHr( true );
		clock.setState( setHours );
	}
	/**
	 * pressPlus can change time is plus one
	 */
	public void pressPlus() {
		clock.setState( clock.getDisplayTimeState() );

	}
	/**
	 * pressMinus can change time is minus one
	 */
	public void pressMinus() {

	}

	ClockState setHours = new ClockState(){

		public void pressSet() {
			clock.setBlinkHr( false );
			clock.setBlinkMin( true );
			clock.setState( setMins );
		}

		public void pressPlus() {
			if( clock.getAlarmHr() < 24 )
				clock.setAlarmHr( clock.getAlarmHr()+1 );			
			else
				clock.setAlarmHr( 0 );
		}

		public void pressMinus() {
			if( clock.getAlarmHr() > 0 )
				clock.setAlarmHr( clock.getAlarmHr()-1 );
			else
				clock.setAlarmHr( 23 );
		}

		public void updateTime() {
			if(clock.isBlink()){
				clock.setShowHr(clock.getAlarmHr());
			}
			else{
				clock.setShowMin( clock.getAlarmMin() );
				clock.setShowSec( clock.getAlarmSec() );
			}
		}
	};

	ClockState setMins = new ClockState(){

		public void pressSet() {
			clock.setBlinkMin( false );
			clock.setBlinkSec( true );
			clock.setState( setSecs );
		}

		public void pressPlus() {
			if( clock.getAlarmMin() < 60 )
				clock.setAlarmMin( clock.getAlarmMin()+1 );				
			else
				clock.setAlarmMin( 0 );
		}

		public void pressMinus() {
			if( clock.getAlarmMin() > 0 )
				clock.setAlarmMin( clock.getAlarmMin()-1 );		
			else
				clock.setAlarmMin( 59 );
		}

		public void updateTime() {
			clock.setShowHr( clock.getAlarmHr() );
			clock.setShowMin( clock.getAlarmMin() );
			clock.setShowSec( clock.getAlarmSec() );
		}
	};
	ClockState setSecs = new ClockState(){

		public void pressSet() {
			clock.setBlinkSec( false );
			clock.setShowAlarm( true );
			clock.setShowSetDay( false );
			clock.save();
			clock.setState( clock.getDisplayTimeState() );
		}

		public void pressPlus() {
			if( clock.getAlarmSec() < 60 )
				clock.setAlarmSec( clock.getAlarmSec()+1 );				
			else
				clock.setAlarmSec( 0 );
		}

		public void pressMinus() {
			if( clock.getAlarmSec() > 0 )
				clock.setAlarmSec( clock.getAlarmSec()-1 );				
			else
				clock.setAlarmSec( 59 );
		}

		public void updateTime() {
			clock.setShowHr( clock.getAlarmHr() );
			clock.setShowMin( clock.getAlarmMin() );
			clock.setShowSec( clock.getAlarmSec() );
		}
	};
}
