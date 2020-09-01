package com.microsoft.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println (longestLIS (nums));
        System.out.println (binaryLIS (nums));
    }

    static int binaryLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch (dp, 0, length, num);
            if(index < 0){
                index = -(index+1);
            }
            dp[index] = num;
            if(index == length){
                ++length;
            }
        }
        return length;
    }

    static int longestLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill (dp, 1);
        int result = 0;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max (dp[i], dp[j] + 1);
                }
            }
            result = Math.max (result, dp[i]);
        }

        return result;
    }


}
