package Saori.Diary;

import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class DiaryListUI extends JDialog implements Runnable{
	private Diary[] Diarylist;
	private DiaryList list;
	public DiaryListUI(DiaryList list){
		super();
		this.list = list;
		this.Diarylist = list.loadDiary();
		setSize(400,500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_4.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JList list_1 = new JList();
		panel_1.add(list_1);
		initComponent();
	}
	public void initComponent(){
		JPanel panel = new JPanel();
		String[] monthName = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String[] diaryTitles = new String[Diarylist.length];
		for (int i = 0 ; i<diaryTitles.length;i++) {
			diaryTitles[i] = "("+Diarylist[i].getDate().get(GregorianCalendar.HOUR)+":"+Diarylist[i].getDate().get(GregorianCalendar.MINUTE)+")"+Diarylist[i].getTitle();
		}
		JList diaryList = new JList(diaryTitles);
		diaryList.setBounds(0, 0, 256, 128);
		JScrollPane scrollPane = new JScrollPane(diaryList);
		
	}
	@Override
	public void run() {
		setVisible(true);
	}
}
