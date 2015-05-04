package Saori.Calculator;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
public class CalculatorUI extends JFrame implements  ActionListener{
//		private static final int WIDTH = 250 ;
//		private static final int HEIGHT = 175 ;
//
//		private JLabel num1Label,num2Label,resultLabel;
//		private JTextField num1TextField ,num2TextField,resultTextField;
//		private JButton addB,subtractB,multiplyB,divideB;
//
//	
//		//Constructor
//		public CalculatorUI(){
//			setTitle("Calculator");
//			setSize(WIDTH,HEIGHT);
//
//			Container pane = getContentPane();
//			GridLayout aGrid = new GridLayout(5,2);
//			pane.setLayout(aGrid);
//			num1Label = new JLabel("1st Number");
//			num2Label = new JLabel("2nd Number");
//			resultLabel = new JLabel("Result");
//
//			num1TextField = new JTextField(10);
//			num2TextField = new JTextField(10);
//			resultTextField = new JTextField(10);
//
//			addB = new JButton ("+");
//			subtractB = new JButton ("-");
//			multiplyB =new JButton ("*");
//			divideB = new JButton ("/");
//
//			pane.add(num1Label);
//			pane.add(num1TextField);
//
//			pane.add(num2Label);
//			pane.add(num2TextField);
//
//			pane.add(addB);
//			pane.add(subtractB);
//			pane.add(multiplyB);
//			pane.add(divideB);
//
//			pane.add(resultLabel);
//			pane.add(resultTextField);
//
//			AddButtonHandler addbHandler = new AddButtonHandler();
//			addB.addActionListener(addbHandler);
//
//			SubtractButtonHandler subtractbHandler = new SubtractButtonHandler();
//			subtractB.addActionListener(subtractbHandler);
//
//			MultiplyButtonHandler multiplybHandler = new MultiplyButtonHandler();
//			multiplyB.addActionListener(multiplybHandler);
//
//			//Annonymous ActionListener class
//			divideB.addActionListener(new ActionListener()
//			{
//				public void actionPerformed (ActionEvent e){
//					String num1Str = num1TextField.getText();
//					String num2Str = num2TextField.getText();
//					double num1 = Double.parseDouble(num1Str);
//					double num2 = Double.parseDouble(num2Str);
//					if(num2 == 0){
//						JOptionPane.showMessageDialog(null,"Division by 0");
//						System.exit(0);
//					}
//					double result = num1/num2 ;
//					String resultStr = Double.toString(result);
//					resultTextField.setText(resultStr);
//				}
//			});
//
//		}// end of constructor
//		//private inner ActionListenner class
//		private class AddButtonHandler implements ActionListener{
//			public void actionPerformed (ActionEvent e){
//				String num1Str = num1TextField.getText();
//				String num2Str = num2TextField.getText();
//				double num1 = Double.parseDouble(num1Str);
//				double num2 = Double.parseDouble(num2Str);
//				double result = num1+num2 ;
//				String resultStr = Double.toString(result);
//				resultTextField.setText(resultStr);
//			}
//		}
//		//private inner ActionListenner class
//		private class SubtractButtonHandler implements ActionListener{
//			public void actionPerformed (ActionEvent e){
//				String num1Str = num1TextField.getText();
//				String num2Str = num2TextField.getText();
//				double num1 = Double.parseDouble(num1Str);
//				double num2 = Double.parseDouble(num2Str);
//				double result = num1-num2 ;
//				String resultStr = Double.toString(result);
//				resultTextField.setText(resultStr);
//			}
//		}
//		//private inner ActionListenner class
//		private class MultiplyButtonHandler implements ActionListener{
//			public void actionPerformed (ActionEvent e){
//				String num1Str = num1TextField.getText();
//				String num2Str = num2TextField.getText();
//				double num1 = Double.parseDouble(num1Str);
//				double num2 = Double.parseDouble(num2Str);
//				double result = num1*num2 ;
//				String resultStr = Double.toString(result);
//				resultTextField.setText(resultStr);
//			}
//		}
//		//main method
//		public static void main (String[] args){
//			JFrame aCalculatorGui = new CalculatorUI();
//			aCalculatorGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			aCalculatorGui.setVisible(true);
//		}

