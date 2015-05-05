package Saori.Calculator;

import java.awt.*;
import java.awt.event.*;
import java.math.*;
import javax.swing.*;
import javax.swing.border.*;


public class CalculatorUI extends JFrame {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel panel ;
	//row1
	private JTextField textFieldShow;
	//row2
	private JTextField textFieldInput;
	//row3
	private JButton memoryclear ,memoryread ,memorysave;
	private JTextField textFieldMemory;
	//row4
	private JRadioButton degrees ,radians;
	private JButton percent ,onedividedbyx;	
	//row5
	private JButton sin;
	private JButton cos;
	private JButton tan;
	private JToggleButton shift;
	private JButton pi;
	//row6
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton squared;
	private JButton add;
	//row7
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton squareroot;
	private JButton subtract;
	//row8
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton cubed;
	private JButton multiply;
	//row9
	private JButton zero;
	private JButton decpoint;
	private JButton negate;
	private JButton cuberoot;
	private JButton divide;
	//row10
	private JButton equals;
	private JButton clear;
	private JButton reset;


	//private ButtonGroup buttonGroup1;

	// End of variables declaration//GEN-END:variables 

	private boolean zerodisp;
	private boolean decdisp;
	private boolean dgrrad;
	private boolean sh;
	private byte op; //operator
	private double ina;
	private double inb;
	private double out;

	public CalculatorUI() {
		setTitle("Java Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 525);
		setResizable(false);
		initComponents();
	}

	//@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		textFieldShow = new JTextField();
		textFieldShow.setBounds(10, 10, 289, 35);
		textFieldShow.setBackground(new Color(199, 218, 220));
		textFieldShow.setFont(new Font("Tahoma", 1, 24)); // NOI18N
		textFieldShow.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		textFieldShow.setFocusable(false);
		panel.add(textFieldShow);
		//textField.setColumns(10);

		textFieldInput = new JTextField("0");
		textFieldInput.setBounds(10, 52, 289, 35);
		textFieldInput.setBackground(new Color(199, 218, 220));
		textFieldInput.setFont(new Font("Tahoma", 1, 24)); // NOI18N
		//textFieldInput.setText("0");
		//textFieldInput.setAutoscrolls(false);
		textFieldInput.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		//		textFieldInput.setFocusable(false);
		textFieldInput.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent evt) {
				
				int keyCode = evt.getKeyCode();
				System.out.println(keyCode+" "+KeyEvent.VK_SHIFT);
				System.out.println(keyCode+" "+KeyEvent.VK_EQUALS);
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
				else if( keyCode == KeyEvent.VK_8 || keyCode == KeyEvent.VK_NUMPAD8 ){
					eightActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_9 || keyCode == KeyEvent.VK_NUMPAD9 ){
					nineActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_ADD || ( keyCode == KeyEvent.VK_EQUALS && keyCode == KeyEvent.SHIFT_DOWN_MASK )){
					System.out.println("+++");
					addActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_SUBTRACT || keyCode == KeyEvent.VK_MINUS ){
					subtractActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_MULTIPLY || ( keyCode == KeyEvent.VK_8 && keyCode == KeyEvent.VK_SHIFT)){
					
					multiplyActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_DIVIDE || keyCode == KeyEvent.VK_SLASH){
					divideActionPerformed(evt);
				}
				else if( keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_EQUALS){
					equalsActionPerformed(evt);
				}
				
			}

