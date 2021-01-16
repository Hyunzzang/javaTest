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
    if (S == null || S.length() == 0) return 0;

    char[] charArray = S.toCharArray();
    Stack<Character> charStack = new Stack<>();

    for (char ch: charArray) {
      switch (ch) {
        case '}':
          if (!check(charStack, '{')) {
            return 0;
          }
          break;
        case ']':
          if (!check(charStack, '[')) {
            return 0;
          }
          break;
        case ')':
          if (!check(charStack, '(')) {
            return 0;
          }
          break;
        case '{':
        case '[':
        case '(':
          charStack.push(ch);
          break;
      }
    }

    if (charStack.isEmpty()) {
      return 1;
    }

    return 0;
  }

  private boolean check(Stack<Character> charStack, char ch) {
    if (charStack.isEmpty()) {
      return false;
    }
    char chTemp = charStack.pop();
    if (chTemp != ch) {
      return false;
    }

    return true;
  }
}
