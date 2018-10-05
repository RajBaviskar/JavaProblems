/* check is givent string is totated will any version of those rotations be a palindrom
   example ip -:
   				exit -> rotation -> texi -> palindrom -> no
   				aaaab -> rotaion -> aabaa -> palindrom -> yes
*/

import java.util.Scanner;

public class RotationPalindrom {

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

	public static boolean checkRotationPalindrom(String ipString) {
		if(ipString == null || ipString.isEmpty()){
			return false;
		}
		int strLength = ipString.length();

		if(strLength == 1){
		return false;
		}

		for(int i = 0; i <  strLength; i++) {
			String str1 = ipString.substring(i+1);
			String str2 = ipString.substring(0,i+1);

			if(isPalindrome(str1 + str2)) {
				return true;
			} else {
				continue;
			}
		}

		return false;
	}

	public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		String ipString = reader.nextLine();
		if(checkRotationPalindrom(ipString)) {
			System.out.println("Rotation of this String has palindrom");
		} else {
			System.out.println("Rotation of this String has no palindrom");
		}
	}
} 				