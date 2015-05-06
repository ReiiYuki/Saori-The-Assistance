package Saori.Diary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DiaryList {
	private GregorianCalendar date;
	public DiaryList(GregorianCalendar dateToGet){
		date = dateToGet;
	}
	public Diary[] loadDiary(){
		try {
			String path = "src\\Saori\\Diary\\Data\\"+date.get(Calendar.DATE)+"-"+date.get(Calendar.MONTH)+"-"+date.get(Calendar.YEAR);
			File folder = new File(path);
			ArrayList<Diary> diary = new ArrayList<Diary>();
			int cursor = 0;
			File[] listOfFile = folder.listFiles();
			for (File i : listOfFile) {
				if (i.getName().endsWith(".isr")) {    
					FileInputStream fileIn = new FileInputStream(i);
			        ObjectInputStream in = new ObjectInputStream(fileIn);
					diary.add((Diary) in.readObject());
					cursor++;
				}
			}
			Diary[] diaryArray = new Diary[diary.size()];
			return diary.toArray(diaryArray);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return new Diary[]{};
		}

	public static void main(String[] args) {
		DiaryList diary = new DiaryList(new GregorianCalendar(2015,4,3));
		Diary[] d = diary.loadDiary();
		System.out.println(d.length);
		for (Diary i : d){
			System.out.println(i.getDescription());
		}
	}
}
