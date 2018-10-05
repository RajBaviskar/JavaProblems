import java.util.Scanner;
    
public class EvenOddArray{
	public static void showArray(final int[] finalArray){

		int size = finalArray.length;
		for(int i = 0; i < size ; i++ ){
			System.out.print(finalArray[i] + ",");
		}
		System.out.println();
	}
    public static void main(String[] args ) {
		Scanner reader = new Scanner(System.in);
		int size = 8;
		int []ArrayOdd = new int[]{1,1,1,1,2,2,2,2};
		int []ArrayEven = new int[]{5,4,5,4,5,4,5,4};

		int swaps = 0;
		int neither = 0;

		for(int i = 0, j = 0; swaps < size/2;) {
			if(ArrayOdd[i]%2 == 0 && ArrayEven[j]%2 == 1) {
				swaps ++;
				int temp = ArrayOdd[i];
				ArrayOdd[i] = ArrayEven[j];
				ArrayEven[j] = temp;
				i++;
				j++;
			} else {

				if(ArrayOdd[i]%2==1){
					i++;
				}

				if(ArrayEven[j]%2==0){
					j++;
				}
			}
		}

		showArray(ArrayOdd);
		showArray(ArrayEven);

	}
}