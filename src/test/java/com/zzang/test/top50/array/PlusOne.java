package com.zzang.test.top50.array;

public class PlusOne {

    /**
     * You are given a large integer represented as an integer array digits, where each digits[i] is
     * the ith digit of the integer. The digits are ordered from most significant to least
     * significant in left-to-right order. The large integer does not contain any leading 0's.
     * <p>
     * Increment the large integer by one and return the resulting array of digits.
     *
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     *
     * Input: digits = [9]
     * Output: [1,0]
     *
     * @param args
     */
    public static void main(String[] args) {
//		int[] digits = {1,2,3};
//		int[] digits = {9,9,9};
//		int[] digits = {9,8,9};
//		int[] digits = {8,9,9};
//		int[] digits = {0,0,1};
        int[] digits = {0, 0};
//		int[] digits = {9,0,0,9};

        int[] result = plusOne2(digits);
        for (int i : result) {
            System.out.println("val: " + i);
        }
    }

    public static int[] plusOne2(int[] digits) {
        int carry = 1;
        int index = digits.length - 1;
        while (index >= 0 && carry > 0) {
            digits[index] = (digits[index] + carry) % 10;

            if (digits[index] == 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            index--;
        }

        if (carry > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
