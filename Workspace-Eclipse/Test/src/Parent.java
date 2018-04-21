import java.util.Scanner;

public class Parent {
	@SuppressWarnings("null")
	public Parent() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter the sentence: ");
		String enteredString = reader.nextLine();
		int count = 0;
		String[] give_array = enteredString.split(" ");
		String[] comapare = new String[give_array.length];
		String[] display_array = new String[give_array.length];
		for (int i = 0; i < give_array.length; i++) {
			comapare[i]=give_array[i];
		}
		for (int i = 0; i < give_array.length; i++) {
			for (int j = 0; j < comapare.length; j++) {
				if (give_array[i] == comapare[j]) {
	                count = count + 1;
	                if (j != -1) {
	                	comapare[j] = " ";
	                }
	            }
			}
			 if (count >= 2) {
				 display_array[i] = give_array[i]+"::"+count;
		            count = 0;
		        }
		        if (count == 1) {
		        	display_array[i] = give_array[i]+"::"+count;
		            count = 0;
		        }
		}		
		for (int i = 0; i < display_array.length; i++) {
			System.out.println(display_array[i]);
		}
		
	}

	public void testMethod() {
		System.out.println("Parent method");
	}

	public static void main(String[] args) {
		new Parent();
	}

}
