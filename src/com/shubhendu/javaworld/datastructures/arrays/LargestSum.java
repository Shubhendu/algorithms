package com.shubhendu.javaworld.datastructures.arrays;

import java.util.Arrays;

public class LargestSum {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		String[] numsArr = new String[nums.length];
		int i = 0;
		for (int n : nums) {
			numsArr[i++] = String.valueOf(n);
		}
		Arrays.sort(numsArr, (n1, n2) -> ((n2 + n1).compareTo(n1 + n2)));

		if (numsArr[0].charAt(0) == '0') {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (String s : numsArr) {
			sb.append(s);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LargestSum l = new LargestSum();
		System.out.println(l.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(l.largestNumber(new int[] { 0, 3, 2, 1, 0 }));
		System.out.println(l.largestNumber(new int[] { 0, 0, 0 }));

	}

}
