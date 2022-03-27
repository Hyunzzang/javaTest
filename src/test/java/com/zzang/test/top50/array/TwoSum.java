package com.zzang.test.top50.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 21};
        int target = 10;
        TwoSum a = new TwoSum();
        int[] result = a.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            int searNum = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == searNum) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }






    //
    public int[] solve(int[] nums, int target) {
        //2.담을 그릇
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        //3.for
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int mapValue = map.get(nums[i]); //i=1일때 8 , map(8,0)
                result[0] = mapValue + 1; //1
                result[1] = i + 1;        //2

            } else {
                map.put(target - nums[i], i); //key 10-2=8, value i=0
            }
        }

        return result;

    }
}
