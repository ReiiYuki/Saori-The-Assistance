package Saori.Diary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class DiaryUI extends JDialog implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3186829717912930588L;
	GregorianCalendar timeEdited;

	JLabel dateLab;
	JTextField remindMin;
	JTextArea article;
	JButton Clear;
	JButton Exit;
	JButton Minimize;
	DiaryIO io;
	private JPanel exitBar;
	JTextField title;
	public DiaryUI(Diary diary){
		super();
		io = new DiaryIO(diary);
		initComponent();
		io.writeOnUI(this);
		pack();
	}
	public DiaryUI(){
		super();
		io = new DiaryIO();
		initComponent();
		pack();
	}
	public void initComponent(){
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		exitBar = new JPanel();
		panel.add(exitBar);
		exitBar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton exitButton = new JButton("New button");
		exitBar.add(exitButton);
		
		JPanel dateBar = new JPanel();
		panel.add(dateBar);
		dateBar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		dateLab = new JLabel();
		dateBar.add(dateLab);
		
		JPanel titleBar = new JPanel();
		panel.add(titleBar);
		titleBar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		title = new JTextField();
		titleBar.add(title);
		title.setColumns(10);
		
		JPanel body = new JPanel();
		panel.add(body);
		body.setLayout(new GridLayout(1, 1, 0, 0));
		
		article = new JTextArea(10,1);
		body.add(article);
		
		JPanel confirmBar = new JPanel();
		panel.add(confirmBar);
		
		JButton confirmButton = new JButton("New button");
		confirmButton.addActionListener(new confirmActionListener());
		confirmBar.add(confirmButton);
		pack();
	}
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
