import java.util.ArrayList;
import java.util.Scanner;


public class NannakuPrematho {

	/**
	 * circle of 100 members 
	 * 1 kills 2 and hands over the sword to 3
	 * 3 kills 4 and to 5
	 * 5 kills 6 and to 7
	 * only one will survive at last 
	 * what is the number surviving?
	 * @param args
	 */
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	
	private int i=0;
	int lastIndex;
	
	public ArrayList<Integer> getArrayList() {
		return arrayList;
	}
	public void setArrayList(ArrayList<Integer> arrayList) {
		this.arrayList = arrayList;
	}

	public int jagguBhai(int a){
		
		for (int i = 1; i <= a; i++) {
			arrayList.add(i);
		}
		while(arrayList.size()!=1){
			
			 lastIndex = arrayList.size()-1;
			if(i==lastIndex){
				arrayList.remove(0);
				i=0;
			}
			else if(i==lastIndex-1){
				arrayList.remove(lastIndex);
				i=0;
			}
			else{
				arrayList.remove(i+1);
				i++;
			}
		}
		System.out.println(arrayList);
		
		return arrayList.size();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			NannakuPrematho prematho = new NannakuPrematho();
			System.out.println(prematho.jagguBhai(sc.nextInt()));
		}
		
	}
}
