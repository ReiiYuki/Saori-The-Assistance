package Saori.Listener.Diary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import Saori.Diary.DiaryList;
import Saori.Diary.DiaryListUI;

public class dateChooseButtonListener implements ActionListener {
	private DiaryListUI ui;
	public dateChooseButtonListener(GregorianCalendar calendar){
		DiaryList diarylist = new DiaryList(calendar);
		ui = new DiaryListUI(diarylist);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ui.run();
	}

}
