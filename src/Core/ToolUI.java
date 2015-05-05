package Core;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Saori.Clock.DigitalClockUI;
import Saori.Listener.DragListener;
import Saori.Listener.ToolUI.clockButtonListener;

public class ToolUI extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4978040096458866365L;
	private DigitalClockUI clock;
	public ToolUI(){
		super();
		initComponent();
		clock = new DigitalClockUI();
		
	}
	public void initComponent(){
		setSize(150,50);
		setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JButton clockButton = new JButton("");
		clockButton.setLocation(0, 0);
		clockButton.setSize(38, 50);
		clockButton.setIcon(new ImageIcon(ToolUI.class.getResource("/Resource/Images/clockicon.png")));
		clockButton.setContentAreaFilled(false);
		clockButton.setBorderPainted(false);
		clockButton.addActionListener(new clockButtonListener(clock));
		panel.add(clockButton);
		
		JButton calendarButton = new JButton("");
		calendarButton.setBounds(36, 0, 38, 50);
		calendarButton.setIcon(new ImageIcon(ToolUI.class.getResource("/Resource/Images/CarlendarIcon.png")));
		calendarButton.setContentAreaFilled(false);
		calendarButton.setBorderPainted(false);
		panel.add(calendarButton);
		
		JButton calculatorButton = new JButton("");
		calculatorButton.setIcon(new ImageIcon(ToolUI.class.getResource("/Resource/Images/CalculatorIcon.png")));
		calculatorButton.setBounds(75, 0, 38, 50);
		calculatorButton.setContentAreaFilled(false);
		calculatorButton.setBorderPainted(false);
		panel.add(calculatorButton);
		
		JButton searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(ToolUI.class.getResource("/Resource/Images/searchIcon3.png")));
		searchButton.setBounds(112, 0, 38, 50);
		searchButton.setContentAreaFilled(false);
		searchButton.setBorderPainted(false);
		panel.add(searchButton);
		
		addMouseMotionListener(new DragListener(this));
		
		setContentPane(panel);
		
		getRootPane().setOpaque(false);
		getContentPane ().setBackground (new Color (0, 0, 0, 0));
		setBackground (new Color (0, 0, 0, 0));
		setAlwaysOnTop(true);
	}
	
}