			@Override
			public void keyReleased(KeyEvent evt) {

			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

		});
		panel.add(textFieldInput);

		
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
		panel.add(memoryread);

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
		panel.add(memoryclear);

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
		panel.add(memorysave);

		textFieldMemory = new JTextField("0");
		textFieldMemory.setBounds(188, 94, 111, 28);
		textFieldMemory.setBackground(new Color(199, 218, 220));
		textFieldMemory.setFont(new Font("Tahoma", 1, 14)); 
		textFieldMemory.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		textFieldMemory.setFocusable(false);
		panel.add(textFieldMemory);


		degrees = new JRadioButton("Degrees");
		degrees.setBounds(10, 130, 80, 23);
		degrees.setFont(new Font("Tahoma", 1, 10)); 
		degrees.setSelected(true);
		degrees.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		degrees.setCursor(new Cursor(Cursor.HAND_CURSOR));
		degrees.setFocusable(false);
		degrees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				radians.setSelected(!dgrrad);
				degreesActionPerformed(evt);
			}
		});
		panel.add(degrees);

		radians = new JRadioButton("Radians");
		radians.setBounds(94, 130, 80, 23);
		radians.setFont(new Font("Tahoma", 1, 10));
		radians.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		radians.setCursor(new Cursor(Cursor.HAND_CURSOR));
		radians.setFocusable(false);
		radians.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				degrees.setSelected(dgrrad);
				radiansActionPerformed(evt);
			}
		});
		panel.add(radians);

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
		panel.add(percent);

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
		panel.add(onedividedbyx);

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
		panel.add(sin);

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
		panel.add(cos);

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
		panel.add(tan);

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
		panel.add(shift);

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
		panel.add(pi);

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
		panel.add(seven);

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
		panel.add(eight);

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
		panel.add(nine);

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
		panel.add(squared);

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

		panel.add(add);

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

		
		panel.add(four);

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

		
		panel.add(five);

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
		panel.add(six);

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
		panel.add(squareroot);

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
		panel.add(subtract);

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
		panel.add(one);

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
		panel.add(two);

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
		panel.add(three);

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
		panel.add(cubed);

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
		panel.add(multiply);

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
		panel.add(zero);

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
		panel.add(decpoint);

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
		panel.add(negate);

		cuberoot = new JButton("3/x");
		cuberoot.setBounds(188, 376, 52, 52);
		cuberoot.setFont(new Font("Tahoma", 1, 8));
		cuberoot.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		cuberoot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cuberoot.setFocusable(false);
		cuberoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cuberootActionPerformed(evt);
			}
		});
		panel.add(cuberoot);

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
		panel.add(divide);

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
		panel.add(equals);

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
		panel.add(clear);

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
		panel.add(reset);
	}

	private void zeroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "0");
	}//GEN-LAST:event_zeroActionPerformed

	private void oneActionPerformed(ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "1");
		zerodisp = true;
	}//GEN-LAST:event_oneActionPerformed

	private void twoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "2");
		zerodisp = true;
	}//GEN-LAST:event_twoActionPerformed

	private void threeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "3");
		zerodisp = true;
	}//GEN-LAST:event_threeActionPerformed

	private void fourActionPerformed(ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "4");
		zerodisp = true;
	}//GEN-LAST:event_fourActionPerformed

	private void fiveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "5");
		zerodisp = true;
	}//GEN-LAST:event_fiveActionPerformed

	private void sixActionPerformed(ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "6");
		zerodisp = true;
	}//GEN-LAST:event_sixActionPerformed

	private void sevenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "7");
		zerodisp = true;
	}//GEN-LAST:event_sevenActionPerformed

	private void eightActionPerformed(ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "8");
		zerodisp = true;
	}//GEN-LAST:event_eightActionPerformed

	private void nineActionPerformed(ActionEvent evt) {//GEN-FIRST:event_nineActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() + "9");
		zerodisp = true;
	}//GEN-LAST:event_nineActionPerformed
	private void zeroActionPerformed(KeyEvent evt) {//GEN-FIRST:event_zeroActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
	}//GEN-LAST:event_zeroActionPerformed

	private void oneActionPerformed(KeyEvent evt) {//GEN-FIRST:event_oneActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
		zerodisp = true;
	}//GEN-LAST:event_oneActionPerformed

	private void twoActionPerformed(KeyEvent evt) {//GEN-FIRST:event_twoActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
		zerodisp = true;
	}//GEN-LAST:event_twoActionPerformed

	private void threeActionPerformed(KeyEvent evt) {//GEN-FIRST:event_threeActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
		zerodisp = true;
	}//GEN-LAST:event_threeActionPerformed

	private void fourActionPerformed(KeyEvent evt) {//GEN-FIRST:event_fourActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
		zerodisp = true;
	}//GEN-LAST:event_fourActionPerformed

	private void fiveActionPerformed(KeyEvent evt) {//GEN-FIRST:event_fiveActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
		zerodisp = true;
	}//GEN-LAST:event_fiveActionPerformed

	private void sixActionPerformed(KeyEvent evt) {//GEN-FIRST:event_sixActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
		zerodisp = true;
	}//GEN-LAST:event_sixActionPerformed

	private void sevenActionPerformed(KeyEvent evt) {//GEN-FIRST:event_sevenActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
		zerodisp = true;
	}//GEN-LAST:event_sevenActionPerformed

	private void eightActionPerformed(KeyEvent evt) {//GEN-FIRST:event_eightActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
		zerodisp = true;
	}//GEN-LAST:event_eightActionPerformed

	private void nineActionPerformed(KeyEvent evt) {//GEN-FIRST:event_nineActionPerformed
		if(!zerodisp && !decdisp){
			textFieldInput.setText(null);
		}
		textFieldInput.setText(textFieldInput.getText() );
		zerodisp = true;
	}//GEN-LAST:event_nineActionPerformed
	private void decpointActionPerformed(ActionEvent evt) {//GEN-FIRST:event_decpointActionPerformed
		if(!decdisp){
			textFieldInput.setText(textFieldInput.getText() + ".");
			decdisp = true;
		}
	}//GEN-LAST:event_decpointActionPerformed

	private void negateActionPerformed(ActionEvent evt) {//GEN-FIRST:event_negateActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		out = inb * -1;

		if(out > -100000000 && out < 100000000){
			textFieldInput.setText(String.valueOf(out));
		}
		else{
			textFieldInput.setText("Error");
		}
		decdisp = true;
		out = 0;
	}//GEN-LAST:event_negateActionPerformed

	private void clearActionPerformed(ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
		textFieldInput.setText("0");
		zerodisp = false;
		decdisp = false;
	}//GEN-LAST:event_clearActionPerformed

	private void resetActionPerformed(ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
		textFieldInput.setText("0");
		textFieldShow.setText(null);
		zerodisp = false;
		decdisp = false;
		ina = 0;
		inb = 0;
		out = 0;
	}//GEN-LAST:event_resetActionPerformed

	private void memoryreadActionPerformed(ActionEvent evt) {//GEN-FIRST:event_memoryreadActionPerformed
		textFieldInput.setText(String.valueOf(textFieldMemory.getText()));
	}//GEN-LAST:event_memoryreadActionPerformed

	private void memoryclearActionPerformed(ActionEvent evt) {//GEN-FIRST:event_memoryclearActionPerformed
		textFieldMemory.setText("0");
	}//GEN-LAST:event_memoryclearActionPerformed

	private void memorysaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_memorysaveActionPerformed
		textFieldMemory.setText(String.valueOf(textFieldInput.getText()));
	}//GEN-LAST:event_memorysaveActionPerformed

	private void onedividedbyxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_onedividedbyxActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		out = 1 / inb;

		if(out > -100000000 && out < 100000000){
			textFieldInput.setText(String.valueOf(out));
		}
		else{
			textFieldInput.setText("Error");
		}
		textFieldShow.setText("1/" + String.valueOf(inb));
		out = 0;
		op = 0;
	}//GEN-LAST:event_onedividedbyxActionPerformed

	private void piActionPerformed(ActionEvent evt) {//GEN-FIRST:event_piActionPerformed
		textFieldInput.setText(String.valueOf(Math.PI));
	}//GEN-LAST:event_piActionPerformed

	private void squaredActionPerformed(ActionEvent evt) {//GEN-FIRST:event_squaredActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		out = inb * inb;

		if(out > -100000000 && out < 100000000){
			textFieldInput.setText(String.valueOf(out));
		}
		else{
			textFieldInput.setText("Error");
		}

		textFieldShow.setText(String.valueOf(inb) + "²");
		out = 0;
		op = 0;
	}//GEN-LAST:event_squaredActionPerformed

	private void squarerootActionPerformed(ActionEvent evt) {//GEN-FIRST:event_squarerootActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		out = Math.sqrt(inb);

		textFieldInput.setText(String.valueOf(out));

		textFieldShow.setText("√" + String.valueOf(inb));
		out = 0;
		op = 0;
	}//GEN-LAST:event_squarerootActionPerformed

	private void cubedActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cubedActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		out = inb * inb * inb;

		if(out > -100000000 && out < 100000000){
			textFieldInput.setText(String.valueOf(out));
		}
		else{
			textFieldInput.setText("Error");
		}

		textFieldShow.setText(String.valueOf(inb) + "³");
		out = 0;
		op = 0;
	}//GEN-LAST:event_cubedActionPerformed

	private void cuberootActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cuberootActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		out = Math.cbrt(inb);

		textFieldInput.setText(String.valueOf(out));

		textFieldShow.setText("³√" + String.valueOf(inb));
		out = 0;
		op = 0;
	}//GEN-LAST:event_cuberootActionPerformed

	private void shiftMouseClicked(MouseEvent evt) {//GEN-FIRST:event_shiftMouseClicked
		if(!sh){
			sh = true;
		}
		else{
			sh = false;
		}
	}//GEN-LAST:event_shiftMouseClicked

	private void sinActionPerformed(ActionEvent evt) {//GEN-FIRST:event_sinActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		if(!sh){
			if(!dgrrad){
				textFieldShow.setText("sin(" + String.valueOf(inb) + ")");
				inb = inb * 0.0174532925;
			}
			out = Math.sin(inb);
		}
		else{
			textFieldShow.setText("sinh(" + String.valueOf(inb) + ")");
			out = Math.sinh(inb);
		}

		textFieldInput.setText(String.valueOf(out));
		out = 0;
		op = 0;
	}//GEN-LAST:event_sinActionPerformed

	private void cosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cosActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		if(!sh){
			if(!dgrrad){
				textFieldShow.setText("cos(" + String.valueOf(inb) + ")");
				inb = inb * 0.0174532925;
			}
			out = Math.cos(inb);
		}
		else{
			textFieldShow.setText("cosh(" + String.valueOf(inb) + ")");
			out = Math.cosh(inb);
		}

		textFieldInput.setText(String.valueOf(out));
		out = 0;
		op = 0;
	}//GEN-LAST:event_cosActionPerformed

	private void tanActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tanActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		if(!sh){
			if(!dgrrad){
				textFieldShow.setText("tan(" + String.valueOf(inb) + ")");
				inb = inb * 0.0174532925;
			}
			out = Math.tan(inb);
		}
		else{
			textFieldShow.setText("tanh(" + String.valueOf(inb) + ")");
			out = Math.tanh(inb);
		}

		textFieldInput.setText(String.valueOf(out));
		out = 0;
		op = 0;
	}//GEN-LAST:event_tanActionPerformed

	private void degreesActionPerformed(ActionEvent evt) {//GEN-FIRST:event_degreesActionPerformed
		dgrrad = false;
	}//GEN-LAST:event_degreesActionPerformed

	private void radiansActionPerformed(ActionEvent evt) {//GEN-FIRST:event_radiansActionPerformed
		dgrrad = true;
	}//GEN-LAST:event_radiansActionPerformed

	private void addActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
		calOperator();
		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + " + ");

		op = 1;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_addActionPerformed

	private void subtractActionPerformed(ActionEvent evt) {//GEN-FIRST:event_subtractActionPerformed
		calOperator();
		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + " - ");

		op = 2;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_subtractActionPerformed

	private void multiplyActionPerformed(ActionEvent evt) {//GEN-FIRST:event_multiplyActionPerformed
		calOperator();
		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + " * ");

		op = 3;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_multiplyActionPerformed

	private void divideActionPerformed(ActionEvent evt) {//GEN-FIRST:event_divideActionPerformed
		calOperator();

		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + " / ");

		op = 4;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_divideActionPerformed

	private void percentActionPerformed(ActionEvent evt) {//GEN-FIRST:event_percentActionPerformed
		ina = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + "%(");

		decdisp = false;
		zerodisp = false;
		op = 5;
	}//GEN-LAST:event_percentActionPerformed

	private void equalsActionPerformed(ActionEvent evt) {//GEN-FIRST:event_equalsActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));

		if(op == 0){
			out = inb;
			textFieldShow.setText(String.valueOf(inb));
		}

		if(op == 1){
			out = ina + inb;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb));
		}

		if(op == 2){
			out = ina - inb;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb));
		}

		if(op == 3){
			out = ina * inb;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb));
		}

		if(op == 4){
			out = ina / inb;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb));
		}

		if(op == 5){
			out = ina * inb / 100;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb) + ")");
		}

		if(out > -100000000 && out < 100000000){
			textFieldInput.setText(String.valueOf(out));
		}
		else{
			textFieldInput.setText("Error");
		}

		ina = 0;
		inb = 0;
		out = 0;

		op = 0;
		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_equalsActionPerformed
	private void addActionPerformed(KeyEvent evt) {//GEN-FIRST:event_addActionPerformed
		calOperator();
		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + " + ");

		op = 1;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_addActionPerformed

	private void subtractActionPerformed(KeyEvent evt) {//GEN-FIRST:event_subtractActionPerformed
		calOperator();

		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + " - ");

		op = 2;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_subtractActionPerformed

	private void multiplyActionPerformed(KeyEvent evt) {//GEN-FIRST:event_multiplyActionPerformed
		calOperator();

		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + " * ");

		op = 3;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_multiplyActionPerformed

	private void divideActionPerformed(KeyEvent evt) {//GEN-FIRST:event_divideActionPerformed
		calOperator();

		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + " / ");

		op = 4;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_divideActionPerformed

	private void percentActionPerformed(KeyEvent evt) {//GEN-FIRST:event_percentActionPerformed
		ina = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		textFieldInput.setText("0");
		textFieldShow.setText(String.valueOf(ina) + "%(");

		decdisp = false;
		zerodisp = false;
		op = 5;
	}//GEN-LAST:event_percentActionPerformed

	private void equalsActionPerformed(KeyEvent evt) {//GEN-FIRST:event_equalsActionPerformed
		inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));

		if(op == 0){
			out = inb;
			textFieldShow.setText(String.valueOf(inb));
		}

		if(op == 1){
			out = ina + inb;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb));
		}

		if(op == 2){
			out = ina - inb;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb));
		}

		if(op == 3){
			out = ina * inb;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb));
		}

		if(op == 4){
			out = ina / inb;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb));
		}

		if(op == 5){
			out = ina * inb / 100;
			textFieldShow.setText(textFieldShow.getText() + String.valueOf(inb) + ")");
		}

		if(out > -100000000 && out < 100000000){
			textFieldInput.setText(String.valueOf(out));
		}
		else{
			textFieldInput.setText("Error");
		}

		ina = 0;
		inb = 0;
		out = 0;

		op = 0;
		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_equalsActionPerformed
	public void calOperator(){
		if(op == 0){
			ina = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		}
		else{
			inb = Double.parseDouble(String.valueOf(textFieldInput.getText()));
		}

		if(op == 1){
			ina = ina + inb;
		}

		if(op == 2){
			ina = ina - inb;
		}

		if(op == 3){
			ina = ina * inb;
		}

		if(op == 4){
			ina = ina / inb;
		}

		if(op == 5){
			ina = ina * inb / 100;
		}

	}

}
