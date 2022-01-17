package com.zzang.test.top50.two_pointers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 최대 두 개의 고유 문자 를 포함하는 가장 긴 부분 문자열의 길이를 리턴하세요
 * Input: s = "eceba" Output: 3 Explanation: "ece"
 * Input: s = "ccaabbb" Output: 5 Explanation: "aabbb"
 */
public class LongestSubMostTwoDistinct {
  public static void main(String[] args) {
    String s = "ccaabbb";
    System.out.println(solve(s));
  }

  public static int solve(String s) {
    int[] map = new int[128];
    int left = 0, right = 0, maxLen = 0, counter = 0;

    while (right < s.length()) {
      char chRight = s.charAt(right);
      if (map[chRight] == 0) {
        counter++;
      }
      map[chRight]++;
      right++;

      while (counter > 2) {
        char chLeft = s.charAt(left);
        if (map[chLeft] == 1) {
          counter--;
        }
        map[chLeft]--;
        left++;
      }

      maxLen = Math.max(maxLen, right - left);
    }

    return maxLen;
  }
}
