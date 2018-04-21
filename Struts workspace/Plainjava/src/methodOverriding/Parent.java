package methodOverriding;

import accessModifiers.AccessModTest;

public class Parent {
	int i;
	static int a;
	static String b;

	static {
		
		System.out.println("s1");
		a = 98;
		
		b = "block 1";
		System.out.println(a + " " + b);
	}
	static {
		System.out.println("s2");
		a = 20;
		b = "block 2";
		System.out.println(a + " " + b);
	}

	public Parent() {
		System.out.println("Parent constructor");
	}

	void color() {
		System.out.println("Parent");
	}

	static void check() {
		System.out.println("Parent check");
	}

	public static void main(String[] args) {
		System.out.println(a + " " + b);
		Parent p = new  Parent();
		p.i=1;
		//We cannot access this object since the class AccessModTest has private constructor
		//AccessModTest amt = new AccessModTest();
	}

}
