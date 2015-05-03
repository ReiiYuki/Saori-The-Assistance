package Saori.Diary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;

public class Diary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GregorianCalendar time;
	private String title;
	private String[] article;
	private static int serialNumbers = 0;
	public Diary(String title,String[] article,GregorianCalendar time){
		this.time = time;
		this.title = title;
		this.article = article;
		serialNumbers++;
	}
	public String getTitle(){
		return title;
	}
	public void read(JTextArea textArea){
		for (String i : article){
			textArea.append(i+"\n");
		}
	}
	public void write(JTextArea textArea,GregorianCalendar thatTime){
		article = textArea.getText().split("\\n");
		time = thatTime;
	}
	public String getDescription(){
		return String.format("%03d - Type: %s Title: %s Date: %d-%d-%d",serialNumbers,getClass().getName(), title,time.get(GregorianCalendar.DATE),time.get(GregorianCalendar.MONTH)+1,time.get(GregorianCalendar.YEAR));
	}
	public String getName(){
		return String.format("%03d%s",serialNumbers,getClass().getName().charAt(0));
	}
}
