public class fb {

	public static boolean isCheck(int [] ipArray, int target) {
		int ipLength = ipArray.length;

		if(ipLength <= 0) {
			return false;
		}

		int sum = 0;
		int backptr = 0;
		for(int i = 0; i < ipLength;){
			
		// for positive only 
			
		// 	if(ipArray[i] == target){
		// 		return true;
		// 	}

		// 	sum += ipArray[i];

		// 	if(sum < target){
		// 		continue;
		// 	}else if( sum > target){
		// 		sum -= ipArray[backptr];
		// 		backptr++;
		// 	}

		// 	if(sum == target){
		// 		return true;
		// 	} 
		// }

		// for negative
			
			if(ipArray[i] == target){
				return true;
			}

			if(sum == 0 && ipArray[i] < 0){
				i++;
				continue;
			}

			while(sum < target && i < ipLength){
				sum+= ipArray[i];
				i++;
			}

			if(sum == target){
				return true;
			}	

			while(sum>target && backptr <= i){
				sum -= ipArray[backptr];
				backptr++;
			}

			if(sum == target){
				return true;
			}	

	}
	return false;
}


	public static void main(String[] args) {
		int[] ipArray = {5,1,3,2,7,9,8};

		//int[] ipArray = {8};

		//int[] ipArray = {5,1,3,2,7,9,2,2,2,2};

		//int[] ipArray = {5,1,3,8,7,9};

		//int[] ipArray = {0,0,0,8};

		//int[] ipArray = {5,1,3,21,-3,3,2,1,2};
		//int[] ipArray = {5,-1,3,-1,-5};

		System.out.println(isCheck(ipArray,8));
	}

}