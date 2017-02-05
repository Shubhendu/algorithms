package com.shubhendu.javaworld;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		int majorityIndex = 0;
		int count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[majorityIndex] == nums[i])
				count++;
			else
				count--;

			if (count == 0) {
				majorityIndex = i;
				count = 1;
			}
		}

		return nums[majorityIndex];
	}

}
