/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

/**
 * @author ssingh 
 * A Fenwick tree or binary indexed tree is a data structure that can efficiently update elements and calculate prefix sums in a table
 * of numbers.
 * 
 * Space complexity - O(N) (N + 1 to be precise) 
 * Creating tree - O(NLogN) 
 * Get sum - O(LogN) 
 * Update range - O(LogN)
 * 
 * References -
 * 	https://en.wikipedia.org/wiki/Fenwick_tree
 * 	https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
 * 	http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 *
 */
public class BinaryIndexTree {

	private int[] binaryIndexTree;

	public BinaryIndexTree(int[] arr) {
		this.binaryIndexTree = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			update(i, arr[i]);
		}
	}

	// Prefix sum -> from 0 to idx
	public int sum(int idx) {
		idx = idx + 1;
		int sum = 0;
		while (idx > 0) {
			sum += this.binaryIndexTree[idx];
			idx = getParent(idx);
		}
		return sum;
	}

	// Range sum
	public int sum(int x, int y) {
		if (x == y) {
			return sum(x);
		} else if (y > x) {
			return sum(y, x);
		} else {
			return sum(x) - sum(y);
		}
	}
	
//	Increments / Decrement existing arr[idx] += val
	public void updateTree(int idx, int val) {
		update(idx, val - sum(idx));
	}
	
	private void update(int idx, int val) {
		idx = idx + 1;
		while (idx < binaryIndexTree.length) {
			binaryIndexTree[idx] += val;
			idx = getNext(idx);
		}
	}

	private int getParent(int idx) {
		return idx - (idx & -idx);
	}

	private int getNext(int idx) {
		return idx + (idx & -idx);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 4, 5, 3, -1, 7 };
		BinaryIndexTree bit = new BinaryIndexTree(arr);
//		System.out.println(bit.sum(2));
//		System.out.println(bit.sum(3));
//		System.out.println(bit.sum(4));
		System.out.println(bit.sum(2, 4));
		
		bit.updateTree(3, -1);
		
		System.out.println(bit.sum(2));
		System.out.println(bit.sum(3));
		System.out.println(bit.sum(4));
		System.out.println(bit.sum(2, 4));
	}

}
