package com.zzang.test.top50.queue_stack;

import java.util.Stack;

/**
 * You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
 *
 * At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
 *
 * An integer x - Record a new score of x.
 * "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
 * "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
 * "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
 * Return the sum of all the scores on the record.
 *
 *
 */
public class BaseballGame {
  public static void main(String[] args) {
    String[] strs = {"5","-2","4","C","D","9","+","+"};
    System.out.println(calPoints(strs));
  }

  public static int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack<>();
    for (String op : ops) {
      switch (op) {
        case "+":
          int x = stack.pop();
          int y = stack.pop();
          stack.push(y);
          stack.push(x);
          stack.push(x + y);
          break;
        case "D":
          stack.push(stack.peek() * 2);
          break;
        case "C":
          stack.pop();
          break;
        default:
          stack.push(Integer.valueOf(op));
      }
    }

    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    return sum;
  }
}
