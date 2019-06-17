package com.zzang.test.codility;

import org.junit.Test;

/**
 *
 *
 */

public class Test2 {
    @Test
    public void test() {
//        int A[] = {-8,4,0,5,-3,6};
        int A[] = {1,3,-3};

        int res = solution(A);
        System.out.println("res : " + res);
    }

//    private int solution(int[] A) {
//        int max=0;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i; j < A.length; j++) {
//                int score = A[i] + A[j] + (j - i);
//                max = score > max ? score : max;
//            }
//        }
//
//        return max;
//    }


    private int solution(int[] A) {
        int size = A.length;
        int max_diff = 0;
        int start = 0;
        int end = 0;

        while (start < size) {
            int a1 = A[start] + A[end];
            int b1 = end - start;
            int abs_num = a1 + b1;
            max_diff = Math.max(max_diff, abs_num);

            if (end < (size-1)) {
                end += 1;
            } else {
                start += 1;
                end = 1;
            }
        }

        return max_diff;
    }


//    private int solution(int[] A) {
//        int N = A.length;
//        int[] K1 = new int[N];
//        int[] K2 = new int[N];
//
//        for(int i = 1; i < N-1; i++){
//            K1[i] = Math.max(K1[i-1] + A[i], 0);
//        }
//        for(int i = N-2; i > 0; i--){
//            K2[i] = Math.max(K2[i+1]+A[i], 0);
//        }
//
//        int max = 0;
//
//        for(int i = 1; i < N-1; i++){
//            max = Math.max(max, K1[i-1]+K2[i+1]);
//        }
//
//        return max;
//    }
}
