package com.microsoft.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int nums[] = {1, 1, 2, 45, 46, 46};
        int target = 47;

        System.out.println(Arrays.toString(twoSumOnePassHash(nums, target)));

       // System.out.println(Arrays.toString(twoSumBruteForce(nums, target)));
    }

    public static int[] twoSumBruteForce(int[] numbs, int target) {

        for (int i = 0; i < numbs.length - 1; i++) {
            for (int j = i + 1; j < numbs.length; j++) {
                if (target - numbs[j] == numbs[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No Solution Exists");
    }


    private static int[] findTwoSum_BruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public static int[] twoSumOnePassHash(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            int compliment = target - nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment),i};
            }
            map.put(nums[i],i);
        }


//        Map<Integer, Integer> numMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (numMap.containsKey(complement)) {
//                return new int[] { numMap.get(complement), i };
//            } else {
//                numMap.put(nums[i], i);
//            }
//        }
        return new int[] {};

       // throw new IllegalArgumentException("No Solution Exists");
    }

}
