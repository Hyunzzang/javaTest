package com.zzang.test.top50.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {

  public static void main(String[] args) {

    String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};

    System.out.println(groupAnagrams_1(list));
  }

  public static List<List<String>> groupAnagrams_1(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> mapVal = new HashMap<>();
   for (String word: strs) {
     char[] chars = word.toCharArray();
     Arrays.sort(chars);
     String key = new String(chars);

     if (mapVal.containsKey(key)) {
       mapVal.get(key).add(word);
     } else {
       List<String> valList = new ArrayList<>();
       valList.add(word);
       mapVal.put(key, valList);
     }
   }

    return new ArrayList<>(mapVal.values());
  }















  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<List<String>>();
    }
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strs) {
      char[] arr = new char[256];
      for (int i = 0; i < str.length(); i++) {
        arr[str.charAt(i)]++;
      }
      String ns = new String(arr);
      System.out.println("ns: " + ns);

      if (map.containsKey(ns)) {
        map.get(ns).add(str);
      } else {
        ArrayList<String> al = new ArrayList<>();
        al.add(str);
        map.put(ns, al);
      }
    }
    result.addAll(map.values());
    return result;
//	        return new ArrayList<List<String>>(map.values());
  }

  public static List<List<String>> groupAnagrams1(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<List<String>>();
    }
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String keyStr = String.valueOf(ca);
      if (!map.containsKey(keyStr)) {
        map.put(keyStr, new ArrayList<String>());
      }
      map.get(keyStr).add(s);
    }
    return new ArrayList<List<String>>(map.values());
  }
}
