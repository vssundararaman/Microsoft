package com.microsoft.sortingsearching;

public class FindMinimumSortedArrayII {

    public static void main(String[] args) {
       int[] nums = {2,2,2,0,1};
        System.out.println(findMin(nums));
    }

    static int findMin(int[] nums) {
        if(nums ==null || nums.length==0)return -1;
        if(nums.length ==1)return nums[0];

        int low = 0, high = nums.length-1;

        while(low < high){
            int pivot = low + (high-low)/2;
            if(nums[pivot] < nums[high]){
                high = pivot;
            }else if(nums[pivot] > nums[high]){
                low = pivot + 1;
            }else{
                high -=1;
            }
        }
        return nums[low];
    }
}
