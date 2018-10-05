/*
	find if string's sustring has palindrom or not
	this solution workd in on^3 
*/
import java.util.Scanner;


public class SubstringPalindrom{

	public static boolean isPalindrome(String ipString) {
		if(ipString == null || ipString.isEmpty()){
			return false;
		}
		String ipStringNew = ipString.replaceAll("[^a-zA-Z0-9\\s+]", "");
		String ipStringNoSpace = ipStringNew.replaceAll("\\s+","");
	
		int strLength = ipStringNoSpace.length();
		if(strLength == 1) {
			return false;
		}

		for(int i = 0 ; i < strLength/2 ; i++) {
			if( Character.toLowerCase(ipStringNoSpace.charAt(i)) == 
				Character.toLowerCase(ipStringNoSpace.charAt(strLength-1-i)) ) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void checkSubStringPalindrom(String ipString){
		if (ipString == null || ipString.isEmpty()) {
			return;
		}

		int ipStringLength = ipString.length();
		for( int i = ipStringLength-1; i >=0 ; i--){
			for(int j = 0; j < ipStringLength-1 ; j++) {
				if( i == j){
					break;
				}
				String str = ipString.substring(j, i);
				if(isPalindrome(str)) {
					System.out.println("Palindrom string = " + str);
				}
			}
		}
		return;
	}

    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		String ipString = reader.nextLine();
		checkSubStringPalindrom(ipString);
	}
}