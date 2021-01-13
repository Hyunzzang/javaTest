package com.zzang.test.codility;

import org.junit.Test;

import java.util.Arrays;

public class MaxCounters {

  @Test
  public void solution() {
    int N = 5;
    int A[] = {3, 4, 4, 6, 1, 4, 4};

    int max = 0;
    int maxVal = 0;
    int counter[] = new int[N];

    for (int i = 0; i < A.length; i++) {
      if (A[i] <= N) {
        if (counter[A[i] - 1] < maxVal) {
          counter[A[i] - 1] = maxVal;
        }
        counter[A[i] - 1] += 1;
        max = counter[A[i] - 1] > max ? counter[A[i] - 1] : max;
      } else {
        maxVal = max;
      }
    }

    for (int j = 0; j < counter.length; j++) {
      if (counter[j] < maxVal) {
        counter[j] = maxVal;
      }
    }

    System.out.println("====> " + Arrays.toString(counter));
  }
}
