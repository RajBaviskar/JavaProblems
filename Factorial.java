import java.util.Scanner;
    
public class Factorial{
	public static int factorialSeq(int input) {
		int result = 1;
		if(input == 0 ) {
			return 1;
		}
		while(input != 1) {
			result = result * input;
			input--;
		}
	  return result;
	}

	public static int factorialRec(int input) {
		if(input == 1 || input == 0) {
			return 1;
		}

		return input * factorialRec(input-1);
	}

    public static void main(String[] args ) {

		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		System.out.println(factorialSeq(input));
		System.out.println(factorialRec(input));
	}
}