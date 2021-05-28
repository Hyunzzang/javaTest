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
}
