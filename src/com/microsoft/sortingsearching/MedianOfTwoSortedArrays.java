package com.microsoft.sortingsearching;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        int t = nums1.length + nums2.length;
        int l = (t + 1)/2;
        int r = (t + 2)/2;

        double result = ((getKthElement(nums1, 0, nums2, 0, l) + getKthElement(nums1, 0, nums2, 0, r)))/2.0;

        System.out.println (result);

        System.out.println (" *****  " + findMedianSortedArrays (nums1,nums2));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0, m = nums1.length, n = nums2.length;

        int[] result = new int[m + n];
        int i = 0;
        while (p1 < nums1.length || p2 < nums2.length) {

            if (p1 < m && p2 < n) {
                if (nums1[p1] < nums2[p2]) {
                    result[i++] = nums1[p1++];
                } else {
                    result[i++] = nums2[p2++];
                }
            } else if (p1 < m && p2 > n) {
                result[i++] = nums1[p1++];
            } else {
                result[i++] = nums2[p2++];
            }
        }
        int median = m + n;
        if (median % 2 == 0) {
            return (double) (result[median / 2] + result[median / 2 - 1] )/ 2.0;
        }

        return result[median / 2];

    }

    static double getKthElement(int[] nums1, int aStart, int[] nums2, int bStart, int k) {
        if (aStart > nums1.length - 1) return nums2[bStart + k - 1];
        if (bStart > nums2.length - 1) return nums1[aStart + k - 1];

        if (k == 1) return Math.min (nums1[aStart], nums2[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;

        if (aStart + k / 2 - 1 < nums1.length) aMid = nums1[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < nums2.length) bMid = nums2[bStart + k / 2 - 1];

        if (aMid < bMid) {
            return getKthElement (nums1, aStart + k / 2, nums2, bStart, k - k / 2);
        }else{
            return getKthElement (nums1, aStart , nums2, bStart + k / 2, k - k / 2);
        }
    }

}
