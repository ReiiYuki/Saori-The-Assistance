package Saori.Diary;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class DiaryIO {
	private Diary diary;
	public DiaryIO(){
		this.diary = new Diary();
	}
	public DiaryIO(GregorianCalendar timeEdited,String title,ArrayList<String> article){
		this.diary = new Diary(timeEdited,title,article);
	}
	public void toRemind(GregorianCalendar remindDate){
		diary = new Reminder(diary,remindDate);
	}
	public void write(String line){
		diary.write(line);
	}
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		}
	}
	public ArrayList<String> read(Diary diary){
		return diary.article;
	}
	public ArrayList<String> readAI(Diary diary){
		ArrayList<String> information = new ArrayList<String>();
		if (diary.getClass().getName().indexOf("Diary")>0) information.add("Diary");
		else {
			information.add("Reminder");
			information.add("Remind at "+((Reminder) diary).getRemindDate());
		}
		information.add(diary.getTitle());
		information.addAll(diary.read());
		return information;
	}
//	public ArrayList<String> readUI(DiaryUI ui){
//		
//	}
	public Diary getDiary() {
		return diary;
	}

}