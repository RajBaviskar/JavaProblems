 import java.util.Scanner;

 public class TotalDigits {
 	public static int totalDigits(String num) {
 		int totalDigits = 0;
 		for(char c : num.toCharArray()){
 			totalDigits++;
 		}
 		return totalDigits;
 	}
 public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number = ");
		String number = reader.nextLine();
		reader.close();
		System.out.println(totalDigits(number));
	}
}
	
	