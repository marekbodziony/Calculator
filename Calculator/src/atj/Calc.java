package atj;

public class Calc {
	
	private double a = 0;
	private double b = 0;
	private String result;
	private String resultDetails;
	//private String action;
	
	// adding (+)
	public String add(){
		a = a + b;
		return result = "" + a;
	}
	// subtraction (-)
	public String sub(){
		a = b - a;
		return result = "" + a;
	}
	//multiplication (*)
	public String multi(){
		a = a * b;
		return result = "" + a;
	}
	// division (/)
	public String div() throws ArithmeticException{
		a = b / a ;
		result = "" + a;
		return result;
	}
	// change sign (+/-)
	public String changeSign(){
		a *=(-1);
		return result = "" + a;
	}
	// sqrt
	public String sqrt(){
		a = Math.sqrt(a);
		return result = "" + a;
	}
	
	
	// getter
	public double getA() { return a;}
	public double getB() { return b;}
	public String getResult() {return result;}
	public String getResultDetails() { return resultDetails;}
	//public String getAction() { return action;}
	
	// setter
	public void setA(double a) { this.a = a;}
	public void setB(double b) { this.b = b;}
	public void setResult(String result) { this.result = result;}
	public void setResultDetails(String resultDetails) { this.resultDetails = resultDetails;}
	//public void setAction(String action) { this.action = action;}
}
