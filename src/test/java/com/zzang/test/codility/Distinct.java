package com.zzang.test.codility;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    @Test
    public void test() {
        int A[] = {2,1,1,2,3,1};

        int res = solution(A);
        System.out.println("res : " + res);
    }

    private int solution(int[] A) {
        Set<Integer> dataSet = new HashSet<>();
        for(int data: A) {
            dataSet.add(data);
        }

        return dataSet.size();
    }
}
