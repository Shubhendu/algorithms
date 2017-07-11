/**
 * 
 */
package com.shubhendu.javaworld.datastructures.arrays;

import java.util.HashMap;

/**
 * @author ssingh
 *
 */
public class MaxSizeSubarraySum {

	public int maxSubArrayLen(int[] nums, int k) {
		int sum = 0, max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (sum == k)
				max = i + 1;
			else if (map.containsKey(sum - k))
				max = Math.max(max, i - map.get(sum - k));
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[] {-2, -1, 2, 1};
		MaxSizeSubarraySum maxSizeSubarraySum = new MaxSizeSubarraySum();
		int m = maxSizeSubarraySum.maxSubArrayLen(nums, 1);
		System.out.println(m);

	}

}
