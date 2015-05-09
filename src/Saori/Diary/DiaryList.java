package Saori.Diary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * DiaryList is using for loading Diarys which were written by date.
 * @author Voraton Lertrattanapaisal
 *
 */
public class DiaryList {
	private GregorianCalendar date;
	public DiaryList(GregorianCalendar dateToGet){
		date = dateToGet;
	}
	/**
	 * Loading the diaries follow the date.
	 * @return array of diaries.
	 */
	@SuppressWarnings("resource")
	public Diary[] loadDiary(){
		try {
			String path = "src\\Saori\\Diary\\Data\\"+date.get(Calendar.DATE)+"-"+(date.get(Calendar.MONTH)+1)+"-"+date.get(Calendar.YEAR);
			File folder = new File(path);
			ArrayList<Diary> diary = new ArrayList<Diary>();
			File[] listOfFile = folder.listFiles();
			if (listOfFile!=null){
				for (File i : listOfFile) {
					if (i.getName().endsWith(".isr")) {    
						FileInputStream fileIn = new FileInputStream(i);
				        ObjectInputStream in = new ObjectInputStream(fileIn);
						diary.add((Diary) in.readObject());
					}
				}
				Diary[] diaryArray = new Diary[diary.size()];
				return diary.toArray(diaryArray);
			}
			return  new Diary[]{};
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return new Diary[]{};
		}
	}
	/**
	 * Get date.
	 * @return date of diarylist.
	 */
	public GregorianCalendar getDate(){
		return date;
	}

}
