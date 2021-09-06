package com.zzang.test.codility;

import java.util.*;
import org.junit.Test;

public class Fish {

  @Test
  public void test() {
    int[] A = {4, 3, 2, 1, 5};
    int[] B = {0, 1, 0, 0, 0};

    int res = solution(A, B);
    System.out.println("res : " + res);
  }


  public int solution(int[] A, int[] B) {
    Stack<Integer> downStack = new Stack<>();
    int count = 0;

    for (int i = 0; i < A.length; i++) {
      if (B[i] == 1) {
        downStack.push(A[i]);
      } else {
        while (!downStack.isEmpty()) {
          int downVal = downStack.peek();
          if (downVal < A[i]) {
            downStack.pop();
          } else {
            break;
          }
        }
        if (downStack.isEmpty()) count++;
      }
    }

    return count + downStack.size();
  }


}
