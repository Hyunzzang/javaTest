package com.zzang.test.top50.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//    int[] nums = { 1 };
//    System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray_1(nums));
    }

    public static int maxSubArray_1(int[] nums) {
        int val = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            val = Math.max(val, sum);
        }

        return val;
    }


    public static int maxSubArray(int[] nums) {
        int newSum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            newSum = Math.max(newSum + nums[i], nums[i]);
            max = Math.max(max, newSum);
        }
        return max;
    }

    public static int maxSubArray_dp(int[] A) {
        int n = A.length;
        int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
