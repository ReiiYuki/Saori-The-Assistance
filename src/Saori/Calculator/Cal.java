package Saori.Calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Cal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnMc;
	private JButton btnMs;
	private JTextField textField_2;
	private JButton btnSin;
	private JButton btnCos;
	private JButton btnTan;
	private JButton btnSh;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton btnX;
	private JButton button_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cal frame = new Cal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 535);
		
		initComponents();
	}
	public void initComponents(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(10, 10, 289, 35);
		contentPane.add(textField);
		//textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 52, 289, 35);
		contentPane.add(textField_1);
		//textField_1.setColumns(10);

		JButton btnMr = new JButton("MR");
		btnMr.setBounds(10, 94, 52, 28);
		contentPane.add(btnMr);

		btnMc = new JButton("MC");
		btnMc.setBounds(70, 94, 52, 28);
		contentPane.add(btnMc);

		btnMs = new JButton("MS");
		btnMs.setBounds(129, 94, 52, 28);
		contentPane.add(btnMs);

		textField_2 = new JTextField();
		textField_2.setBounds(188, 94, 111, 28);
		contentPane.add(textField_2);
		//textField_2.setColumns(10);

		JRadioButton rdbtnDegrees = new JRadioButton("Degrees");
		rdbtnDegrees.setBounds(10, 130, 80, 23);
		contentPane.add(rdbtnDegrees);

		JRadioButton rdbtnRadians = new JRadioButton("Radians");
		rdbtnRadians.setBounds(94, 130, 80, 23);
		contentPane.add(rdbtnRadians);

		JButton button = new JButton("%");
		button.setBounds(188, 129, 52, 28);
		contentPane.add(button);

		JButton btnx = new JButton("1/x");
		btnx.setBounds(247, 129, 52, 28);
		contentPane.add(btnx);

		btnSin = new JButton("Sin");
		btnSin.setBounds(10, 164, 52, 28);
		contentPane.add(btnSin);

		btnCos = new JButton("Cos");
		btnCos.setBounds(70, 164, 52, 28);
		contentPane.add(btnCos);

		btnTan = new JButton("Tan");
		btnTan.setBounds(129, 164, 52, 28);
		contentPane.add(btnTan);

		btnSh = new JButton("Sh");
		btnSh.setBounds(188, 164, 52, 28);
		contentPane.add(btnSh);

		button_1 = new JButton("ⁿ");
		button_1.setBounds(247, 164, 52, 28);
		contentPane.add(button_1);

		button_2 = new JButton("7");
		button_2.setBounds(10, 199, 52, 52);
		contentPane.add(button_2);

		button_3 = new JButton("8");
		button_3.setBounds(70, 199, 52, 52);
		contentPane.add(button_3);

		button_4 = new JButton("9");
		button_4.setBounds(129, 199, 52, 52);
		contentPane.add(button_4);

		btnX = new JButton("x^2");
		btnX.setBounds(187, 199, 52, 52);
		contentPane.add(btnX);

		button_5 = new JButton("+");
		button_5.setBounds(247, 199, 52, 52);
		contentPane.add(button_5);

		JButton button_6 = new JButton("4");
		button_6.setBounds(10, 258, 52, 52);
		contentPane.add(button_6);

		JButton button_7 = new JButton("5");
		button_7.setBounds(70, 258, 52, 52);
		contentPane.add(button_7);

		JButton button_8 = new JButton("6");
		button_8.setBounds(129, 258, 52, 52);
		contentPane.add(button_8);

		JButton btnx_1 = new JButton("รูทx");
		btnx_1.setBounds(188, 258, 52, 52);
		contentPane.add(btnx_1);

		JButton button_9 = new JButton("-");
		button_9.setBounds(247, 258, 52, 52);
		contentPane.add(button_9);

		JButton button_10 = new JButton("1");
		button_10.setBounds(10, 317, 52, 52);
		contentPane.add(button_10);

		JButton button_11 = new JButton("2");
		button_11.setBounds(70, 317, 52, 52);
		contentPane.add(button_11);

		JButton button_12 = new JButton("3");
		button_12.setBounds(129, 317, 52, 52);
		contentPane.add(button_12);

		JButton btnX_1 = new JButton("x^3");
		btnX_1.setBounds(188, 317, 52, 52);
		contentPane.add(btnX_1);

		JButton button_13 = new JButton("*");
		button_13.setBounds(247, 317, 52, 52);
		contentPane.add(button_13);

		JButton button_14 = new JButton("0");
		button_14.setBounds(10, 376, 52, 52);
		contentPane.add(button_14);

		JButton button_15 = new JButton(".");
		button_15.setBounds(70, 376, 52, 52);
		contentPane.add(button_15);

		JButton button_16 = new JButton("+-");
		button_16.setBounds(129, 376, 52, 52);
		contentPane.add(button_16);

		JButton btnx_2 = new JButton("3/x");
		btnx_2.setBounds(188, 376, 52, 52);
		contentPane.add(btnx_2);

		JButton button_17 = new JButton("/");
		button_17.setBounds(247, 376, 52, 52);
		contentPane.add(button_17);

		JButton button_18 = new JButton("=");
		button_18.setBounds(10, 435, 171, 52);
		contentPane.add(button_18);

		JButton btnCe = new JButton("CE");
		btnCe.setBounds(188, 435, 52, 52);
		contentPane.add(btnCe);

		JButton btnC = new JButton("C");
		btnC.setBounds(247, 435, 52, 52);
		contentPane.add(btnC);




	}
}
