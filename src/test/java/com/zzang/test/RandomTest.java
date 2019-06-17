package com.zzang.test;

import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomTest {


//    @Test
//    public void givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
//        byte[] array = new byte[7]; // length is bounded by 7
//        new Random().nextBytes(array);
//        String generatedString = new String(array, Charset.forName("UTF-8"));
//
//        System.out.println("===================================================");
//        System.out.println("givenUsingPlainJava -- 1 : " + generatedString);
//    }
//
//
//    @Test
//    public void givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {
//
//        int leftLimit = 97; // letter 'a'
//        int rightLimit = 122; // letter 'z'
//        int targetStringLength = 10;
//        Random random = new Random();
//        StringBuilder buffer = new StringBuilder(targetStringLength);
//        for (int i = 0; i < targetStringLength; i++) {
//            int randomLimitedInt = leftLimit + (int)
//                    (random.nextFloat() * (rightLimit - leftLimit + 1));
//            buffer.append((char) randomLimitedInt);
//        }
//        String generatedString = buffer.toString();
//
//        System.out.println("===================================================");
//        System.out.println("givenUsingPlainJava -- 2 : " + generatedString);
//    }
//
//
//    @Test
//    public void givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect() {
//
//        int length = 10;
//        boolean useLetters = true;
//        boolean useNumbers = false;
//        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
//
//        System.out.println("===================================================");
//        System.out.println("givenUsingApache -- 1 : " + generatedString);
//    }
//
//    @Test
//    public void givenUsingApache_whenGeneratingRandomAlphabeticString_thenCorrect() {
//        String generatedString = RandomStringUtils.randomAlphabetic(10);
//
//        System.out.println("===================================================");
//        System.out.println("givenUsingApache -- 2 : " + generatedString);
//    }
//
//    @Test
//    public void givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
//        String generatedString = RandomStringUtils.randomAlphanumeric(10);
//
//        System.out.println("===================================================");
//        System.out.println("givenUsingApache -- 3 : " + generatedString);
//    }

    @Test
    public void generatingDateDigest() {
        int i = 0;
        while (i++ < 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.nanoTime());

            String generatedString = Hashing.murmur3_32()
                    .hashString(sb.toString(), StandardCharsets.UTF_8)
                    .toString();

            System.out.println("===================================================");
            System.out.println("murmur3_32 DateDigest : " + generatedString + " : " + generatedString.length());
            System.out.println("===================================================");
            System.out.println("generatingApacheNumber : " + generatingApacheNumber());
        }
    }

    private String generatingApacheNumber() {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, 0, 0, useLetters, useNumbers, chars, new Random());
    }

}
