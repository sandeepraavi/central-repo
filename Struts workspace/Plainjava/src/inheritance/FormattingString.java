package inheritance;

public class FormattingString{
    public static void main(String args[] ) throws Exception {
    
    //Storing the string in a StringBuilder
    
   /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while ((thisLine = br.readLine()) != null) {
        //appending the inouts (if multiple inputs to the StringBuilder)
            sb.append(thisLine);
         }*/
        //Storing the input in a String variable and initially converting every character to lower case. 
        String str = "THis_is_the_give__string".toLowerCase(); 
        // replcing every character other that letters and numbers with Space
        String s1 = str.replaceAll("[^a-zA-Z0-9]"," ");
        //Replacing multiple spaces with single space.
        s1=s1.trim().replaceAll("\\s{2,}"," ");
        //Splitting the string with a space and storing in a string array.
        String[] sArr = s1.split(" ");
        StringBuffer sbuf = new StringBuffer();
        /*Iterating through the array and changing each first character of the each word to uppercase and appending to a StringBuffer and converting it to string and printing it at the end.*/
        for(int i =0; i<sArr.length;i++){
            sbuf.append(Character.toUpperCase(sArr[i].charAt(0))).append(sArr[i].substring(1)).append(" ");
        }
        String result = sbuf.toString();
        System.out.println(result);
     }
}