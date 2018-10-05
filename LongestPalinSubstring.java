
import java.util.Scanner;

public class LongestPalinSubstring {

	public static void printSubstring(String str, int start, int end) {
		System.out.println(str.substring(start,end));
	}

	public static void longestPalinSubstring(String ipString) {
		if(ipString == null && ipString.isEmpty()) {
			return;
		}

		int start = 0;
		int maxlength = 0;
		int low = 0;
		int high = 0;

		int ipStringlength = ipString.length();
		for(int i = 1 ; i < ipStringlength ; ++i) {

			low = i - 1;
			high = i;
			while(low >= 0 && high < ipStringlength &&
				  ipString.charAt(low) == ipString.charAt(high)) {
				if(high - low + 1 > maxlength) {
               		start = low;
               		maxlength = high - low + 1;
            	}
				--low;
				++high;
			}
				
			low = i - 1;
			high = i + 1;

			while(low >= 0 && high < ipStringlength &&
				  ipString.charAt(low) == ipString.charAt(high)) {
				if(high - low + 1 > maxlength) { 
					start = low;
					maxlength = high - low + 1;
				}
				--low;
			    ++high;
			}
		}

		printSubstring(ipString,start, start + maxlength);
	}

    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		String ipString = reader.nextLine();
		longestPalinSubstring(ipString);
	}
}