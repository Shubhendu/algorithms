/**
 * 
 */
package com.shubhendu.javaworld.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class FindDuplicates {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> returnValList = new ArrayList<Integer>();
		int[] numArr = new int[nums.length];
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			numArr[nums[i] - 1] = ++numArr[nums[i] - 1];
			if (i != j) {
				numArr[nums[j] - 1] = ++numArr[nums[j] - 1];
			}

			i++;
			j--;
		}
		for (int idx = 0; idx < nums.length; idx++) {
			if (numArr[idx] > 1) {
				returnValList.add(idx + 1);
			}
		}

		return returnValList;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {4,3,2,7,8,2,3,1};
		FindDuplicates f = new FindDuplicates();
		List<Integer> result = f.findDuplicates(nums);
		System.out.println(result.size());

	}

}
