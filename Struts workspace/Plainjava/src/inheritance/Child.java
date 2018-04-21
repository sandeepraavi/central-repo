package inheritance;

public class Child extends Parent {
	public void ChildMethod() {
		
		System.out.println("Child method");
	}

	public void method() {
		System.out.println("Child Method method");
	}

	public static void main(String[] args) {
		// Child chil = new Parent();
		Child child = new Child();
		Parent par = new Child();
		Parent parent = new Parent();
		// parent.ParentMethod();
		/*child.ParentMethod();
		child.ChildMethod();
		child.method();*/
		par.method();
		//par.method();
		// parent.method();
		// parent.method();
	}

}
