package com.zzang.test.top50.two_pointers;

public class LongestSubWithoutRepeatChar {

  public static void main(String[] args) {
//		String input = "pwwkea";
    String input = "abcabcd";
    System.out.println(solve_1(input));
  }


  public static int solve_1(String s) {
    int[] map = new int[128];
    int start = 0, end = 0, maxLen = 0, counter = 0;

    while (end < s.length()) {
      char c1 = s.charAt(end);
      if (map[c1] > 0) counter++;
      map[c1]++;
      end++;

      while (counter > 0) {
        char c2 = s.charAt(start);
        if (map[c2] > 1) counter--;
        map[c2]--;
        start++;
      }

      maxLen = Math.max(maxLen, end - start);
    }

    return maxLen;
  }


}
