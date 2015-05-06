package Saori.Diary;

import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

public class DiaryListUI extends JDialog implements Runnable{
	private DiaryList list;
	public DiaryListUI(DiaryList list){
		super();
		this.list = list;
		initComponent();
	}
	public void initComponent(){
		JPanel panel = new JPanel();
//		JList 
	}
	@Override
	public void run() {
		setVisible(true);
	}
}
