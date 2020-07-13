package com.microsoft.arraysandstrings;

public class TroppingRainWater {

    public static void main(String[] args) {
        //int arr[] = {1,0,2,2,4,0,1,5,2,1,3,1};
        int arr[] = {1,0,1};

        System.out.println(findWater(arr));

        System.out.println(findWaterForLoop(arr));
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

    static int findWaterForLoop(int[] arr){
        int n = arr.length;

        int water = 0;

        //left[i] contains the tallest bar to the
        //left of i'th bar including itself
        int left[]=new int[n];

        //right[i] contains the tallest bar to the
        //right of i'th bar including itself
        int right[] = new int[n];

        left[0]=arr[0];

        //Fill the left array
        for(int i=1; i < n;i++){
            left[i]=Math.max(left[i-1],arr[i]);
        }

        //Fill the right Array
        right[n - 1] = arr[n - 1];
        for(int i=n-2;i >= 0;i--){
            right[i]= Math.max(right[i+1],arr[i]);
        }


        //Calculate the water by Element by Element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i]
        for(int i=0;i<n;i++){
            water = water + Math.min(left[i],right[i])-arr[i];
        }

        return water;
    }
}
