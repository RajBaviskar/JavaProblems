import java.util.Scanner;

public class Powers {

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
    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number and power = ");
		int number = reader.nextInt();
		int power = reader.nextInt();
		System.out.println(power(number, power));
		reader.close();
	}
}