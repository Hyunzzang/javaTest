package com.zzang.test.top50.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of
 * size at least two whose elements sum up to a multiple of k, or false otherwise.
 * <p>
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a
 * multiple of k.
 * <p>
 */
public class ContinuousSubarraySum {

    public static void main(String[] args) {
        ContinuousSubarraySum a = new ContinuousSubarraySum();
//        int[] nums= {23,2,4,6,7};
//        int k = 6;
        int[] nums = {5, 0, 0, 0};
        int k = 3;
        System.out.println(a.checkSubarraySumWithMod_2(nums, k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < preSum.length; i++) {
            int res = preSum[i];
            if (k != 0) {
                res = preSum[i] % k;
            }
            if (map.containsKey(res) && (i - map.get(res)) > 1) {
                return true;
            }

            if (!map.containsKey(res)) {
                map.put(res, i);
            }
        }

        return false;
    }


    public boolean checkSubarraySumWithMod_2(int[] nums, int k) {
        HashMap<Integer, Integer> subArrSum = new HashMap<>();

        int accmulSum = nums[0];
        subArrSum.put(accmulSum % k, 0);
        for (int i = 1; i < nums.length; i++) {
            accmulSum = accmulSum + nums[i];
            int mod = accmulSum % k;
            if (mod == 0) {
                return true;
            }
            if (subArrSum.containsKey(mod) && i - subArrSum.get(mod) >= 2) {
                return true;
            }
            subArrSum.putIfAbsent(mod, i);
        }
        return false;
    }


    public boolean checkSubarraySum2(int[] nums, int k) {
        int subArrSum = 0;
        int mod = 0;
        for (int i = 0; i < nums.length; i++) {
            mod = (nums[i] + mod) % k;
            if (mod == 0) {
                return true;
            }
        }
        return false;
    }

}
