package com.zzang.test.codility;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FrogJumper {

    @Test
    public void solution() {
        int X = 10;
        int Y = 85;
        int D = 30;

        int count = 0;

//        int position = X;
//        while (position < Y) {
//            position += D;
//            count++;
//        }

        int temp_1 = (int) Math.ceil((double) (Y-X) / (double) D);

        System.out.println("temp1 : " + temp_1);

        assertTrue(temp_1 == 3);
    }
}
