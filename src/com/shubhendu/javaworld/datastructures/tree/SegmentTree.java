/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.Arrays;

/**
 * @author ssingh
 *
 */
public class SegmentTree {
	private int[] segmentTree;

	public SegmentTree(int[] arr) {
		int n = arr.length;
		int power = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSize = (int) (2 * Math.pow(2, power) - 1);
		this.segmentTree = new int[maxSize];
		Arrays.fill(this.segmentTree, Integer.MAX_VALUE);
		constructSegmentTree(arr, 0, arr.length - 1, 0);
	}

	private void constructSegmentTree(int[] arr, int lo, int hi, int pos) {
		if (hi <= lo) {
			this.segmentTree[pos] = arr[lo];
			return;
		}
		int mid = lo + (hi - lo) / 2;
		constructSegmentTree(arr, lo, mid, 2 * pos + 1);
		constructSegmentTree(arr, mid + 1, hi, 2 * pos + 2);

		this.segmentTree[pos] = Math.min(this.segmentTree[2 * pos + 1], this.segmentTree[2 * pos + 2]);
	}

	public int minRange(int qLo, int qHi) {
		return minRange(qLo, qHi, 0, 3, 0);
	}

	private int minRange(int qLo, int qHi, int lo, int hi, int pos) {
		if(qLo <= lo && qHi >= hi){
			// Total overlap
			return this.segmentTree[pos];
		}  
		if(qLo > hi || qHi < lo){
			// No overlap
			return Integer.MAX_VALUE;
		} 
		
		int mid = (hi + lo) / 2;
		return Math.min(minRange(qLo, qHi, lo, mid, 2 * pos + 1), minRange(qLo, qHi, mid + 1, hi, 2 * pos + 2));
		

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] {-1, 4, 0, -2};
		SegmentTree sTree = new SegmentTree(arr);
		//System.out.println(sTree.minRange(0, 3));
		System.out.println(sTree.minRange(1, 2));
		System.out.println(sTree.minRange(2, 3));
		System.out.println(sTree.minRange(0, 1));
	}

}
