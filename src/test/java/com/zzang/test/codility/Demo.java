package com.zzang.test.codility;

import org.junit.Test;

import java.util.Arrays;

public class Demo {
    @Test
    public void test() {
        int A[] = {1, 2,3};

        int res = solution(A);
        System.out.println("res : " + res);
    }

    private int solution(int[] A) {
        Arrays.sort(A);

        int res = 1;
        for(int data: A) {
            if (res == data) {
                res++;
            }
        }

        return res;
    }
}
