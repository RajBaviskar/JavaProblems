import java.util.Scanner;

/* check is givent string is palindrom or not
   This handles spaces, special characters
   example ip -:
   				Dammit, I’m Mad!
   				a man a plan a canal-panama 
*/

public class Palindrome {
	public static boolean isPalindrome(String ipString) {
    		if(ipString == null || ipString.isEmpty()){
    			return false;
    		}
    		String ipStringNew = ipString.replaceAll("[^a-zA-Z0-9\\s+]", "");
    		String ipStringNoSpace = ipStringNew.replaceAll("\\s+","");
			System.out.println(ipStringNoSpace);

			int strLength = ipStringNoSpace.length();
			if(strLength == 1) {
				return false;
			}
			
			for(int i = 0 ; i < strLength/2 ; i++) {
				if( Character.toLowerCase(ipStringNoSpace.charAt(i)) == 
				    Character.toLowerCase(ipStringNoSpace.charAt(strLength-1-i)) ) {
					continue;
				} else {
					System.out.println(ipStringNoSpace.charAt(i) + "---" + ipStringNoSpace.charAt(strLength-1-i));
					return false;
				}
			}

			return true;
    	}

    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		String ipString = reader.nextLine();

		if(isPalindrome(ipString)) {
			System.out.println("Its a Palindrome");
		} else {
			System.out.println("Its not a Palindrome");
		}
	}
}