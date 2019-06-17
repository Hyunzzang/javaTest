package com.zzang.test.codility;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class MissingInteger {

    @Test
    public void solution() {
        int A[] = {-1,-3,-4,-5,-7,-1,-5, 1, 2};

//        SortedSet<Integer> dataSet = new TreeSet<>();
//        for (int data: A) {
//            dataSet.add(data);
//        }
//
//        int empty = 0;
//        for (int i=dataSet.first(); i < dataSet.last(); i++) {
//            if (!dataSet.contains(i) && i > 0) {
//                empty = i;
//                break;
//            }
//        }
//
//        System.out.println("empty : " + empty);
//
//        int res ;
//        if (empty > 0) {
//            res = empty;
//        } else if (empty < 0) {
//            res = 1;
//        } else {
//            if (dataSet.last() < 0 ) {
//                res = 1;
//            } else {
//                res = dataSet.last() + 1;
//            }
//        }

        int res = 1;
        Arrays.sort(A);
        for(int i : A){
            if(i > 0 & i == res){
                res++;
            }
        }

        System.out.println("res : " + res);
        assertTrue(res == 3);
    }
}
