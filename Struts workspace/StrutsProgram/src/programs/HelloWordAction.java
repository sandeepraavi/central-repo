package programs;

public class HelloWordAction {
	private String name;
	private boolean myKey;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args){
		System.out.println("Pls enter the number of lines");
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}*/
		for (int  i = 0; i < 128; i++) {
			System.out.println(i);
		}
	}
}
