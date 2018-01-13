package inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpellChecker {
	public List<String> words = Arrays.asList("phone","pillow","elephant","listen","televison","couch");
	int count=0;
	int index=0;
	private List<String> checker(String s) {
		List<String> sugWords = new ArrayList<String>();
		for (int i = 0; i < words.size(); i++) {
			if (s.equals(words.get(i))) {
				count ++;
			}
		}
		if(count>0){
			System.out.println(sugWords.size());
		}
		else if (count == 0 ){
			Pattern p = Pattern.compile(s);
			for (int i = 0; i < words.size(); i++) {
				Matcher m = p.matcher(words.get(i));
				if(m.find()){
				index = i ;	
				}
			}
			if(index>0){
				sugWords.add(words.get(index));
			}
			
		}
		return sugWords;
	}
	
	public static void main(String[] args) {
		SpellChecker sc = new SpellChecker();
		List<String> x = sc.checker("pillwo");
		 for (int i = 0; i < x.size(); i++) {
			System.out.println(x.get(i));
		}
		
	}

}
