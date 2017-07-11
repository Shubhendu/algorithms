package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSum {

	private int count;
	private List<String> expressions;
	private Map<String, Integer> dp;

	public int findTargetSumWays(int[] nums, int S) {
		this.count = 0;
		this.dp = new HashMap<String, Integer>();
		expressions = new ArrayList<String>();
		char[] resultArr = new char[nums.length * 2];
		return backTrack(nums, resultArr, 0, 0, S);
	}

	private int backTrack(int[] nums, char[] resultArr, int startIndex, int operandIndex, int target) {
		if (this.dp.containsKey(new String(resultArr))) {
			return this.dp.get(new String(resultArr));
		}
		if (startIndex >= nums.length) {
			String key = new String(resultArr);
			if (target == 0) {
				count++;
				expressions.add(key);
			}
			this.dp.put(key, count);
			return count;
		}

		// for (int i = startIndex; i < nums.length; i++) {
		// resultArr[operandIndex++] = '+';
		// resultArr[operandIndex++] = (char) (nums[i] + '0');
		// backTrack(nums, resultArr, i + 1, operandIndex, target - nums[i]);
		// operandIndex -= 2;
		//
		// resultArr[operandIndex++] = '-';
		// resultArr[operandIndex++] = (char) (nums[i] + '0');
		// backTrack(nums, resultArr, i + 1, operandIndex, nums[i] + target);
		// operandIndex -= 2;
		//
		// }
		resultArr[operandIndex++] = '+';
		resultArr[operandIndex++] = (char) (nums[startIndex] + '0');
		backTrack(nums, resultArr, startIndex + 1, operandIndex, target - nums[startIndex]);
		operandIndex -= 2;

		resultArr[operandIndex++] = '-';
		resultArr[operandIndex++] = (char) (nums[startIndex] + '0');
		backTrack(nums, resultArr, startIndex + 1, operandIndex, nums[startIndex] + target);
		operandIndex -= 2;

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] nums = new int[] { 1, 1, 1, 1, 1 };
//		int target = 3;
//		TargetSum t = new TargetSum();
//		int count = t.findTargetSumWays(nums, target);
//		System.out.println(count);

		int[] nums = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}; // new int[] { 1, 3, 2, 0, 1 };
		int target = 1;
		TargetSum t = new TargetSum();
		int count = t.findTargetSumWays(nums, target);
		System.out.println(count);
		
		nums = new int[] { 1, 1, 1, 1, 1 };
		target = 3;
		count = t.findTargetSumWays(nums, target);
		System.out.println(count);
	}

}
