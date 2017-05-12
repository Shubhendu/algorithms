/**
 * 
 */
package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ssingh
 *
 */
public class Subset {
	private int[] nums;

	public List<List<Integer>> subsetsOrig(int[] nums) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return sets;
		}

		this.nums = nums;
		int[] numArr = null;
		for (int i = 0; i <= nums.length; i++) {
			numArr = new int[i];
			subsets(i, 0, 0, numArr, sets);
		}

		return sets;
	}

	private void subsets(int maxSize, int startIndex, int currIndex, int[] numArr, List<List<Integer>> sets) {
		if (startIndex > this.nums.length) {
			return;
		}

		if (currIndex >= maxSize) {
			sets.add(Arrays.stream(numArr).boxed().collect(Collectors.toList()));
			return;
		}

		for (int i = startIndex; i < this.nums.length; i++) {
			numArr[currIndex++] = nums[i];
			subsets(maxSize, i + 1, currIndex, numArr, sets);
			currIndex--;
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		Subset subSet = new Subset();
		printLisOfList(subSet.subsets(nums));

	}

}
