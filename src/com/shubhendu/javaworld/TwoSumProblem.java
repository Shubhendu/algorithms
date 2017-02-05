package com.shubhendu.javaworld;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumProblem {

	public int[] twoSum(int[] nums, int target) {
		Set<Integer> numSet = new HashSet<Integer>();
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		int[] sumArr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (numMap.containsKey(complement)) {
				sumArr[0] = numMap.get(complement);
				sumArr[1] = i;
				return sumArr;
			}
			numMap.put(nums[i], i);
		}
		return sumArr;

	}

	public static void main(String[] args) {
//		TwoSumProblem twoSumProblem = new TwoSumProblem();
////		int[] nums = new int[] { 1, 4, 3, 1, 5 };
//		int[] nums = new int[] { -3,4,3,90 };
//		int target = 0;
//		int[] sumArr = twoSumProblem.twoSum(nums, target);
//		System.out.println(sumArr);
		int[] arr = new int[10];
		
		Arrays.fill(arr, 1);
		// [0,4,3,0]

	}

}
