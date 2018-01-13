
public class Child extends Parent {
	enum FreshJuiceSize{ SMALL, MEDIUM, LARGE }
	   FreshJuiceSize size;
	
	public Child() {
		System.out.println("Child constructor");
	}

	public String childTest() {
		System.out.println("Test method in child");
		return "";
	}

	public static void main(String[] args) {
		//new Child();
		/*Parent parent = new Child();
		parent.testMethod();*/
		Parent p = new Parent();
	Parent pp= new Child();
		Child child = new Child();
		//child.testMethod();
		child.size = Child.FreshJuiceSize.LARGE ;
	      System.out.println("Size: " + child.size);
	}

}
