package Saori.Calculator;

public class Calculator{

	private CalculatorUI calculatorUI;
	protected boolean isZero ;
	protected boolean isDot ;
	protected boolean isDegrees ;
	protected boolean sh ; //shift
	protected byte op ; //operator
	protected double ina ;
	protected double inb ;
	protected double out ;

	public Calculator(CalculatorUI calculatorUI){
		this.calculatorUI = calculatorUI;
	}

	public void numberFunction(String num){
		if(!isZero && !isDot){
			calculatorUI.textFieldInput.setText(null);
		}
		calculatorUI.textFieldInput.setText(calculatorUI.textFieldInput.getText() + num );
		isZero = true;
	}
	public void zeroFunction(String num){
		if(!isZero && !isDot){
			this.calculatorUI.textFieldInput.setText(null);
		}
		this.calculatorUI.textFieldInput.setText(this.calculatorUI.textFieldInput.getText() + num);
	}
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
	public void operatorShiftFunction(String opString , byte opInteger){
		if(op == 0){
			ina = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText().substring(0, this.calculatorUI.textFieldInput.getText().length()-1)));
		}
		else{
			inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText().substring(0, this.calculatorUI.textFieldInput.getText().length()-1)));
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
	public void percentFunction(){
		ina = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		this.calculatorUI.textFieldInput.setText("0");
		this.calculatorUI.textFieldShow.setText( ina + "%(");

		isDot = false;
		isZero = false;
		op = 5;
	}
	public void cuberootFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = Math.cbrt(inb);

		this.calculatorUI.textFieldInput.setText(String.valueOf(out));

		this.calculatorUI.textFieldShow.setText("³√" + inb );
		out = 0;
		op = 0;
	}
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
	public void squarerootFunction(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = Math.sqrt(inb);

		this.calculatorUI.textFieldInput.setText(String.valueOf(out));

		this.calculatorUI.textFieldShow.setText("√" + inb );
		out = 0;
		op = 0;
	}
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
	public void resetFunction(){
		this.calculatorUI.textFieldInput.setText("0");
		this.calculatorUI.textFieldShow.setText(null);
		isZero = false;
		isDot = false;
		ina = 0;
		inb = 0;
		out = 0;
	}
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