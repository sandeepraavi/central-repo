package inheritance;

import java.util.Scanner;

public class A {
	int power(int a, int b)throws Exception{
		if(a<0 || b<0){
			throw new Exception();
		}
		return (b==0)?1:a*power(a,b-1);
	}
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	A m= new A();
	int x;
	while(sc.hasNext()){
		try{
			x= m.power(sc.nextInt(),sc.nextInt());
			System.out.println(x);
		}
		catch(Exception e){
			System.out.println("Caught Exception");
		}
	}
	
	}

}
