import java.util.Scanner;
    
public class PrimeSeries{
	public static boolean isPrime(final int ipNumber) {
		for(int i = 2; i < ipNumber ;i++) {
			if(ipNumber % i == 0) {
				return false;
			}
		}
		return true;
	}
    public static void main(String[] args ) {
    	System.out.print(1);
		for(int i = 2 ; i <= 100 ; i++) {
			if(isPrime(i)) {
				System.out.print("," + i);
			}
		}
	}
}