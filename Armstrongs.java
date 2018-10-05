import java.util.Scanner;
    
public class Armstrongs{
	public static int cube(int ipNumber) {
		boolean negative = false;
		if(ipNumber < 0) {
			negative = true;
		}

		int result = 1;
		for(int i = 0; i < 3; i++) {
			result *= ipNumber;
		}

		return result;
	}

	public static void armstrongs(int ipNumber) {
		int number = ipNumber;
		int result = 0;
		while (number > 0) {
			int eachNum = number%10;
			number = number/10;
			result += cube(eachNum);
		}

		if(result == ipNumber) {
			System.out.println("This is Armstrongs Number");
			return;
		}

		System.out.println("This is Not Armstrongs Number");
		return;
	}

    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		int ipNumber = reader.nextInt();
		System.out.println("Input Number = " + ipNumber);
		armstrongs(ipNumber);
	}
}