		Container c ; 
			JTextField result ;
			JPanel p = new JPanel();
			JButton b[] = new JButton[16];
			String s[] = {"0","1","2","3","4","5","6","7","8","9","+","-","/","*","=","C"};
			//----------------------Me------------------------
			String Screen="",monitor1="",monitor2="",OperationOnScreen=""; 
			boolean CommandEmpty=true,switcher=true;
			double R=Integer.MIN_VALUE,L=Integer.MIN_VALUE;
			//------------------------------------------------
			public CalculatorUI ()
				{
				super ("Casio ^_^");
			
				c=getContentPane();
				result = new JTextField();
				result.setEditable(false);
				result.setBackground(Color.cyan);
				
				p.setLayout(new GridLayout(4,4));
				for (int i=0;i<16;i++)
				{
					b[i] = new JButton(s[i]);
					b[i].addActionListener(this);
					p.add(b[i]);
				}
				c.add(result,BorderLayout.NORTH);
				c.add(p);
				
				setSize(300,300);
				setVisible(true);
				setResizable(false);
				setLocationRelativeTo(null);
				}//End Constructor
			public static void main (String[] args) 
				{
					new CalculatorUI();
		  		}
		  	//------------------------------------------------				
			public void actionPerformed(ActionEvent event)
				{
					for (int i=0; i<=9; i++)//Numbers
					{
						if(event.getSource()==b[i])
						{					
							Screen+=i;
							result.setText("");
							result.setText(Screen);	
						}
					}
						
					for (int i=10; i<=14; i++)//Commands
					{
						if(event.getSource()==b[i])
						{
							if(result.getText().lastIndexOf(OperationOnScreen)!=-1)//prevent exception
								result.setText(result.getText().substring(0,result.getText().lastIndexOf(OperationOnScreen))+s[i]);
							else
								result.setText(result.getText()+s[i]);
							OperationOnScreen=s[i];	
								
							if(switcher)
							     {monitor1=s[i];switcher=false;}
							else {monitor2=s[i];switcher=true;}
							
							if (monitor1!=monitor2 && monitor2!="")
								{
								if(switcher) //execute older,send sign newer
							   	 	 {Calc(event,monitor1.charAt(0),monitor2); }
								else {Calc(event,monitor2.charAt(0),monitor1); }
							    }
							if(s[i]!="=") //calc returns 0
								Calc(event,s[i].charAt(0),s[i]);
						}					
					}
					
					if(event.getSource()==b[15]) //Clear
					{
						Screen=""; monitor1=""; monitor2=""; 
						switcher=true; CommandEmpty=true;
						result.setText("");
					}
				}//end actionPerformed
				
				public void Calc(ActionEvent event,char OpType,String Operator)
				{		if (Operator=="=")
							Operator="";
							
						if(CommandEmpty && Screen=="")
						{
							return;
						}
							
						else if(CommandEmpty && Screen!="")
						{
							R=Integer.parseInt(Screen);
							result.setText(Screen+Operator);
							Screen="";
							CommandEmpty=false;
						}
						else if(!CommandEmpty && Screen!="")
						{
							L=Integer.parseInt(Screen);
							R=Operations(R,L,OpType);//calculate
							Screen="";
							result.setText("");
							result.setText(R+Operator);
						}	
				}//End Calc				

			public static double  Operations(double R, double L, char op)
			{	
				switch (op)
				{
					case '+':
						return R+L;
					case '-':
						return R-L;
					case '*':
						return R*L;
					case '/':
						return R/L;											
				}
				return 0;
			}
	//end class
	}



