package inheritance;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Calculation {
	public Severity ss;
	public Calculation() {//Constructor
		System.out.println("Parent constructor");
	}

	public int add(int a, int b){
		int add = a+b;
		Severity aa = ss.high;
		return add;
	}
	public int subtarct(int a, int b){
		int sub = a-b;
		return sub;
	}
	public static void main(String[] args) {
		String s = "sandeep";
		for (int i = 0; i <= s.length()-1; i++) {
			System.out.println(s.charAt(i));
		}
				
		int i=0;
		int sum = 0;
		for ( i = 0; i <=5;sum+= i++) {
			System.out.println("Sum: "+sum);
		} 
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "Sandeep");
		hm.put(2, "Praveen");
		hm.put(3, "Ganesh");
		hm.put(4, "Vihari");
		hm.put(5, "Vamsi");
		for(String key:hm.values()){
			System.out.println(key);
		}
		/*Set set = hm.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()){
			Map.Entry me = (Map.Entry) i.next();
			System.out.println("Keys :"+me.getKey());
			System.out.println("Values :"+me.getValue());
		}*/
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		String a = "816 207 7272";
		String b = "";
		/*for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i) >= 48 && a.charAt(i)<=57){
				 b= b+a.charAt(i);
			}	
		}*/
		
		System.out.println("This is the"+b);
	}
}
