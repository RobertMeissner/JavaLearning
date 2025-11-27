package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class p088Test {
    @Test
    public void shouldReturnSameArray(){
        int[] nums1 = new int[]{3};
        int n = nums1.length;
        int[] nums2 = new int[]{};
        int m = nums2.length;
        p088 solution = new p088();
        solution.merge(nums1, n,nums2, m);
        assertArrayEquals(new int[]{3}, nums1);
    }

    @Test public void shouldOrderSmallArrays(){

        int[] nums1 = new int[]{1, 3, 0};
        int n = 2;
        int[] nums2 = new int[]{4};
        int m = nums2.length;
        p088 solution = new p088();
        solution.merge(nums1, n,nums2, m);
        System.out.printf(Arrays.toString(nums1));
        assertArrayEquals(new int[]{1,3,4}, nums1);
    }

    @Test public void shouldOrderEqualSizedArrays(){

        int[] nums1 = new int[]{1, 3, 0,0};
        int n = 2;
        int[] nums2 = new int[]{2, 4};
        int m = nums2.length;
        p088 solution = new p088();
        solution.merge(nums1, n,nums2, m);
        System.out.printf(Arrays.toString(nums1));
        assertArrayEquals(new int[]{1,2,3,4}, nums1);
    }

    @Test public void shouldAppendSortedArrays(){

        int[] nums1 = new int[]{1, 2, 0,0};
        int n = 2;
        int[] nums2 = new int[]{3, 4};
        int m = nums2.length;
        p088 solution = new p088();
        solution.merge(nums1, n,nums2, m);
        System.out.printf(Arrays.toString(nums1));
        assertArrayEquals(new int[]{1,2,3,4}, nums1);
    }
    @Test public void emptyNums1(){

        int[] nums1 = new int[]{0,0};
        int n = 0;
        int[] nums2 = new int[]{3, 4};
        int m = nums2.length;
        p088 solution = new p088();
        solution.merge(nums1, n,nums2, m);
        System.out.printf(Arrays.toString(nums1));
        assertArrayEquals(new int[]{3,4}, nums1);
    }
    @Test public void emptyNums2(){

        int[] nums1 = new int[]{3, 4};
        int n = 2;
        int[] nums2 = new int[]{};
        int m = nums2.length;
        p088 solution = new p088();
        solution.merge(nums1, n,nums2, m);
        System.out.printf(Arrays.toString(nums1));
        assertArrayEquals(new int[]{3,4}, nums1);
    }
    @Test public void singleElements(){

        int[] nums1 = new int[]{3, 0};
        int n = 1;
        int[] nums2 = new int[]{1};
        int m = nums2.length;
        p088 solution = new p088();
        solution.merge(nums1, n,nums2, m);
        System.out.printf(Arrays.toString(nums1));
        assertArrayEquals(new int[]{1,3}, nums1);
    }
    @Test public void nums2LargerThanNums1(){

        int[] nums1 = new int[]{3, 0,0};
        int n = 1;
        int[] nums2 = new int[]{1, 2};
        int m = nums2.length;
        p088 solution = new p088();
        solution.merge(nums1, n,nums2, m);
        System.out.printf(Arrays.toString(nums1));
        assertArrayEquals(new int[]{1,2,3}, nums1);
    }
}
