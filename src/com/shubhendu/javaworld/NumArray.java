package com.shubhendu.javaworld;
/**
 * 
 */

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

	Example:
	Given nums = [-2, 0, 3, -5, 2, -1]
	
	sumRange(0, 2) -> 1
	sumRange(2, 5) -> -1
	sumRange(0, 5) -> -3
	Note:
	You may assume that the array does not change.
	There are many calls to sumRange function.
 *
 */
public class NumArray {
	private int[] sumArr;
	private int length;

	public NumArray(int[] nums) {
		if (nums == null || nums.length==0) {
			return;
		}
		this.length = nums.length;
		this.sumArr = new int[length];
		sumArr[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sumArr[i] = sumArr[i - 1] + nums[i];
		}

	}

	public int sumRange(int i, int j) {
		if (sumArr != null && i < sumArr.length && j < sumArr.length) {
			if (i == 0) {
				return sumArr[j];
			}
			int lhs = sumArr[i-1];
			int rhs = sumArr[length - 1] - sumArr[j];
			return sumArr[length - 1] - lhs - rhs;
		}
			
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { -2, 0, 3, -5, 2, -1 };
		NumArray numArray = new NumArray(nums);
//		System.out.println(numArray.sumRange(0, 2));
//		System.out.println(numArray.sumRange(0, 3));
		System.out.println(numArray.sumRange(2, 0));
//		System.out.println(numArray.sumRange(0, 0));
//		System.out.println(numArray.sumRange(0, 1));
//
//		nums = new int[] {};
//		numArray = new NumArray(nums);
//		System.out.println(numArray.sumRange(0, 2));
	}

}
