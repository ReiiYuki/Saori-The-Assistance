package Saori.Calculator;

public class Calculator{

	private CalculatorUI calculatorUI;
	protected boolean zerodisp;
	protected boolean decdisp;
	protected boolean dgrrad;
	protected boolean sh;
	protected byte op; //operator
	protected double ina;
	protected double inb;
	protected double out;

	public Calculator(CalculatorUI calculatorUI){
		this.calculatorUI = calculatorUI;
	}

	public void numberFuntion(String num){
		if(!zerodisp && !decdisp){
			calculatorUI.textFieldInput.setText(null);
		}
		calculatorUI.textFieldInput.setText(calculatorUI.textFieldInput.getText() + num );
		zerodisp = true;
	}
	public void zeroFuntion(String num){
		if(!zerodisp && !decdisp){
			this.calculatorUI.textFieldInput.setText(null);
		}
		this.calculatorUI.textFieldInput.setText(this.calculatorUI.textFieldInput.getText() + num);
	}
	public void equalsFunfumtion(){
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
		decdisp = false;
		zerodisp = false;
	}
	public void operatorFuntion(String opString , byte opInteger){
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

		decdisp = false;
		zerodisp = false;

	}
	public void sinFuntion(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		if(!sh){
			if(!dgrrad){
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
	public void cosFuntion(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		if(!sh){
			if(!dgrrad){
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
	public void tanFuntion(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		if(!sh){
			if(!dgrrad){
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
	public void percentFintion(){
		ina = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		this.calculatorUI.textFieldInput.setText("0");
		this.calculatorUI.textFieldShow.setText( ina + "%(");

		decdisp = false;
		zerodisp = false;
		op = 5;
	}
	public void cuberootFuntion(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = Math.cbrt(inb);

		this.calculatorUI.textFieldInput.setText(String.valueOf(out));

		this.calculatorUI.textFieldShow.setText("³√" + inb );
		out = 0;
		op = 0;
	}
	public void cubedFuntion(){
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
	public void squarerootFuntion(){
		inb = Double.parseDouble(String.valueOf(this.calculatorUI.textFieldInput.getText()));
		out = Math.sqrt(inb);

		this.calculatorUI.textFieldInput.setText(String.valueOf(out));

		this.calculatorUI.textFieldShow.setText("√" + inb );
		out = 0;
		op = 0;
	}
	public void onedividedbyxFuntion(){
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
	public void squarFuntion(){
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
	public void resetFuntion(){
		this.calculatorUI.textFieldInput.setText("0");
		this.calculatorUI.textFieldShow.setText(null);
		zerodisp = false;
		decdisp = false;
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
		decdisp = true;
		out = 0;
	}
}