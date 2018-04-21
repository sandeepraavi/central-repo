
public  class CalculatingPowers {

	double b=0;
	
	double p;
	
	public static double powerCalculator(double b, double p) {
		String myword = "train";

		if (myword == "train") {
			System.out.println("if block");

		} else if(myword == "train") {
			System.out.println("first else if ");

		}
		else if(myword == "train") {
			System.out.println("second else if ");

		}else if(myword == "byk") {
			System.out.println("third else if ");

		}else{
			System.out.println("else block");
		}
		
	 if (p == 0) {
		System.out.println("Entered if for the power 0");

		return 1;
	} else {
		double answer = Math.pow(b, p);
		System.out.println("the value of the power " + b + " to " + p + " is::");
		return answer;
	}
	}
	
	public static void main(String[] args) {

//CalculatingPowers c = new CalculatingPowers();
System.out.println(powerCalculator(9,0.5));
	}
}
