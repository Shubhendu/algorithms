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
public class Combination {
	private static void printLisOfList(List<List<Integer>> list) {
		System.out.println("\nPrinting list");
		for (List<Integer> x : list) {
			printList(x);
		}
	}

	private static void printList(List<Integer> list) {
		System.out.print("[");
		for (int x : list) {
			System.out.print(x + ", ");
		}
		System.out.print("]\n");
	}

	public List<List<Integer>> combination(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combination(n, k, 1, new ArrayList<Integer>(), result);
		return result;
	}

	private void combination(int n, int k, int start, List<Integer> numList, List<List<Integer>> result) {
		if (numList.size() == k) {
			result.add(new ArrayList<Integer>(numList));
			return;
		}

		for (int i = start; i <= n; i++) {
			numList.add(i);
			combination(n, k, i + 1, numList, result);
			numList.remove(numList.size() - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 5;
		int k = 2;
		Combination c = new Combination();
		List<List<Integer>> result = c.combination(n, k);
		printLisOfList(result);

	}

}
