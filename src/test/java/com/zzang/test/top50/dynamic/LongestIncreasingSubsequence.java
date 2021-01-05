package com.zzang.test.top50.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {

    LongestIncreasingSubsequence a = new LongestIncreasingSubsequence();
//    int[] nums = {1,2,3, 2, 5, 2, 6, 10, 4, 12};
    int[] nums = {9, 11, 2, 8, 4, 7, 88, 15};

    System.out.println("value " + a.solve2(nums));
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
