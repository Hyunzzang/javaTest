package com.zzang.test.util;

import org.junit.Test;

import java.util.BitSet;

public class BitSetTest {

    @Test
    public void setTest() {
        BitSet bitset = new BitSet(8);

        // assign values to bitset1
        bitset.set(0);
        bitset.set(1);
        bitset.set(2);
        bitset.set(3);
        bitset.set(4);
        bitset.set(5);

        // print the sets
        System.out.println("Bitset:" + bitset);

        // set more values
        bitset.set(1, 10, false);

        // print the sets
        System.out.println("Bitset:" + bitset);

        bitset.set(2, 5, true);
        System.out.println("Bitset:" + bitset);
    }

    @Test
    public void getTest() {
        BitSet bitset = new BitSet(8);

        // assign values to bitset
        bitset.set(0);
        bitset.set(1);
        bitset.set(2);
        bitset.set(3);
        bitset.set(4);
        bitset.set(5);

        // print the sets
        System.out.println("Bitset:" + bitset);

        // get index 1 to 4 of bitset
        System.out.println("" + bitset.get(1,4));
    }
}
