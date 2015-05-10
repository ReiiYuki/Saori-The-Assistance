package Saori.Diary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Saori.Listener.DragListener;
import Saori.Listener.ExitListener;
import Saori.Loader.LoadFont;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
/**
 * DiaryUI is user interface which is use for writing diary.
 * @author Voraton Lertrattanapaisal
 *
 */
public class DiaryUI extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3186829717912930588L;
	GregorianCalendar timeEdited;

	JLabel dateLab;
	JTextField remindMin;
	JTextArea article;
	JButton Exit;
	DiaryIO io;
	private JPanel exitBar;
	
	private Font font;
	JTextField title;
	private JTextField remindDate;
	private JTextField remindMonth;
	private JTextField remindYear;
	private JTextField remindHour;
	private JCheckBox reminderChecker;
	/**
	 * Constructor to initialize ui with old diary.
	 * @param diary is diary that will be set on ui.
	 */
	public DiaryUI(Diary diary){
		super();
		io = new DiaryIO(diary);
		font = LoadFont.loadFont();
		initComponent();
		io.writeOnUI(this);
		pack();
	}
	/**
	 * Constructor to initialize ui for creating new diary.
	 */
	public DiaryUI(){
		super();
		font = LoadFont.loadFont();
		io = new DiaryIO();
		initComponent();
		pack();
	}
	/**
	 * To initialize component of ui.
	 */
	public void initComponent(){
		setUndecorated(true);
		JPanel panel = new ImagePanel("Saori/Diary/Imagee/WhiteRosePolkaPaper.png");
		panel.setBorder(new EmptyBorder(10,10,10,10));
		setContentPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		exitBar = new JPanel();
		panel.add(exitBar);
		exitBar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		exitBar.setOpaque(false);
		exitBar.setBackground (new Color (0, 0, 0, 0));
		JButton exitButton = new JButton();
		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setBorder(BorderFactory.createEmptyBorder());
		exitButton.addActionListener(new ExitListener(this));
		exitButton.setIcon(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/exit.png")));
		exitBar.add(exitButton);
		
		font = font.deriveFont(Font.PLAIN, 10);
		JPanel checkingPanel = new JPanel();
		checkingPanel.setOpaque(false);
		checkingPanel.setBackground (new Color (0, 0, 0, 0));
		checkingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(checkingPanel);
		checkingPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		reminderChecker = new JCheckBox("Reminder");
		reminderChecker.setOpaque(false);
		reminderChecker.setIcon(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/checked.png")));
		reminderChecker.setSelectedIcon(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/unchecked.png")));
		reminderChecker.setFont(font);
		checkingPanel.add(reminderChecker);
		
		JPanel datePanel = new JPanel();
		datePanel.setOpaque(false);
		datePanel.setBackground (new Color (0, 0, 0, 0));
		panel.add(datePanel);
		datePanel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel currentDatePanel = new JPanel();
		currentDatePanel.setOpaque(false);
		currentDatePanel.setBackground (new Color (0, 0, 0, 0));
		datePanel.add(currentDatePanel);
		currentDatePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		font = font.deriveFont(Font.PLAIN, 20);
		JLabel currentDateTitle = new JLabel("Date");
		currentDateTitle.setFont(font);
		currentDatePanel.add(currentDateTitle);
		
		JPanel reminderPanel = new JPanel();
		reminderPanel.setOpaque(false);
		reminderPanel.setBackground (new Color (0, 0, 0, 0));
		datePanel.add(reminderPanel);
		reminderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel reminderTitle = new JLabel("Remind Date");
		reminderTitle.setFont(font);
		reminderPanel.add(reminderTitle);
		
		font = font.deriveFont(Font.PLAIN, 15);

		JPanel currentDateShow = new JPanel();
		currentDateShow.setOpaque(false);
		currentDateShow.setBackground (new Color (0, 0, 0, 0));
		datePanel.add(currentDateShow);
		currentDateShow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		dateLab = new JLabel(io.getDiary().getDate().get(GregorianCalendar.DATE)+"/"+io.getDiary().getDate().get(GregorianCalendar.MONTH)+"/"+io.getDiary().getDate().get(GregorianCalendar.YEAR));
		dateLab.setFont(font);
		currentDateShow.add(dateLab);
		
		JPanel reminderDateShow = new JPanel();
		reminderDateShow.setOpaque(false);
		reminderDateShow.setBackground (new Color (0, 0, 0, 0));
		datePanel.add(reminderDateShow);
		reminderDateShow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		remindDate = new JTextField();
		remindDate.setEditable(true);
		remindDate.setFont(font);
		remindDate.setOpaque(false);
		remindDate.setBorder(null);
		reminderDateShow.add(remindDate);
		remindDate.setColumns(2);
		
		JLabel slashLab = new JLabel("/");
		reminderDateShow.add(slashLab);
		slashLab.setFont(font);

		remindMonth = new JTextField();
		remindMonth.setEditable(true);
		reminderDateShow.add(remindMonth);
		remindMonth.setOpaque(false);
		remindMonth.setBorder(null);
		remindMonth.setFont(font);
		remindMonth.setColumns(2);
		
		JLabel slashLab2 = new JLabel("/");
		slashLab2.setFont(font);
		reminderDateShow.add(slashLab2);
		
		remindYear = new JTextField();
		remindYear.setFont(font);
		remindYear.setEditable(true);
		remindYear.setOpaque(false);
		remindYear.setBorder(null);
		reminderDateShow.add(remindYear);
		remindYear.setColumns(4);
		
		JPanel timePanel = new JPanel();
		timePanel.setOpaque(false);
		timePanel.setBackground (new Color (0, 0, 0, 0));
		timePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(timePanel);
		timePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		remindHour = new JTextField();
		timePanel.add(remindHour);
		remindHour.setOpaque(false);
		remindHour.setEditable(true);
		remindHour.setBorder(null);
		remindHour.setFont(font);
		remindHour.setColumns(2);
		
		JLabel colonLab = new JLabel(":");
		dateLab.setFont(font);
		dateLab.setOpaque(false);
		dateLab.setBorder(null);
		timePanel.add(colonLab);

		remindMin = new JTextField();
		remindMin.setFont(font);
		remindMin.setEditable(true);
		remindMin.setOpaque(false);
		remindMin.setBorder(null);
		timePanel.add(remindMin);
		remindMin.setColumns(2);
		
		JPanel titleBar = new JPanel();
		titleBar.setOpaque(false);
		titleBar.setBackground (new Color (0, 0, 0, 0));
		panel.add(titleBar);
		titleBar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		font = font.deriveFont(Font.PLAIN, 30);
		title = new JTextField();
		title.setFont(font);
		title.setEditable(true);
		title.setOpaque(false);
		title.setBorder(null);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setText("Title");
		titleBar.add(title);
		title.setColumns(10);
		
		JPanel body = new JPanel();
		body.setOpaque(false);
		body.setBackground (new Color (0, 0, 0, 0));
		panel.add(body);

		body.setLayout(new GridLayout(1, 1, 0, 0));
		font = font.deriveFont(Font.PLAIN, 10);

		article = new JTextArea(30,50);
		article.setFont(font);
		article.setOpaque(false);
		article.setEditable(true);
		article.setBackground (new Color (0, 0, 0, 0));
		article.setBorder(BorderFactory.createEmptyBorder());
		JScrollPane scroll = new JScrollPane(article);
		scroll.setOpaque(false);
		scroll.setBackground (new Color (0, 0, 0, 0));
		scroll.setBorder(null);
		body.add(scroll);
		
		JPanel confirmBar = new JPanel();
		confirmBar.setOpaque(false);
		confirmBar.setBackground (new Color (0, 0, 0, 0));
		panel.add(confirmBar);
		
		JButton confirmButton = new JButton();
		confirmButton.setOpaque(false);
		confirmButton.setContentAreaFilled(false);
		confirmButton.setBorderPainted(false);
		confirmButton.setBorder(BorderFactory.createEmptyBorder());
		confirmButton.addActionListener(new ExitListener(this));
		confirmButton.setIcon(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/save.png")));
		confirmButton.addActionListener(new confirmActionListener());
		confirmBar.add(confirmButton);
		addMouseMotionListener(new DragListener(this));

		pack();
	}
	/**
	 * Action listener of confirm button to save diary.
	 * @author Voraton Lertrattanapaisal
	 *
	 */
	class confirmActionListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				Diary diary  = new Diary();
				diary.setTitle(title.getText());
				for (String i : article.getText().split("\\n")){
					diary.write(i);
				}
				io.setDiary(diary);
				if (!reminderChecker.isSelected()){
					int year = Integer.parseInt(remindYear.getText());
					int month = Integer.parseInt(remindMonth.getText());
					int date = Integer.parseInt(remindDate.getText());
					int hour = Integer.parseInt(remindHour.getText());
					int min = Integer.parseInt(remindMin.getText());
	
					GregorianCalendar alertTime = new GregorianCalendar();
					alertTime.set(year, month, date, hour, min);
					io.toRemind(alertTime);
				}
				io.writeFile();
			}
			catch (NumberFormatException n){
				//do nothing
			}
		}
		
	}
	
	/** run GUI **/
	public void run() {
		setVisible(true);
		pack();
	}
}
