package com.zzang.test.codility;

import java.util.Arrays;
import org.junit.Test;

public class NumberOfDiscIntersections {

  @Test
  public void test() {
    int A[] = {1, 5, 2, 1, 4, 0};

    int res = solution(A);
    System.out.println("res : " + res);
  }

  public int solution(int[] A) {
    Disc[] discs = new Disc[A.length];
    int aLen = A.length;
    int count = 0;

    for (int i = 0; i < aLen; i++) {
      Disc disc = new Disc();
      disc.left = i - A[i];
      disc.right = i + A[i];
      discs[i] = disc;
    }

    Arrays.sort(discs, (a, b) -> a.left - b.left);

    for (int i = 0; i < aLen - 1; i++) {
      int right = discs[i].right;
      for (int j = i + 1; j < aLen && right >= discs[j].left; j++) {
        count++;
        if (10000000 < count) {
          return -1;
        }
      }
    }

    return count;
  }

  class Disc {
    public int left;
    public int right;
  }

  public int solution_1(int[] A) {
    int N = A.length;
    long[] lower = new long[N];
    long[] upper = new long[N];

    for (int i = 0; i < N; i++) {
      lower[i] = i - (long) A[i];
      upper[i] = i + (long) A[i];
    }

    Arrays.sort(lower);
    Arrays.sort(upper);

    int intersection = 0;
    int j = 0;

    for (int i = 0; i < N; i++) {
      while (j < N && upper[i] >= lower[j]) {
        intersection += j;
        intersection -= i;
        j++;
      }
    }

    if (intersection > 10000000) {
      return -1;
    }
    return intersection;
  }
}
