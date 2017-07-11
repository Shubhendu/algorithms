package com.shubhendu.javaworld.datastructures.unionFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslands {
	private class UnionFind {
		private int[] root;
		private int[] size;
		private int cc;
		private int n;
		private int connectedToZero;
		public UnionFind(int n) {
			this.n = n;
			this.root = new int[n + 1];
			this.size = new int[n];
			this.cc = n;
			this.connectedToZero = n;
			for (int i = 0; i < n; i++) {
				this.root[i] = n + 1;
				this.size[i] = 1;
			}
		}

		public int find(int x) {
			while (x != root[x]) {
				x = root[x];
			}
			return x;
		}

		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}

		public void union(int x, int y) {
			if (root[x] == n + 1) {
				this.connectedToZero--;
				root[x] = x;
			}
			if (root[y] == n + 1) {
				this.connectedToZero--;
				root[y] = y;
			}
			if (isConnected(x, y)) {
				return;
			}
			int rootX = find(x);
			int rootY = find(y);
			if (size[rootY] > size[rootX]) {
				root[rootX] = rootY;
				size[rootY] += size[rootX];
			} else {
				root[rootY] = rootX;
				size[rootX] += size[rootY];
			}
			cc--;
		}
		
	}

	public List<Integer> numIslands2(int m, int n, int[][] positions) {

		List<Integer> islands = new ArrayList<Integer>();
		if (positions == null) {
			return islands;
		}

		int[][] matrix = new int[m][n];
		UnionFind uf = new UnionFind(m * n);
		Set<Integer> isolatedIslands = new HashSet<Integer>();
		for (int r = 0; r < positions.length; r++) {
			boolean top = false;
			boolean bottom = false;
			boolean left = false;
			boolean right = false;
			int i = positions[r][0];
			int j = positions[r][1];

			matrix[i][j] = 1;
			int x = (i * (n - 1)) + (i + j);

			if (i > 0 && matrix[i - 1][j] == 1) {
				top = true;
				uf.union(x, x - n);
				if (isolatedIslands.contains(x - n)) {
					isolatedIslands.remove(x - n);
				}
			}
			if (i < m - 1 && matrix[i + 1][j] == 1) {
				bottom = true;
				uf.union(x, x + n);
				if (isolatedIslands.contains(x + n)) {
					isolatedIslands.remove(x + n);
				}
			}
			if (j > 0 && matrix[i][j - 1] == 1) {
				left = true;
				uf.union(x, x - 1);
				if (isolatedIslands.contains(x - 1)) {
					isolatedIslands.remove(x - 1);
				}
			}
			if (j < n - 1 && matrix[i][j + 1] == 1) {
				right = true;
				uf.union(x, x + 1);
				if (isolatedIslands.contains(x + 1)) {
					isolatedIslands.remove(x + 1);
				}
			}
			if (!top && !bottom && !left && !right) {
				isolatedIslands.add(x);
			}

			islands.add((uf.cc - uf.connectedToZero) + isolatedIslands.size());
		}

		return islands;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m = 3;
		int n = 3;
		int[][] positions = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 }, { 1, 1 } };

		NumberOfIslands num = new NumberOfIslands();
		List<Integer> islands = num.numIslands2(m, n, positions);
		for (int x : islands) {
			System.out.println(x);
		}

	}

}
