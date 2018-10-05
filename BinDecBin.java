import java.util.Scanner;

public class BinDecBin {

	// Helper function
	public static long totalDigits(String num) {
 		long totalDigits = 0;
 		for(char c : num.toCharArray()){
 			totalDigits++;
 		}
 		return totalDigits;
 	}

 	// Helper function
 	public static long power(long num, long power) {
 	
 		if(power == 0){
 			return 1;
 		}
 		
 		if(power == 1) {
 			return num;
 		}

 		long result = num;
 		while(power != 1 ) {
 		  result = result * num;
 		  power--; 	
 		}
 		return result;
 	}

 	// Helper function
 	public static String stringReverse(final String ipString) {
		int strLength = ipString.length();
		String reversed="";
		for(int i = strLength-1; i >= 0; i--){
			reversed += ipString.charAt(i);
		}
		return reversed;
	}

	public static void binToDec(String number) {
		long dec = 0;
		long totalDigits = totalDigits(number);
		for(char c : number.toCharArray()){
			long x = Character.getNumericValue(c);
			dec = dec + (x * power(2,totalDigits-1));
			totalDigits--;
		}
		System.out.println("Dec = " + dec);
	}

	public static String decToBin(String number) {
		boolean negativeNumber= false;
		String Binary = "";

		if(number.charAt(0) == '-'){
			negativeNumber = true;
	 	}

		long num = Long.parseLong(number);
		if(negativeNumber) {
			num = num * -1;
		}
		
		if(num == 0) {
			Binary =  "0";

			if(negativeNumber) {
				Binary = "-" + Binary;
			}
		    return Binary;	 
		}

		if(num == 1) {
			Binary =  "1";

			if(negativeNumber) {
				Binary = "-" + Binary;
			}
		    return Binary;	 
		}

		long remainder = 0; 
		while(remainder != 1) {
			remainder = num/2; 
			Binary += num%2; 
			num = remainder;
		}

		Binary += remainder;
		Binary = stringReverse(Binary);
		
		if(negativeNumber) {
			Binary = "-" + Binary;
		}

		return Binary;
	}

	public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number = ");
		String number = reader.nextLine();
		reader.close();
		//binToDec(number);
		System.out.println("Binary = " + decToBin(number));
	}
}