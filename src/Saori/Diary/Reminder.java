package Saori.Diary;

import java.util.GregorianCalendar;

public class Reminder extends Diary {
	private GregorianCalendar alertTime;
	public Reminder(String title, String[] article,GregorianCalendar time,GregorianCalendar alertTime) {
		super(title, article, time);
		this.alertTime = alertTime;
	}
	public boolean isAlert(GregorianCalendar currentTime){
		boolean dateEquality = alertTime.get(GregorianCalendar.DATE) == currentTime.get(GregorianCalendar.DATE);
		boolean monthEquality = alertTime.get(GregorianCalendar.MONTH) == currentTime.get(GregorianCalendar.MONTH);
		boolean yearEquality = alertTime.get(GregorianCalendar.YEAR) == currentTime.get(GregorianCalendar.YEAR);
		boolean hourEquality = alertTime.get(GregorianCalendar.HOUR_OF_DAY) == currentTime.get(GregorianCalendar.HOUR_OF_DAY);
		boolean minEquality = alertTime.get(GregorianCalendar.MINUTE) == currentTime.get(GregorianCalendar.MINUTE);
		if (dateEquality == true && monthEquality == true && yearEquality == true && hourEquality == true && minEquality == true) return true;
		return false;
	}
}
