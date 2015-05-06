package Saori.Process;

import Saori.AICore;
import Saori.SaoriUI;
import Saori.Event.StandingEvent;

public class RelaxingProcess implements Process{
	private AICore ai;
	private SaoriUI ui;
	public RelaxingProcess(AICore ai,SaoriUI ui){
		this.ai = ai;
		this.ui = ui;
		ui.changeEvent(new StandingEvent(ui));
	}
	@Override
	public String doingProcess(String line) {
		
		return null;
	}
	public String endProcess(Process newProcess){
		if (newProcess.getClass() == WritingProcess.class) {
			ai.changeProcess(newProcess);
			return "Master, please tell me ^^ ♥";
		}
	}
}
