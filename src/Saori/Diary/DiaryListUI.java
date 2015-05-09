package Saori.Diary;

import java.awt.FlowLayout;
import java.awt.GridLayout;
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
/**
 * DiaryListUI is ui that show list of diary of that time.
 * @author Voraton Lertrattanapaisal
 *
 */
public class DiaryListUI extends JDialog implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5805365650919114775L;
	private DiaryList diaryList;
	private JList<Diary> list;
	public DiaryListUI(DiaryList diaryList){
		super();
		this.diaryList = diaryList;
		initComponent();
		pack();
	}
	/**
	 * To initialize the component of ui.
	 */
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
		list = new JList<Diary>(diaryList.loadDiary());
		list.addMouseListener(new selectListListener(list));
		JScrollPane scroll = new JScrollPane(list);
		panel.add(exitPanel);
		panel.add(title);
		panel.add(newPanel);
		panel.add(scroll);
		
		setContentPane(panel);
		
	}
	/**
	 * Update list of diary.
	 */
	public void updateList(){
		list =  new JList<Diary>(diaryList.loadDiary());
		repaint();
	}
	@Override
	public void run(){
		setVisible(true);
	}
}
