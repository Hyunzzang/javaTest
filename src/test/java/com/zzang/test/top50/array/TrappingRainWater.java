package com.zzang.test.top50.array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 */
public class TrappingRainWater {

    public static void main(String[] args) {
//    int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nums = {4, 2, 0, 3, 2, 5};
//    System.out.println(trap(nums));
        System.out.println(trap_1(nums));
    }

    public static int trap_pointers(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

    public static int trap_dynamic(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];

        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.max(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    public static int trap_1(int[] height) {
        int[] leftNums = new int[height.length];
        int[] rightNums = new int[height.length];

        int leftMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftNums[i] = leftMax;
        }

        int rightMax = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightNums[i] = rightMax;
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int minVal = Math.min(leftNums[i], rightNums[i]);
            res += (minVal - height[i]);
        }

        return res;
    }

    public static int trap(int[] height) {
        int result = 0;
        if (height == null || height.length <= 2) {
            return result;
        }

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = height[0];
        left[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            if (height[i] < max) {
                left[i] = max;
            } else {
                left[i] = height[i];
                max = height[i];
            }
        }

        max = height[height.length - 1];
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] < max) {
                right[i] = max;
            } else {
                right[i] = height[i];
                max = height[i];
            }
        }

        for (int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;

    }
}
