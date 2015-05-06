package Saori.Listener.ToolUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Saori.Calculator.CalculatorUI;

public class calculatorButtonListener implements ActionListener {
	private CalculatorUI calculator;
	public calculatorButtonListener(CalculatorUI calculator){
		this.calculator = calculator;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		calculator.setVisible(true);
	}

}