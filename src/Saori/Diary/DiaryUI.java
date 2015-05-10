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

import Saori.Listener.ExitListener;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
/**
 * DiaryUI is user interface which is use for writing diary.
 * @author Voraton Lertrattanapaisal
 *
 */
public class DiaryUI extends JDialog implements Runnable{
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
	JTextField title;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Constructor to initialize ui with old diary.
	 * @param diary is diary that will be set on ui.
	 */
	public DiaryUI(Diary diary){
		super();
		io = new DiaryIO(diary);
		initComponent();
		io.writeOnUI(this);
		pack();
	}
	/**
	 * Contructor to initialize ui for creating new diary.
	 */
	public DiaryUI(){
		super();
		io = new DiaryIO();
		initComponent();
		pack();
	}
	/**
	 * To initialize component of ui.
	 */
	public void initComponent(){
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		exitBar = new JPanel();
		panel.add(exitBar);
		exitBar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton exitButton = new JButton();
		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setBorder(BorderFactory.createEmptyBorder());
		exitButton.addActionListener(new ExitListener(this));
		exitButton.setIcon(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/exit.png")));
		exitBar.add(exitButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Remind Date");
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		dateLab = new JLabel(io.getDiary().getDate().get(GregorianCalendar.DATE)+"/"+io.getDiary().getDate().get(GregorianCalendar.MONTH)+"/"+io.getDiary().getDate().get(GregorianCalendar.YEAR));
		panel_5.add(dateLab);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(2);
		
		JLabel lblNewLabel = new JLabel("/");
		panel_6.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel_6.add(textField_1);
		textField_1.setColumns(2);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		panel_6.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		panel_6.add(textField_2);
		textField_2.setColumns(4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_3 = new JTextField();
		panel_1.add(textField_3);
		textField_3.setColumns(2);
		
		JLabel label = new JLabel(":");
		panel_1.add(label);
		
		textField_4 = new JTextField();
		panel_1.add(textField_4);
		textField_4.setColumns(2);
		
		JPanel titleBar = new JPanel();
		panel.add(titleBar);
		titleBar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		title = new JTextField();
		titleBar.add(title);
		title.setColumns(10);
		
		JPanel body = new JPanel();
		panel.add(body);
		body.setLayout(new GridLayout(1, 1, 0, 0));
		
		article = new JTextArea(10,10);
		JScrollPane scroll = new JScrollPane(article);
		body.add(scroll);
		
		JPanel confirmBar = new JPanel();
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
			Diary diary  = new Diary();
			diary.setTitle(title.getText());
			for (String i : article.getText().split("\\n")){
				diary.write(i);
			}
			io.setDiary(diary);
			io.writeFile();
		}
		
	}
	@Override
	public void run() {
		setVisible(true);
	}
}
