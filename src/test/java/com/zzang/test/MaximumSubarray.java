package com.zzang.test;

import org.junit.Test;

public class MaximumSubarray {

    @Test
    public void test() {
        int input[] = {1,3,-3};

        int res = solution(input);
        System.out.println("res : " + res);

    }

    private int solution(int[] A) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int size = A.length;

        for (int i = 1; i < size; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = A[i];
            }
            else {
                maxEndingHere += A[i];
            }

            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }
}
