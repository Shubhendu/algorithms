/**
 * 
 */
package com.shubhendu.javaworld.datastructures.quickUnion;

/**
 * @author ssingh
 *
 */

public class QuickFind {
	private int[] id;

	public QuickFind(int capacity) {
		for (int i = 0; i < capacity; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		int x = id[p];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == x) {
				id[i] = x;
			}
		}
	}

}


