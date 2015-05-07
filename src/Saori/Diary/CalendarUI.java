package Saori.Diary;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;

import Saori.Listener.DragListener;
import Saori.Listener.ExitListener;
import Saori.Listener.Diary.dateChooseButtonListener;

public class CalendarUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4456125431731463002L;
	private JTextField YearLab;
	private JTextField MonthLab;
	private String[] monthName;
	private final HashMap<String,Object[]> monthMap = new HashMap<String,Object[]>();
	{
		monthMap.put("January", new Object[]{1,"January"});
		monthMap.put("February",new Object[]{2,"February"});
		monthMap.put("March", new Object[]{3,"March"});
		monthMap.put("April",new Object[]{4,"April"});
		monthMap.put("May", new Object[]{5,"May"});
		monthMap.put("June",new Object[]{6,"June"});
		monthMap.put("July",new Object[]{ 7,"July"});
		monthMap.put("August",new Object[]{8,"August"});
		monthMap.put("September",new Object[]{ 9,"September"});
		monthMap.put("October",new Object[]{10,"October"});
		monthMap.put("November",new Object[]{ 11,"November"});
		monthMap.put("December",new Object[]{12,"December"});
	};
	TransperantButton[][] calendarShow;
	Font font;
	private GregorianCalendar  calendar;
	private GregorianCalendar  calendarNow;
	public CalendarUI()  {
		super();
		setUndecorated(true);
		calendarNow = new GregorianCalendar();
		calendarNow.setTimeInMillis(System.currentTimeMillis());
		calendar = new GregorianCalendar();
		calendar.setTimeInMillis(System.currentTimeMillis());
        URL fontUrl = ClassLoader.getSystemResource("Resource/Font/WaffleRegular.otf");
        try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
        GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
		initComponent();
		updateTime();
		pack();
	}
	public void initComponent(){
		
		JPanel panel = new ImagePanel();
		panel.setBorder(new EmptyBorder(10,10,10,10));
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		JPanel exitBar = new JPanel();
		exitBar.setLayout(new FlowLayout());
		JButton exit = new JButton();
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setBorder(BorderFactory.createEmptyBorder());
		exit.addActionListener(new ExitListener(this));
		exit.setIcon(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/exit.png")));
		exitBar.add(exit);	
		exitBar.setOpaque(false);
		exitBar.setBackground (new Color (0, 0, 0, 0));
		panel.add(exitBar);
		JPanel header = new JPanel();
		YearLab = new JTextField(4);
        font = font.deriveFont(Font.PLAIN,30);
        YearLab.setForeground(Color.decode("#3B240B"));
        YearLab.setHorizontalAlignment(JTextField.CENTER);
		YearLab.setText(calendar.get(Calendar.YEAR)+"");
		YearLab.setBackground (new Color (0, 0, 0, 0));
		YearLab.setOpaque(false);
		YearLab.setBorder(null);
		YearLab.setFont(font);
		YearLab.addActionListener(new setListener());
		header.setLayout(new FlowLayout());
		header.setOpaque(false);
		header.setBackground (new Color (0, 0, 0, 0));
		header.add(YearLab);
		panel.add(header);
		JPanel title = new JPanel();
		title.setLayout(new FlowLayout());
		monthName = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		MonthLab = new JTextField(9);
		font = font.deriveFont(Font.PLAIN,40);
		MonthLab.setForeground(Color.decode("#3B240B"));
		MonthLab.setHorizontalAlignment(JTextField.CENTER);
		MonthLab.setText(calendar.get(Calendar.YEAR)+"");
		MonthLab.setBackground (new Color (0, 0, 0, 0));
		MonthLab.setOpaque(false);
		MonthLab.setBorder(null);
		MonthLab.setFont(font);
		MonthLab.setText(monthName[calendar.get(Calendar.MONTH)]);
		MonthLab.addActionListener(new setListener());
		title.setOpaque(false);
		title.setBackground (new Color (0, 0, 0, 0));
		title.add(MonthLab);
		panel.add(title);
		JPanel calendarTable = new JPanel();
		calendarTable.setLayout(new GridLayout(7,7));
		String[] listDay = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		for (int i =0;i<7;i++){
			JLabel dayLab = new JLabel();
			font = font.deriveFont(Font.PLAIN,15);
			dayLab.setForeground(Color.decode("#3B240B"));
			dayLab.setFont(font);
			dayLab.setIconTextGap(-109);
			dayLab.setIcon(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/Label.jpg")));
			dayLab.setOpaque(true);
			dayLab.setText(listDay[i]);
			dayLab.setHorizontalTextPosition(JLabel.CENTER);
			calendarTable.add(dayLab);
		}
		calendarShow = new TransperantButton[6][7];
		for (int i = 0;i<6;i++){
			for (int j = 0;j<7;j++){
				calendarShow[i][j] = new TransperantButton();
				font = font.deriveFont(Font.PLAIN,15);
				calendarShow[i][j].setBackground(Color.WHITE);
				calendarShow[i][j].setFont(font);
				calendarShow[i][j].setForeground(Color.decode("#3B240B"));
				calendarShow[i][j].setBackground( Color.decode("#F3E2A9") );
				calendarShow[i][j].setOpaque(true);
				calendarShow[i][j].setContentAreaFilled(false);
				calendarShow[i][j].setBorderPainted(false);
				calendarTable.add(calendarShow[i][j]);
			}
		}
		calendarTable.setOpaque(false);
		calendarTable.setBackground (new Color (0, 0, 0, 0));
		panel.add(calendarTable);
		setContentPane(panel);
		addMouseMotionListener(new DragListener(this));
	}
	public void updateTime(){
		for (int i =0;i<6;i++) {
			for (int j =0;j<7;j++){
				calendarShow[i][j].setText("");
				for (ActionListener k :	calendarShow[i][j].getActionListeners()) {
					calendarShow[i][j].setBackground(Color.decode("#F3E2A9"));
					calendarShow[i][j].removeActionListener(k);
				}
			}
		}
		YearLab.setText(calendar.get(Calendar.YEAR)+"");
		Calendar upCalendar = new GregorianCalendar(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),1);
		calendar.setTimeInMillis(System.currentTimeMillis());
		int maxDay = upCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfFirst = upCalendar.get(Calendar.DAY_OF_WEEK);
		for (int i = 1;i<=maxDay;i++){
			int row = (i+dayOfFirst-2)/7;
			int column = (i+dayOfFirst-2)%7;
			if (i == calendar.get(Calendar.DATE)&& upCalendar.get(Calendar.MONTH) ==  calendar.get(Calendar.MONTH) && upCalendar.get(Calendar.YEAR) ==  calendar.get(Calendar.YEAR)){
				calendarShow[row][column].setBackground(Color.RED);
			}
			calendarShow[row][column].setText(i+"");
			calendarShow[row][column].setHorizontalTextPosition(JButton.CENTER);
			calendarShow[row][column].setVerticalTextPosition(JButton.CENTER);
			calendarShow[row][column].addActionListener(new dateChooseButtonListener(new GregorianCalendar(upCalendar.get(GregorianCalendar.YEAR),upCalendar.get(GregorianCalendar.MONTH),i)));
		}
		pack();
	}
	
	private class setListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int year = calendar.get(Calendar.YEAR);
			int month = 0;
			try {
				year = Integer.parseInt(YearLab.getText());
				calendar.set(Calendar.YEAR, year);
			}
			catch(NumberFormatException err){
				System.out.println("Invalid Year Format");
			}
			try {
				month = Integer.parseInt(MonthLab.getText());
				if (month>0&&month<=12) {
					calendar.set(Calendar.MONTH, month-1);
					MonthLab.setText(monthName[month-1]);
				}
				else System.out.println("Invalid Month Format");
			}
			catch(NumberFormatException err){
				Object[] monthObject = (Object[]) monthMap.get(MonthLab.getText());
				if (monthObject == null) System.out.println("Invalid Month Format");
				else {
					month = (int) monthObject[0];
					calendar.set(Calendar.MONTH,month-1);
					MonthLab.setText((String)monthObject[1]);
				}
			}
			updateTime();
		}
		
	}
	private class ImagePanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 7739895286879920819L;

		public void paintComponent(Graphics g) {
		    g.drawImage(new ImageIcon(ClassLoader.getSystemResource("Saori/Diary/Imagee/bg.jpg")).getImage(), 0, 0, null);
		 }
	}
	private class TransperantButton extends JButton{
		/**
		 * 
		 */
		private static final long serialVersionUID = 7252957684507474258L;
		/** 
         * @inherited <p>
         */
        @Override
        protected void paintComponent(Graphics g)
        {
            g.setColor( getBackground() );
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }
	}
	public static void main(String[] args) {
		CalendarUI ui = new CalendarUI();
		ui.setVisible(true);
	}
}
