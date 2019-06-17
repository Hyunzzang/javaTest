package com.zzang.test.codility;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class FrogRiverOne {

    @Test
    public void solution() {
        int[] A = {1,3,1,4,2,3,5,4};
        int X = 5;

        int res = -1;
        Set<Integer> dataSet = new HashSet<>();
        for (int i=0; i < A.length; i++) {
            if (A[i] <= X)
                dataSet.add(A[i]);

            if (dataSet.size() == X) {
                res = i;
                break;
            }
        }

        assertTrue(res == 6);
    }
}
