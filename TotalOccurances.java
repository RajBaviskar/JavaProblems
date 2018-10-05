/* Total occurances of charachter in the string 
example -: rajeshrakesh r = 2
*/


import java.util.Scanner;
import java.util.Arrays;
    
public class TotalOccurances{

	public static void totalOccurances(final String ipString) {

		if(ipString == null || ipString.isEmpty()) {
			return;
		}

		int totalSize = 256;
		int stringLength = ipString.length();
		int[] totalOccurance = new int[totalSize];
		Arrays.fill(totalOccurance, 0);
		for(int i = 0; i < stringLength; i++) {
			totalOccurance[(int)(ipString.charAt(i))]++;
		}

		for(int i = 0; i < stringLength ;i++) {
			int total = (int)(ipString.charAt(i));
			if(totalOccurance[total] != 0) {
				System.out.println("character = " + ipString.charAt(i) + "   occurances = " + totalOccurance[total]);
				totalOccurance[(int)(ipString.charAt(i))] = 0;
			}
		}
	}

    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		String ipString = reader.nextLine();

		totalOccurances(ipString);

	}
}