
    
public class MaxInArray{

	public static int maxInArray(int[] array) {
		int arrayLength = array.length;
	
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int from = 0;
		int to = 0;
		int s = 0;
	
		for(int i = 0; i < arrayLength; i++) {
			sum += array[i];
			if(sum > max) {
				max = sum;
				System.out.println("Max = " + max);
				from = s;
				to = i;
			}else if(sum < 0) {
				sum = 0;
				s = i+1;
			}
		}
	  System.out.println("Max = " + max + "and Range is from " + from + " to " + to);
	  return max;	
	}

    public static void main(String[] args ) {
		//int[] array = {-5, -6 ,-10, 0, 1, -2, -4};
		//int[] array = {-5, -6 ,-10, -2, -4};
		//int[] array = {15, 6 ,-22, 0, 22, -2, -4, 32};
		int[] array = {-5, -6 ,-10, 0, 1, -2, -4};
		//int[] array = {-5, 6 ,10, 0, 1, -2, -4};
		System.out.println(maxInArray(array));
	}
}