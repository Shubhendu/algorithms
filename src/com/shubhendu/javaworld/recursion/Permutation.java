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
public class Permutation {

	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permute(num, 0, result);
		return result;
	}

	void permute(int[] num, int start, List<List<Integer>> result) {

		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}

		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
		}
	}

	private ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String x = ".abc.";
		System.out.println(x.substring(0,1));
		
//		int[] nums = new int[] {1,2,3};
//		Permutation p = new Permutation();
//		List<List<Integer>> permutations = p.permute(nums);
//		for (List<Integer> numList : permutations) {
//			System.out.println("\n===");
//			for (Integer n : numList) {
//				System.out.print(n+ " ");
//			}
//		}
	}

}
