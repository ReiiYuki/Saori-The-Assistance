package Saori.Listener.ToolUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Saori.Diary.CalendarUI;

public class calendarButtonListener implements ActionListener {
	private CalendarUI calendar;
	public calendarButtonListener(CalendarUI calendar){
		this.calendar = calendar;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		calendar.setVisible(true);
	}

}