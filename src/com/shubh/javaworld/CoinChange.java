package com.shubh.javaworld;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		int max = amount + 1;
		Arrays.fill(dp, max);
		dp[0] = 0;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < dp.length; j++) {
				if (j % coins[i] == 0) {
					dp[j] = Math.min(dp[j], j / coins[i]);
				}
				dp[j] = Math.min(dp[coins[i]] + dp[j - coins[i]], dp[j]);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		CoinChange c = new CoinChange();
		int[] coins = new int[] { 1, 2, 5 };
		// System.out.println(c.coinChange(coins, 11));
		coins = new int[] { 2 };
		System.out.println(c.coinChange(coins, 3));

	}

}
