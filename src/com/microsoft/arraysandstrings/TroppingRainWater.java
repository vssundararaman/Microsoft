package com.microsoft.arraysandstrings;

public class TroppingRainWater {

    public static void main(String[] args) {
        int arr[] = {1,0,2,2,4,0,1,5,2,1,3,1};
        System.out.println(findWater(arr));
    }

    static int findWater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int water = 0;
        int left_max = 0, right_max = 0;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            if(arr[left] < arr[right]){
                if(arr[left]>left_max){
                    left_max = arr[left];
                }else{
                    water = water + left_max - arr[left];
                    left++;
                }
            }else{
                if(arr[right]>right_max){
                    right_max = arr[right];
                }else{
                    water = water + right_max -arr[right];
                    right--;
                }
            }
        }


        return water;
    }
}
