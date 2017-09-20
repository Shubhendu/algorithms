/**
 * 
 */
package com.shubhendu.javaworld.datastructures.arrays;

/**
 * @author ssingh
 *
 */
public class KthElementSortedArrays {

	public int getKthElement(int[] arr1, int[] arr2, int k) {
		if (k > (arr1.length + arr2.length)) {
			return -1;
		}
		int lo1 = 0;
		int lo2 = 0;

		int hi1 = arr1.length - 1;
		int hi2 = arr2.length - 1;
		int mid1 = -1;
		int mid2 = -1;

		while (true) {
			if (hi1 > lo1) {
				mid1 = lo1 + (hi1 - lo1) / 2;
			} else {
				mid1 = lo1;
			}
			if (hi2 > lo2) {
				mid2 = lo2 + (hi2 - lo2) / 2;
			} else {
				mid2 = lo2;
			}

			int size = mid1 + mid2 + 2;
			if (size == k) {
				if (arr1[mid1] > arr2[mid2]) {
					return arr1[mid1];
				} else {
					return arr2[mid2];
				}
			} else if (size == 2 && k == 1) {
				if (arr1[mid1] < arr2[mid2]) {
					return arr1[mid1];
				} else {
					return arr2[mid2];
				}
			} else if (size < k) {
				if (arr1[mid1] < arr2[mid2]) {
					lo1 = mid1 + 1;
				} else {
					lo2 = mid2 + 1;
				}

			} else {
				if (arr1[mid1] < arr2[mid2]) {
					hi2 = mid2;
				} else {
					hi1 = mid1;
				}
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] { 10, 20, 30};
		int[] nums2 = new int[] { 5, 7, 11, 21};
		KthElementSortedArrays kth = new KthElementSortedArrays();
		System.out.println(kth.getKthElement(nums1, nums2, 7));
		System.out.println(kth.getKthElement(nums1, nums2, 6));
		System.out.println(kth.getKthElement(nums1, nums2, 5));
		System.out.println(kth.getKthElement(nums1, nums2, 4));
		System.out.println(kth.getKthElement(nums1, nums2, 3));
		System.out.println(kth.getKthElement(nums1, nums2, 2));
//		System.out.println(kth.getKthElement(nums1, nums2, 1));
	}

}
