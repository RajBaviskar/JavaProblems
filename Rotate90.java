import java.util.Scanner;
    
public class Rotate90{
	
	pubic static vois showArray(final int[][] originalArray) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(originalArray[i][j] + " - ");
			}
			System.out.println();
		}
	}

    public static void main(String[] args ) {
		//Scanner reader = new Scanner(System.in);
		int [][]originalArray = new int[3][3];
		int data = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				originalArray[i][j] = data;
				data ++;
			}
		}

		// Show array
		showArray(originalArray);
	}
}