/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

	The update(i, val) function modifies nums by updating the element at index i to val.
	Example:
	Given nums = [1, 3, 5]
	
	sumRange(0, 2) -> 9
	update(1, 2)
	sumRange(0, 2) -> 8
	Note:
	The array is only modifiable by the update function.
	You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class NumArray2 {
	private int[] sumArr;
	private int[] nums;

	public NumArray2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		this.nums = nums;
		this.sumArr = new int[this.nums.length];
		sumArr[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sumArr[i] = sumArr[i - 1] + nums[i];
		}
	}

	public void update(int i, int val) {
		if (sumArr == null)
			return;
		if (nums[i] == val)
			return;
		if (i >= nums.length)
			return;

		int diff = val - nums[i];
		nums[i] = val;
		for (int x = i; x < sumArr.length; x++) {
			sumArr[x] = sumArr[x] + diff;
		}

	}

	public int sumRange(int i, int j) {
		if (sumArr != null && i < sumArr.length && j < sumArr.length) {
			int length = this.nums.length;
			if (i == 0) {
				return sumArr[j];
			}
			int lhs = sumArr[i - 1];
			int rhs = sumArr[length - 1] - sumArr[j];
			return sumArr[length - 1] - lhs - rhs;
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
