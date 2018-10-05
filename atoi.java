import java.util.Scanner;

public class atoi {
	public static int my_atoi(String ip_string) {
		boolean isNegative = false;
		int result = 0;
		for(char c : ip_string.toCharArray()){

			if(c == '-'){
				isNegative = true;
				continue;
			}
			int value_of_char = (int)c;
			if(value_of_char <= 47 || value_of_char >= 58) {
				return -1;
			} else {
				result = result * 10 + value_of_char - '0';
			}
		}

		if(isNegative) {
			result = result * -1;
		}

		return result;
	}

    public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String ip_string = reader.nextLine();
		int result = my_atoi(ip_string);
		if(result == -1) {
			System.out.println("Enter valid number");
		} else {
			System.out.println(result);
		}	
	}
}
	