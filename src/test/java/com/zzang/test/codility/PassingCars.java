package com.zzang.test.codility;

import org.junit.Test;

public class PassingCars {

    @Test
    public void test() {
        int A[] = {1,0,1,0,1,1,0,1,1,1};

        int res = solution(A);
        System.out.println("res : " + res);
    }

    private int solution(int[] A) {
        int P = 0;
        int Q = 1;
        int LIMIT = 1000000000;

        int total = 0;

        for (int data: A) {
            if (Q == data) {
                total++;
            }
        }

        int sum = 0;
        int q_count = 0;
        for (int i=0; i < A.length; i++) {
            if (P == A[i]) {
                total -= q_count;
                sum += total;
                q_count = 0;
            } else {
                q_count++;
            }

            if (LIMIT < sum) {
                return -1;
            }
        }

        return sum;
    }
}
