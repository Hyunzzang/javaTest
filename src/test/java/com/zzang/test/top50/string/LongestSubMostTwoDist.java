package com.zzang.test.top50.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring t that contains at most 2 distinct
 * characters.
 */
public class LongestSubMostTwoDist {

    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, len = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                counter++;//new char
            }
            end++;
            while (counter > 2) {
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if (map.get(cTemp) == 0) {
                    counter--;
                }
                start++;
            }
            len = Math.max(len, end - start);
        }
        return len;
    }

    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() > 2) {
                max = Math.max(max, i - start);

                while (map.size() > 2) {
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if (count > 1) {
                        map.put(t, count - 1);
                    } else {
                        map.remove(t);
                    }
                    start++;
                }
            }
        }

        max = Math.max(max, s.length() - start);

        return max;
    }

    public int LengthOfLongestSubstringTwoDistinct2(String s) {
        int left1 = -1;
        int left2 = -1;
        int len = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (left1 == -1 || s.charAt(i) == s.charAt(left1)) {
                left1 = i;
                len++;
                max = Math.max(max, len);
            } else if (left2 == -1 || s.charAt(i) == s.charAt(left2)) {
                left2 = i;
                len++;
                max = Math.max(max, len);
            } else {
                if (left1 < left2) {
                    len = i - left1;
                    left1 = i;
                } else {
                    len = i - left2;
                    left2 = i;
                }
            }
        }
        return max;
    }

}
