package com.zzang.test.codility;

import java.util.PriorityQueue;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class PermCheck {

    @Test
    public void test() {
        int A[] = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
        int res = solution_1(A);

        assertTrue(res == 0);
    }

    private int solution_1(int A[]) {
        Arrays.sort(A);

        for (int i = 1; i <= A.length; i++) {
            if (A[i-1] != i) {
                return 0;
            }
        }

        return 1;
    }

    private int solution2_(int A[]) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val: A) {
            priorityQueue.offer(val);
        }

        for (int i = 1; i <= A.length; i++) {
            int prioVal = priorityQueue.poll();
            if (prioVal != i) {
                return 0;
            }
        }

        return 1;

    }
}
