package com.zzang.test.codility;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PermMissingElemTest {

    @Test
    public void solution() {
        int[] A = {2,3,1,5};
        int sumData = 0;
        for (int i=1; i <= A.length+1; i++) {
            sumData += i;
        }
        System.out.println("===== Sum > " + sumData);

        for (int data: A) {
            sumData -= data;
            System.out.println("=====> " + sumData);
        }

        assertTrue(sumData == 4);
    }
}
