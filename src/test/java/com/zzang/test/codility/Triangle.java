package com.zzang.test.codility;

import java.util.Arrays;
import org.junit.Test;

public class Triangle {
  @Test
  public void test() {
//    int A[] = {10, 2, 5, 1, 8, 20};
    int A[] = {1, 1, 1, 1, 5, 5, 5};

    int res = solution(A);
    System.out.println("res : " + res);
  }

  public int solution(int[] A) {
    if (3 > A.length) return 0;

    int count = 0;

    for (int i = 0; i < A.length-2; i++) {
      int a = A[i];
      for (int j = i+1; j < A.length-1; j++) {
        int b = A[j];
        for (int k = j+1; k < A.length; k++) {
          int c = A[k];
          boolean isCase_1 = checkValidat(a, b, c);
          boolean isCase_2 = checkValidat(b, c, a);
          boolean isCase_3 = checkValidat(c, a, b);
          if (isCase_1 && isCase_2 && isCase_3) {
            count++;
          }
        }
      }
    }

    return count;
  }

  private boolean checkValidat(int a, int b, int c) {
    if ((a + b) > c) {
      return true;
    } else {
      return false;
    }
  }

  public int solution_1(int[] A) {
    if (3 > A.length)
      return 0;

    Arrays.sort(A);

    for (int i = 0; i < A.length - 2; i++) {
      long P = A[i];
      long Q = A[i + 1];
      long R = A[i + 2];
      if (P + Q > R) {
        return 1;
      }
    }

    return 0;
  }
}
