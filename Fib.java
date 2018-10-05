import java.util.Scanner;
    
public class Fib{
	public static void fibSeq(int input) { 
		int cur = 0;
		int next = 1;

		if(input <= 0){
			System.out.println("enter valid term");
			return;
		} 

		if(input == 1){
			System.out.println(cur);
			return;
		} 

		if(input == 2){
		  System.out.print(cur + "->" + next);
		  return;
		}

		int result = 0;
		System.out.print(cur + "->" + next + "->");
		for(int i = 0; i < input - 2; i++) {
			result = cur + next;
			System.out.print(result + "->");
			cur = next;
			next = result;
		}
		System.out.println();
	}

	public static int fibRec(int input) {

		if(input <= 0){
			return 0;
		} else if(input == 1){
			return 1;
		} 
		return fibRec(input - 1) + fibRec (input - 2);
	} 

    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		fibSeq(input);
		System.out.println(fibRec(input));
	}
}