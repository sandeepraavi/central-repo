package inheritance;

import java.util.Scanner;

class Solution {
    public static void main(String args[] ) throws Exception {
        //initialing int array of size 26
        int arr[] = new int[26];
        //taking input
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //converting string to character array
        char[] chararr = str.toLowerCase().toCharArray();
        //looping over array counting occurances
        for(int  i=0;i<chararr.length;i++){
            if(Character.isLetter(chararr[i])){
            int j = chararr[i]-'a';
            arr[j]++;
            }
        }
        //printing the occurances
        for(int i=0;i<arr.length;i++){
            char c = (char)(i+'a');
            if(arr[i]>=2){
            System.out.print("'"+c+"' ");
            System.out.println(arr[i]);
        }
        }
    }
}

