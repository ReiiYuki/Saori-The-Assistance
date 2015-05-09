package Saori.Clock;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * DigitalClockUI is GUI of DigitalClock
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public class DigitalClockUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7420402910042556L;
	// attributes for graphical components
	private JPanel pane ,panel1 ,panel2 ,panelStatus ,panelDay;
	private JButton stopButton, setButton ,plusButton ,minusButton ;
	private JLabel hrLabel1 ,hrLabel2 ,minLabel1 ,minLabel2 ,secLabel1 ,secLabel2 ,colonLabel1 ,colonLabel2 ,statusLabel ;
	private JCheckBox boxSun ,boxMon ,boxTue ,boxWed ,boxThu ,boxFri ,boxSat ;
	private ImageIcon [] icon ;
	private Clock clock ;
	private Timer timer;
	/**
	 * Constructor for new DigitalClockUI
	 */
	public DigitalClockUI(Clock clock){
		this.setTitle( "DigitalClock" );
		this.clock = clock;
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.initComponents();
		getSelected();
	}
	/**
	 * initialize components in the window
	 */
	private void initComponents(){
		pane = new JPanel();
		pane.setLayout(new BoxLayout ( pane , BoxLayout.Y_AXIS ) );	
		panelStatus = new JPanel();
		panelStatus.setBackground( Color.BLACK );
		panel1 = new JPanel();
		panel1.setBackground( Color.BLACK );
		panelDay = new JPanel();
		panelDay.setBackground( Color.BLACK );
		panel2 = new JPanel();
		panel2.setBackground( Color.BLACK );
		stopButton = new JButton( " StopWatch ");
		stopButton.setBackground( Color.BLACK );
		stopButton.setForeground( Color.WHITE );
		setButton = new JButton( " set " );
		setButton.setBackground( Color.BLACK );
		setButton.setForeground( Color.WHITE );
		plusButton = new JButton( " + " );
		plusButton.setBackground( Color.BLACK );
		plusButton.setForeground( Color.WHITE );
		minusButton = new JButton( " - " );
		minusButton.setBackground( Color.BLACK );
		minusButton.setForeground( Color.WHITE );
		statusLabel = new JLabel();
		hrLabel1 = new JLabel();
		hrLabel2 = new JLabel();
		minLabel1 = new JLabel();
		minLabel2 = new JLabel();
		secLabel1 = new JLabel();
		secLabel2 = new JLabel();
		colonLabel1 = new JLabel();
		colonLabel2 = new JLabel();
		boxSun = new JCheckBox("Sun",clock.isSun());
		boxMon = new JCheckBox("Mon",clock.isMon());
		boxTue = new JCheckBox("Tue");
		boxWed = new JCheckBox("Wed");
		boxThu = new JCheckBox("Thu");
		boxFri = new JCheckBox("Fri");
		boxSat = new JCheckBox("Sat");



		int delay = 500 ; // milliseconds
		ActionListener task = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clock.updateTime();
				updateTime();
				if( clock.isBlink() ){
					clock.setBlink( false );
				}
				else
					clock.setBlink( true );
			}
		};
		timer = new Timer( delay , task );
		timer.start();


		icon = new ImageIcon [14] ;
		@SuppressWarnings("rawtypes")
		Class time = this.getClass();
		URL time0 = time.getResource("images/0.gif");
		icon[0] = new ImageIcon( time0 );
		URL time1 = time.getResource("images/1.gif");
		icon[1] = new ImageIcon( time1 );
		URL time2 = time.getResource("images/2.gif");
		icon[2] = new ImageIcon( time2 );
		URL time3 = time.getResource("images/3.gif");
		icon[3] = new ImageIcon( time3 );
		URL time4 = time.getResource("images/4.gif");
		icon[4] = new ImageIcon( time4 );
		URL time5 = time.getResource("images/5.gif");
		icon[5] = new ImageIcon( time5 );
		URL time6 = time.getResource("images/6.gif");
		icon[6] = new ImageIcon( time6 );
		URL time7 = time.getResource("images/7.gif");
		icon[7] = new ImageIcon( time7 );
		URL time8 = time.getResource("images/8.gif");
		icon[8] = new ImageIcon( time8 );
		URL time9 = time.getResource("images/9.gif");
		icon[9] = new ImageIcon( time9 );
		URL time10 = time.getResource("images/colon.gif");
		icon[10] = new ImageIcon( time10 );
		URL time11 = time.getResource("images/black.gif");
		icon[11] = new ImageIcon( time11 );
		URL time12 = time.getResource("images/alram.gif");
		icon[12] = new ImageIcon( time12 );
		URL time13 = time.getResource("images/alramBlink.gif");
		icon[13] = new ImageIcon( time13 );

		this.colonLabel1.setIcon( icon[10] );
		this.colonLabel2.setIcon( icon[10] );
		
		ActionListener listenerStopWatch = new StopWatchButtonListener( );
		stopButton.addActionListener( listenerStopWatch );
		
		ActionListener listenerSet = new SetButtonListener( );
		setButton.addActionListener( listenerSet );

		ActionListener listenerPlus = new PlusButtonListener( );
		plusButton.addActionListener( listenerPlus );

		ActionListener listenerMinus = new MinusButtonListener( );
		minusButton.addActionListener( listenerMinus );
		
		panelStatus.add( statusLabel );
		panel1.add( hrLabel1 );
		panel1.add( hrLabel2 );
		panel1.add( colonLabel1 );
		panel1.add( minLabel1 );
		panel1.add( minLabel2 );
		panel1.add( colonLabel2 );
		panel1.add( secLabel1 );
		panel1.add( secLabel2 );
		panel2.add( stopButton );
		panel2.add( setButton );
		panel2.add( plusButton );
		panel2.add ( minusButton );
		pane.add( panelStatus );
		pane.add( panel1 );
		pane.add( panelDay );
		pane.add( panel2 );
		if(boxSun.isSelected())
			clock.setNumSun(Calendar.SUNDAY);
		if(boxMon.isSelected())
			clock.setNumMon(Calendar.MONDAY);
		if(boxTue.isSelected())
			clock.setNumTue(Calendar.TUESDAY);
		if(boxWed.isSelected())
			clock.setNumWed(Calendar.WEDNESDAY);
		if(boxThu.isSelected())
			clock.setNumThu(Calendar.THURSDAY);
		if(boxFri.isSelected())
			clock.setNumFri(Calendar.FRIDAY);
		if(boxSat.isSelected())
			clock.setNumSat(Calendar.SATURDAY);
		super.add( pane );
	}
	class StopWatchButtonListener implements ActionListener {
		/** method to perform action when the button is pressed */
		public void actionPerformed( ActionEvent evt ) {
			clock.setState( clock.getStopWatch() );
			clock.setShowSec(0);
		}
	}// end of the inner class for SetButtonListener
	class SetButtonListener implements ActionListener {
		/** method to perform action when the button is pressed */
		public void actionPerformed( ActionEvent evt ) {
			clock.handleSetKey();
		}
	}// end of the inner class for SetButtonListener
	class PlusButtonListener implements ActionListener {
		/** method to perform action when the button is pressed */
		public void actionPerformed( ActionEvent evt ) {
			clock.handlePlusKey();
		}
	}// end of the inner class for PlusButtonListener
	class MinusButtonListener implements ActionListener {
		/** method to perform action when the button is pressed */
		public void actionPerformed( ActionEvent evt ) {
			clock.handleMinusKey();
		}
	}// end of the inner class for MinusButtonListener
	/**
	 * updateTime is update method when over time
	 */
	public void updateTime(){
		if( clock.isBlink() && clock.isBlinkHr() ){
			this.hrLabel1.setIcon( icon[11] );
			this.hrLabel2.setIcon( icon[11] );
		}
		else{
			this.hrLabel1.setIcon( icon[clock.getShowHr()/10] );
			this.hrLabel2.setIcon( icon[clock.getShowHr()%10] );
		}
		if( clock.isBlink() && clock.isBlinkMin() ){
			this.minLabel1.setIcon( icon[11] );
			this.minLabel2.setIcon( icon[11] );
		}
		else{
			this.minLabel1.setIcon( icon[clock.getShowMin()/10] );
			this.minLabel2.setIcon( icon[clock.getShowMin()%10] );
		}
		if( clock.isBlink() && clock.isBlinkSec() ){
			this.secLabel1.setIcon( icon[11] );
			this.secLabel2.setIcon( icon[11] );
		}
		else{
			this.secLabel1.setIcon( icon[clock.getShowSec()/10] );
			this.secLabel2.setIcon( icon[clock.getShowSec()%10] );
		}
		if( clock.isShowAlarm() ){
			if( clock.isBlink())
				this.statusLabel.setIcon( icon[13] );	
			else
				this.statusLabel.setIcon( icon[12] );
		}
		else{
			this.statusLabel.setIcon( icon[13] );
		}
		if( clock.isShowSetDay() ){
			panelDay.add(boxSun);
			panelDay.add(boxMon);
			panelDay.add(boxTue);
			panelDay.add(boxWed);
			panelDay.add(boxThu);
			panelDay.add(boxFri);
			panelDay.add(boxSat);
		}
		else
			panelDay.removeAll();
		this.pack();
	}

	public void getSelected(){
		if (clock.isSun()) boxSun.setSelected(true);
		if (clock.isMon()) boxMon.setSelected(true);
		if (clock.isTue()) boxTue.setSelected(true);
		if (clock.isWed()) boxWed.setSelected(true);
		if (clock.isThu()) boxThu.setSelected(true);
		if (clock.isFri()) boxFri.setSelected(true);
		if (clock.isSat()) boxSat.setSelected(true);

	}
}
