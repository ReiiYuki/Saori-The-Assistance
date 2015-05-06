package Saori.Diary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DiaryUI extends JDialog {
	GregorianCalendar timeEdited;
	JTextField titleField;
	JLabel dateEdit;
	JLabel timeEdit;
	JLabel SerialNumber;
	JCheckBox typeChooser;
	JTextField remindYear; 
	JTextField remindMonth;
	JTextField remindDate;
	JTextField remindHour;
	JTextField remindMin;
	JTextArea article;
	JButton Save;
	JButton Clear;
	JButton Exit;
	JButton Minimize;
	public DiaryUI(GregorianCalendar timeEdited){
		super();
		this.timeEdited = timeEdited;
		initComponent();
		pack();
		setVisible(true);
	}
	public void initComponent(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		titleField = new JTextField(20);
		panel.add(titleField);
		article = new JTextArea(20,1);
		panel.add(article);
		Save = new JButton("Confirm");
		Save.addActionListener(new S());
		panel.add(Save);
		setContentPane(panel);
		pack();
	}
	class S implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String[] b = article.getText().split("\\n");
			ArrayList<String> a = new ArrayList<String>();
			for (String i : b) a.add(i);
			Diary diary = new Diary(timeEdited,titleField.getText(),a);
			String path = "src\\Saori\\Diary\\Data\\"+timeEdited.get(Calendar.DATE)+"-"+timeEdited.get(Calendar.MONTH)+"-"+timeEdited.get(Calendar.YEAR);
			File file = new File(path);
			if (file.exists()){
				try {

					FileOutputStream fout = new FileOutputStream(path+"\\"+diary.getTitle()+".isr");
					ObjectOutputStream oos = new ObjectOutputStream(fout);   
					oos.writeObject(diary);
					oos.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			else {
				if (file.mkdirs()){
					
						
					try {

						FileOutputStream fout = new FileOutputStream(path+"\\"+diary.getTitle()+".isr");
						ObjectOutputStream oos = new ObjectOutputStream(fout);   
						oos.writeObject(diary);
						oos.close();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
				}
			}
		}
	}
	public static void main(String[] args) {
		DiaryUI ui = new DiaryUI(new GregorianCalendar());
	}
}
