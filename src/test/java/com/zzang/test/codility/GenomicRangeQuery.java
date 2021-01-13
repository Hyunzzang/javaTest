package com.zzang.test.codility;

import org.junit.Test;

import java.util.Arrays;

public class GenomicRangeQuery {

  @Test
  public void test() {
    String S = "CAGCCTA";
    int[] P = {2, 5, 0};
    int[] Q = {4, 5, 6};

    int res[] = solution_1(S, P, Q);
    System.out.println("res : " + Arrays.toString(res));
  }

  private int[] solution(String S, int[] P, int[] Q) {
    char ch[] = S.toCharArray();

    int res[] = new int[P.length];

    for (int i = 0; i < P.length; i++) {
      int start = P[i];
      int end = Q[i] + 1;
      char temp[] = Arrays.copyOfRange(ch, start, end);
      Arrays.sort(temp);
      res[i] = convert(temp[0]);
    }

    return res;
  }


  private int convert(char ch) {
    int A = 1;
    int C = 2;
    int G = 3;
    int T = 4;

    switch (ch) {
      case 'A':
        return A;
      case 'C':
        return C;
      case 'T':
        return T;
      case 'G':
        return G;
    }

    return 0;
  }

  public int[] solution_1(String S, int[] P, int[] Q) {
    int[][] individualCount = new int[4][S.length()+1];
    int res[] = new int[P.length];

    char ch[] = S.toCharArray();
    for (int i = 0; i < ch.length; i++) {
      for (int j = 0; j < individualCount.length; j++) {
        individualCount[j][i + 1] = individualCount[j][i];
      }
      int dnaIndex = convert(ch[i]);
      individualCount[dnaIndex - 1][i+1]++;
    }

    for (int i = 0; i < P.length; i++) {
      for (int j = 0; j < 4; j++) {
        if (individualCount[j][Q[i] + 1] - individualCount[j][P[i]] > 0) {
          res[i] = j + 1;
          break;
        }
      }
    }

    return res;
  }


  public int[] solution_2(String S, int[] P, int[] Q) {
    int aCnt[] = new int[S.length() + 1];
    int cCnt[] = new int[S.length() + 1];
    int gCnt[] = new int[S.length() + 1];

    int min[] = new int[P.length];

    int ptmp;
    int qtmp;

    for (int i = 0; i < S.length(); i++) {
      aCnt[i + 1] = aCnt[i];
      cCnt[i + 1] = cCnt[i];
      gCnt[i + 1] = gCnt[i];

      if (S.charAt(i) == 'A') {
        aCnt[i + 1]++;
      } else if (S.charAt(i) == 'C') {
        cCnt[i + 1]++;
      } else if (S.charAt(i) == 'G') {
        gCnt[i + 1]++;
      }
    }

    for (int j = 0; j < P.length; j++) {
      ptmp = P[j];
      qtmp = Q[j];

      if (aCnt[ptmp] != aCnt[qtmp + 1]) {
        min[j] = 1;
      } else if (cCnt[ptmp] != cCnt[qtmp + 1]) {
        min[j] = 2;
      } else if (gCnt[ptmp] != gCnt[qtmp + 1]) {
        min[j] = 3;
      } else {
        min[j] = 4;
      }
    }

    return min;
  }


  public int[] solution_3(String S, int[] P, int[] Q) {
    int length = S.length();
    int impactLength = 4;
    int[] impactCnt = new int[impactLength];
    int[][] impactFactorArray = new int[impactLength][length + 1];

    char c;
    int impactFactor = 0;
    for (int i = 0; i < length; i++) {
      c = S.charAt(i);
      if ('A' == c) {
        impactFactor = 1;
      } else if ('C' == c) {
        impactFactor = 2;
      } else if ('G' == c) {
        impactFactor = 3;
      } else if ('T' == c) {
        impactFactor = 4;
      }

      impactCnt[impactFactor - 1] += 1;

      for (int j = 0; j < impactLength; j++) {
        impactFactorArray[j][i + 1] = impactCnt[j];
      }
    }

    int[] result = new int[P.length];
    for (int i = 0; i < P.length; i++) {
      for (int j = 0; j < impactLength; j++) {
        if (impactFactorArray[j][Q[i] + 1] - impactFactorArray[j][P[i]] > 0) {
          result[i] = j + 1;
          break;
        }
      }
    }
    return result;
  }
}
