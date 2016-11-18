package atj;

public class Calc {
	
	private float a = 0;
	private float b = 0;
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
	// change sign (+/-)
	public String changeSign(){
		float cs = Float.parseFloat(result);
		return result = "" + (cs*(-1));
	}
	
	// getter
	public float getA() { return a;}
	public float getB() { return b;}
	public String getResult() {return result;}
	public String getResultDetails() { return resultDetails;}
	//public String getAction() { return action;}
	
	// setter
	public void setA(float a) { this.a = a;}
	public void setB(float b) { this.b = b;}
	public void setResult(String result) { this.result = result;}
	public void setResultDetails(String resultDetails) { this.resultDetails = resultDetails;}
	//public void setAction(String action) { this.action = action;}
}
