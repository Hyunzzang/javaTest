package com.zzang.test.top50.array;

/**
 * You are given a license key represented as a string s that consists of only alphanumeric
 * characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given
 * an integer k.
 * <p>
 * We want to reformat the string s such that each group contains exactly k characters, except for
 * the first group, which could be shorter than k but still must contain at least one character.
 * Furthermore, there must be a dash inserted between two groups, and you should convert all
 * lowercase letters to uppercase.
 * <p>
 * Return the reformatted license key.
 */
public class LicenseKeyFormatting {

    public static void main(String[] args) {

        String S = "5F3Z-2e-9-w";
//		String S = "2-5g-3-J";
        int k = 4;
        System.out.println(licenseKeyFormatting(S, k));
    }

    public static String licenseKeyFormatting(String S, int K) {

        String S1 = S.replace("-", "");
        S1 = S1.toUpperCase();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S1.length(); i++) {
            sb.append(S1.charAt(i));
        }
        int len = sb.toString().length();
        for (int i = K; i < len; i = i + K) {
            sb.insert(len - i, '-');
        }
        return sb.toString();
    }
}
