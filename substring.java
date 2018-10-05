
import java.util.Scanner;
    
public class substring {
	public  static boolean findSubstring(final String ipStringOne, final String ipStringTwo) {
    		if(ipStringOne == null || ipStringTwo == null || ipStringOne.isEmpty() || ipStringTwo.isEmpty()) {
    			return false;
    		}

    		int one_len = ipStringOne.length();
    		int two_len = ipStringTwo.length();

    		if(two_len > one_len){
    			return false;
    		}

    		int j = 0;
    		for(int i = 0 ; i < one_len ; i++){
    			while(j < two_len && ipStringOne.charAt(i) == ipStringTwo.charAt(j)){
    				i++;
    				j++;
    			}

    			if(two_len == j){
    				return true;
    			}
    			j=0;
    		}

    		
    	 return false;	
    	}

    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		String ipStringOne = reader.nextLine();
		String ipStringTwo = reader.nextLine();

		if(findSubstring(ipStringOne, ipStringTwo)) {
			System.out.println("yup string two is substrig on string one");
		} else {
			System.out.println("not a substring");
		}
	}
}
