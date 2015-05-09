package Saori.Diary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Diary is storage for storing text.
 * @author Voraton Lertrattanapaisal
 *
 */
public class Diary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8692162105901890624L;
	String title;
	ArrayList<String> article;
	GregorianCalendar timeEdited;
	/**
	 * Constructor for initialize new Diary.
	 */
	public Diary(){
		timeEdited = new GregorianCalendar();
		title = timeEdited.getTimeInMillis()+"";
		article = new ArrayList<String>();
	}
	/**
	 * Constructor for initialize new diary which contain time, title and the arcticle.
	 * @param timeEdited is time that was edited the diary.
	 * @param title is title of diary.
	 * @param article is the arcticle of the diary.
	 */
	public Diary(GregorianCalendar timeEdited,String title,ArrayList<String> article){
		this.timeEdited = timeEdited;
		this.title = title;
		this.article = article;
	}
	/**
	 * Constructor for initialize diary which use data from other diary.
	 * @param diary is diary which contain data.
	 */
	public Diary(Diary diary){
		this.timeEdited = diary.timeEdited;
		this.title = diary.title;
		this.article = diary.article;
	}
	/**
	 * Reading article to user.
	 * @return article of diary.
	 */
	public ArrayList<String> read(){
		return this.article;
	}
	/**
	 * Writing a line of article to article.
	 * @param line is line which is written to store in article field.
	 */
	public void write(String line){
		article.add(line);
	}
	/**
	 * Setting the title of the diary.
	 * @param title is title of diary.
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 * Getting title of the diary. 
	 * @return title of diary.
	 */
	public String getTitle(){
		return title;
	}
	/**
	 * Getting date of the diary.
	 * @return the date which is edied the diary.
	 */
	public GregorianCalendar getDate(){
		return timeEdited;
	}
	/**
	 * return the string of diary.
	 */
	public String toString(){
		return String.format("%02d:%02d:%02d %d/%d/%d %s %s",timeEdited.get(GregorianCalendar.HOUR),timeEdited.get(GregorianCalendar.MINUTE),timeEdited.get(GregorianCalendar.SECOND),timeEdited.get(GregorianCalendar.DATE),timeEdited.get(GregorianCalendar.MONTH),timeEdited.get(GregorianCalendar.YEAR),getClass().getName(),getTitle() );
	}
}
