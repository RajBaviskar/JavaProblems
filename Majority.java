import java.util.*;
    
public class Majority{
	public static int majority(int[] ipArray) {
		HashMap<Integer, Integer>  map = new HashMap<Integer, Integer>();
		int arrayLength = ipArray.length;
		for (int i = 0; i < arrayLength; i++) {
			if(map.containsKey(ipArray[i])){
				map.put(ipArray[i], map.get(ipArray[i]) + 1);
			} else {
				map.put(ipArray[i], 1);
			}
		}
		return Collections.max(map.entrySet(), HashMap.Entry.comparingByValue()).getKey();
	}
    public static void main(String[] args ) {
	int[] ipArray = {2,2,1,1,1,2,2};
	System.out.println(majority(ipArray));
	}
}