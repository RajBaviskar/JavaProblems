import java.util.Scanner;
    
public class RotateNinty{
	
	public static void showArray(final int[][] originalArray, int rs, int cs) {
		System.out.println("############");
		for(int i = 0; i < rs; i++) {
			for(int j = 0; j < cs; j++) {
				System.out.print(originalArray[i][j] + " - ");
			}
			System.out.println();
		}
	}

	public static int[][] rotate90(int [][] originalArray, int rs, int cs) {

		int temp;
		int len = cs;
		for(int i = 0; i < len/2 ; i++) {
			for( int j = 0; j < len - 2 * i - 1; j++) {
				temp = originalArray[i][i+j];
				originalArray[i][i + j] = originalArray[len-i-j-1][i];
				originalArray[len-i-j-1][i] = originalArray[len-i-1][len-i-j-1];
				originalArray[len-i-1][len-i-j-1] = originalArray[i+j][len-i-1];
				originalArray[i+j][len-i-1] = temp;
			}
		}
		return originalArray;
	}

    public static void main(String[] args ) {
		int data = 1;
		int rs = 5;
		int cs = 5;
		int [][]originalArray = new int[rs][cs];
		

		for(int i = 0; i < rs; i++) {
			for(int j = 0; j < cs; j++) {
				originalArray[i][j] = data;
				data ++;
			}
		}

		// Show array
		showArray(originalArray,rs,cs);
		showArray(rotate90(originalArray,rs,cs),rs,cs);
	}
}