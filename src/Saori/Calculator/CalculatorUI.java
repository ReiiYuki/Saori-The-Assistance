package Saori.Calculator;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

/**
 * CalculatorUI is GUI of Calculator
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public class CalculatorUI extends JFrame {
	// attributes for graphical components
	private Calculator calculator;
	private JPanel panel ;
	protected JTextField textFieldShow ,textFieldInput ,textFieldMemory;
	private JButton memoryclear ,memoryread ,memorysave;
	private JRadioButton degrees ,radians;
	private JButton percent ,onedividedbyx,pi,squareroot,squared,add,subtract,multiply,cubed;	
	private JButton equals ,clear ,reset ,divide ,cuberoot ,negate ,decpoint;
	private JButton sin,cos,tan;
	private JToggleButton shift;
	private JButton zero ,one ,two ,three ,four ,five ,six ,seven ,eight ,nine ;
	private String buffer = null ;
	private boolean isShiftPressed = false ;
	/**
	 * Constructor for new DigitalClockUI
	 */
	public CalculatorUI() {
		setTitle("Java Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 525);
		setResizable(false);
		initComponents();
		this.calculator = new Calculator(this);
	}
	/**
	 * initialize components in the window
	 */
	private void initComponents() {

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		textFieldShow = new JTextField();
		textFieldShow.setBounds(10, 10, 289, 35);
		textFieldShow.setBackground(new Color(199, 218, 220));
		textFieldShow.setFont(new Font("Tahoma", 1, 24)); 
		textFieldShow.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		textFieldShow.setFocusable(false);
		panel.add(textFieldShow);

		textFieldInput = new JTextField("0");
		textFieldInput.setBounds(10, 52, 289, 35);
		textFieldInput.setBackground(new Color(199, 218, 220));
		textFieldInput.setFont(new Font("Tahoma", 1, 24)); 
		textFieldInput.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		textFieldInput.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent evt) {

				int keyCode = evt.getKeyCode();
				if( keyCode == KeyEvent.VK_0 || keyCode == KeyEvent.VK_NUMPAD0 ){
					zeroActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_1 || keyCode == KeyEvent.VK_NUMPAD1 ){
					oneActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_2 || keyCode == KeyEvent.VK_NUMPAD2 ){
					twoActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_3 || keyCode == KeyEvent.VK_NUMPAD3 ){
					threeActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_4 || keyCode == KeyEvent.VK_NUMPAD4 ){
					fourActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_5 || keyCode == KeyEvent.VK_NUMPAD5 ){
					fiveActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_6 || keyCode == KeyEvent.VK_NUMPAD6 ){
					sixActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_7 || keyCode == KeyEvent.VK_NUMPAD7 ){
					sevenActionPerformed(evt);
				}
				else if( ( keyCode == KeyEvent.VK_8 || keyCode == KeyEvent.VK_NUMPAD8 ) && !isShiftPressed){
					eightActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_9 || keyCode == KeyEvent.VK_NUMPAD9 ){
					nineActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_ADD ){
					addActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_SUBTRACT || keyCode == KeyEvent.VK_MINUS ){
					subtractActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_MULTIPLY ){

					multiplyActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_DIVIDE || keyCode == KeyEvent.VK_SLASH){
					divideActionPerformed(evt);
				}
				else if( (keyCode == KeyEvent.VK_ENTER)  ){
					equalsActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_EQUALS  && !isShiftPressed ){
					try {
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_BACK_SPACE);
						robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					} catch (AWTException e) {
						e.printStackTrace();
					}
					equalsActionPerformed(evt);

				}

				else if (keyCode == KeyEvent.VK_SHIFT){
					buffer = "" ;
					isShiftPressed = true; 	
				}


			}
			@Override
			public void keyTyped(KeyEvent evt) {
				if (isShiftPressed){
					buffer = evt.getKeyChar()+"" ;
				}
			}
			@Override
			public void keyReleased(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_SHIFT){
					isShiftPressed = false;
					if ( buffer.equals("+") ){ 
						operatorPlusFuntion(evt);
					}
					if ( buffer.equals("*") ){ 
						operatorMultiplyFuntion(evt);
					}
				}
			}


		});

		memoryread = new JButton("MR");
		memoryread.setBounds(10, 94, 52, 28);
		memoryread.setFont(new Font("Tahoma", 1, 10)); 
		memoryread.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		memoryread.setCursor(new Cursor(Cursor.HAND_CURSOR));
		memoryread.setFocusable(false);
		memoryread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				memoryreadActionPerformed(evt);
			}
		});

		memoryclear = new JButton("MC");
		memoryclear.setBounds(70, 94, 52, 28);
		memoryclear.setFont(new Font("Tahoma", 1, 10));
		memoryclear.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		memoryclear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		memoryclear.setFocusable(false);
		memoryclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				memoryclearActionPerformed(evt);
			}
		});

		memorysave = new JButton("MS");
		memorysave.setBounds(129, 94, 52, 28);
		memorysave.setFont(new Font("Tahoma", 1, 10));
		memorysave.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		memorysave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		memorysave.setFocusable(false);
		memorysave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				memorysaveActionPerformed(evt);
			}
		});

		textFieldMemory = new JTextField("0");
		textFieldMemory.setBounds(188, 94, 111, 28);
		textFieldMemory.setBackground(new Color(199, 218, 220));
		textFieldMemory.setFont(new Font("Tahoma", 1, 14)); 
		textFieldMemory.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		textFieldMemory.setFocusable(false);

		degrees = new JRadioButton("Degrees");
		degrees.setBounds(10, 130, 80, 23);
		degrees.setFont(new Font("Tahoma", 1, 10)); 
		degrees.setSelected(true);
		degrees.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		degrees.setCursor(new Cursor(Cursor.HAND_CURSOR));
		degrees.setFocusable(false);
		degrees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				radians.setSelected(!calculator.isDegrees);
				degreesActionPerformed(evt);
			}
		});

		radians = new JRadioButton("Radians");
		radians.setBounds(94, 130, 80, 23);
		radians.setFont(new Font("Tahoma", 1, 10));
		radians.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		radians.setCursor(new Cursor(Cursor.HAND_CURSOR));
		radians.setFocusable(false);
		radians.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				degrees.setSelected(calculator.isDegrees);
				radiansActionPerformed(evt);
			}
		});

		percent = new JButton("%");
		percent.setBounds(188, 129, 52, 28);
		percent.setFont(new Font("Tahoma", 1, 10)); 
		percent.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		percent.setCursor(new Cursor(Cursor.HAND_CURSOR));
		percent.setFocusable(false);
		percent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				percentActionPerformed(evt);
			}
		});

		onedividedbyx = new JButton("1/x");
		onedividedbyx.setBounds(247, 129, 52, 28);
		onedividedbyx.setFont(new Font("Tahoma", 1, 10));
		onedividedbyx.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		onedividedbyx.setCursor(new Cursor(Cursor.HAND_CURSOR));
		onedividedbyx.setFocusable(false);
		onedividedbyx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				onedividedbyxActionPerformed(evt);
			}
		});

		sin = new JButton("Sin");
		sin.setBounds(10, 164, 52, 28);
		sin.setFont(new Font("Tahoma", 1, 8));
		sin.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		sin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sin.setFocusable(false);
		sin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sinActionPerformed(evt);
			}
		});

		cos = new JButton("Cos");
		cos.setBounds(70, 164, 52, 28);
		cos.setFont(new Font("Tahoma", 1, 8));
		cos.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		cos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cos.setFocusable(false);
		cos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cosActionPerformed(evt);
			}
		});

		tan = new JButton("Tan");
		tan.setBounds(129, 164, 52, 28);
		tan.setFont(new Font("Tahoma", 1, 8));
		tan.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		tan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tan.setFocusable(false);
		tan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tanActionPerformed(evt);
			}
		});

		shift = new JToggleButton("Sh");
		shift.setBounds(188, 164, 52, 28);
		shift.setFont(new Font("Tahoma", 1, 10));
		shift.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		shift.setCursor(new Cursor(Cursor.HAND_CURSOR));
		shift.setFocusable(false);
		shift.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				shiftMouseClicked(evt);
			}
		});

		pi = new JButton("π");//ⁿ 
		pi.setBounds(247, 164, 52, 28);
		pi.setFont(new Font("Tahoma", 1, 10)); 
		pi.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		pi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pi.setFocusable(false);
		pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				piActionPerformed(evt);
			}
		});

		seven = new JButton("7");
		seven.setBounds(10, 199, 52, 52);
		seven.setFont(new Font("Tahoma", 1, 10)); 
		seven.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		seven.setCursor(new Cursor(Cursor.HAND_CURSOR));
		seven.setFocusable(false);
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sevenActionPerformed(evt);
			}
		});

		eight = new JButton("8");
		eight.setBounds(70, 199, 52, 52);
		eight.setFont(new Font("Tahoma", 1, 10));
		eight.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		eight.setCursor(new Cursor(Cursor.HAND_CURSOR));
		eight.setFocusable(false);
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				eightActionPerformed(evt);
			}
		});

		nine = new JButton("9");
		nine.setBounds(129, 199, 52, 52);
		nine.setFont(new Font("Tahoma", 1, 10)); 
		nine.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		nine.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nine.setFocusable(false);
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nineActionPerformed(evt);
			}
		});

		squared = new JButton("x²");
		squared.setBounds(187, 199, 52, 52);
		squared.setFont(new Font("Tahoma", 1, 8)); 
		squared.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		squared.setCursor(new Cursor(Cursor.HAND_CURSOR));
		squared.setFocusable(false);
		squared.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				squaredActionPerformed(evt);
			}
		});

		add = new JButton("+");
		add.setBounds(247, 199, 52, 52);
		add.setFont(new Font("Tahoma", 1, 10)); 
		add.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		add.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add.setFocusable(false);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addActionPerformed(evt);
			}
		});

		four = new JButton("4");
		four.setBounds(10, 258, 52, 52);
		four.setFont(new Font("Tahoma", 1, 10));
		four.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		four.setCursor(new Cursor(Cursor.HAND_CURSOR));
		four.setFocusable(false);
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fourActionPerformed(evt);
			}
		});

		five = new JButton("5");
		five.setBounds(70, 258, 52, 52);
		five.setFont(new Font("Tahoma", 1, 10)); 
		five.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		five.setCursor(new Cursor(Cursor.HAND_CURSOR));
		five.setFocusable(false);
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fiveActionPerformed(evt);
			}
		});

		six = new JButton("6");
		six.setBounds(129, 258, 52, 52);
		six.setFont(new Font("Tahoma", 1, 10)); 
		six.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		six.setCursor(new Cursor(Cursor.HAND_CURSOR));
		six.setFocusable(false);
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sixActionPerformed(evt);
			}
		});

		squareroot = new JButton("√x");
		squareroot.setBounds(188, 258, 52, 52);
		squareroot.setFont(new Font("Tahoma", 1, 8)); 
		squareroot.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		squareroot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		squareroot.setFocusable(false);
		squareroot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				squarerootActionPerformed(evt);
			}
		});

		subtract = new JButton("-");
		subtract.setBounds(247, 258, 52, 52);
		subtract.setFont(new Font("Tahoma", 1, 10)); 
		subtract.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		subtract.setCursor(new Cursor(Cursor.HAND_CURSOR));
		subtract.setFocusable(false);
		subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				subtractActionPerformed(evt);
			}
		});

		one = new JButton("1");
		one.setBounds(10, 317, 52, 52);
		one.setFont(new Font("Tahoma", 1, 10)); 
		one.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		one.setCursor(new Cursor(Cursor.HAND_CURSOR));
		one.setFocusable(false);
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				oneActionPerformed(evt);
			}
		});

		two = new JButton("2");
		two.setBounds(70, 317, 52, 52);
		two.setFont(new Font("Tahoma", 1, 10)); 
		two.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		two.setCursor(new Cursor(Cursor.HAND_CURSOR));
		two.setFocusable(false);
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				twoActionPerformed(evt);
			}
		});

		three = new JButton("3");
		three.setBounds(129, 317, 52, 52);
		three.setFont(new Font("Tahoma", 1, 10)); 
		three.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		three.setCursor(new Cursor(Cursor.HAND_CURSOR));
		three.setFocusable(false);
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				threeActionPerformed(evt);
			}
		});

		cubed = new JButton("x³");
		cubed.setBounds(188, 317, 52, 52);
		cubed.setFont(new Font("Tahoma", 1, 8));
		cubed.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		cubed.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cubed.setFocusable(false);
		cubed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cubedActionPerformed(evt);
			}
		});

		multiply = new JButton("*");
		multiply.setBounds(247, 317, 52, 52);
		multiply.setFont(new Font("Tahoma", 1, 10));
		multiply.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		multiply.setCursor(new Cursor(Cursor.HAND_CURSOR));
		multiply.setFocusable(false);
		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				multiplyActionPerformed(evt);
			}
		});

		zero = new JButton("0");
		zero.setBounds(10, 376, 52, 52);
		zero.setFont(new Font("Tahoma", 1, 10));
		zero.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		zero.setCursor(new Cursor(Cursor.HAND_CURSOR));
		zero.setFocusable(false);
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				zeroActionPerformed(evt);
			}
		});

		decpoint = new JButton(".");
		decpoint.setBounds(70, 376, 52, 52);
		decpoint.setFont(new Font("Tahoma", 1, 10));
		decpoint.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		decpoint.setCursor(new Cursor(Cursor.HAND_CURSOR));
		decpoint.setFocusable(false);
		decpoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				decpointActionPerformed(evt);
			}
		});

		negate = new JButton("±");
		negate.setBounds(129, 376, 52, 52);
		negate.setFont(new Font("Tahoma", 1, 10));
		negate.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		negate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		negate.setFocusable(false);
		negate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				negateActionPerformed(evt);
			}
		});

		cuberoot = new JButton("3/x");
		cuberoot.setBounds(188, 376, 52, 52);
		cuberoot.setFont(new Font("Tahoma", 1, 8));
		cuberoot.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		cuberoot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cuberoot.setFocusable(false);
		cuberoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cubedrootActionPerformed(evt);
			}
		});		

		divide = new JButton("/");
		divide.setBounds(247, 376, 52, 52);
		divide.setFont(new Font("Tahoma", 1, 10));
		divide.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		divide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		divide.setFocusable(false);
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				divideActionPerformed(evt);
			}
		});			

		equals = new JButton("=");
		equals.setBounds(10, 435, 171, 52);
		equals.setFont(new Font("Tahoma", 1, 10)); 
		equals.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		equals.setCursor(new Cursor(Cursor.HAND_CURSOR));
		equals.setFocusable(false);
		equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				equalsActionPerformed(evt);
			}
		});

		clear = new JButton("CE");
		clear.setBounds(188, 435, 52, 52);
		clear.setFont(new Font("Tahoma", 1, 10)); 
		clear.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clear.setFocusable(false);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clearActionPerformed(evt);

			}
		});

		reset = new JButton("C");
		reset.setBounds(247, 435, 52, 52);
		reset.setFont(new Font("Tahoma", 1, 10));
		reset.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
		reset.setFocusable(false);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetActionPerformed(evt);
			}
		});

		panel.add(textFieldInput);
		panel.add(memoryread);
		panel.add(memoryclear);
		panel.add(memorysave);
		panel.add(textFieldMemory);
		panel.add(degrees);
		panel.add(radians);
		panel.add(percent);
		panel.add(onedividedbyx);
		panel.add(sin);
		panel.add(cos);
		panel.add(tan);
		panel.add(shift);
		panel.add(pi);
		panel.add(seven);
		panel.add(eight);
		panel.add(nine);
		panel.add(squared);
		panel.add(add);
		panel.add(four);
		panel.add(five);
		panel.add(six);
		panel.add(squareroot);
		panel.add(subtract);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(cubed);
		panel.add(multiply);
		panel.add(zero);
		panel.add(decpoint);
		panel.add(negate);
		panel.add(cuberoot);
		panel.add(divide);
		panel.add(equals);
		panel.add(clear);
		panel.add(reset);
	}
	/**
	 * zeroActionPerformed is function of zero number
	 * @param evt is action that you click
	 */
	private void zeroActionPerformed(ActionEvent evt) {
		this.calculator.zeroFunction("0");
	}//end zeroActionPerformed
	/**
	 * oneActionPerformed is function of one number
	 * @param evt is action that you click
	 */
	private void oneActionPerformed(ActionEvent evt) {
		this.calculator.numberFunction("1");
	}//end oneActionPerformed
	/**
	 * twoActionPerformed is function of two number
	 * @param evt is action that you click
	 */
	private void twoActionPerformed(ActionEvent evt) {
		this.calculator.numberFunction("2");
	}//end twoActionPerformed
	/**
	 * threeActionPerformed is function of three number
	 * @param evt is action that you click
	 */
	private void threeActionPerformed(ActionEvent evt) {
		this.calculator.numberFunction("3");
	}//end threeActionPerformed
	/**
	 * fourActionPerformed is function of four number
	 * @param evt is action that you click
	 */
	private void fourActionPerformed(ActionEvent evt) {
		this.calculator.numberFunction("4");
	}//end fourActionPerformed
	/**
	 * fiveActionPerformed is function of five number
	 * @param evt is action that you click
	 */
	private void fiveActionPerformed(ActionEvent evt) {
		this.calculator.numberFunction("5");
	}//end fiveActionPerformed
	/**
	 * sixActionPerformed is function of six number
	 * @param evt is action that you click
	 */
	private void sixActionPerformed(ActionEvent evt) {
		this.calculator.numberFunction("6");
	}//end sixActionPerformed
	/**
	 * sevenActionPerformed is function of seven number
	 * @param evt is action that you click
	 */
	private void sevenActionPerformed(ActionEvent evt) {
		this.calculator.numberFunction("7");
	}//end sevenActionPerformed
	/**
	 * eightActionPerformed is function of eight number
	 * @param evt is action that you click
	 */
	private void eightActionPerformed(ActionEvent evt) {
		this.calculator.numberFunction("8");
	}//end eightActionPerformed
	/**
	 * nineActionPerformed is function of nine number
	 * @param evt is action that you click
	 */
	private void nineActionPerformed(ActionEvent evt) {
		this.calculator.numberFunction("9");
	}//end nineActionPerformed
	/**
	 * zeroActionPerformed is function of zero number
	 * @param evt is action that you print Keyboard
	 */
	private void zeroActionPerformed(KeyEvent evt) {
		this.calculator.zeroFunction("");
	}//end zeroActionPerformed
	/**
	 * oneActionPerformed is function of one number
	 * @param evt is action that you print Keyboard
	 */
	private void oneActionPerformed(KeyEvent evt) {
		this.calculator.numberFunction("");
	}//end oneActionPerformed
	/**
	 * twoActionPerformed is function of two number
	 * @param evt is action that you print Keyboard
	 */
	private void twoActionPerformed(KeyEvent evt) {
		this.calculator.numberFunction("");
	}//end twoActionPerformed
	/**
	 * threeActionPerformed is function of three number
	 * @param evt is action that you print Keyboard
	 */
	private void threeActionPerformed(KeyEvent evt) {
		this.calculator.numberFunction("");
	}//end threeActionPerformed
	/**
	 * fourActionPerformed is function of four number
	 * @param evt is action that you print Keyboard
	 */
	private void fourActionPerformed(KeyEvent evt) {
		this.calculator.numberFunction("");
	}//end fourActionPerformed
	/**
	 * fiveActionPerformed is function of five number
	 * @param evt is action that you print Keyboard
	 */
	private void fiveActionPerformed(KeyEvent evt) {
		this.calculator.numberFunction("");
	}//end fiveActionPerformed
	/**
	 * sixActionPerformed is function of six number
	 * @param evt is action that you print Keyboard
	 */
	private void sixActionPerformed(KeyEvent evt) {
		this.calculator.numberFunction("");
	}//end sixActionPerformed
	/**
	 * sevenActionPerformed is function of seven number
	 * @param evt is action that you print Keyboard
	 */
	private void sevenActionPerformed(KeyEvent evt) {
		this.calculator.numberFunction("");
	}//end sevenActionPerformed
	/**
	 * eightActionPerformed is function of eight number
	 * @param evt is action that you print Keyboard
	 */
	private void eightActionPerformed(KeyEvent evt) {
		this.calculator.numberFunction("");
	}//end eightActionPerformed
	/**
	 * nineActionPerformed is function of nine number
	 * @param evt is action that you print Keyboard
	 */
	private void nineActionPerformed(KeyEvent evt) {
		this.calculator.numberFunction("");
	}//end nineActionPerformed
	/**
	 * decpointActionPerformed is function of decpoint
	 * @param evt is action that you click
	 */
	private void decpointActionPerformed(ActionEvent evt) {
		if(!this.calculator.isDot){
			textFieldInput.setText(textFieldInput.getText() + ".");
			this.calculator.isDot = true;
		}
	}//end decpointActionPerformed
	/**
	 * negateActionPerformed is function of negate
	 * @param evt is action that you click
	 */
	private void negateActionPerformed(ActionEvent evt) {
		this.calculator.negateFunction();
	}//end negateActionPerformed
	/**
	 * clearActionPerformed is function of clearButton
	 * @param evt is action that you click
	 */
	private void clearActionPerformed(ActionEvent evt) {
		textFieldInput.setText("0");
		this.calculator.isZero = false;
		this.calculator.isDot = false;
	}//end clearActionPerformed
	/**
	 * resetActionPerformed is function of reset
	 * @param evt is action that you click
	 */
	private void resetActionPerformed(ActionEvent evt) {
		this.calculator.resetFunction();
	}//end resetActionPerformed
	/**
	 * memoryreadActionPerformed is function of memoryread
	 * @param evt is action that you click
	 */
	private void memoryreadActionPerformed(ActionEvent evt) {
		textFieldInput.setText(String.valueOf(textFieldMemory.getText()));
	}//end memoryreadActionPerformed
	/**
	 * memoryclearActionPerformed is function of memoryclear
	 * @param evt is action that you click
	 */
	private void memoryclearActionPerformed(ActionEvent evt) {
		textFieldMemory.setText("0");
	}//end memoryclearActionPerformed
	/**
	 * memorysaveActionPerformed is function of memorysave
	 * @param evt is action that you click
	 */
	private void memorysaveActionPerformed(ActionEvent evt) {
		textFieldMemory.setText(String.valueOf(textFieldInput.getText()));
	}//end memorysaveActionPerformed
	/**
	 * onedividedbyxActionPerformed is function of 1/x
	 * @param evt is action that you click
	 */
	private void onedividedbyxActionPerformed(ActionEvent evt) {
		this.calculator.onedividedbyxFunction();
	}//end onedividedbyxActionPerformed
	/**
	 * piActionPerformed is function of π
	 * @param evt is action that you click
	 */
	private void piActionPerformed(ActionEvent evt) {
		textFieldInput.setText(String.valueOf(Math.PI));
	}//end piActionPerformed
	/**
	 * squaredActionPerformed is function of squared
	 * @param evt is action that you click
	 */
	private void squaredActionPerformed(ActionEvent evt) {
		this.calculator.squarFunction();
	}//end squaredActionPerformed
	/**
	 * squarerootActionPerformed is function of squareroot
	 * @param evt is action that you click
	 */
	private void squarerootActionPerformed(ActionEvent evt) {
		this.calculator.squarerootFunction();
	}//end squarerootActionPerformed
	/**
	 * cubedActionPerformed is function of cubed
	 * @param evt is action that you click
	 */
	private void cubedActionPerformed(ActionEvent evt) {
		this.calculator.cubedFunction();
	}//end cubedActionPerformed
	/**
	 * cubedrootActionPerformed is function of cuberoot
	 * @param evt is action that you click
	 */
	private void cubedrootActionPerformed(ActionEvent evt) {
		this.calculator.cuberootFunction();
	}//end cubedrootActionPerformed
	/**
	 * shiftMouseClicked is function of shift
	 * @param evt is action that you click
	 */
	private void shiftMouseClicked(MouseEvent evt) {
		this.calculator.operatorShiftFunction();
	}//end shiftMouseClicked
	/**
	 * sinActionPerformed is function of sin
	 * @param evt is action that you click
	 */
	private void sinActionPerformed(ActionEvent evt) {
		this.calculator.sinFunction();
	}//end sinActionPerformed
	/**
	 * cosActionPerformed is function of cos
	 * @param evt is action that you click
	 */
	private void cosActionPerformed(ActionEvent evt) {
		this.calculator.cosFunction();
	}//end cosActionPerformed
	/**
	 * tanActionPerformed is function of tan
	 * @param evt is action that you click
	 */
	private void tanActionPerformed(ActionEvent evt) {
		this.calculator.tanFunction();
	}//end tanActionPerformed
	/**
	 * degreesActionPerformed is function of degrees
	 * @param evt is action that you click
	 */
	private void degreesActionPerformed(ActionEvent evt) {
		this.calculator.isDegrees = false;
	}//end degreesActionPerformed
	/**
	 * radiansActionPerformed is function of radians
	 * @param evt is action that you click
	 */
	private void radiansActionPerformed(ActionEvent evt) {
		this.calculator.isDegrees = true;
	}//end radiansActionPerformed
	/**
	 * addActionPerformed is function of add
	 * @param evt is action that you click
	 */
	private void addActionPerformed(ActionEvent evt) {
		this.calculator.operatorFunction("+",(byte) 1);
	}//end addActionPerformed
	/**
	 * subtractActionPerformed is function of subtract
	 * @param evt is action that you click
	 */
	private void subtractActionPerformed(ActionEvent evt) {
		this.calculator.operatorFunction("-",(byte) 2);
	}//end subtractActionPerformed
	/**
	 * multiplyActionPerformed is function of multiply
	 * @param evt is action that you click
	 */
	private void multiplyActionPerformed(ActionEvent evt) {
		this.calculator.operatorFunction("*",(byte) 3);
	}//end multiplyActionPerformed
	/**
	 * divideActionPerformed is function of divide
	 * @param evt is action that you click
	 */
	private void divideActionPerformed(ActionEvent evt) {
		this.calculator.operatorFunction("/",(byte) 4);
	}//end divideActionPerformed
	/**
	 * percentActionPerformed is function of percent
	 * @param evt is action that you click
	 */
	private void percentActionPerformed(ActionEvent evt) {
		this.calculator.percentFunction();
	}//end percentActionPerformed
	/**
	 * equalsActionPerformed is function of equals
	 * @param evt is action that you click
	 */
	private void equalsActionPerformed(ActionEvent evt) {
		this.calculator.equalsFunction();
	}//end equalsActionPerformed
	/**
	 * operatorPlusFuntion is function of plus
	 * @param evt is action that you print Keyboard
	 */
	private void operatorPlusFuntion(KeyEvent evt) {
		this.calculator.operatorFunction("+",(byte) 1);
	}
	/**
	 * operatorPlusFuntion is function of plus
	 * @param evt is action that you print Keyboard
	 */
	private void operatorMultiplyFuntion(KeyEvent evt) {
		this.calculator.operatorFunction("*",(byte) 3);
	}
	/**
	 * addActionPerformed is function of add
	 * @param evt is action that you print Keyboard
	 */
	private void addActionPerformed(KeyEvent evt) {
		this.calculator.operatorFunction("+",(byte) 1);
	}//end addActionPerformed
	/**
	 * subtractActionPerformed is function of subtract
	 * @param evt is action that you print Keyboard
	 */
	private void subtractActionPerformed(KeyEvent evt) {
		this.calculator.operatorFunction("-",(byte) 2);
	}//end subtractActionPerformed
	/**
	 * multiplyActionPerformed is function of multiply
	 * @param evt is action that you print Keyboard
	 */
	private void multiplyActionPerformed(KeyEvent evt) {
		this.calculator.operatorFunction("*",(byte) 3);
	}//end multiplyActionPerformed
	/**
	 * divideActionPerformed is function of divide
	 * @param evt is action that you print Keyboard
	 */
	private void divideActionPerformed(KeyEvent evt) {
		this.calculator.operatorFunction("/",(byte) 4);
	}//end divideActionPerformed
	/**
	 * percentActionPerformed is function of percent
	 * @param evt is action that you print Keyboard
	 */
	private void percentActionPerformed(KeyEvent evt) {
		this.calculator.percentFunction();
	}//end percentActionPerformed
	/**
	 * equalsActionPerformed is function of equals
	 * @param evt is action that you print Keyboard
	 */
	private void equalsActionPerformed(KeyEvent evt) {
		this.calculator.equalsFunction();
	}//end equalsActionPerformed
}