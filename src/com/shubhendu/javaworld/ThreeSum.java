/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> zeroSumList = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return zeroSumList;
		}

		Arrays.sort(nums);
		int sum = 0;
		int j = 0;
		int k = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				return zeroSumList;
			}
			j = i + 1;
			k = nums.length - 1;

			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (sum > 0) {
					k--;
				} else if (sum < 0) {
					j++;
				} else {

					zeroSumList.add(Arrays.asList(nums[i], nums[j], nums[k]));

					j++;
					k--;

					while ((j < k) && nums[j] == nums[j - 1]) {
						j++;
					}

					while ((j < k) && nums[k] == nums[k + 1]) {
						k--;
					}

				}
			}

			while ((i + 1) < nums.length && nums[i] == nums[i + 1]) {
				i++;
			}

		}

		return zeroSumList;
	}

	private static void printLisOfList(List<List<Integer>> list) {
		System.out.println("\nPrinting list");
		for (List<Integer> x : list) {
			printList(x);
		}
	}

	private static void printList(List<Integer> list) {
		System.out.print("[");
		for (int x : list) {
			System.out.print(x + ", ");
		}
		System.out.print("]\n");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] nums = new int[] { -1, 0, 1, 1, 2, 2, -1, -4, 4 };
		int[] nums = new int[] { -4, -1, -4, 0, 2, -2, -4, -3, 2, -3, 2, 3, 3, -4 };
		ThreeSum threeSum = new ThreeSum();
		printLisOfList(threeSum.threeSum(nums));
	}

}
