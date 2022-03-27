package com.zzang.test.top50.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements
 * without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of
 * the array [0,3,1,6,2,2,7].
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        LongestIncreasingSubsequence a = new LongestIncreasingSubsequence();
//    int[] nums = {1,2,3, 2, 5, 2, 6, 10, 4, 12};
        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {0};

        System.out.println("value " + a.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }





    public int solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            System.out.println("i: " + i);
            for (int j = 0; j < i; j++) {
                System.out.println("nums[" + j + "] " + nums[j] + " nums[" + i + "] " + nums[i]);

                if (nums[j] < nums[i]) {
                    System.out.println(" dp[" + j + "] " + dp[j] + "   dp[" + i + "]" + dp[i]);
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    System.out.println("adp[" + j + "]+1 " + dp[j] + " dp[" + i + "]" + dp[i]);

                }
            }
            System.out.println();
            result = Math.max(result, dp[i]);
            System.out.println("result: " + result);
        }
        return result;

    }

    public int solve2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (list.size() == 0 || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    if (list.get(mid) < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                list.set(j, num);
            }
        }

        return list.size();

    }
}
