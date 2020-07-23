package com.microsoft.sortingsearching;

public class FindMinimumSortedArray {

    public static void main(String[] args) {
        System.out.println("Executing...");
    }

    static int findMin(int[] nums) {

        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[1];

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int midPoint = left + (right - left) / 2;
            if (midPoint > 0 && nums[midPoint] < nums[midPoint - 1]) {
                return nums[midPoint];
            } else if (nums[left] <= nums[midPoint] && nums[midPoint] > nums[right]) {
                left = midPoint + 1;
            } else {
                right = midPoint - 1;
            }
        }

        return nums[left];
    }
}
