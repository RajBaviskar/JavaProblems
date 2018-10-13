import java.io.*;
import java.util.*;

class PanCakeSort {

    static int[] flip(int[] arr,int k){
        int i = 0;
        if( k >= arr.length){
            return null;
        }
        while(i < k){
            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
            i++;
            k--;
        }
        return arr;
    }

    static int getMax(int[] arr, int start, int end){
        int max = arr[start];
        int maxIndex = -1;
        for(int i = start+1; i <= end; i++){
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static int[] pancakeSort(int[] arr) {
        // your code goes here
        int start = 0;
        int end = arr.length-1;
        int last = end;
        int maxIndex = getMax(arr,start,end);
        //System.out.println("maxIndex = " + maxIndex);
        //System.out.println("last = " + last);
        while(last > 0){
            arr = flip(arr,maxIndex);
            arr = flip(arr,last);
            last--;
            //System.out.println("last = " + last);
            maxIndex = getMax(arr,start,last);
        //System.out.println("maxIndex = " + maxIndex);
        }
        return arr;
    }

    public static void main(String[] args) {

        int arr[] = {1,5,4,3,2};
        pancakeSort(arr);
        //arr = flip(arr,2);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}