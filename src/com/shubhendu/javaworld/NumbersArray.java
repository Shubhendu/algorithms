package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.List;

public class NumbersArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
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
			if (numArr[idx] == 0) {
				returnValList.add(idx + 1);
			}
		}

		return returnValList;

	}

	public static void main(String[] args) {
		NumbersArray numbersArray = new NumbersArray();
//		List<Integer> returnValList = numbersArray
//				.findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1, 9, 9, 10, 11, 11 });
		// List<Integer> returnValList = numbersArray
		// .findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1, 9, 9, 10,
		// 1 });
		List<Integer> returnValList = numbersArray
				.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1 });
		System.out.println(returnValList);

	}

}
