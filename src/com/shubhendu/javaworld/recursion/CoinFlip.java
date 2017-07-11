/**
 * 
 */
package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class CoinFlip {
	private int consecutiveTailsCount;

	public double findProbability(int n) {
		this.consecutiveTailsCount = 0;
		char[] combinations = new char[n];
		List<String> result = new ArrayList<String>();
		findCombination(combinations, result, 0, n);

		double probabilty = 1 - (this.consecutiveTailsCount / Math.pow(2, n));
		return probabilty;

	}

	private void findCombination(char[] combinations, List<String> result, int idx, int n) {

		if (idx == n) {
			result.add(new String(combinations));
			return;
		}

		combinations[idx] = 'T';
		findCombination(combinations, result, idx + 1, n);
		
		if (idx > 0 && combinations[idx] == 'T' && combinations[idx - 1] == 'T') {
			this.consecutiveTailsCount++;
		}
		
		combinations[idx] = 'H';
		findCombination(combinations, result, idx + 1, n);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CoinFlip c = new CoinFlip();
		double result = c.findProbability(2);
		System.out.println(result);
		int n = 4;
		int p = (int) (Math.ceil(Math.log(n) / Math.log(2))) + 1;
		int nodes = (int) (Math.pow(2, p) - 1);
		System.out.println("nodes: "+ nodes);

	}

}
