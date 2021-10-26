package com.zzang.test;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class BaseTest {

    @Test
    public void listTest() {
        List<String> stringList = null;

        if (stringList.isEmpty()) {
            System.out.println("isEmpty");
        }

        System.out.println("OK");
    }

    @Test
    public void stringTest() {
        String str = "abcdef";

        System.out.println("charAt : " + str.charAt(1));
        System.out.println("toCharArray : " + str.toCharArray());
        System.out.println("indexOf : " + str.indexOf('a'));
        System.out.println("indexOf : " + str.indexOf("bc"));
        System.out.println("indexOf : " + str.indexOf("bc", 1));
    }
}
