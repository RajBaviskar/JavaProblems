  import java.util.Scanner;

public class StringReverse {
	public static String stringReverse(final String ipString) {
		int strLength = ipString.length();
		String reversed="";
		for(int i = strLength-1; i >= 0; i--){
			reversed += ipString.charAt(i);
		}
		return reversed;
	}
	public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the String = ");
		String ipString = reader.nextLine();
		reader.close();	
		System.out.println(stringReverse(ipString));
	}
}