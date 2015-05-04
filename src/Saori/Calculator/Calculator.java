package Saori.Calculator;

import java.awt.*;
import java.awt.event.*;
import java.math.*;
import javax.swing.*;
import javax.swing.border.*;
//import border.SoftBevelBorder;



public class Calculator extends JFrame {

	private boolean zerodisp;
	private boolean decdisp;
	private boolean dgrrad;
	private boolean sh;

	private byte op; //operator

	private double ina;
	private double inb;
	private double out;

	public Calculator() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Java Calculator");
		setResizable(false);
		initComponents();
	}

	//@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		buttonGroup1 = new ButtonGroup();
		display2 = new JTextField();
		display1 = new JTextField();
		memorydisplay = new JTextField();
		memoryread = new JButton();
		memoryclear = new JButton();
		memorysave = new JButton();
		onedividedbyx = new JButton();
		percent = new JButton();
		pi = new JButton();
		cos = new JButton();
		tan = new JButton();
		sin = new JButton();
		seven = new JButton();
		eight = new JButton();
		nine = new JButton();
		add = new JButton();
		squared = new JButton();
		subtract = new JButton();
		squareroot = new JButton();
		multiply = new JButton();
		cubed = new JButton();
		divide = new JButton();
		cuberoot = new JButton();
		four = new JButton();
		five = new JButton();
		six = new JButton();
		one = new JButton();
		two = new JButton();
		three = new JButton();
		negate = new JButton();
		decpoint = new JButton();
		zero = new JButton();
		degrees = new JRadioButton();
		radians = new JRadioButton();
		equals = new JButton();
		clear = new JButton();
		reset = new JButton();
		shift = new JToggleButton();

		display2.setBackground(new Color(199, 218, 220));
		display2.setFont(new Font("Tahoma", 1, 24)); // NOI18N
		display2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		display2.setFocusable(false);

		display1.setBackground(new Color(199, 218, 220));
		display1.setFont(new Font("Tahoma", 1, 24)); // NOI18N
		display1.setText("0");
		display1.setAutoscrolls(false);
		display1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		display1.setFocusable(false);

		memorydisplay.setBackground(new Color(199, 218, 220));
		memorydisplay.setFont(new Font("Tahoma", 1, 14)); // NOI18N
		memorydisplay.setText("0");
		memorydisplay.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		memorydisplay.setFocusable(false);

		memoryread.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		memoryread.setText("MR");
		memoryread.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		memoryread.setCursor(new Cursor(Cursor.HAND_CURSOR));
		memoryread.setFocusable(false);
		memoryread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				memoryreadActionPerformed(evt);
			}
		});

		memoryclear.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		memoryclear.setText("MC");
		memoryclear.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		memoryclear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		memoryclear.setFocusable(false);
		memoryclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				memoryclearActionPerformed(evt);
			}
		});

		memorysave.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		memorysave.setText("MS");
		memorysave.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		memorysave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		memorysave.setFocusable(false);
		memorysave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				memorysaveActionPerformed(evt);
			}
		});

		onedividedbyx.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		onedividedbyx.setText("1/x");
		onedividedbyx.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		onedividedbyx.setCursor(new Cursor(Cursor.HAND_CURSOR));
		onedividedbyx.setFocusable(false);
		onedividedbyx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				onedividedbyxActionPerformed(evt);
			}
		});

		percent.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		percent.setText("%");
		percent.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		percent.setCursor(new Cursor(Cursor.HAND_CURSOR));
		percent.setFocusable(false);
		percent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				percentActionPerformed(evt);
			}
		});

		pi.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		pi.setText("ⁿ");
		pi.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		pi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pi.setFocusable(false);
		pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				piActionPerformed(evt);
			}
		});

		cos.setFont(new Font("Tahoma", 1, 8)); // NOI18N
		cos.setText("Cos");
		cos.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		cos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cos.setFocusable(false);
		cos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cosActionPerformed(evt);
			}
		});

		tan.setFont(new Font("Tahoma", 1, 8)); // NOI18N
		tan.setText("Tan");
		tan.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		tan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tan.setFocusable(false);
		tan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tanActionPerformed(evt);
			}
		});

		sin.setFont(new Font("Tahoma", 1, 8)); // NOI18N
		sin.setText("Sin");
		sin.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		sin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sin.setFocusable(false);
		sin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sinActionPerformed(evt);
			}
		});

		seven.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		seven.setText("7");
		seven.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		seven.setCursor(new Cursor(Cursor.HAND_CURSOR));
		seven.setFocusable(false);
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sevenActionPerformed(evt);
			}
		});

		eight.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		eight.setText("8");
		eight.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		eight.setCursor(new Cursor(Cursor.HAND_CURSOR));
		eight.setFocusable(false);
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				eightActionPerformed(evt);
			}
		});

		nine.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		nine.setText("9");
		nine.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		nine.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nine.setFocusable(false);
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nineActionPerformed(evt);
			}
		});

		add.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		add.setText("+");
		add.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		add.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add.setFocusable(false);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addActionPerformed(evt);
			}
		});

		squared.setFont(new Font("Tahoma", 1, 8)); // NOI18N
		squared.setText("x²");
		squared.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		squared.setCursor(new Cursor(Cursor.HAND_CURSOR));
		squared.setFocusable(false);
		squared.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				squaredActionPerformed(evt);
			}
		});

		subtract.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		subtract.setText("-");
		subtract.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		subtract.setCursor(new Cursor(Cursor.HAND_CURSOR));
		subtract.setFocusable(false);
		subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				subtractActionPerformed(evt);
			}
		});

		squareroot.setFont(new Font("Tahoma", 1, 8)); // NOI18N
		squareroot.setText("√x");
		squareroot.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		squareroot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		squareroot.setFocusable(false);
		squareroot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				squarerootActionPerformed(evt);
			}
		});

		multiply.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		multiply.setText("*");
		multiply.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		multiply.setCursor(new Cursor(Cursor.HAND_CURSOR));
		multiply.setFocusable(false);
		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				multiplyActionPerformed(evt);
			}
		});

		cubed.setFont(new Font("Tahoma", 1, 8)); // NOI18N
		cubed.setText("x³");
		cubed.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		cubed.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cubed.setFocusable(false);
		cubed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cubedActionPerformed(evt);
			}
		});

		divide.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		divide.setText("/");
		divide.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		divide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		divide.setFocusable(false);
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				divideActionPerformed(evt);
			}
		});

		cuberoot.setFont(new Font("Tahoma", 1, 8)); // NOI18N
		cuberoot.setText("³√x");
		cuberoot.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		cuberoot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cuberoot.setFocusable(false);
		cuberoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cuberootActionPerformed(evt);
			}
		});

		four.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		four.setText("4");
		four.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		four.setCursor(new Cursor(Cursor.HAND_CURSOR));
		four.setFocusable(false);
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fourActionPerformed(evt);
			}
		});

		five.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		five.setText("5");
		five.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		five.setCursor(new Cursor(Cursor.HAND_CURSOR));
		five.setFocusable(false);
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fiveActionPerformed(evt);
			}
		});

		six.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		six.setText("6");
		six.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		six.setCursor(new Cursor(Cursor.HAND_CURSOR));
		six.setFocusable(false);
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sixActionPerformed(evt);
			}
		});

		one.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		one.setText("1");
		one.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		one.setCursor(new Cursor(Cursor.HAND_CURSOR));
		one.setFocusable(false);
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				oneActionPerformed(evt);
			}
		});

		two.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		two.setText("2");
		two.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		two.setCursor(new Cursor(Cursor.HAND_CURSOR));
		two.setFocusable(false);
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				twoActionPerformed(evt);
			}
		});

		three.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		three.setText("3");
		three.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		three.setCursor(new Cursor(Cursor.HAND_CURSOR));
		three.setFocusable(false);
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				threeActionPerformed(evt);
			}
		});

		negate.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		negate.setText("±");
		negate.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		negate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		negate.setFocusable(false);
		negate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				negateActionPerformed(evt);
			}
		});

		decpoint.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		decpoint.setText(".");
		decpoint.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		decpoint.setCursor(new Cursor(Cursor.HAND_CURSOR));
		decpoint.setFocusable(false);
		decpoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				decpointActionPerformed(evt);
			}
		});

		zero.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		zero.setText("0");
		zero.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		zero.setCursor(new Cursor(Cursor.HAND_CURSOR));
		zero.setFocusable(false);
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				zeroActionPerformed(evt);
			}
		});

		buttonGroup1.add(degrees);
		degrees.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		degrees.setSelected(true);
		degrees.setText("Degrees");
		degrees.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		degrees.setCursor(new Cursor(Cursor.HAND_CURSOR));
		degrees.setFocusable(false);
		degrees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				degreesActionPerformed(evt);
			}
		});

		buttonGroup1.add(radians);
		radians.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		radians.setText("Radians");
		radians.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		radians.setCursor(new Cursor(Cursor.HAND_CURSOR));
		radians.setFocusable(false);
		radians.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				radiansActionPerformed(evt);
			}
		});

		equals.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		equals.setText("=");
		equals.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		equals.setCursor(new Cursor(Cursor.HAND_CURSOR));
		equals.setFocusable(false);
		equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				equalsActionPerformed(evt);
			}
		});

		clear.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		clear.setText("CE");
		clear.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clear.setFocusable(false);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clearActionPerformed(evt);
			}
		});

		reset.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		reset.setText("C");
		reset.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
		reset.setFocusable(false);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetActionPerformed(evt);
			}
		});

		shift.setFont(new Font("Tahoma", 1, 10)); // NOI18N
		shift.setText("Sh");
		shift.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		shift.setCursor(new Cursor(Cursor.HAND_CURSOR));
		shift.setFocusable(false);
		shift.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				shiftMouseClicked(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(equals, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(clear, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(divide, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
												.addComponent(reset, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
												.addComponent(display2)
												.addComponent(display1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(memoryread, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(memoryclear, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(memorysave, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(degrees)
																				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(radians)))
																				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																						.addGroup(layout.createSequentialGroup()
																								.addComponent(percent, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(onedividedbyx, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																								.addComponent(memorydisplay)))
																								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																										.addComponent(four, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(five, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(six, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(squareroot, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(subtract, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																										.addGroup(layout.createSequentialGroup()
																												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																														.addGroup(layout.createSequentialGroup()
																																.addComponent(one, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																.addComponent(two, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																																.addGroup(layout.createSequentialGroup()
																																		.addComponent(zero, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(decpoint, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
																																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																																				.addGroup(layout.createSequentialGroup()
																																						.addComponent(three, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																						.addComponent(cubed, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																						.addComponent(multiply, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																																						.addGroup(layout.createSequentialGroup()
																																								.addComponent(negate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																								.addComponent(cuberoot, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																								.addGap(56, 56, 56))))
																																								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																																										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																																												.addGroup(layout.createSequentialGroup()
																																														.addComponent(seven, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																														.addComponent(eight, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																														.addComponent(nine, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																																														.addGroup(layout.createSequentialGroup()
																																																.addComponent(sin, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																																.addComponent(cos, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																																.addComponent(tan, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
																																																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																																																		.addGroup(layout.createSequentialGroup()
																																																				.addComponent(shift, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																																				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																																				.addComponent(pi, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																																																				.addGroup(layout.createSequentialGroup()
																																																						.addComponent(squared, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																																						.addComponent(add, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))))
																																																						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(display2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(display1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(memorydisplay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(memoryread, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
										.addComponent(memoryclear, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(memorysave, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(onedividedbyx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
																.addComponent(percent, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																				.addComponent(degrees)
																				.addComponent(radians))
																				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
																				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																								.addComponent(sin, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
																								.addComponent(tan, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
																								.addComponent(pi, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
																								.addComponent(shift, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																								.addComponent(cos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																										.addComponent(seven, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																										.addComponent(eight, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																										.addComponent(nine, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																										.addComponent(add, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																										.addComponent(squared, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																												.addComponent(subtract, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																												.addComponent(squareroot, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																												.addComponent(four, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																												.addComponent(five, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																												.addComponent(six, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																														.addComponent(multiply, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																														.addComponent(cubed, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																														.addComponent(one, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																														.addComponent(two, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																														.addComponent(three, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																																.addComponent(divide, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																.addComponent(cuberoot, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																.addComponent(negate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																.addComponent(decpoint, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																.addComponent(zero, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																																		.addComponent(equals, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																		.addComponent(clear, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
																																		.addComponent(reset, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
																																		.addContainerGap())
				);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void zeroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "0");
	}//GEN-LAST:event_zeroActionPerformed

	private void oneActionPerformed(ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "1");
		zerodisp = true;
	}//GEN-LAST:event_oneActionPerformed

	private void twoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "2");
		zerodisp = true;
	}//GEN-LAST:event_twoActionPerformed

	private void threeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "3");
		zerodisp = true;
	}//GEN-LAST:event_threeActionPerformed

	private void fourActionPerformed(ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "4");
		zerodisp = true;
	}//GEN-LAST:event_fourActionPerformed

	private void fiveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "5");
		zerodisp = true;
	}//GEN-LAST:event_fiveActionPerformed

	private void sixActionPerformed(ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "6");
		zerodisp = true;
	}//GEN-LAST:event_sixActionPerformed

	private void sevenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "7");
		zerodisp = true;
	}//GEN-LAST:event_sevenActionPerformed

	private void eightActionPerformed(ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "8");
		zerodisp = true;
	}//GEN-LAST:event_eightActionPerformed

	private void nineActionPerformed(ActionEvent evt) {//GEN-FIRST:event_nineActionPerformed
		if(!zerodisp && !decdisp){
			display1.setText(null);
		}
		display1.setText(display1.getText() + "9");
		zerodisp = true;
	}//GEN-LAST:event_nineActionPerformed

	private void decpointActionPerformed(ActionEvent evt) {//GEN-FIRST:event_decpointActionPerformed
		if(!decdisp){
			display1.setText(display1.getText() + ".");
			decdisp = true;
		}
	}//GEN-LAST:event_decpointActionPerformed

	private void negateActionPerformed(ActionEvent evt) {//GEN-FIRST:event_negateActionPerformed
		inb = Double.parseDouble(String.valueOf(display1.getText()));
		out = inb * -1;

		if(out > -100000000 && out < 100000000){
			display1.setText(String.valueOf(out));
		}
		else{
			display1.setText("Error");
		}
		decdisp = true;
		out = 0;
	}//GEN-LAST:event_negateActionPerformed

	private void clearActionPerformed(ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
		display1.setText("0");
		zerodisp = false;
		decdisp = false;
	}//GEN-LAST:event_clearActionPerformed

	private void resetActionPerformed(ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
		display1.setText("0");
		display2.setText(null);
		zerodisp = false;
		decdisp = false;
		ina = 0;
		inb = 0;
		out = 0;
	}//GEN-LAST:event_resetActionPerformed

	private void memoryreadActionPerformed(ActionEvent evt) {//GEN-FIRST:event_memoryreadActionPerformed
		display1.setText(String.valueOf(memorydisplay.getText()));
	}//GEN-LAST:event_memoryreadActionPerformed

	private void memoryclearActionPerformed(ActionEvent evt) {//GEN-FIRST:event_memoryclearActionPerformed
		memorydisplay.setText("0");
	}//GEN-LAST:event_memoryclearActionPerformed

	private void memorysaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_memorysaveActionPerformed
		memorydisplay.setText(String.valueOf(display1.getText()));
	}//GEN-LAST:event_memorysaveActionPerformed

	private void onedividedbyxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_onedividedbyxActionPerformed
		inb = Double.parseDouble(String.valueOf(display1.getText()));
		out = 1 / inb;

		if(out > -100000000 && out < 100000000){
			display1.setText(String.valueOf(out));
		}
		else{
			display1.setText("Error");
		}
		display2.setText("1/" + String.valueOf(inb));
		out = 0;
		op = 0;
	}//GEN-LAST:event_onedividedbyxActionPerformed

	private void piActionPerformed(ActionEvent evt) {//GEN-FIRST:event_piActionPerformed
		display1.setText(String.valueOf(Math.PI));
	}//GEN-LAST:event_piActionPerformed

	private void squaredActionPerformed(ActionEvent evt) {//GEN-FIRST:event_squaredActionPerformed
		inb = Double.parseDouble(String.valueOf(display1.getText()));
		out = inb * inb;

		if(out > -100000000 && out < 100000000){
			display1.setText(String.valueOf(out));
		}
		else{
			display1.setText("Error");
		}

		display2.setText(String.valueOf(inb) + "²");
		out = 0;
		op = 0;
	}//GEN-LAST:event_squaredActionPerformed

	private void squarerootActionPerformed(ActionEvent evt) {//GEN-FIRST:event_squarerootActionPerformed
		inb = Double.parseDouble(String.valueOf(display1.getText()));
		out = Math.sqrt(inb);

		display1.setText(String.valueOf(out));

		display2.setText("√" + String.valueOf(inb));
		out = 0;
		op = 0;
	}//GEN-LAST:event_squarerootActionPerformed

	private void cubedActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cubedActionPerformed
		inb = Double.parseDouble(String.valueOf(display1.getText()));
		out = inb * inb * inb;

		if(out > -100000000 && out < 100000000){
			display1.setText(String.valueOf(out));
		}
		else{
			display1.setText("Error");
		}

		display2.setText(String.valueOf(inb) + "³");
		out = 0;
		op = 0;
	}//GEN-LAST:event_cubedActionPerformed

	private void cuberootActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cuberootActionPerformed
		inb = Double.parseDouble(String.valueOf(display1.getText()));
		out = Math.cbrt(inb);

		display1.setText(String.valueOf(out));

		display2.setText("³√" + String.valueOf(inb));
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
		inb = Double.parseDouble(String.valueOf(display1.getText()));
		if(!sh){
			if(!dgrrad){
				display2.setText("sin(" + String.valueOf(inb) + ")");
				inb = inb * 0.0174532925;
			}
			out = Math.sin(inb);
		}
		else{
			display2.setText("sinh(" + String.valueOf(inb) + ")");
			out = Math.sinh(inb);
		}

		display1.setText(String.valueOf(out));
		out = 0;
		op = 0;
	}//GEN-LAST:event_sinActionPerformed

	private void cosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cosActionPerformed
		inb = Double.parseDouble(String.valueOf(display1.getText()));
		if(!sh){
			if(!dgrrad){
				display2.setText("cos(" + String.valueOf(inb) + ")");
				inb = inb * 0.0174532925;
			}
			out = Math.cos(inb);
		}
		else{
			display2.setText("cosh(" + String.valueOf(inb) + ")");
			out = Math.cosh(inb);
		}

		display1.setText(String.valueOf(out));
		out = 0;
		op = 0;
	}//GEN-LAST:event_cosActionPerformed

	private void tanActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tanActionPerformed
		inb = Double.parseDouble(String.valueOf(display1.getText()));
		if(!sh){
			if(!dgrrad){
				display2.setText("tan(" + String.valueOf(inb) + ")");
				inb = inb * 0.0174532925;
			}
			out = Math.tan(inb);
		}
		else{
			display2.setText("tanh(" + String.valueOf(inb) + ")");
			out = Math.tanh(inb);
		}

		display1.setText(String.valueOf(out));
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
		if(op == 0){
			ina = Double.parseDouble(String.valueOf(display1.getText()));
		}
		else{
			inb = Double.parseDouble(String.valueOf(display1.getText()));
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

		display1.setText("0");
		display2.setText(String.valueOf(ina) + " + ");

		op = 1;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_addActionPerformed

	private void subtractActionPerformed(ActionEvent evt) {//GEN-FIRST:event_subtractActionPerformed
		if(op == 0){
			ina = Double.parseDouble(String.valueOf(display1.getText()));
		}
		else{
			inb = Double.parseDouble(String.valueOf(display1.getText()));
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

		display1.setText("0");
		display2.setText(String.valueOf(ina) + " - ");

		op = 2;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_subtractActionPerformed

	private void multiplyActionPerformed(ActionEvent evt) {//GEN-FIRST:event_multiplyActionPerformed
		if(op == 0){
			ina = Double.parseDouble(String.valueOf(display1.getText()));
		}
		else{
			inb = Double.parseDouble(String.valueOf(display1.getText()));
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

		display1.setText("0");
		display2.setText(String.valueOf(ina) + " * ");

		op = 3;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_multiplyActionPerformed

	private void divideActionPerformed(ActionEvent evt) {//GEN-FIRST:event_divideActionPerformed
		if(op == 0){
			ina = Double.parseDouble(String.valueOf(display1.getText()));
		}
		else{
			inb = Double.parseDouble(String.valueOf(display1.getText()));
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

		display1.setText("0");
		display2.setText(String.valueOf(ina) + " / ");

		op = 4;

		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_divideActionPerformed

	private void percentActionPerformed(ActionEvent evt) {//GEN-FIRST:event_percentActionPerformed
		ina = Double.parseDouble(String.valueOf(display1.getText()));
		display1.setText("0");
		display2.setText(String.valueOf(ina) + "%(");

		decdisp = false;
		zerodisp = false;
		op = 5;
	}//GEN-LAST:event_percentActionPerformed

	private void equalsActionPerformed(ActionEvent evt) {//GEN-FIRST:event_equalsActionPerformed
		inb = Double.parseDouble(String.valueOf(display1.getText()));

		if(op == 0){
			out = inb;
			display2.setText(String.valueOf(inb));
		}

		if(op == 1){
			out = ina + inb;
			display2.setText(display2.getText() + String.valueOf(inb));
		}

		if(op == 2){
			out = ina - inb;
			display2.setText(display2.getText() + String.valueOf(inb));
		}

		if(op == 3){
			out = ina * inb;
			display2.setText(display2.getText() + String.valueOf(inb));
		}

		if(op == 4){
			out = ina / inb;
			display2.setText(display2.getText() + String.valueOf(inb));
		}

		if(op == 5){
			out = ina * inb / 100;
			display2.setText(display2.getText() + String.valueOf(inb) + ")");
		}

		if(out > -100000000 && out < 100000000){
			display1.setText(String.valueOf(out));
		}
		else{
			display1.setText("Error");
		}

		ina = 0;
		inb = 0;
		out = 0;

		op = 0;
		decdisp = false;
		zerodisp = false;
	}//GEN-LAST:event_equalsActionPerformed


	public static void main(String args[]) {

		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Calculator().setVisible(true);
			}
		});
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton add;
	private ButtonGroup buttonGroup1;
	private JButton clear;
	private JButton cos;
	private JButton cubed;
	private JButton cuberoot;
	private JButton decpoint;
	private JRadioButton degrees;
	private JTextField display1;
	private JTextField display2;
	private JButton divide;
	private JButton eight;
	private JButton equals;
	private JButton five;
	private JButton four;
	private JButton memoryclear;
	private JTextField memorydisplay;
	private JButton memoryread;
	private JButton memorysave;
	private JButton multiply;
	private JButton negate;
	private JButton nine;
	private JButton one;
	private JButton onedividedbyx;
	private JButton percent;
	private JButton pi;
	private JRadioButton radians;
	private JButton reset;
	private JButton seven;
	private JToggleButton shift;
	private JButton sin;
	private JButton six;
	private JButton squared;
	private JButton squareroot;
	private JButton subtract;
	private JButton tan;
	private JButton three;
	private JButton two;
	private JButton zero;
	// End of variables declaration//GEN-END:variables
}
