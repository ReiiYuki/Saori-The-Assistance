package Saori.Diary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Diary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8692162105901890624L;
	String title;
	ArrayList<String> article;
	GregorianCalendar timeEdited;
	public Diary(){
		timeEdited = new GregorianCalendar();
		title = timeEdited.getTimeInMillis()+"";
		article = new ArrayList<String>();
	}
	public Diary(GregorianCalendar timeEdited,String title,ArrayList<String> article){
		this.timeEdited = timeEdited;
		this.title = title;
		this.article = article;
	}
	public Diary(Diary diary){
		this.timeEdited = diary.timeEdited;
		this.title = diary.title;
		this.article = diary.article;
	}
	public ArrayList<String> read(){
		return this.article;
	}
	public void write(String line){
		article.add(line);
	}
	public String getTitle(){
		return title;
	}
	public String getDescription(){
		return String.format("%s %s %s", getClass().getName(),getTitle(),timeEdited.toString());
	}
	public GregorianCalendar getDate(){
		return timeEdited;
	}
}
