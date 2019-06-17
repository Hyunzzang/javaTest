package com.zzang.test.codility;

import org.junit.Test;

/**
 *
 */

public class Test1 {
    @Test
    public void test() {
        int N = 17;

        int res = solution(N);
        System.out.println("res : " + res);
    }

    private int solution(int N) {
        if (N == 0) {
            return 0;
        }


        int sum = 0;
        int count = 1;
        do {
            sum += count;
            count++;
        } while (sum <= N);

        return count-2;
    }
}
