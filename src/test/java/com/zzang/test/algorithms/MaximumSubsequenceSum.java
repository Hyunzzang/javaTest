package com.zzang.test.algorithms;

public class MaximumSubsequenceSum {

	static void solution1(int[] arrVal) {
		int valLen = arrVal.length;
		int maxSum = 0;
		for (int i = 0; i < valLen; i++) {
			int sum = 0;
			for (int j = i; j < valLen; j++) {
				sum += arrVal[j];
				maxSum = Math.max(maxSum, sum);
			}
		}

		System.out.println("solution1 Max sum: " + maxSum);
	}

	static void solution2(int[] arrVal) {
		int valLen = arrVal.length;
		int maxSum = 0;
		int sum = 0;

		for (int i = 0; i < valLen; i++) {
			sum = Math.max(arrVal[i], sum + arrVal[i]);
			maxSum = Math.max(maxSum, sum);
		}

		System.out.println("solution1 Max sum: " + maxSum);
	}

	public static void main(String[] args) {
		int[] arrVal = {-1, 2, 4, -3, 5, 2, -5, 2};
		solution2(arrVal);
	}
}
