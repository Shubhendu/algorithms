/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * @author ssingh
 *
 */
public class RotatedArray {
	public int search(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		int pivotIndex = -1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				pivotIndex = i;
				break;
			}
		}

		int lo = pivotIndex >= 0 ? pivotIndex + 1 : 0;
		int hi = nums.length - 1;
		if (target >= nums[lo] && target <= nums[hi])
			return searchRec(nums, lo, hi, target);
		else
			return searchRec(nums, 0, pivotIndex, target);
	}

	private int searchRec(int[] nums, int lo, int hi, int target) {
		 System.out.println(" lo: " + lo + " hi: " + hi + " target: " +
		 target);
		if (hi < lo)
			return -1;
		if (target > nums[hi] && target < nums[lo])
			return -1;

		if (hi == lo + 1) {
			if (target == nums[lo])
				return lo;
			else if (target == nums[hi])
				return hi;
			else
				return -1;
		}

		int mid = (lo + hi) / 2;

		if (target == nums[mid])
			return mid;
		else if (target > nums[mid])
			return searchRec(nums, mid, hi, target);
		else
			return searchRec(nums, lo, mid, target);
	}

	public static void main(String[] args) {
		RotatedArray r = new RotatedArray();
		int[] arr = new int[] { 40, 51, 61, 71, 80, 91, 92, 103 };

		System.out.println("40: " + r.search(arr, 40));
		System.out.println("80: " + r.search(arr, 82));
		System.out.println("103: " + r.search(arr, 103));
		arr = new int[] { 3, 1};
		System.out.println("1: " + r.search(arr, 1));

	}
}
