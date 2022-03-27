package com.zzang.test.top50.dynamic;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer
 * amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money
 * cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange3(coins, amount));
    }

    public static int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }








    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            System.out.println("i: " + i);
            for (int j = 0; j < coins.length; j++) {
                System.out.println(": " + coins[j] + "  " + i);
                if (coins[j] <= i) {
                    System.out.println(
                        "coins[" + j + "]" + coins[j] + " i " + i + " " + (dp[i - coins[j]]));
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            System.out.println();
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static int coinChange2(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        int recur = recur(coins, amounts, amount);
        // 문제에서 특별히 주어진 동전종류로 원하는 금액을 만들 수 없는 경우 -1을
        // 리턴 해야 하므로 아래 처림 처리
        return recur > amount ? -1 : recur;
    }

    public static int recur(int[] coins, int[] amounts, int amount) {
        // 동전을 만들 수 없는 경우는 제외 하므로
        // 1원 = 1원만 필요하고 2원을 필요하지 않기 때문에 max값을 리턴하여 최소 개수계산에 제외 된다.
        if (amount < 0) {
            return Integer.MAX_VALUE - 1;
        }
        if (amount == 0) {
            return 0;
        }
        if (amounts[amount] > 0) {
            return amounts[amount]; // 불필요한 계산을 피하기위한 memorization
        }
        int min = Integer.MAX_VALUE - 1;

        // 점화식이 표현 된 부분
        for (int i = 0; i < coins.length; i++) {
            min = Math.min(min, recur(coins, amounts, amount - coins[i]) + 1);
        }

        return amounts[amount] = min;
    }
}
