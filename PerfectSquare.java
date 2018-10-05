import java.util.Scanner;
    
public class PerfectSquare {
	public static int checkSquare(int ipNumber) {
		int sum = 0;
		while(ipNumber > 0) {
			int remainder = ipNumber % 10;
			sum += remainder;
			ipNumber = ipNumber/10;
		}
		if(sum == 1 || sum == 4 || sum == 7 || sum == 9) {
			System.out.println("Numbers is perfect Square");
		}
		return sum;
	}
	public static void checkPerfectSquare(int ipNumber) {
		int sum = 0;
		if(ipNumber < 0) {
			ipNumber = ipNumber * -1;
		}
		sum = checkSquare(ipNumber);
		while(sum/10 > 0){
			sum = checkSquare(sum);
			System.out.println(sum);
		}
	}


    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		int ipNumber = reader.nextInt();
		checkPerfectSquare(ipNumber);
	}
}