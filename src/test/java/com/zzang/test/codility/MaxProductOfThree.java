package com.zzang.test.codility;

import java.util.Arrays;
import org.junit.Test;

public class MaxProductOfThree {

  @Test
  public void test() {
    int A[] = {-3, 1, 2, -2, 5, 6};

    int res = solution(A);
    System.out.println("res : " + res);
  }

  public int solution(int[] A) {
    Arrays.sort(A);
    int res = A[A.length-3] * A[A.length-2] * A[A.length-1];

    // 음수
    if (A[0] <= 0 && A[1] <= 0 && A[A.length-1] >= 0) {
      int res2 = A[0] * A[1] * A[A.length-1];
      res = res < res2 ? res2 : res;
    }

    return res;
  }
}
