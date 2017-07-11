package com.shubhendu.javaworld.datastructures.tree;

public class SegmentTreeSum {
	private int[] nums;
	private int[] segmentTree;

	public SegmentTreeSum(int[] nums) {
        if (nums != null && nums.length > 0) {
            this.nums = nums;
            int n = nums.length;
            int power = (int) Math.ceil(Math.log(n) / Math.log(2));
            int maxSize = 2 * ((int) Math.pow(2, power)) - 1;
            this.segmentTree = new int[maxSize];
            constructSegmentTree(0, n - 1, 0);
        }
    }

	private void constructSegmentTree(int lo, int hi, int pos) {
		if (hi <= lo) {
			this.segmentTree[pos] = this.nums[lo];
			return;
		}
		int mid = lo + (hi - lo) / 2;
		constructSegmentTree(lo, mid, 2 * pos + 1);
		constructSegmentTree(mid + 1, hi, 2 * pos + 2);

		this.segmentTree[pos] = this.segmentTree[2 * pos + 1] + this.segmentTree[2 * pos + 2];

	}

	public void update(int i, int val) {
		if (this.nums == null || this.nums.length == 0) {
			return;
		}
		update(i, val, 0, this.nums.length - 1, 0);
	}

	private void update(int i, int val, int lo, int hi, int pos) {
		System.out.println(i + " " + val + " " + lo + " " + hi + " " + pos);
		if (lo > i || hi < i) {
			return;
		}

		if (hi <= lo) {

			this.segmentTree[pos] = val;
			return;
		}

		int mid = lo + (hi - lo) / 2;
		update(i, val, lo, mid, 2 * pos + 1);
		update(i, val, mid + 1, hi, 2 * pos + 2);
		this.segmentTree[pos] = this.segmentTree[2 * pos + 1] + this.segmentTree[2 * pos + 2];
	}

	public int sumRange(int i, int j) {
		if (this.nums == null || this.nums.length == 0) {
			return 0;
		}

		if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
			return 0;
		}
		return sumRange(0, nums.length - 1, i, j, 0);
	}

	private int sumRange(int lo, int hi, int qLo, int qHi, int pos) {
		if (hi < qLo || lo > qHi) {
			return 0;
		}

		if (lo >= qLo && hi <= qHi) {
			return this.segmentTree[pos];
		}

		int mid = lo + (hi - lo) / 2;
		return sumRange(lo, mid, qLo, qHi, 2 * pos + 1) + sumRange(mid + 1, hi, qLo, qHi, 2 * pos + 2);
	}

	public static void main(String[] args) {
		int[] arr = new int[] {9,-8};
		SegmentTreeSum sm = new SegmentTreeSum(arr);
		sm.update(0, 3);
		System.out.println(sm.sumRange(1, 1));
		String s= "dasdaa";
		
		

	}
	/*
	 * public class SegmentTree {
	private int[] numArr;

	public SegmentTree(int[] arr) {
		int n = arr.length;
		int p = (int) Math.ceil(Math.log(2) / Math.log(n)) + 1;
		int numOfNodes = (int) Math.pow(2, p) - 1;
		constructSegmentTree(arr, 0, arr.length - 1, 0);
	}

	private void constructSegmentTree(int[] arr, int lo, int hi, int pos) {
		if (hi < lo) {
			return;
		}
		if (lo == hi) {
			this.numArr[pos] = arr[lo];
			return;
		}
		int mid = lo + (hi - lo) / 2;
		constructSegmentTree(arr, lo, mid, 2*pos + 1);
		constructSegmentTree(arr, mid + 1, hi, 2*pos + 2);
		this.numArr[pos] = this.numArr[2*pos + 1] + this.numArr[2*pos + 2];
	}

	public int sumRange(int lo, int hi) {
		return sumRange(lo, hi, 0, numArr.length - 1, 0);
	}

	private int sumRange(int qLo, int qHi, int lo, int hi, int pos) {
		if (lo > qHi || hi < qLo) {
			// No coverage
			return 0;
		}

		if (lo >= qLo && hi <= qHi) {
			// Full coverage
			return this.numArr[pos];
		}

		int mid = lo + (hi - lo) / 2;
		int left = sumRange(qLo, qHi, lo, mid, 2*pos + 1);
		int right = sumRange(qLo, qHi, mid + 1, hi, 2*pos + 2);
		return left + right;
	}

	public void update(int idx, int newVal) {
		update(0, numArr.length - 1, 0, idx, newVal);
	}

	private update(int lo, int hi, int pos, int idx, int newVal) {
		if (hi < lo) {
			return;
		}

		if (lo > idx || hi < idx) {
			return;
		}

		if (lo == idx && hi == idx) {
			this.numArr[pos] = newVal;
			return;
		}
		int mid = lo + (hi - lo) / 2;
		update(lo, mid, 2*pos + 1, idx, newVal);
		update(mid + 1, hi, 2*pos + 1, idx, newVal);
		this.numArr[pos] = this.numArr[2*pos + 1] + this.numArr[2*pos + 2];
	}
}
	 */

}
