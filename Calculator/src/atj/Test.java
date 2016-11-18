package atj;

public class Test {

	public static void main(String[] args) {

		try{
			double a = test();
			System.out.println(a);
		}
		catch (ArithmeticException e){
			System.out.println("ERR");
		}
		
		//System.out.println(a);
	}
	
	public static double test() throws ArithmeticException{
		double a = 4 / 0;
		return a;
	}

}
