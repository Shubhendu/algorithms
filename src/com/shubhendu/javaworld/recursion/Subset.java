/**
 * 
 */
package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class Subset {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		Integer[] arr;
		
		for (int i = 0; i < nums.length; i++) {
			int maxSize = i + 1;
			arr = new Integer[maxSize];
			collectSubSets(nums, 0, maxSize, sets, arr);
		}

		return sets;
	}

	private void collectSubSets(int[] nums, int startIndex, int maxSize, List<List<Integer>> sets, Integer[] arr) {
		if (startIndex == arr.length) {
			sets.add(new ArrayList<Integer>(Arrays.asList(arr)));
			return;
		}

		for (int i = startIndex; i < arr.length; i++) {
			arr[i] = nums[i];
			collectSubSets(nums, startIndex + 1, maxSize, sets, arr);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
