package com.zzang.test.codility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class PermCheck {

    @Test
    public void solution() {
        int A[] = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};

        Arrays.sort(A);

        int res;
        int len = A.length;

        if ((1 == A[0]) && (len == A[len - 1])) {
            res = 1;
        } else {
            res = 0;
        }

        assertTrue(res == 1);
    }
}
