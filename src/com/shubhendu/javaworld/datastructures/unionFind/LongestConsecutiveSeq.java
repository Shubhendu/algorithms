/**
 * 
 */
package com.shubhendu.javaworld.datastructures.unionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ssingh
 *
 */
public class LongestConsecutiveSeq {
	private UnionFind uf;
	private Map<Integer, Integer> numMap;

	private class UnionFind {
		private int[] root;
		private int[] size;
		private int maxSize;

		public UnionFind(int[] arr) {
			this.root = new int[arr.length];
			this.size = new int[arr.length];
			this.maxSize = 1;
			for (int i = 0; i < arr.length; i++) {
				this.root[i] = i;
				this.size[i] = 1;
			}
		}

		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);

			if (rootX == rootY) {
				return;
			}

			if (size[rootX] < size[rootY]) {
				root[rootX] = rootY;
				size[rootY] += size[rootX];
				if (size[rootY] > maxSize) {
					maxSize = size[rootY];
				}
			} else {
				root[rootY] = rootX;
				size[rootX] += size[rootY];
				if (size[rootX] > maxSize) {
					maxSize = size[rootX];
				}
			}
		}

		public boolean connected(int x, int y) {
			return find(x) == find(y);
		}

		public int find(int x) {
			while (x != root[x]) {
				x = root[x];
			}
			return x;
		}
	}

	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		uf = new UnionFind(nums);
		numMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!numMap.containsKey(nums[i])) {
				connectCC(i, nums[i]);
				numMap.put(nums[i], i);
			}
		}

		return this.uf.maxSize;

	}

	private void connectCC(int idx, int num) {
		if (numMap.containsKey(num - 1)) {
			this.uf.union(idx, numMap.get(num - 1));
		}
		if (numMap.containsKey(num + 1)) {
			this.uf.union(idx, numMap.get(num + 1));
		}
	}

	public static void main(String[] args) {
//		int[] arr = new int[] { 7, -2, 9, 9, 1, 9, 8, -4, 6, -6, -6, 4, 1, 3, 6, 3, 5, -2, 3, 4, -6, 1, 5, -9, 6, 1, 2,
//				-2, 1 };
//		LongestConsecutiveSeq lc = new LongestConsecutiveSeq();
//		System.out.println(lc.longestConsecutive(arr));
		
		Map<Double, ArrayList<Integer>> slopeMap = new HashMap<Double, ArrayList<Integer>>();
		slopeMap.put(Double.valueOf("0"), new ArrayList<Integer>());
		
		System.out.println(0 == Double.valueOf("0"));
	}

}
