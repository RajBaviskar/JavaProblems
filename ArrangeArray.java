
    
public class ArrangeArray{
	
	// this is o(n^2)
	// public static void arrangeArray(int[] ipArray) {
	// 	int arrayLength = ipArray.length;
	// 	int i = 0; 
	// 	while (i < arrayLength) {
	// 		if(ipArray[i] == 0){
	// 			for(int j = i+1; j < arrayLength ;j++){
	// 				if(ipArray[j] == 0) {
	// 					continue;
	// 				}else {
	// 					int temp = ipArray[j];
	// 					ipArray[j] = ipArray[i];
	// 					ipArray[i] = temp;
	// 					break;
	// 				}
	// 			}
	// 		}
	// 		i++;
	// 	}

	// 	for(i = 0; i < arrayLength; i++) {
	// 		System.out.println(ipArray[i]);
	// 	}
	// }

	// this o(n)
	public static void arrangeArray(int[] ipArray) {
		int arrayLength = ipArray.length;

		int count = 0;

		for(int i = 0; i < arrayLength; i++) {
			if(ipArray[i] != 0) {
				ipArray[count] = ipArray[i];
				count++; 
			}	
		}

		while(count < arrayLength) {
			ipArray[count] = 0;
			count++;
		}
			for(int i = 0; i < arrayLength; i++) {
			System.out.println(ipArray[i]);
		}
	}

    public static void main(String[] args ) {
    //int[] ipArray = {0,0,6};
    // int[] ipArray = {0,6,0};
    // int[] ipArray = {6,0,0};
    // int[] ipArray = {1,2,6};
    // int[] ipArray = {0,0,0};
    int[] ipArray = {0,0,6,0,1,2,3,0,-1,67,0,0,34,8,0};
	//int[] ipArray = {1,2,3,4,5,0,0,6};
	arrangeArray(ipArray);
	}
}