package com.shubhendu.javaworld;

/**
 * 
 * https://leetcode.com/problems/plus-one/#/description
 *
 */
public class AddOne {

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0 ; i--) {
			digits[i] = (digits[i] + 1) % 10;
			if (digits[i] > 0 && digits[i] < 10) {
				return digits;
			}
		}
		int[] nums = new int[digits.length + 1];
		nums[0] = 1;
		return nums;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddOne a = new AddOne();
		int[] nums = new int[] {9,9,9};
		int[] result = a.plusOne(nums);
		System.out.println(result.length);
		

	}

}
