/**
 * 
 */
package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: 
 * [ 
 * 	[1,1,2],
 * 	[1,2,1],
 *  [2,1,1] 
 * ]
 *
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			if (numMap.get(nums[i]) != null) {
				count = numMap.get(nums[i]);
			}
			numMap.put(nums[i], count + 1);
		}
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		Integer[] numArr = new Integer[nums.length];
		permuteRec(nums, numMap, permutations, 0, numArr);

		return permutations;
	}

	private void permuteRec(int[] nums, Map<Integer, Integer> numMap, List<List<Integer>> permutations, int depth,
			Integer[] numArr) {

		if (depth == nums.length) {
			permutations.add(new ArrayList<Integer>(Arrays.asList(numArr)));
			return;
		}

		for (Integer key : numMap.keySet()) {
			if (numMap.get(key) > 0) {
				numArr[depth] = key;
				numMap.put(key, numMap.get(key) - 1);
				permuteRec(nums, numMap, permutations, depth + 1, numArr);
				numMap.put(key, numMap.get(key) + 1);
			}
		}

	}

	private static void printList(List<List<Integer>> permutations) {
		for (List<Integer> l : permutations) {
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.println("\n===");
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3 };
		PermutationsII perm = new PermutationsII();
		List<List<Integer>> permutations = perm.permuteUnique(nums);
		printList(permutations);
	}
}
