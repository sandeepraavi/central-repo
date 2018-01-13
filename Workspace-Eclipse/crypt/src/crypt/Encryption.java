package crypt;

	import java.util.Scanner;

	public class Encryption {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			      Encryption en = new Encryption();
	                Scanner sc = new Scanner(System.in);
	                System.out.println("Enter the Key in Caps");
			        String key = sc.nextLine();
			        System.out.println("Enter the String to Encrypt");
			        String ori = sc.nextLine();
			        String enc = en.encrypt(ori, key);
			        System.out.println(enc);
			        System.out.println(en.decrypt(enc, key));
			    }
			 
			     String encrypt(String text, String key) {
			        String res = "";
			        text = text.toUpperCase();
			        for (int i = 0, j = 0; i < text.length(); i++) {
			            char c = text.charAt(i);
			            if (c < 'A' || c > 'Z') continue;
			            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
			            j = ++j % key.length();
			        }
			        return res;
			    }
			 
			     String decrypt(String text, String key) {
			        String res = "";
			        text = text.toUpperCase();
			        for (int i = 0, j = 0; i < text.length(); i++) {
			            char c = text.charAt(i);
			            if (c < 'A' || c > 'Z') continue;
			            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
			            j = ++j % key.length();
			        }
			        return res;
			    }
			
		

	}



