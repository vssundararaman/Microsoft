package com.microsoft.sortingsearching;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int num1[]={1,4,6};
        int[] num2={2,5,8};

        merge(num1,num2);
    }

    public static void merge(int[] nums1,int[] nums2) {

        int m = nums1.length;
        int n= nums2.length;

        int result[] = new int[m+n];

        int i = 0, j=0, k=0;

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                result[k] = nums1[i];
                i++;
                k++;
            }else{
                result[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(i<m){
            result[k++] = nums1[i++];
        }
        while(j < n){
            result[k++] = nums2[j++];
        }

        System.out.println(Arrays.toString(result));
    }
}
