package com.zzang.test.top50.array;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {
  public static void main(String args[]) {
    // 1
    int[] nums = { 0, 3, 2, 0, 8, 5 };
    // 2
    int currentIndex = 0;
    // 3
    for (int i = 0; i < nums.length; i++) {
      // 4
      if (nums[i] != 0) {
        nums[currentIndex] = nums[i];
        currentIndex++;
      }
    }
    // 5
    while (currentIndex < nums.length) {
      nums[currentIndex] = 0;
      currentIndex++;
    }
    // 6
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + ",");
    }
  }
}
