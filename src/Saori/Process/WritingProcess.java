package Saori.Process;


import Saori.AICore;
import Saori.SaoriUI;
import Saori.Diary.DiaryIO;
import Saori.Event.WritingEvent;

public class WritingProcess implements Process{
	private DiaryIO diaryWriter;
	private SaoriUI ui;
	private AICore ai;
	public WritingProcess(AICore ai,SaoriUI ui,DiaryIO diaryWriter){
		this.diaryWriter = diaryWriter;
		this.ai = ai;
		this.ui = ui;
		ui.changeEvent(new WritingEvent(ui));
	}
	@Override
	public String doingProcess(String line) {
		diaryWriter.write(line);
		return "What's next?";
	}
	@Override
	public String endProcess(Process newProcess) {
		diaryWriter.writeFile();
		ai.changeProcess(newProcess);
		return "Wow! master story is fun!";
	}
	
}
