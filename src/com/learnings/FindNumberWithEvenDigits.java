package com.learnings;

public class FindNumberWithEvenDigits {

    public static void main(String[] args) {
        int[] nums = {12,345,20,6,7896};

        System.out.println(findNumber(nums));

    }

    static int findNumber(int[] nums){
        int count = 0;

        for(int num: nums){
            if(String.valueOf(num).length() % 2 == 0){
                count ++;
            }
        }
        return count;
    }
}
