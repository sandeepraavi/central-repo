package inheritance;

public class Parent {
	 public void ParentMethod() {
		System.out.println("Parent Method");
	}

	public void method() {
		System.out.println("Parent Method method");
	}

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.ParentMethod();

	}

}
