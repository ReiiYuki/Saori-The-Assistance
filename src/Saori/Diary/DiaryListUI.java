package Saori.Diary;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Saori.Listener.Diary.createNewDiaryUIListener;
import Saori.Listener.Diary.selectListListener;

public class DiaryListUI extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5805365650919114775L;
	private DiaryList diaryList;
	public DiaryListUI(DiaryList diaryList){
		super();
		this.diaryList = diaryList;
		initComponent();
		pack();
	}
	public void initComponent(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		JPanel exitPanel = new JPanel();
		exitPanel.setLayout(new FlowLayout());
		JButton exitButton = new JButton("X");
		exitPanel.add(exitButton);
		JPanel title = new JPanel();
		title.setLayout(new FlowLayout());
		String [] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		JLabel dateLab = new JLabel("What\'s in "+diaryList.getDate().get(GregorianCalendar.YEAR)+", "+monthName[diaryList.getDate().get(GregorianCalendar.MONTH)]+" "+diaryList.getDate().get(GregorianCalendar.DATE));
		title.add(dateLab);
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new FlowLayout());
		JButton createDiaryButton = new JButton();
		createDiaryButton.addActionListener(new createNewDiaryUIListener());
		newPanel.add(createDiaryButton);
		JPanel showDiary = new JPanel();
		showDiary.setBorder(new EmptyBorder(10,10,10,10));
		showDiary.setLayout(new GridLayout(1,1));
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JList<Diary> list = new JList(diaryList.loadDiary());
		list.addMouseListener(new selectListListener(list));
		JScrollPane scroll = new JScrollPane(list);
		panel.add(exitPanel);
		panel.add(title);
		panel.add(newPanel);
		panel.add(scroll);
		
		setContentPane(panel);
		
	}
	public void run(){
		setVisible(true);
	}
}
