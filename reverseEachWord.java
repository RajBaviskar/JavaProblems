/* reverse the word 
	ip-: Hi I am here 
	op-: iH I ma ereh
*/

import java.util.Scanner;
import java.util.ArrayList;
    
public class reverseEachWord {
	public static String reverse(final String word) {
		
		if(word == null || word.isEmpty()) {
			return null;
		}

		int len = word.length();
		char[] newWordArray = word.toCharArray();

		for(int i = 0; i < len; i++,len--) {
			char temp = newWordArray[len-1];
			 newWordArray[len-1] = newWordArray[i];
			 newWordArray[i] = temp;
		}
		String op = "";
		int newWordArrayLength = newWordArray.length;
		for(int i = 0; i < newWordArrayLength; i++) {
			op += newWordArray[i];
		}
		return op;
	}
	public static void reverseEachWord(final String ipString) {
		if(ipString == null || ipString.isEmpty()) {
			return;
		}

		String[] splitedSentence = ipString.split("\\s+");

		String op = "";
		int arrayLength = splitedSentence.length;
		for(int i = 0; i < arrayLength ; i++){
			op += reverse(splitedSentence[i]);
		}

		System.out.println("Reversed Is = " + op);

	}
    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		String ipString = reader.nextLine();
		reverseEachWord(ipString);
	}
}
