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
public class CombinationSum {
	// public List<List<Integer>> combinationSum(int[] candidates, int target) {
	// Arrays.sort(candidates);
	// List<List<Integer>> result = new ArrayList<List<Integer>>();
	// getResult(result, new ArrayList<Integer>(), candidates, target, 0);
	//
	// return result;
	// }
	//
	// private void getResult(List<List<Integer>> result, List<Integer> cur, int
	// candidates[], int target, int start) {
	// if (target > 0) {
	// for (int i = start; i < candidates.length && target >= candidates[i];
	// i++) {
	// cur.add(candidates[i]);
	// getResult(result, cur, candidates, target - candidates[i], i);
	// cur.remove(cur.size() - 1);
	// } // for
	// } // if
	// else if (target == 0) {
	// result.add(new ArrayList<Integer>(cur));
	// } // else if
	// }

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		combinationSumRecursive(candidates, target, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void combinationSumRecursive(int[] candidates, int target, int startIndex, ArrayList<Integer> currList,
			List<List<Integer>> result) {

		if (target < 0) {
			return;
		}

		if (target == 0) {
			result.add(new ArrayList<Integer>(currList));
			return;
		}

		for (int i = startIndex; i < candidates.length && target >= candidates[i]; i++) {
			currList.add(candidates[i]);
			combinationSumRecursive(candidates, target - candidates[i], i, currList, result);
			currList.remove(currList.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		combinationSum2Recursive(candidates, target, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void combinationSum2Recursive(int[] candidates, int target, int startIndex, ArrayList<Integer> currList,
			List<List<Integer>> result) {

		if (target < 0) {
			return;
		}

		if (target == 0) {
			result.add(new ArrayList<Integer>(currList));
			return;
		}

		for (int i = startIndex; i < candidates.length && target >= candidates[i]; i++) {
			if (i > startIndex && candidates[i] == candidates[i - 1])
				continue;
			currList.add(candidates[i]);
			combinationSum2Recursive(candidates, target - candidates[i], i + 1, currList, result);
			currList.remove(currList.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combinationSum3Recursive(k, n, 1, new ArrayList<Integer>(), result);
		return result;
	}

	public void combinationSum3Recursive(int maxSize, int target, int startIndex, ArrayList<Integer> currList,
			List<List<Integer>> result) {
		if (target < 0 || currList.size() > maxSize) {
			return;
		}
		if (target == 0) {
			if (currList.size() == maxSize) {
				result.add(new ArrayList<Integer>(currList));
			} else {
				return;
			}
		}
		for (int i = startIndex; i <= 9; i++) {
			currList.add(i);
			combinationSum3Recursive(maxSize, target - i, i + 1, currList, result);
			currList.remove(currList.size() - 1);
		}
	}

	private int[] dp;

	public int combinationSum4(int[] nums, int target) {
		this.dp = new int[target + 1];
		Arrays.fill(this.dp, -1);
		this.dp[0] = 1;
		return combinationSum4Recursive(nums, target);
	}

	public int combinationSum4Recursive(int[] nums, int target) {
		if (dp[target] != -1) {
			return dp[target];
		}

		int count = 0;
		for (int i = 0; i < nums.length && target >= nums[i]; i++) {
			count += combinationSum4Recursive(nums, target - nums[i]);
		}
		dp[target] = count;
		return count;
	}

	// public void combinationSum4Recursive(int[] nums, int target, int
	// startIndex, ArrayList<Integer> currList,
	// List<List<Integer>> result) {
	// if (target < 0) {
	// return;
	// }
	//
	// if (target == 0) {
	// result.add(new ArrayList<Integer> (currList));
	// }
	//
	// for (int i = startIndex; i < nums.length && target >= nums[i]; i++) {
	// currList.add(nums[i]);
	// combinationSum4Recursive(nums, target - nums[i], startIndex, currList,
	// result);
	// currList.remove(currList.size() - 1);
	// }
	//
	// }

	private static void printList(List<List<Integer>> permutations) {
		for (List<Integer> l : permutations) {
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.println("\n===");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[] { 1, 2, 3 };
		int target = 4;

		CombinationSum c = new CombinationSum();
		// List<List<Integer>> result = c.combinationSum(nums, target);
		// printList(result);

		// nums = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		// target = 8;
		// List<List<Integer>> result = c.combinationSum2(nums, target);
		// printList(result);

		// List<List<Integer>> result = c.combinationSum3(3, 7);
		// printList(result);
		System.out.println(c.combinationSum4(nums, target));
	}

}
