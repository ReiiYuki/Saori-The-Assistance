package Saori.Listener.Diary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import Saori.Diary.Diary;
import Saori.Diary.DiaryUI;
/**
 * selectListListener is action listener which use for run diaryui.
 * @author Voraton Lertrattanapaisal
 *
 */
public class selectListListener implements MouseListener {
	private JList<Diary> list;
	public selectListListener(JList<Diary> list){
		this.list = list;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount()>=2){
			System.out.println("Yes");
			Diary diary =  list.getSelectedValue();
			System.out.println(diary.toString());
			DiaryUI ui = new DiaryUI(diary);
			ui.run();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//do nothing
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//do nothing
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//do nothing
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//do nothing
	}

}
