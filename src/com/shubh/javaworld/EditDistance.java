package com.shubh.javaworld;

/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

	You have the following 3 operations permitted on a word:
	
	a) Insert a character
	b) Delete a character
	c) Replace a character
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1.equals(word2)) {
			return 0;
		}
		if (word1.length() == 0 || word2.length() == 0) {
			return Math.abs(word1.length() - word2.length());
		}

		int r = word1.length();
		int c = word2.length();
		int[] dp = new int[c + 1];

		for (int j = 0; j <= c; j++) {
			dp[j] = j;
		}
		for (int i = 1; i <= r; i++) {
			int[] curr = new int[c + 1];
			curr[0] = i;
			for (int j = 1; j <= c; j++) {
				char c1 = word1.charAt(i - 1);
				char c2 = word2.charAt(j - 1);
				if (c1 == c2) {
					curr[j] = dp[j - 1];
				} else {
					curr[j] = 1 + Math.min(Math.min(curr[j - 1], dp[j - 1]), dp[j]);
				}
			}
			dp = curr;
		}
		return dp[c];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
