package com.zzang.test.codility;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CyclicRotation {

//    @Test
//    public void solution() {
//        int A[] = {3, 8, 9, 7, 6};
//        int K = 6;
//
//        List<Integer> dataList = new ArrayList<>(A.length);
//
//        int loop = A.length < K ? (K-A.length) : K;
//        int point = A.length - loop;
//        int index=0;
//        while (index < loop) {
//            dataList.add(index++, A[point++]);
//        }
//        for (int i=0; i < (A.length-loop); i++) {
//            dataList.add(index++, A[i]);
//        }
//
//        int res[] = dataList.stream().mapToInt(i -> i).toArray();
//        System.out.println("DataList : " + Arrays.toString(res));
//
//        int res1[] = {6, 3, 8, 9, 7};
//        assertTrue(Arrays.equals(res, res1));
//    }

    @Test
    public void solution() {
        int A[] = {6, 1, 1};
        int K = 13;
        int arraySize = A.length;
        int res[] = new int[arraySize];

        if (arraySize == 0) {
            return;
        }

        for (int i=0; i < arraySize; i++) {
            res[(i+K)%arraySize] = A[i];
        }

        int res1[] = {1, 6, 1};
        assertTrue(Arrays.equals(res, res1));
    }
}
