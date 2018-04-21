package inheritance;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PrintDoubles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int count = 0;
		// Replacing every other char except letters with an empty space.
		String s1 = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
		Set<Character> uniElmnts = new HashSet<Character>();
		for (int i = 0; i < s1.length(); i++) {
			uniElmnts.add(s1.charAt(i));
		}
		for (Iterator iterator = uniElmnts.iterator(); iterator.hasNext();) {
			char check = (Character) iterator.next();
			for (int i = 0; i < s1.length(); i++) {
				if (check == s1.charAt(i)) {
					count++;
				}
			}
			System.out.println("'" + check + "'" + " " + count);
			count = 0;
		}
		sc.close();
	}

}
