package com.zzang.test.top50.string;

import java.util.Arrays;

public class PlusOne {

  public int[] plusOne(int[] digits) {
    for (int i = digits.length-1; i >= 0; i--) {
      digits[i] += 1;

      if (digits[i] < 10) {
        return digits;
      }

      digits[i] = 0;
    }

    int[] result = new int[digits.length + 1];
    result[0] = 1;
    for (int i=0; i < digits.length; i++) {
      result[i+1] = digits[i];
    }
    return result;
  }

  public static void main(String[] args) {
//    int[] digits = {9,0,9};
    int[] digits = {1,2,4};

    PlusOne plusOne = new PlusOne();
    int[] res = plusOne.plusOne(digits);

    System.out.println("res: " + Arrays.toString(res));
  }
}
