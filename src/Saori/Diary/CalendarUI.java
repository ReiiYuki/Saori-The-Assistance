package Saori.Diary;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import Saori.Listener.ExitListener;

public class CalendarUI extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel YearLab;
	Font font;
	private Calendar calendar;
	public CalendarUI() throws FontFormatException, IOException {
		super();
		calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
        URL fontUrl = ClassLoader.getSystemResource("Resource/Font/WaffleRegular.otf");
        font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,20);
        GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
		initComponent();
		pack();
	}
	public void initComponent(){
		Container field = getContentPane();
		field.setLayout(new GridLayout(3,1));
		
		Container header = new Container();
		header.setLayout(new BorderLayout());
		YearLab = new JLabel(2005+"");
		YearLab.setFont(font);
		header.add(YearLab,BorderLayout.CENTER);
		JButton exit = new JButton("x");
		exit.addActionListener(new ExitListener());
		header.add(exit, BorderLayout.EAST);
		field.add(header);
		setVisible(true);
	}
	public static void main(String[] args) throws FontFormatException, IOException {
		CalendarUI test = new CalendarUI();
	}
}
