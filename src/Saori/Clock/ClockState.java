package Saori.Clock;
/**
 * ClockState is interface of DisplayTimeState class ,AlarmRingingState class and SettingAlarmState class
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public interface ClockState {
	/**
	 * pressSet can change of state that you want
	 */
	public void pressSet();
	/**
	 * pressPlus can change time is plus one
	 */
	public void pressPlus();
	/**
	 * pressMinus can change time is minus one
	 */
	public void pressMinus();
	/**
	 * updateTime is update method when over time
	 */
	public void updateTime();
	
}
