package com.microsoft.others;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,1};

        System.out.println( singleNumber(nums));
    }

    static int singleNumber(int[] nums){

        List<Integer> integerList = new ArrayList<>();

        for(int num: nums){
            if(!integerList.contains(num)){
                integerList.add(num);
            }else{
                integerList.remove(new Integer(num));
            }
        }

        return integerList.get(0);
    }
}
