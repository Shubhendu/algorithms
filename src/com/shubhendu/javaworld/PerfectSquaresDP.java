/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.Arrays;

/**
 * @author ssingh
 *
 */
public class PerfectSquaresDP {

	public void perfectSquares(int n) {
		System.out.println("==="+n);
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				System.out.println("i: " + i + " dp[i]: " + dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
	
	public static void main(String[] args){
		PerfectSquaresDP pf = new PerfectSquaresDP();
		pf.perfectSquares(13);
//		pf.perfectSquares(1);
//		pf.perfectSquares(9);
//		pf.perfectSquares(121);
//		pf.perfectSquares(12);
//		pf.perfectSquares(13);
//		pf.perfectSquares(27);
	}

}
