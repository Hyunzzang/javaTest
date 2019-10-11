package com.zzang.test.algorithms;

import java.util.Arrays;

/**
 * How do you find the largest and smallest number in an unsorted integer array?
 */
public class Array_largest_smallest {

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{12, 3, 5, 7, 19};
        int k = 1;
        System.out.print( "K'th smallest element is " + kthSmallest(arr, k) );
    }

    public static int kthSmallest(Integer [] arr, int k) {
        // Sort the given array
        Arrays.sort(arr);

        // Return k'th element in
        // the sorted array
        return arr[k-1];
    }
}
