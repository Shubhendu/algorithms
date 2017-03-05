/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
		You must do this in-place without making a copy of the array.
		Minimize the total number of operations.
 *
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int arrLength = nums.length;
		int i = 0;
		int j = i + 1;

		while (i < arrLength) {
			if (nums[i] == 0) {
				while (j < arrLength && nums[j] == 0) {
					j++;
				}
				if (j < arrLength) {
					nums[i] = nums[j];
					nums[j] = 0;
				} else {
					break;
				}
			}
			i++;
			j++;
		}

		System.out.println("\n After moving Zeroes");
		for (int x : nums)
			System.out.print(x + " ");
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 0, 3, 12,0,0,0,0,0,3};
		MoveZeroes m = new MoveZeroes();
		m.moveZeroes(nums);
		
		nums = new int[] {0, 1};
		m.moveZeroes(nums);
	}

}
