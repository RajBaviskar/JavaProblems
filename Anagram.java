import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;

public class Anagram {

	// this will allow dups like 121 and 212 is true
	// public static boolean isAnagram(String first, String second) {
	// 	if(first == null || second == null){
	// 		return false;
	// 	}
	// 	int firstLength = first.length();
	// 	int secondLength = second.length();

	// 	if(firstLength == 0 || secondLength == 0) {
	// 		return false;
	// 	}

	// 	int[] alphabet = new int [26];

	// 	for(int i = 0; i < firstLength; i++) {
	// 		int index = (int)first.charAt(i)%26;
	// 		alphabet[index]++; 
	// 	}

	// 	for(int i = 0; i < secondLength; i++) {
	// 		int index = (int)second.charAt(i)%26;
	// 		if(alphabet[index] == 0){
	// 			return false;
	// 		}
	// 	}
	// 	return true;
	// } 

	// exact anagram 121 and 212 retrun false
	public static boolean isAnagram(String first, String second) {
		if(first == null || second == null){
			return false;
		}
		int firstLength = first.length();
		int secondLength = second.length();

		if(firstLength == 0 && secondLength == 0){
			return true;
		}

		if(firstLength == 0 || secondLength == 0 
			|| firstLength != secondLength) {
			return false;
		}

		int[] alphabet = new int [26];

		for(int i = 0; i < firstLength; i++) {
			int index = (int)first.charAt(i)%26;
			alphabet[index]++; 
		}

		for(int i = 0; i < secondLength; i++) {
			int index = (int)second.charAt(i)%26;
			alphabet[index]--; 
		}


		for(int i = 0; i < 26; i++) {
			if(alphabet[i] > 0){
				return false;
			}
		}
		return true;
	} 

	// Using hash
	//public static boolean isAnagram(String s1, String s2) {
	// 	boolean isAnagram = true;
	// 	HashMap<Character, Integer>  map = new HashMap<Character, Integer>();
	// 	int i = 0;
	// 	for(char c: s1.toCharArray()) {
	// 		map.put(c,i);
	// 		i++;
	// 	}

	// 	Iterator<Character> mapIterator = map.keySet().iterator();
	// 	while(mapIterator.hasNext()) {
	// 		Character mapItemKey = mapIterator.next();
	// 		System.out.println("Character = " + mapItemKey + 
	// 			"Index = " + map.get(mapItemKey));
	// 	}

	// 	for(char c: s2.toCharArray()) {
	// 		if(map.get(c) != null) {
	// 			continue;
	// 		} else {
	// 			isAnagram = false;
	// 		}
	// 	}


	// 	return isAnagram;
	// }

    public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the strings = ");
		String first = reader.nextLine();
		String second = reader.nextLine();

		if(isAnagram(first, second)) {
			System.out.println("Is Anagram");
		} else {
			System.out.println("Not an Anagram");
		} 
	}
}
	