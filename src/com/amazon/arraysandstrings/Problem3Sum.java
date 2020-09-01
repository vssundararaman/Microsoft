package com.amazon.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3Sum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println (threeSum(nums));
    }

    static List<List<Integer>> threeSum(int[] nums) {

        int size = nums.length;
        List<List<Integer>> list = new ArrayList<> ();

        Arrays.sort (nums);

        for (int i = 0; i < size && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = size - 1;
                while (low < high) {
                    if (nums[low] + nums[high] < -nums[i]) low++;
                    else if (nums[low] + nums[high] > -nums[i]) high--;
                    else {
                        list.add (Arrays.asList (nums[i], nums[low++], nums[high--]));
                        while (low < high && nums[low] == nums[low - 1]) low++;
                    }
                }
            }
        }
        return list;
    }
}
