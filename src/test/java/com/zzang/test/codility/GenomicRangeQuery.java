package com.zzang.test.codility;

import org.junit.Test;

import java.util.Arrays;

public class GenomicRangeQuery {

    @Test
    public void test() {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        int res[] = solution(S, P, Q);
        System.out.println("res : " + Arrays.toString(res));
    }

    private int[] solution(String S, int[] P, int[] Q) {
        char ch[] = S.toCharArray();

        int res[] = new int[P.length];

        for (int i=0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;
            char temp[] = Arrays.copyOfRange(ch, start, end);
            Arrays.sort(temp);
            res[i] = convert(temp[0]);
        }

        return res;
    }


    private int convert(char ch) {
        int A = 1;
        int C = 2;
        int G = 3;
        int T = 4;

        switch (ch) {
            case 'A':
                return A;
            case 'C':
                return C;
            case 'T':
                return T;
            case 'G':
                return G;
        }

        return 0;
    }
}
