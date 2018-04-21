package inheritance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Removeduplicates {

	public static void main(String[] args) {
		String carString = "Audi,BMW,Audi,Merc,Alpha,BMW";
		String[] carArray = carString.split(",");
		Set<String> mySet = new HashSet<String>(Arrays.asList(carArray));
		for (Iterator iterator = mySet.iterator(); iterator.hasNext();) {
			System.out.println((String) iterator.next());
			
		}
		/*String[] carArray = {"Audi","BMW","Audi","Merc","Alpha","BMW"};*/
		/*int Alength = carArray.length;
		for (int i = 0; i < Alength; i++) {
			for (int j = i+1; j < Alength; j++) {
				if(carArray[i].equals(carArray[j])){
					carArray[j]=carArray[Alength-1];
					Alength--;
					j--;
				}
			}
		}
		String[] newCars = Arrays.copyOf(carArray, Alength);
		for (int i = 0; i < newCars.length; i++) {
			System.out.print(newCars[i]+"\t");
		}*/

	}

}
