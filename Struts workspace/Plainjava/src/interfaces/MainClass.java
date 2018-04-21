package interfaces;

import inheritance.MyCalculation;

public class MainClass extends MyCalculation implements InterfaceClass, SecondInterface {

	public MainClass() {
	System.out.println("Main class constructor");
	}
	public static void main(String[] args) {
		/*MyCalculation mycal = new MainClass();
		mycal.myMethod();*/
	}
	public int multiply(int a, int b) {
		int c = a*b;
		return c;
	}
	public int addition(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
