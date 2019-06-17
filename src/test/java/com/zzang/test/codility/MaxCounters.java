package com.zzang.test.codility;

import org.junit.Test;

import java.util.Arrays;

public class MaxCounters {

    @Test
    public void solution() {
        int N = 5;
        int A[] = {3,4,4,6,1,4,4};

        int counter[] = new int[N];

        int max = 0;
        for (int i=0; i < A.length; i++) {

            if (A[i] <= N) {
                int val = counter[A[i]-1] + 1;
                max = max < val ? val:max;
                counter[A[i]-1] = val;
            } else {
                for(int j = 0; j < counter.length; j++) {
                    counter[j] = max;
                }
            }
        }

        System.out.println("====> " + Arrays.toString(counter));
    }
}
