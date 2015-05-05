package Saori;

import java.util.GregorianCalendar;

import Saori.Clock.Clock;
import Saori.Diary.DiaryIO;
import Saori.Process.ReadingProcess;
import Saori.Process.RelaxingProcess;
import Saori.Process.Process;
import Saori.Process.WritingProcess;

public class AICore implements Runnable{
	private SaoriUI saori;
	private Clock clock;
	private DiaryIO diaryIO; 
	private Process process;
	private AICore(){
		saori = new SaoriUI();
		diaryIO = new DiaryIO();
		clock = new Clock();
		process = new RelaxingProcess(this,saori);
	}
	public AICore getInstance(){
		AICore ai = new AICore();
		return ai;
	}
	public String doingCommand(String key){
		
		if ("write".indexOf(key)>0 && process.getClass() == RelaxingProcess.class) return process.endProcess(new WritingProcess(this,saori,diaryIO));
		if ("end".indexOf(key)>0 && process.getClass() == WritingProcess.class) return process.endProcess(new RelaxingProcess(this,saori));
		if ("read".indexOf(key)>0 && process.getClass() == ReadingProcess.class ) return process.endProcess(new ReadingProcess());
		return process.doingProcess(key);
	}
	public GregorianCalendar getDateFormat(String key){
		String[] splitedKey = key.split(" ");
		for (String i : splitedKey) {
			if (i.matches("([0-9]{1-2})-([0-9]{1-2})-([0-9]{1-4})")){
				String[] dateFormat = i.split("-");
				int date = Integer.parseInt(dateFormat[0]);
				int month = Integer.parseInt(dateFormat[1])-1;
				int year = Integer.parseInt(dateFormat[2]);
				return new GregorianCalendar(year,month,date);
			}
		}
		return null;
	}
	@Override
	public void run() {
		
	}
	
	public void changeProcess(Process newProcess) {
		this.process = newProcess;
	}
	
}
