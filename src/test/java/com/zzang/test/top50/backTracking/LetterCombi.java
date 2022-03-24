package com.zzang.test.top50.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 * the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 */
public class LetterCombi {

    public static void main(String[] args) {
        LetterCombi a = new LetterCombi();
        a.solve("23");
    }

    public List<String> solve(String digits) {
        String digitletter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<String>();

        if (digits.length() == 0) {
            return result;
        }

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            result = combine(digitletter[digits.charAt(i) - '0'], result);
        }

        return result;
    }

    public List<String> combine(String digit, List<String> firstList) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < digit.length(); i++) {
            for (String firstStr : firstList) {
                result.add(firstStr + digit.charAt(i));
            }
        }

        return result;
    }
}
