package com.zzang.test.codility;

import java.util.Stack;
import org.junit.Test;

public class Brackets {

  @Test
  public void test() {
    String S = "{[()()]}";
//    String S = "))dsfd))))))))";

    int res = solution(S);
    System.out.println("res : " + res);
  }

  public int solution(String S) {
    char[] charArray = S.toCharArray();
    Stack<Character> charStack = new Stack<>();

    for (char ch: charArray) {
      if ('{' == ch || '[' == ch || '(' == ch) {
        charStack.push(ch);
      } else {
        if (charStack.isEmpty()) {
          return 0;
        }
        char chTemp = charStack.pop();
        if ('}' == ch && chTemp != '{') {
          return 0;
        } else if (']' == ch && chTemp != '[') {
          return 0;
        } else if (')' == ch && chTemp != '(') {
          return 0;
        }
      }
    }

    if (charStack.isEmpty()) {
      return 1;
    }

    return 0;
  }
}
