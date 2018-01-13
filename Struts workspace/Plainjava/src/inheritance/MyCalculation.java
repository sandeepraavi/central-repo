package inheritance;

public class MyCalculation extends Calculation{

	public MyCalculation() {
	System.out.println("Child Constructor");
	}
	public int multiply(int a, int b){
		int mul=a*b;
		return mul;
	}
	public void myMethod(){
		System.out.println("asd");
	}
	public static void main(String[] args) {
		MyCalculation myCalculation = new MyCalculation();//child object and has 
		//access to all the methods from both parent and child.
		/*MyCalculation cal = new MainClass();*/
		/*System.out.println(myCalculation.add(1, 2));
		myCalculation.subtarct(5, 4);
		myCalculation.multiply(25, 65);*/

	}

}
