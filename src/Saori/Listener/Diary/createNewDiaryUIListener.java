package Saori.Listener.Diary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Saori.Diary.DiaryUI;

public class createNewDiaryUIListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DiaryUI diary = new DiaryUI();
		diary.run();
	}
	
}
