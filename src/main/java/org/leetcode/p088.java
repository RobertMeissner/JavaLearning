package org.leetcode;

public class p088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // output: non-decreasing/increasing sorted merged array of both inputs
        // backwards approach

        // is there something to merge into the existing nums1?

//        if (n > 0 && m > 0) {

        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
//        } else if (n >0 && m == 0 ) {
//            System.arraycopy(nums2, 0, nums1, 0, n);
//
//        }
    }
}
