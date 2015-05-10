package Saori.Diary;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * DiaryIO is use for inputing or outputing the diary.
 * @author Voraton Lertrattanapaisal
 *
 */
public class DiaryIO {
	private Diary diary;
	/**
	 * Constructor for initialize empty diary.
	 */
	public DiaryIO(){
		this.diary = new Diary();
	}
	/**
	 * Constructor for setup diary.
	 * @param diary that will be set.
	 */
	public DiaryIO(Diary diary){
		this.diary = diary;
	}
	/**
	 * Setup the reminder.
	 * @param remindDate is date to notify.
	 */
	public void toRemind(GregorianCalendar remindDate){
		diary = new Reminder(diary,remindDate);
	}
	/**
	 * To write line to the diary.
	 * @param line is line which is written to the diary.
	 */
	public void write(String line){
		diary.write(line);
	}
	/**
	 * To write the output file of diary.
	 */
	public void writeFile(){
		GregorianCalendar date = diary.getDate();
		String path = "src\\Saori\\Diary\\Data\\"+date.get(GregorianCalendar.DATE)+"-"+(date.get(GregorianCalendar.MONTH)+1)+"-"+date.get(GregorianCalendar.YEAR);
		File file = new File(path);
		if (file.exists()){
			try {
				
				FileOutputStream fout = new FileOutputStream(path+"\\"+diary.getTitle()+".isr");
				ObjectOutputStream oos = new ObjectOutputStream(fout);   
				oos.writeObject(diary);
				oos.close();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		else {
			if (file.mkdirs()){
				
					
				try {

					FileOutputStream fout = new FileOutputStream(path+"\\"+diary.getTitle()+".isr");
					ObjectOutputStream oos = new ObjectOutputStream(fout);   
					oos.writeObject(diary);
					oos.close();

				} catch (IOException e1) {
					
					e1.printStackTrace();
				} 
				
			}
		}
	}
	/**
	 * Reading the diary.
	 * @param diary is diary which will be read. 
	 * @return article of diary.
	 */
	public ArrayList<String> read(Diary diary){
		return diary.article;
	}
	/**
	 * Writing article title and date on the GUI.
	 * @param ui is DiaryUI that will be written.
	 */
	public void writeOnUI(DiaryUI ui){
		for (String i: read(diary)){
			ui.article.append(i);
		}
		ui.setTitle(diary.getTitle());
		ui.dateLab.setText(diary.getDate().get(GregorianCalendar.DATE)+"/"+diary.getDate().get(GregorianCalendar.MONTH)+"/"+diary.getDate().get(GregorianCalendar.YEAR));
	}
	/**
	 * Set the diary to DiaryIO.
	 * @param diary is diary that will be set.
	 */
	public void setDiary(Diary diary){
		this.diary = diary;
	}
	/**
	 * Get the diary which was set in DiaryIO.
	 * @return diary of DiaryIO.
	 */
	public Diary getDiary() {
		return diary;
	}

}
