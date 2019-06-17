package com.zzang.test.codility;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OddOccurrencessInArrayTest {

    @Test
    public void oddArrayTest() {
        int A[] = {9,3,9,3,9,7,9};

        int temp = 0;

        for (int i=0; i < A.length; ++i) {
            temp = temp ^ A[i];
            System.out.println("====> : " + temp);
        }

        assertTrue(temp == 7);
    }
}
