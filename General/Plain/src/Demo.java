import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
String sample = sc.nextLine();
String response = "";
for (int i = sample.length()-1; i >=0 ; i--) {
	response = response+ sample.charAt(i);
}

System.out.println(response);
	}

}
