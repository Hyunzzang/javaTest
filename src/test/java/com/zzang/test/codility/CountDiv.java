package com.zzang.test.codility;

import org.junit.Test;

public class CountDiv {

  @Test
  public void test() {
    int A = 6;
    int B = 11;
    int K = 2;

    int res = solution_2(A, B, K);
    System.out.println("res : " + res);
  }

  private int solution_1(int A, int B, int K) {
    int count = 0;
    for (int i = A; i <= B; i++) {
      if ((i % K) == 0) {
        count++;
      }
    }

    return count;
  }

  private int solution_2(int A, int B, int K) {
    int count = 0;
    if (A % K == 0) {
      count++;
    }
    if (A != B) {
      int firstDivided = A / K;
      int secondDivided = B / K;
      count += secondDivided - firstDivided;
    }
    return count;
  }
}
