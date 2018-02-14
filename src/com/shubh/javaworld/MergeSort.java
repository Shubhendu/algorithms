package com.shubh.javaworld;

import java.util.Arrays;

public class MergeSort {

	public void sort(int[] nums) {
		int[] aux = new int[nums.length];
		sort(nums, aux, 0, nums.length - 1);
	}

	private void sort(int[] nums, int[] aux, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(nums, aux, lo, mid);
		sort(nums, aux, mid + 1, hi);
		merge(nums, aux, lo, mid, hi);
	}

	private void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = nums[i];
		}

		int i = lo;
		int j = mid + 1;
		int k = lo;
		while (k <= hi) {
			if (j > hi) {
				nums[k++] = aux[i++];
			} else if (i > mid) {
				nums[k++] = aux[j++];
			} else if (aux[j] < aux[i]) {
				nums[k++] = aux[j++];
			} else {
				nums[k++] = aux[i++];
			}
		}

		// for (int k = lo; k <= hi; k++) {
		// aux[k] = arr[k];
		// }
		// int i = lo;
		// int j = mid + 1;
		//
		// for (int k = lo; k <= hi; k++) {
		// if (j > hi) {
		// arr[k] = aux[i++];
		// } else if (i > mid) {
		// arr[k] = aux[j++];
		// } else if (aux[j] < aux[i]) {
		// arr[k] = aux[j++];
		// } else {
		// arr[k] = aux[i++];
		// }
		// }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 7, 10, 12, 4, 5, 4, 6, 9 };
		MergeSort m = new MergeSort();
		m.sort(nums);
		System.out.println(Arrays.asList(nums).toString());
		System.out.println(Integer.MIN_VALUE);
	}

}
