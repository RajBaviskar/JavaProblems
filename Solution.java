//import java.util.*;
//
//class Solution {
//
//	  public int leastInterval(char[] tasks, int n) {
//        int[] counter = new int[26];
//        int ipLen = tasks.length;
//
//        for(int i = 0; i < ipLen; i++) {
//        	counter[tasks[i] - 'A']++;
//        }
//
//        Array.sort(counter);
//
//        int i = 0;
//        int time = 0;
//        while(tasks[25] > 0){
//        	i = 0;
//        	while(i <= n) {
//        		if(counter[25] == 0){
//        			break;
//        		}else if(i < 26 && counter[25 - i] > 0){
//        			couter[25-i]--;
//        		}
//        		time++;
//        		i++;
//        	}
//        	Array.sort(counter);
//        }
//        return time;
//    }
//
//}