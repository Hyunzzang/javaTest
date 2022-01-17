package com.zzang.test.top50.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramInAString {
  public static void main(String args[]) {
    FindAllAnagramInAString a = new FindAllAnagramInAString();
    String s = "abab", p = "ab";
    System.out.println(a.solve(s, p));
  }

  public List<Integer> solve(String s, String p) {
    List<Integer> resList = new ArrayList<>();

    int[] pMap = new int[26];
    for (char ch: p.toCharArray()) {
      pMap[ch-'a']++;
    }

    for (int i = 0; i < s.length() - p.length()+1; i++) {
      int[] sMap = new int[26];
      for (int j = 0; j < p.length(); j++) {
        sMap[s.charAt(i+j) - 'a']++;
      }

      if (check(pMap, sMap)) {
        resList.add(i);
      }
    }

    return resList;
  }

  public static boolean check(int[] pMap, int[] sMap) {
    for (int index = 0; index < pMap.length; index++) {
      if (pMap[index] != sMap[index]) {
        return false;
      }
    }

    return true;
  }
}
