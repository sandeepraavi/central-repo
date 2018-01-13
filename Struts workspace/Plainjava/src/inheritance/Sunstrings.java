package inheritance;

/*please test input/output by entering inputs in the box below.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sunstrings {
    public static void main(String args[] ) throws Exception {
    String thisLine = null;
    StringBuilder sb = new StringBuilder();
    int count=0;
    int counter=0;
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while ((thisLine = br.readLine()) != null) {
           //System.out.println(thisLine);
           count = thisLine.length();
           sb.append(thisLine);
         }
    String str = sb.toString();
    String str1= str.substring(0,count);
    String str2 = str.substring(count);
    
    if(str1.length()==str2.length()){
        if(str1.equals(str2)){
            System.out.println("true");
        }
        else{
           for(int i = 0; i<count;i++){
               for(int j=i;j<count;j++){
                   if(str1.charAt(i)==str2.charAt(j)){
                       counter=counter++;
                       
                       StringBuilder newStr = new StringBuilder(str2);
                       newStr.setCharAt(j, str1.charAt(count-1));
                       str2 = newStr.toString();
                       count--;
                       j--;
                      // str2.charAt(j)=str1.charAt(count-1);
                   }
                   
               }
               if(counter==count){
                       System.out.println("true");
                }
                else{
                       System.out.println("false");
                }
           }
        }
    }
   else{
       System.out.println("false");
   }
   
    }
}