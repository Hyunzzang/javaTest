package com.zzang.test.codility;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinaryGap {

    @Test
    public void solution() {
        int N = 529;

        String strBina = Integer.toBinaryString(N);
        char[] binarys = strBina.toCharArray();
        System.out.println("binarys : " + strBina);

        int max = 0;
        int count = 0;
        for (int i=0; i < binarys.length; i++) {
            if (binarys[i] == '0') {
                count++;
            } else if(binarys[i] == '1') {
                max = count > max ? count : max;
                count = 0;
            }

            System.out.println("count : " + count);
            System.out.println("max : " + max);
        }

        assertTrue(max == 5);
    }
}
