package Saori.Diary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Reminder extends Diary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2907026660646427781L;
	private GregorianCalendar remindDate;
	public Reminder(GregorianCalendar remindDate){
		super();
		this.remindDate = remindDate;
	}
	public Reminder(GregorianCalendar timeEdited,GregorianCalendar remindDate,String title,ArrayList<String> article){
		super(timeEdited,title,article);
		this.remindDate = remindDate;
	}
	public Reminder(Diary diary, GregorianCalendar remindDate){
		super(diary);
		this.remindDate = remindDate;
	}
	public boolean isThatTime(GregorianCalendar currentTime){
		boolean dateEquality = remindDate.get(GregorianCalendar.DATE)==currentTime.get(GregorianCalendar.DATE);
		boolean monthEquality = remindDate.get(GregorianCalendar.MONTH)==currentTime.get(GregorianCalendar.MONTH);
		boolean yearEquality = remindDate.get(GregorianCalendar.YEAR)==currentTime.get(GregorianCalendar.YEAR);
		boolean hourEquality = remindDate.get(GregorianCalendar.HOUR)==currentTime.get(GregorianCalendar.HOUR);
		boolean minEquality = remindDate.get(GregorianCalendar.MINUTE)==currentTime.get(GregorianCalendar.MINUTE);
		return dateEquality&&monthEquality&&yearEquality&&hourEquality&&minEquality;
	}
	public String getRemindDate(){
		return remindDate.get(GregorianCalendar.YEAR)+"-"+remindDate.get(GregorianCalendar.MONTH)+"-"+remindDate.get(GregorianCalendar.DATE);
	}
}
