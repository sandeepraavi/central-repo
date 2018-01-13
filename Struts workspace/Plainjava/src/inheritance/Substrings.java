package inheritance;

import java.io.IOException;

public class Substrings {

	public static void main(String[] args) throws IOException {

		/*int count = 4;
		StringBuilder sb = new StringBuilder("cokeokec");

		String s1 = sb.toString().substring(0, count);
		String s2 = sb.toString().substring(count, sb.length());
		Pattern p = Pattern.compile(s1);

		Matcher m = p.matcher(s2 + s2);
		while (m.find()) {
			System.out.println(m.start());
		}*/

		String s1 = "coke".toLowerCase();
		String s2 = "keco".toLowerCase();
		if (s1.length() == s2.length()) {
			if (s1.equals(s2)) {
				System.out.println("True");
			} else {
				String snew = s2 + s2;
				int fIndex = snew.indexOf(s1);
				if (fIndex > 0) {
					String part1 = snew.substring(fIndex, s1.length() + fIndex);
					String part2 = snew.substring(0, fIndex);
					String part3 = snew.substring(s1.length() + fIndex, snew.length());
					System.out.println("True " + part1 + "::" + part3 + part2);

				} else {
					System.out.println("False");
				}
			}
		} else {
			System.out.println("False");
		}
	}
}
