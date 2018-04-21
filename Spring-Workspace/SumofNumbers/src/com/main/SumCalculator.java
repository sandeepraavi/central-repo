package com.main;

import java.util.Scanner;

public class SumCalculator {
	
	

	public static void main(String[] args) {
		int input = 3;// taking the default divider as 3
		int sum=0;
		System.out.println("Enter the divider value");
		Scanner sc = new Scanner(System.in);
		
			try{
				input = sc.nextInt();
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}	
		
		for (int i = 0; i < 1000; i++) {
			if(sum+i<1000 && i%input==0){
				sum=sum+i;
			}
		}
		System.out.println("The value of the sum::"+sum);
	}

}
