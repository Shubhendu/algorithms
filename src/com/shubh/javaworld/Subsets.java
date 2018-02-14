package com.shubh.javaworld;

import java.util.Arrays;

public class Subsets {

	public static void printSubSets(String[] strings) {
		Arrays.sort(strings);
		int len = strings.length;
		int totalSubsets = (int) Math.pow(2, len);

		for (int i = 0; i < totalSubsets; i++) {
			for (int j = 0; j < len; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(strings[j] + " ");
				}
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[] { "b", "c", "a" };
		printSubSets(arr);
	}

}
