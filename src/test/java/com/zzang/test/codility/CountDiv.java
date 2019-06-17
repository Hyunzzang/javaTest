package com.zzang.test.codility;

import org.junit.Test;

public class CountDiv {
    @Test
    public void test() {
        int A = 0;
        int B = 0;
        int K = 11;

        int res = solution(A, B, K);
        System.out.println("res : " + res);
    }

    private int solution(int A, int B, int K) {
//        int val = B - A;
//        if (val < K) {
//            return 0;
//        }
//
//        return (int)Math.ceil((double)val / (double)K);

        int count = 0;
        for (int i = A; i <= B; i++) {
            if ((i % K) == 0) {
                count++;
            }
        }

        return count;
    }
}
