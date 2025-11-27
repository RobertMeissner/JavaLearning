package org.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class p088 {

    private void mergeArrays(int[] nums1, int m, int[] nums2, int n) {
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
    }

    private void mergeAsStream(int[] nums1, int m, int[] nums2, int n){
        // less efficient; experimenting with Stream
        int[] result = IntStream.concat(Arrays.stream(nums1, 0, m), Arrays.stream(nums2)).sorted().toArray();
        System.arraycopy(result, 0, nums1, 0, m+n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // output: non-decreasing/increasing sorted merged array of both inputs
        // backwards approach

        // mergeArrays(nums1, m, nums2, n);
        mergeAsStream(nums1, m, nums2, n);

    }
}
