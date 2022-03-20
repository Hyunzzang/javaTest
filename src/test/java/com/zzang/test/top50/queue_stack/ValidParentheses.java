package com.zzang.test.top50.queue_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses {
  public static void main(String[] args) {
    //String str= "()[]{}"  ;//true;
    //String str= "(}"  ;//false;
    String exp = "([}}])";
    System.out.println(solve(exp));
  }


  public static boolean solve(String str) {
    Stack<Character> stack = new Stack<>();
    for(char c: str.toCharArray()) {
      System.out.println("c: "+c);
      if(c=='(') {
        stack.push(')');
      }else if(c=='[') {
        stack.push(']');
      }else if(c=='{') {
        stack.push('}');
      }else if(stack.isEmpty()|| stack.pop() != c) {
        return false;
      }

    }
    return stack.isEmpty();
  }

  public static boolean isValid_map(String str) {
    Map<Character, Character> map = new HashMap<>();
    map.put('{', '}');
    map.put('(', ')');
    map.put('[', ']');
    Stack<Character> stack = new Stack<>();

    for(int i=0; i<str.length(); i++) {
      char c = str.charAt(i);
      if(map.containsKey(c)) {
        stack.push(c);
      }else if(map.containsValue(c)) {
        if(!stack.isEmpty() && map.get(stack.peek())==c) {
          stack.pop();
        }else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
