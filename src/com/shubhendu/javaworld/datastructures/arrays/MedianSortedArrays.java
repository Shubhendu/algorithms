/**
 * 
 */
package com.shubhendu.javaworld.datastructures.arrays;

/**
 * @author ssingh
 *
 */
public class MedianSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int hi1 = nums1.length;
		int hi2 = nums2.length;
		return findMedianSortedArrays(nums1, nums2, 0, hi1 - 1, 0, hi2 - 1);
	}

	private double findMedianSortedArrays(int[] nums1, int[] nums2, int lo1, int hi1, int lo2, int hi2) {
		if (hi1 == lo1 && hi2 == lo2) {
			return (nums1[lo1] + nums2[lo2]) / 2;
		}

		if (hi1 - lo1 == 1 && hi2 - lo2 == 1) {
			return (double) (Math.max(nums1[lo1], nums2[lo2]) + Math.min(nums1[hi1], nums2[hi2])) / 2;
		}

		double median1 = 0;
		int mid1 = -1;

		if (lo1 == hi1) {
			median1 = nums1[lo1];
		} else {
			mid1 = lo1 + (hi1 - lo1) / 2;
			if ( ((hi1 - lo1) + 1) % 2 == 0) {
				median1 = (double) (nums1[mid1] + nums1[mid1 + 1]) / 2.0;
			} else {
				median1 = nums1[mid1];
			}
		}

		double median2 = 0;
		int mid2 = -1;
		if (lo2 == hi2) {
			median2 = nums2[lo2];
		} else {
			mid2 = lo2 + (hi2 - lo2) / 2;

			if (((hi2 - lo2) + 1) % 2 == 0) {
				median2 = (double) (nums2[mid2] + nums2[mid2 + 1]) / 2.0;
			} else {
				median2 = nums2[mid2];
			}
		}

		if (median1 == median2) {
			return median1;
		} else if (median1 > median2) {
			if (mid1 < 0) {
				mid1 = hi1 + 1;
			}
			if (mid2 < 0) {
				mid2 = lo2 - 1;
			}
			return findMedianSortedArrays(nums1, nums2, lo1, mid1, mid2 + 1, hi2);
		} else {
			if (mid1 < 0) {
				mid1 = lo1 - 1;
			}
			if (mid2 < 0) {
				mid2 = hi2 + 1;
			}
			return findMedianSortedArrays(nums1, nums2, mid1 + 1, hi1, lo2, mid2);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] nums1 = new int[] {1,3,7,8};
		int [] nums2 = new int[] {2,9};
		
		MedianSortedArrays m = new MedianSortedArrays();
		double median = m.findMedianSortedArrays(nums1, nums2);
		System.out.println(median);

	}

}
