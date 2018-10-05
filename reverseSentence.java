/*
	This is to reverse the sentense 
	example -: Hi I am here.
	op -: ereh ma I ih
*/

import java.util.Scanner;
import java.util.ArrayList;
    
public class reverseSentence {
	public static void reverseSentense(final String ipString) {

		if(ipString == null || ipString.isEmpty()) {
			return;
		}

		ArrayList<Character> sentenseArray = new ArrayList<Character>();
		int ipStringLength = ipString.length();
		for (int i = 0; i < ipStringLength; i++) {
			sentenseArray.add(ipString.charAt(i));
		} 
		String op = "";
		for(int i = sentenseArray.size() - 1; i >= 0; i--) {
			op += sentenseArray.get(i);

		}

		System.out.println("Reversed String is = " + op);
	}
    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		String ipString = reader.nextLine();
		reverseSentense(ipString);
	}
}