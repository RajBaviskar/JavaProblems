import java.util.Arrays;

public class FindSum{
	public static void findSum(int[] ipArray, int sum) {
		Arrays.sort(ipArray);
		int arrayLength = ipArray.length;
		int left = 0;
		int right = arrayLength-1;

		while(right > left){
			int total = ipArray[left] + ipArray[right];
			if(total == sum){
				System.out.println("Pair is = " + ipArray[left] + " and " + ipArray[right]);
				return;
			}else if(total > sum) {
				right --;
			}else {
				left++;
			}
		}
		System.out.println("No Pair found");
	}
    public static void main(String[] args ) {
		
		// int[] ipArray = {-5, -6 ,-10, 0, 1, -2, -4};
		// findSum(ipArray, 1);

		int[] ipArray = {9,12,10,1,5,11,7,6,4,22,3,14,2,1,8};
		findSum(ipArray, 22);
	}
}