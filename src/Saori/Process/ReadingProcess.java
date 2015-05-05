package Saori.Process;

import java.util.GregorianCalendar;

import Saori.AICore;
import Saori.SaoriUI;
import Saori.Diary.DiaryIO;
import Saori.Event.ReadingEvent;

public class ReadingProcess implements Process{
	private DiaryIO diaryWriter;
	private SaoriUI ui;
	private AICore ai;
	public ReadingProcess(AICore ai,SaoriUI ui,DiaryIO diaryWriter,GregorianCalendar date){
		this.diaryWriter = diaryWriter;
		this.ai = ai;
		this.ui = ui;
		ui.changeEvent(new ReadingEvent(ui));
	}
	@Override
	public String doingProcess(String line) {
		
		return null;
	}
	
	@Override
	public String endProcess(Process newProcess) {
		
		return null;
	}
	
}
