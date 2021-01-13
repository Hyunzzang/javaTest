package com.zzang.test.codility;

import org.junit.Test;


public class MinAvgTwoSlice {

  @Test
  public void test() {
    int A[] = {4, 2, 2, 5, 1, 5, 8};

    int res = solution(A);
    System.out.println("res : " + res);
  }

  public int solution(int[] A) {
    int minIndex = 0;
    float min = Float.MAX_VALUE;

    for (int i = 0; i < A.length - 1; i++) {
      int sum = A[i];
      int count = 1;
      for (int j = i + 1; j < A.length; j++) {
        sum += A[j];
        count++;
        float avg = (float) sum / (float) count;

        if (avg < min) {
          min = avg;
          minIndex = i;
        }

        if (count == 3) {
          break;
        }
      }
    }

    return minIndex;
  }

  private int solution_2(int[] A) {
    float minAvg = (A[0] + A[1]) / 2f;
    int minIndex = 0;
    for (int i = 2; i < A.length; i++) {
      float avg = (A[i - 2] + A[i - 1] + A[i]) / 3f;
      if (minAvg > avg) {
        minAvg = avg;
        minIndex = i - 2;
      }

      avg = (A[i - 1] + A[i]) / 2f;
      if (minAvg > avg) {
        minAvg = avg;
        minIndex = i - 1;
      }
    }
    return minIndex;
  }
}
