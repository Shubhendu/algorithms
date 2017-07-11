/**
 * 
 */
package com.shubhendu.javaworld.datastructures.unionFind;

/**
 * @author ssingh
 *
 */
public class UnionFind {
	private int[] root;
	private int[] size;
	private int cc;

	public UnionFind(int n) {
		this.root = new int[n];
		this.size = new int[n];
		this.cc = n;
		for (int i = 0; i < n; i++) {
			this.root[i] = i;
			this.size[i] = 1;
		}
	}

	public boolean connected(int u, int v) {
		return find(u) == find(v);
	}

	public int connectedComponents() {
		return this.cc;
	}

	public void union(int x, int y) {
		if (connected(x, y)) {
			return;
		}
		int rootX = find(x);
		int rootY = find(y);

		if (size[rootY] > size[rootX]) {
			root[rootX] = root[rootY];
			size[rootY] += size[rootX];
		} else {
			root[rootY] = root[rootX];
			size[rootX] += size[rootY];
		}
		this.cc--;
	}

	public int find(int x) {
		int temp = x;
		while (x != root[x]) {
			x = root[x];
		}
		// Path compression
		while (root[temp] != x) {
			int y = root[temp];
			root[temp] = x;
			temp = y;
		}
		return x;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
