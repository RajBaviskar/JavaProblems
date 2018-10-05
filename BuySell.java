import java.util.Scanner;
    
public class BuySell {
	public static int maxProfit(int[] ipArray) {
		int max = 0;
		int arrayLength = ipArray.length;
		if(arrayLength == 0) {
			return 0;
		}
		int i = 0;
		int peek = ipArray[0];
		int valley = ipArray[0];
		while(i < arrayLength - 1) {

			while(i < arrayLength - 1 && ipArray[i] >= ipArray[i + 1]) {
				i++;
			}
			valley = ipArray[i];

			while(i < arrayLength - 1 && ipArray[i] <= ipArray[i + 1]) {
				i++;
			}
			peek = ipArray[i];
			max += peek - valley; 
		}
		return max;
	}
    public static void main(String[] args ) {
		int[] ipArray = {};
		System.out.println(maxProfit(ipArray));
	}
}