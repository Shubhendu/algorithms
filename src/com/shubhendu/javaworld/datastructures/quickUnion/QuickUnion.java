package com.shubhendu.javaworld.datastructures.quickUnion;

public class QuickUnion {
	private int[] id;
	private int[] size;
	private int cc; // connected components

	public QuickUnion(int capacity) {
		id = new int[capacity];
		cc = capacity;
		for (int i = 0; i < capacity; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	public int numberOfConnectedComponents() {
		return cc;
	}

	private int root(int x) {
		while (id[x] != x) {
			x = id[x];
		}
		return x;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if (size[rootP] > size[rootQ]) {
			id[rootQ] = rootP;
			size[rootP] += size[rootQ];
		} else {
			id[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		cc--;
	}

	public static void main(String[] args) {
		int[] arr = new int[126];
		arr['Z'] = 1;

		arr['z'] = 2;
	}
	
}
