package staticDemo;

public class OuterClass {
	private  String str = "Static Str";

	public static class InnerClass {
		public void disp() {

			System.out.println(new OuterClass().str);
		}
	}

	public static void main(String[] args) {
		new OuterClass.InnerClass().disp();

	}

}
