import java.util.Scanner;
    
public class prime{
	public static boolean isPrime(final int ipNumber) {
		for(int i = 2; i < ipNumber ;i++) {
			if(ipNumber % i == 0) {
				return false;
			}
		}
		return true;
	}
    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		int ipNumber = reader.nextInt();
		if(isPrime(ipNumber)){
			System.out.println("This is a Prime Number");
		} else {
			System.out.println("This is not a Prime Number");
		}
	}
}