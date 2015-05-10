package Saori.Diary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Reminder is diary which can setup alert time.
 * @author Voraton Lertrattanapaisal
 *
 */
public class Reminder extends Diary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2907026660646427781L;
	private GregorianCalendar remindDate;
	/**
	 * Constructor to initialize new reminder.
	 * @param remindDate is alert time.
	 */
	public Reminder(GregorianCalendar remindDate){
		super();
		this.remindDate = remindDate;
	}
	/**
	 * Constructor to initialize reminder with date and alert time and title and article.
	 * @param timeEdited is time that edited.
	 * @param remindDate is time that it will be alert.
	 * @param title is title of reminder.
	 * @param article is article of reminder.
	 */
	public Reminder(GregorianCalendar timeEdited,GregorianCalendar remindDate,String title,ArrayList<String> article){
		super(timeEdited,title,article);
		this.remindDate = remindDate;
	}
	/**
	 * Constructor to initialize reminder with data from diary and alert time.
	 * @param diary is diary that contain old data.
	 * @param remindDate is time to alert.
	 */
	public Reminder(Diary diary, GregorianCalendar remindDate){
		super(diary);
		this.remindDate = remindDate;
	}
	/**
	 * Checking currentime with alert time.
	 * @param currentTime is current time.
	 * @return true if current time equal to alert time.
	 */
	public boolean isThatTime(GregorianCalendar currentTime){
		boolean dateEquality = remindDate.get(GregorianCalendar.DATE)==currentTime.get(GregorianCalendar.DATE);
		boolean monthEquality = remindDate.get(GregorianCalendar.MONTH)==currentTime.get(GregorianCalendar.MONTH);
		boolean yearEquality = remindDate.get(GregorianCalendar.YEAR)==currentTime.get(GregorianCalendar.YEAR);
		boolean hourEquality = remindDate.get(GregorianCalendar.HOUR)==currentTime.get(GregorianCalendar.HOUR);
		boolean minEquality = remindDate.get(GregorianCalendar.MINUTE)==currentTime.get(GregorianCalendar.MINUTE);
		return dateEquality&&monthEquality&&yearEquality&&hourEquality&&minEquality;
	}
	/**
	 * Get alert time in string.
	 * @return alert time in string.
	 */
	public String getRemindDate(){
		return remindDate.get(GregorianCalendar.YEAR)+"-"+remindDate.get(GregorianCalendar.MONTH)+"-"+remindDate.get(GregorianCalendar.DATE);
	}
	public GregorianCalendar getRemindCalendarDate(){
		return remindDate;
	}
}
