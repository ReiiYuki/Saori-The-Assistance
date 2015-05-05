package Saori.Clock;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * AlarmRingingState is check that pressPlus ,pressMinus and pressSet come back to DisplayTimeState
 * @author Wanchanapon Thanwaranurak
 * @version 3/11/2015
 */
public class Clock {
	// attributes for can use every method
	private ClockState state ;
	
	private ClockState DisplayTimeState ;
	private ClockState AlarmRingingState ;
	private ClockState SettingAlarmState ;
	private ClockState StopWatch ;
	private int alarmHr ,alarmMin ,alarmSec ;
	private int showHr ,showMin ,showSec ;
	private boolean blink ,blinkHr ,blinkMin, blinkSec, showAlarm ,showSetDay;
	private boolean sun ,mon ,tue ,wed ,thu ,fri ,sat ;
	private int numSun ,numMon ,numTue ,numWed ,numThu ,numFri ,numSat ;
	private Clip sound ;
	private Calendar calendar  ;
	private Calendar alarm;
	private ArrayList<Calendar> setOfAlarm;
	/**
	 * Constructor for new Clock
	 */
	public Clock(){
		this.DisplayTimeState = new DisplayTimeState( this );
		this.AlarmRingingState = new AlarmRingingState( this );
		this.SettingAlarmState = new SettingAlarmState( this );
		this.StopWatch = new StopWatch ( this );
		this.blink = false ;
		this.blinkHr = false ;
		this.blinkMin = false ;
		this.blinkSec = false ;
		this.showAlarm = false ;
		this.showSetDay = false ;
		this.sun = false ;
		this.mon = false ;
		this.tue = false ;
		this.wed = false ;
		this.thu = false ;
		this.fri = false ;
		this.sat = false ;
		this.numSun = 0 ;
		this.numMon = 0 ;
		this.numTue = 0 ;
		this.numWed = 0 ;
		this.numThu = 0 ;
		this.numFri = 0 ;
		this.numSat = 0 ;
		this.calendar = Calendar.getInstance();
		this.alarm = Calendar.getInstance();
		this.setOfAlarm = new ArrayList<Calendar>();
		this.checkDay();
		restore();
		this.setState( DisplayTimeState );
	}
	public int getNumSun() {
		return numSun;
	}
	public ClockState getStopWatch() {
		return StopWatch;
	}
	public void setStopWatch(ClockState stopWatch) {
		StopWatch = stopWatch;
	}
	public void setNumSun(int numSun) {
		this.numSun = numSun;
	}
	public int getNumMon() {
		return numMon;
	}
	public void setNumMon(int numMon) {
		this.numMon = numMon;
	}
	public int getNumTue() {
		return numTue;
	}
	public void setNumTue(int numTue) {
		this.numTue = numTue;
	}
	public int getNumWed() {
		return numWed;
	}
	public void setNumWed(int numWed) {
		this.numWed = numWed;
	}
	public int getNumThu() {
		return numThu;
	}
	public void setNumThu(int numThu) {
		this.numThu = numThu;
	}
	public int getNumFri() {
		return numFri;
	}
	public void setNumFri(int numFri) {
		this.numFri = numFri;
	}
	public int getNumSat() {
		return numSat;
	}
	public void setNumSat(int numSat) {
		this.numSat = numSat;
	}
	public void checkDay(){
		if( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY )
			this.setSun(true);
		else if( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY )
			this.setMon(true); 
		else if( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY )
			this.setTue(true); 
		else if( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY )
			this.setWed(true);
		else if( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY )
			this.setThu(true);
		else if( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY )
			this.setFri(true);
		else {
			this.setSat(true);}
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public boolean isShowSetDay() {
		return showSetDay;
	}
	public void setShowSetDay(boolean showSetDay) {
		this.showSetDay = showSetDay;
	}
	public boolean isSun() {
		return sun;
	}
	public void setSun(boolean sun) {
		this.sun = sun;
	}
	public boolean isMon() {
		return mon;
	}
	public void setMon(boolean mon) {
		this.mon = mon;
	}
	public boolean isTue() {
		return tue;
	}
	public void setTue(boolean tue) {
		this.tue = tue;
	}
	public boolean isWed() {
		return wed;
	}
	public void setWed(boolean wed) {
		this.wed = wed;
	}
	public boolean isThu() {
		return thu;
	}
	public void setThu(boolean thu) {
		this.thu = thu;
	}
	public boolean isFri() {
		return fri;
	}
	public void setFri(boolean fri) {
		this.fri = fri;
	}
	public boolean isSat() {
		return sat;
	}
	public void setSat(boolean sat) {
		this.sat = sat;
	}
	public void restore(){
		File alertFile = new File("src\\Saori\\Clock\\listOfAlert.loa");
		if (alertFile.exists()){
	        try {
	    		FileInputStream filein = new FileInputStream(alertFile);
	            ObjectInputStream instream = new ObjectInputStream(filein);
				setOfAlarm = (ArrayList<Calendar>) instream.readObject();
				for (Calendar i : setOfAlarm){
					if (i.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) setSun(true);
					if (i.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY) setMon(true);
					if (i.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY) setTue(true);
					if (i.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY) setWed(true);
					if (i.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY) setThu(true);
					if (i.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY) setFri(true);
					if (i.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) setSat(true);
					setAlarmHr(i.get(Calendar.HOUR));
					setAlarmMin(i.get(Calendar.MINUTE));
					setAlarmSec(i.get(Calendar.SECOND));
					setShowAlarm(true);
				}
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void save(){
         try {
    		FileOutputStream fileout = new FileOutputStream("src\\Saori\\Clock\\listOfAlert.loa");
			ObjectOutputStream outstream= new ObjectOutputStream(fileout);
			outstream.writeObject(getListOfAlarm());
			outstream.close();
			fileout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Calendar> getListOfAlarm(){
		if (isSun()) {
			alarm.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			setOfAlarm.add(alarm);
		}
		if (isMon()) {
			alarm.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			setOfAlarm.add(alarm);
		}
		if (isTue()) {
			alarm.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			setOfAlarm.add(alarm);
		}
		if (isWed()) {
			alarm.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			setOfAlarm.add(alarm);
		}
		if (isThu()) {
			alarm.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
			setOfAlarm.add(alarm);
		}
		if (isFri()) {
			alarm.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			setOfAlarm.add(alarm);
		}
		if (isSat()) {
			alarm.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			setOfAlarm.add(alarm);
		}
		return setOfAlarm;
	}
	/**
	 * soundEffect is open effect method
	 */
	public void soundEffect(){
		try{
			sound = AudioSystem.getClip();
			Class loader = this.getClass();
			URL audio = loader.getResource( "sounds/RingTone.wav" );
			AudioInputStream soundStrem = AudioSystem.getAudioInputStream( audio );
			sound.open( soundStrem );
		}catch(IOException | UnsupportedAudioFileException | LineUnavailableException e ){
			e.printStackTrace();
		}
	}
	/**
	 * getSound is get sound ,type Clip
	 * @return sound is clip that you want to open
	 */
	public Clip getSound() {
		return sound;
	}
	/**
	 * setSound can set a new sound
	 * @param sound is clip that you want to open
	 */
	public void setSound(Clip sound) {
		this.sound = sound;
	}
	/**
	 * isShowAlarm is isShowAlarm that you set
	 * @return showAlarm is blink of icon alarm clock
	 */
	public boolean isShowAlarm() {
		return showAlarm;
	}
	/**
	 * setShowAlarm can set that you want to blink
	 * @param showAlarm is blink of icon alarm clock
	 */
	public void setShowAlarm(boolean showAlarm) {
		this.showAlarm = showAlarm;
	}
	/**
	 * isBlink is isBlink that you set
	 * @return blink is blink of all time
	 */
	public boolean isBlink() {
		return blink;
	}
	/**
	 * setBlink can set that you want to blink
	 * @param blink is blink of all time
	 */
	public void setBlink(boolean blink) {
		this.blink = blink;
	}
	/**
	 * blinkHr is blinkHr that you set
	 * @return blinkHr is blink of hours time
	 */
	public boolean isBlinkHr() {
		return blinkHr;
	}
	/**
	 * blinkHr can set that you want to blink
	 * @param blinkHr is blink of hours time
	 */
	public void setBlinkHr(boolean blinkHr) {
		this.blinkHr = blinkHr;
	}
	/**
	 * isBlinkMin is blinkMin that you set
	 * @return blinkMin is blink of minutes time
	 */
	public boolean isBlinkMin() {
		return blinkMin;
	}
	/**
	 * setBlinkMin can set that you want to blink
	 * @param blinkMin is blink of minutes time
	 */
	public void setBlinkMin(boolean blinkMin) {
		this.blinkMin = blinkMin;
	}
	/**
	 * isBlinkSec is blinkSec that you set
	 * @return blinkSec is blink of second time
	 */
	public boolean isBlinkSec() {
		return blinkSec;
	}
	/**
	 * setBlinkSec can set that you want to blink
	 * @param blinkSec is blink of second time
	 */
	public void setBlinkSec(boolean blinkSec) {
		this.blinkSec = blinkSec;
	}
	/**
	 * getShowHr is get showHr that you set
	 * @return showHr is time type hours ,type integer
	 */
	public int getShowHr() {
		return showHr;
	}
	/**
	 * setShowHr can set showHr that you want to show on GUI
	 * @param showHr is time type hours ,type integer
	 */
	public void setShowHr(int showHr) {
		this.showHr = showHr;
	}
	/**
	 * getShowMin is get showMin that you set
	 * @return showMin is time type minutes ,type integer
	 */
	public int getShowMin() {
		return showMin;
	}
	/**
	 * setShowMin can set showMin that you want to show on GUI
	 * @param showMin is time type minutes ,type integer
	 */
	public void setShowMin(int showMin) {
		this.showMin = showMin;
	}
	/**
	 * getShowSec is get showSec that you set
	 * @return showSec is time type second ,type integer
	 */
	public int getShowSec() {
		return showSec;
	}
	/**
	 * setShowSec can set showSec that you want to show on GUI
	 * @param showSec is time type second ,type integer
	 */
	public void setShowSec(int showSec) {
		this.showSec = showSec;
	}
	/**
	 * getAlarmHr is get alarmHr that you set
	 * @return alarmHr is Alarm clock type hours ,type integer
	 */
	public int getAlarmHr() {
		return alarmHr;
	}
	/**
	 * setAlarmHr can set alarmHr that you want to change
	 * @param alarmHr is Alarm clock type hours ,type integer
	 */
	public void setAlarmHr(int alarmHr) {
		this.alarmHr = alarmHr;
		alarm.set(Calendar.HOUR, alarmHr);
	}
	/**
	 * getAlarmMin is get alarmMin that you set
	 * @return alarmMin is Alarm clock type minutes ,type integer
	 */
	public int getAlarmMin() {
		return alarmMin;
	}
	/**
	 * setAlarmMin can set alarmMin that you want to change
	 * @param alarmMin is Alarm clock type minutes ,type integer
	 */
	public void setAlarmMin(int alarmMin) {
		this.alarmMin = alarmMin;
		alarm.set(Calendar.MINUTE, alarmMin);
	}
	/**
	 * getAlarmSec is get alarmSec that you set
	 * @return alarmSec is Alarm clock type second ,type integer
	 */
	public int getAlarmSec() {
		return alarmSec;
	}
	/**
	 * setAlarmSec can set alarmSec that you want to change
	 * @param alarmSec is Alarm clock type second ,type integer
	 */
	public void setAlarmSec(int alarmSec) {
		this.alarmSec = alarmSec;
		alarm.set(Calendar.SECOND,alarmSec);
	}
	/**
	 * updateTime is update method when over time
	 */
	public void updateTime(){
		state.updateTime();
	}
	/**
	 * getDisplayTimeState is get DisplayTime that you set
	 * @return DisplayTimeState is DisplayTime ,type ClockState
	 */
	public ClockState getDisplayTimeState() {
		return this.DisplayTimeState;
	}
	/**
	 * setAlarmRingingState can set DisplayTime that you want to change
	 * @param DisplayTimeState is DisplayTime ,type ClockState
	 */
	public void setDisplayTimeState(ClockState displayTimeState) {
		DisplayTimeState = displayTimeState;
	}
	/**
	 * getAlarmRingingState is get AlarmRinging that you set
	 * @return AlarmRingingState is AlarmRinging ,type ClockState
	 */
	public ClockState getAlarmRingingState() {
		return this.AlarmRingingState;
	}
	/**
	 * setAlarmRingingState can set setAlarmRinging that you want to change
	 * @param AlarmRingingState is AlarmRinging ,type ClockState
	 */
	public void setAlarmRingingState(ClockState alarmRingingState) {
		AlarmRingingState = alarmRingingState;
	}
	/**
	 * getSettingAlarmState is get settingAlarm that you set
	 * @return settingAlarmState is settingAlarm ,type ClockState
	 */
	public ClockState getSettingAlarmState() {
		return this.SettingAlarmState;
	}
	/**
	 * setSettingAlarmState can set SettingAlarmState that you want to change
	 * @param settingAlarmState is settingAlarm ,type ClockState
	 */
	public void setSettingAlarmState(ClockState settingAlarmState) {
		SettingAlarmState = settingAlarmState;
	}
	/**
	 * getState is get state that you live
	 * @return state that live ,type ClockState
	 */
	public ClockState getState() {
		return state;
	}
	/**
	 * setState can set state that you want to change
	 * @param state that live ,type ClockState 
	 */
	public void setState(ClockState state) {
		this.state = state;
	}
	/**
	 * handleSetKey is call method pressSet
	 */
	public void handleSetKey(){
		state.pressSet();
	}
	/**
	 * handlePlusKey is call method pressPlus
	 */
	public void handlePlusKey(){
		state.pressPlus();
	}
	/**
	 * handleMinusKey is call method pressMinus
	 */
	public void handleMinusKey(){
		state.pressMinus();
	}
	
}
