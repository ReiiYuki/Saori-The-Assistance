package Saori.Diary;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Saori.Listener.DragListener;
import Saori.Listener.ExitListener;
import Saori.Listener.Diary.createNewDiaryUIListener;
import Saori.Listener.Diary.selectListListener;
import Saori.Loader.LoadFont;
/**
 * DiaryListUI is ui that show list of diary of that time.
 * @author Voraton Lertrattanapaisal
 *
 */
public class DiaryListUI extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5805365650919114775L;
	private DiaryList diaryList;
	private JList<Diary> list;
	private Font font;
	public DiaryListUI(DiaryList diaryList){
		super();
		font = LoadFont.loadFont();
		this.diaryList = diaryList;
		initComponent();
		pack();
	}
	/**
	 * To initialize the component of ui.
	 */
	public void initComponent(){
		setUndecorated(true);
		JPanel panel = new ImagePanel("Saori/Diary/Imagee/bg.jpg");
		panel.setBorder(new EmptyBorder(10,10,10,10));
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		JPanel exitPanel = new JPanel();
		exitPanel.setOpaque(false);
		exitPanel.setBackground (new Color (0, 0, 0, 0));
		exitPanel.setLayout(new FlowLayout());
		JButton exitButton = new JButton();
		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setBorder(BorderFactory.createEmptyBorder());
		exitButton.addActionListener(new ExitListener(this));
		exitButton.setIcon(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/exit.png")));
		exitPanel.add(exitButton);
		JPanel title = new JPanel();
		title.setOpaque(false);
		title.setBackground (new Color (0, 0, 0, 0));
		title.setLayout(new FlowLayout());
		String [] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		JLabel dateLab = new JLabel("What\'s in "+diaryList.getDate().get(GregorianCalendar.YEAR)+", "+monthName[diaryList.getDate().get(GregorianCalendar.MONTH)]+" "+diaryList.getDate().get(GregorianCalendar.DATE));
		font = font.deriveFont(Font.PLAIN,30);
		dateLab.setFont(font);
		title.add(dateLab);
		JPanel newPanel = new JPanel();
		newPanel.setOpaque(false);
		newPanel.setBackground (new Color (0, 0, 0, 0));
		newPanel.setLayout(new FlowLayout());
		JButton createDiaryButton = new JButton();
		createDiaryButton.setOpaque(false);
		createDiaryButton.setContentAreaFilled(false);
		createDiaryButton.setBorderPainted(false);
		createDiaryButton.setBorder(BorderFactory.createEmptyBorder());
		createDiaryButton.addActionListener(new ExitListener(this));
		createDiaryButton.setIcon(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/CreateNewDiary.png")));
		createDiaryButton.addActionListener(new createNewDiaryUIListener());
		newPanel.add(createDiaryButton);
		JPanel showDiary = new JPanel();
		showDiary.setBorder(new EmptyBorder(10,10,10,10));
		showDiary.setLayout(new GridLayout(1,1));
		list = new JList<Diary>(diaryList.loadDiary());
		font = font.deriveFont(Font.PLAIN,20);
		list.setFont(font);
		list.setBackground(Color.decode("#F3E2A9"));
		list.addMouseListener(new selectListListener(list));
		JScrollPane scroll = new JScrollPane(list);
		panel.add(exitPanel);
		panel.add(title);
		panel.add(newPanel);
		panel.add(scroll);
		addMouseMotionListener(new DragListener(this));
		setContentPane(panel);
		
	}
	/**
	 * Update list of diary.
	 */
	public void updateList(){
		list =  new JList<Diary>(diaryList.loadDiary());
		repaint();
	}
	public void run(){
		setVisible(true);
		updateList();
	}
}
