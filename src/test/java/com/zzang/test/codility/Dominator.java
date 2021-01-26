package com.zzang.test.codility;

import org.junit.Test;

import java.util.*;

/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 *
 * For example, consider array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 *
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 *
 * For example, given array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
public class Dominator {
    @Test
    public void test() {
//        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
//        int[] A = {2147483647};
        int[] A = {2, 1, 1, 1, 3};

        int res = solution2(A);
        System.out.println("res : " + res);
    }

    public int solution2(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        Map<Integer, Integer> dominatorInfoMap = new HashMap<>();
        int max = 0;
        int maxValue = 0;
        for(int i = 0; i < A.length; i++) {
            Integer mapVal = dominatorInfoMap.get(A[i]);
            if (mapVal == null) {
                dominatorInfoMap.put(A[i], 1);
                if (max == 0) max = 1;
                if (maxValue == 0) maxValue = A[i];
            } else {
                mapVal += 1;
                dominatorInfoMap.put(A[i], mapVal);
                if (max < mapVal) {
                    max = mapVal;
                    maxValue = A[i];
                }
            }
        }

        if ((A.length / 2) >= max) return -1;

        for(int i = 0; i < A.length; i++) {
            if (maxValue == A[i]) {
                return i;
            }
        }

        return -1;
    }

    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        Map<Integer, DominatorInfo> dominatorInfoMap = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            DominatorInfo dominatorInfo = dominatorInfoMap.get(A[i]);
            if (dominatorInfo == null) {
                dominatorInfo = new DominatorInfo(A[i], i);
            } else {
                dominatorInfo.addIndex(i);
            }
            dominatorInfoMap.put(A[i], dominatorInfo);
        }

        DominatorInfo resDominatorInfo = dominatorInfoMap.values()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getCount(),  a.getCount()))
                .findFirst()
                .get();

        return (A.length / 2) < resDominatorInfo.getCount() ? resDominatorInfo.getIndex() : -1;
    }

    public class DominatorInfo {
        private int val;
        private Set<Integer> indexList = new HashSet<>();
        private int count;

        public DominatorInfo(int val, int index) {
            this.val = val;
            this.indexList.add(index);
            this.count++;
        }

        public void addIndex(int index) {
            if (this.indexList.add(index)) {
                this.count++;
            }
        }

        public int getCount() {
            return count;
        }

        public int getIndex() {
            return this.indexList.stream().findFirst().get();
        }
    }
}
