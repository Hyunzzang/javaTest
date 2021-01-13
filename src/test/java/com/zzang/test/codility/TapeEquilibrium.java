package com.zzang.test.codility;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TapeEquilibrium {

    @Test
    public void solution() {
        int A[] = {3,1,2,4,3};

        int res = 1000000;
        int front = 0;
        int rear = 0;
        for (int s: A) rear += s;

        for (int i = 0; i < A.length-1; i++) {
            front += A[i];
            rear -= A[i];
            int sum = front - rear;
            sum = sum > 0 ? sum : sum * -1;
            System.out.println("front : " + front);
            System.out.println("rear : " + rear);
            System.out.println("Sum : " + sum);

            res = res > sum ? sum : res;
        }


        Assert.assertTrue(res == 1);
    }
}
