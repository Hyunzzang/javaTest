package com.zzang.test.codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TapeEquilibrium {

    @Test
    public void solution() {
        int A[] = {3,1,2,4,3};

        int size = A.length;
        int res = 1000000;

        for (int i = 0; i < A.length-1; i++) {
            int front = front(A, i);
            int rear = rear(A, i, size);
            int sum = front - rear;
            sum = sum > 0 ? sum : sum * -1;
            System.out.println("front : " + front);
            System.out.println("rear : " + rear);
            System.out.println("Sum : " + sum);

            res = res > sum ? sum : res;
        }


        Assert.assertTrue(res == 1);
    }

    private int front(int A[], int index) {
        int sum = 0;

        while (index >= 0) {
            sum += A[index--];
        }

        return sum;
    }

    private int rear(int A[], int index, int size) {
        int sum = 0;

        for (int i = index+1; i < size; i++) {
            sum += A[i];
        }

        return sum;
    }
}
