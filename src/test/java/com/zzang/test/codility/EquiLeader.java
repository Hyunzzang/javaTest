package com.zzang.test.codility;

import org.junit.Test;

import java.util.*;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * The leader of this array is the value that occurs in more than half of the elements of A.
 *
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * we can find two equi leaders:
 *
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 *
 * For example, given:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 *
 * 여기서 리더를 뽑아야 하는데 해당 리더는 2가지 조건이 있습니다.
 * 1. 가장 많이 중복되는 값.
 * 2. 배열 길이의 절반 값보다 더 많이 나오는 경우.
 */
public class EquiLeader {

    @Test
    public void test() {
        int[] A = {4, 3, 4, 4, 4, 2};

        int res = solution(A);
        System.out.println("res : " + res);
    }

    public int solution(int[] A) {
        int leaderNo = 0;
        int maxCount = 0;
        Map<Integer, Integer> leaderMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!leaderMap.containsKey(A[i])) {
                leaderMap.put(A[i], 1);
            } else {
                leaderMap.replace(A[i], leaderMap.get(A[i]) + 1);
            }

            int val = leaderMap.get(A[i]);
            if (val > maxCount) {
                maxCount = val;
                leaderNo = A[i];
            }
        }

        for (int i = 1; i < A.length-1; i++) {
            for (int j = 0; j < i; j++) {
                
            }
        }

        return 0;
    }
}
