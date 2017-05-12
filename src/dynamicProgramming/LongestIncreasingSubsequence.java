/**
 * 
 */
package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the
 * longest subsequence of a given sequence such that all elements of the
 * subsequence are sorted in increasing order. For example, the length of LIS
 * for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60,
 * 80}.
 *
 */
public class LongestIncreasingSubsequence {

	/*
	 * Accepts an int array arr[]. Let lis[i] = length of LIS ending at arr[i]
	 * lis[i] = max of (lis[j] for all j<i and arr[i] > arr[j]) + arr[i]
	 */
	public static int findLIS(int[] arr) {
		int arrLength = arr.length;
		int[] lis = new int[arrLength];
		lis[0] = 1;
		int maxLength = lis[0];

		List<Integer> longestIncreasingSub = new ArrayList<Integer>();

		for (int i = 1; i < arrLength; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;

					if (lis[i] > maxLength) {
						maxLength = lis[i];
						if (longestIncreasingSub.isEmpty()) {
							longestIncreasingSub.add(j);
						}
						longestIncreasingSub.add(i);
						break;
					}
				}
			}
		}

		System.out.println("\nmaxLength: " + maxLength);

		for (int x : longestIncreasingSub) {
			System.out.print(arr[x] + "\t");
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		LongestIncreasingSubsequence.findLIS(arr);

		arr = new int[] { 10, 22, 9, 33, 21, 50, 39, 2, 80 };
		LongestIncreasingSubsequence.findLIS(arr);
	}

}
