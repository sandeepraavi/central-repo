package newefw;
import java.util.Scanner;

	/**
	 * CaesarCipherAttack class is used to Encrypt or Decrypt the given text using Caesar Cipher
	 * @author sxd36000
	 */
	public class CaesarCipherAttack {

	  public static final String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyz"; 

	    public static void main(String[] args)
	    {
	        Scanner sc = new Scanner(System.in);
	        String message = new String();
	        Scanner in = new Scanner(System.in); 
	        System.out.println("Enter Input String without special characters and space for CaesarCipher Attack Encryption : "); 
	        // Reading the text value from the console
	        message = sc.next();
	        System.out.println("Enter the lenght of shiftKeyLength in numbers: "); 
	        // Reading the lenght of the shift key to be used in the caesar cipher
	        int shiftKeyLength = in.nextInt();   
	        
	        // convert text value from console to lower case english alphabtes
	        String inputText = message.toLowerCase();
	        String cipherText = "";        
	        
	        for (int i = 0; i < inputText.length(); i++)
	        {
	            int charPosition = ENGLISH_ALPHABET.indexOf(inputText.charAt(i));
	           
	            int keyValue = (shiftKeyLength + charPosition) % 26;
	            char replaceValue = ENGLISH_ALPHABET.charAt(keyValue);
	            cipherText += replaceValue;
	        }

	        System.out.println("encryptCaesarCipher Message : "+cipherText);
	        
	        String plainText = "";
	        for (int i = 0; i < cipherText.length(); i++)    {
	            int charPosition = ENGLISH_ALPHABET.indexOf(cipherText.charAt(i));
	             // logic for caesar cipher attack Decryption
	            int keyValue = (charPosition - shiftKeyLength) % 26;
	            if (keyValue < 0)
	            {
	                keyValue = ENGLISH_ALPHABET.length() + keyValue;

	            }
	            char replaceValue = ENGLISH_ALPHABET.charAt(keyValue);
	            plainText += replaceValue;

	        }
	        System.out.println("DecryptCaesarCipher Message : "+plainText);
	        
	        // closing scanner reader
	        sc.close();
	        in.close();
	    }
	}
	    
