import java.util.Scanner;
    
public class RomanToInteger {
	public static int symbol_I() {
		return 1;
	}

	public static int symbol_V() {
		return 5;
	}

	public static int symbol_X() {
		return 10;
	}

	public static int symbol_L() {
		return 50;
	}

	public static int symbol_C() {
		return 100;
	}

	public static int symbol_D() {
		return 500;
	}

	public static int symbol_M() {
		return 1000;
	}

	public static int getValue(Character c) {
		switch(c) {
			case 'I':
				return symbol_I();
			case 'V':
				return symbol_V();
			case 'X':
				return symbol_X();
			case 'L':
				return symbol_L();
			case 'C':
				return symbol_C();
			case 'D':
				return symbol_D();
			case 'M':
				return symbol_M();
			default:
				break;				
		}
		return -1;
	}

	public static int getInteger(String ipString) {
		int stringLength = ipString.length();
		int result = 0;
		for(int i = 0; i < stringLength; i++) {
			int currentValue = getValue(ipString.charAt(i));
			if( i+1 < stringLength && currentValue < getValue(ipString.charAt(i+1))) {
				result -= currentValue;
			} else {
				result += currentValue;
			}	
		}
		return result;
	}


    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		String ipString = reader.nextLine();
		System.out.println(getInteger(ipString));
	}
}