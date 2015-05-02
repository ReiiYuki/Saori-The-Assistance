package Saori.Diary;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Saori.Listener.ExitListener;

public class CalendarUI extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel YearLab;
	private JLabel MonthLab;
	JButton[][] calendarShow;
	Font font;
	private GregorianCalendar  calendar;
	JPanel panel;
	public CalendarUI() throws FontFormatException, IOException {
		super();
		calendar = new GregorianCalendar();
		calendar.setTimeInMillis(System.currentTimeMillis());
        URL fontUrl = ClassLoader.getSystemResource("Resource/Font/WaffleRegular.otf");
        font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,20);
        GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
		initComponent();
		updateTime();
		pack();
	}
	public void initComponent(){
		Container field = getContentPane();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JPanel header = new JPanel();
		header.setLayout(new FlowLayout());
		header.add(new JLabel("      "));
		YearLab = new JLabel(2005+"");
		YearLab.setFont(font);
		header.add(YearLab);
		JButton exit = new JButton("x");
		exit.addActionListener(new ExitListener());
		header.add(exit);		
		panel.add(header);
		JPanel title = new JPanel();
		title.setLayout(new FlowLayout());
		MonthLab = new JLabel("March");
		JButton event = new JButton("view event");
		title.add(MonthLab);
		title.add(event);
		panel.add(title);
		JPanel calendarTable = new JPanel();
		calendarTable.setLayout(new GridLayout(7,7));
		String[] listDay = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		for (int i =0;i<7;i++){
			calendarTable.add(new JLabel(listDay[i]));
		}
		calendarShow = new JButton[6][7];
		for (int i = 0;i<6;i++){
			for (int j = 0;j<7;j++){
				calendarShow[i][j] = new JButton();
				calendarTable.add(calendarShow[i][j]);
			}
		}
		panel.add(calendarTable);
		field.add(panel);
		setVisible(true);
	}
	public void updateTime(){
		Calendar upCalendar = new GregorianCalendar(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),1);
		
		int maxDay = upCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfFirst = upCalendar.get(Calendar.DAY_OF_WEEK);
		for (int i = 1;i<=maxDay;i++){
			int row = (i+dayOfFirst-2)/7;
			int column = (i+dayOfFirst-2)%7;
			calendarShow[row][column].setText(i+"");
		}
	}
	public static void main(String[] args) throws FontFormatException, IOException {
		CalendarUI test = new CalendarUI();
	}
}
