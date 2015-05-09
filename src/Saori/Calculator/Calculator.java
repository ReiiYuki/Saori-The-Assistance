package Saori.Calculator;
/**
 * Calculator is command calculator everything 
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public class Calculator{

	private CalculatorUI calculatorUI;
	protected boolean isZero ; //number zero 
	protected boolean isDot ; //dot or .
	protected boolean isDegrees ; // check that click degrees
	protected boolean sh ; //shift
	protected byte op ; //operator
	protected double ina ; //integer a
	protected double inb ; //integer b
	protected double out ; //out lead print to String
	/**
	 * Constructor for new Calculator 
	 * @param calculatorUI is GUI of Calculator 
	 */
	public Calculator(CalculatorUI calculatorUI){
		this.calculatorUI = calculatorUI;
	}
	/**
	 * zeroFunction is work of number button
	 * @param num is number that print
	 */
	public void numberFunction(String num){
		if(!isZero && !isDot){
			calculatorUI.textFieldInput.setText(null);
		}
		calculatorUI.textFieldInput.setText(calculatorUI.textFieldInput.getText() + num );
		isZero = true;
	}
	/**
	 * zeroFunction is work of number zero button
	 * @param num is number that print
	 */
	public void zeroFunction(String num){
		if(!isZero && !isDot){
			this.calculatorUI.textFieldInput.setText(null);
		}
		this.calculatorUI.textFieldInput.setText(this.calculatorUI.textFieldInput.getText() + num);
	}
	/**
	 * equalsFunction is work of equals button
	 */
	public void equalsFunction(){
		inb = Double.parseDouble(String.valueOf(calculatorUI.textFieldInput.getText()));

		if(op == 0){
			out = inb;
			calculatorUI.textFieldShow.setText(String.valueOf(inb));
		}

		if(op == 1){
			out = ina + inb;
			calculatorUI.textFieldShow.setText(calculatorUI.textFieldShow.getText() + inb );
		}

		if(op == 2){
			out = ina - inb;
			calculatorUI.textFieldShow.setText(calculatorUI.textFieldShow.getText() + inb );
		}

		if(op == 3){
			out = ina * inb;
			calculatorUI.textFieldShow.setText(calculatorUI.textFieldShow.getText() + inb );
		}

		if(op == 4){
			out = ina / inb;
			calculatorUI.textFieldShow.setText(calculatorUI.textFieldShow.getText() + inb );
		}

		if(op == 5){
			out = ina * inb / 100;
			calculatorUI.textFieldShow.setText(calculatorUI.textFieldShow.getText() + inb + ")");
		}

		if(out > -100000000 && out < 100000000){
			calculatorUI.textFieldInput.setText(String.valueOf(out));
		}
		else{
			calculatorUI.textFieldInput.setText("Error");
		}

		ina = 0;
		inb = 0;
		out = 0;

		op = 0;
		isDot = false;
		isZero = false;
	}
	/**
	 * operatorShiftFunction is work of shift button
	 */
	public void operatorShiftFunction(){
		if(!sh){
			sh = true;
		}
		else{
			sh = false;
		}
	}
	/**
	 * operatorFunction is work of operator button
	 * @param opString is operator that you print
	 * @param opInteger is number of operator
	 */
	public void operatorFunction(String opString , byte opInteger){
		if(op == 0){
			ina = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		}
		else{
			inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		}

		if(op == 1){
			ina =ina + inb;
		}

		if(op == 2){
			ina = ina - inb;
		}

		if(op == 3){
			ina = ina *inb;
		}

		if(op == 4){
			ina = ina / inb;
		}

		if(op == 5){
			ina = ina * inb / 100;
		}

		this.calculatorUI.textFieldInput.setText("0");
		this.calculatorUI.textFieldShow.setText(String.valueOf(ina) + " "+opString+" ");

		op = opInteger;

		isDot = false;
		isZero = false;

	}
	/**
	 * sinFunction is work of sin button
	 */
	public void sinFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		if(!sh){
			if(!isDegrees){
				this.calculatorUI.textFieldShow.setText("sin(" + inb + ")");
				inb = inb * 0.0174532925;
			}
			out = Math.sin(inb);
		}
		else{
			this.calculatorUI.textFieldShow.setText("sinh(" + inb + ")");
			out = Math.sinh(inb);
		}

		this.calculatorUI.textFieldInput.setText(String.valueOf(out));
		out = 0;
		op = 0;
	}
	/**
	 * cosFunction is work of cos button
	 */
	public void cosFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		if(!sh){
			if(!isDegrees){
				this.calculatorUI.textFieldShow.setText("cos(" + inb + ")");
				inb = inb * 0.0174532925;
			}
			out = Math.cos(inb);
		}
		else{
			this.calculatorUI.textFieldShow.setText("cosh(" + inb + ")");
			out = Math.cosh(inb);
		}

		this.calculatorUI.textFieldInput.setText(String.valueOf(out));
		out = 0;
		op = 0;
	}
	/**
	 * tanFunction is work of tan button
	 */
	public void tanFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		if(!sh){
			if(!isDegrees){
				this.calculatorUI.textFieldShow.setText("tan(" + inb + ")");
				inb = inb * 0.0174532925;
			}
			out = Math.tan(inb);
		}
		else{
			this.calculatorUI.textFieldShow.setText("tanh(" + inb + ")");
			out = Math.tanh(inb);
		}

		this.calculatorUI.textFieldInput.setText(String.valueOf(out));
		out = 0;
		op = 0;
	}
	/**
	 * percentFunction is work of percent button
	 */
	public void percentFunction(){
		ina = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		this.calculatorUI.textFieldInput.setText("0");
		this.calculatorUI.textFieldShow.setText( ina + "%(");

		isDot = false;
		isZero = false;
		op = 5;
	}
	/**
	 * cuberootFunction is work of cuberoot button
	 */
	public void cuberootFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = Math.cbrt(inb);

		this.calculatorUI.textFieldInput.setText(String.valueOf(out));

		this.calculatorUI.textFieldShow.setText("³√" + inb );
		out = 0;
		op = 0;
	}
	/**
	 * cubedFunction is work of cubed button
	 */
	public void cubedFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = inb * inb * inb;

		if(out > -100000000 && out < 100000000){
			this.calculatorUI.textFieldInput.setText(String.valueOf(out));
		}
		else{
			this.calculatorUI.textFieldInput.setText("Error");
		}

		this.calculatorUI.textFieldShow.setText( inb + "³");
		out = 0;
		op = 0;
	}
	/**
	 * squarerootFunction is work of squareroot button
	 */
	public void squarerootFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = Math.sqrt(inb);

		this.calculatorUI.textFieldInput.setText(String.valueOf(out));

		this.calculatorUI.textFieldShow.setText("√" + inb );
		out = 0;
		op = 0;
	}
	/**
	 * onedividedbyxFunction is work of 1/x button
	 */
	public void onedividedbyxFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = 1 / inb;

		if(out > -100000000 && out < 100000000){
			this.calculatorUI.textFieldInput.setText(String.valueOf(out));
		}
		else{
			this.calculatorUI.textFieldInput.setText("Error");
		}
		this.calculatorUI.textFieldShow.setText("1/" + inb );
		out = 0;
		op = 0;
	}
	/**
	 * squarFunction is work of squar button
	 */
	public void squarFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = inb * inb;

		if(out > -100000000 && out < 100000000){
			this.calculatorUI.textFieldInput.setText(String.valueOf(out));
		}
		else{
			this.calculatorUI.textFieldInput.setText("Error");
		}

		this.calculatorUI.textFieldShow.setText( inb + "²");
		out = 0;
		op = 0;
	}
	/**
	 * resetFunction is work of reset button
	 */
	public void resetFunction(){
		this.calculatorUI.textFieldInput.setText("0");
		this.calculatorUI.textFieldShow.setText(null);
		isZero = false;
		isDot = false;
		ina = 0;
		inb = 0;
		out = 0;
	}
	/**
	 * negateFunction is work of negate button
	 */
	public void negateFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = inb * -1;

		if(out > -100000000 && out < 100000000){
			this.calculatorUI.textFieldInput.setText(String.valueOf(out));
		}
		else{
			this.calculatorUI.textFieldInput.setText("Error");
		}
		isDot = true;
		out = 0;
	}
}