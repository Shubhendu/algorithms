package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
	private static final int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int numDistinctIslands(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		Set<ArrayList<List<Integer>>> distinctIslands = new HashSet<ArrayList<List<Integer>>>();
		int rows = grid.length;
		int cols = grid[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				ArrayList<List<Integer>> islands = new ArrayList<List<Integer>>();
				if (dfs(r, c, r, c, islands, grid)) {
					distinctIslands.add(islands);
				}
			}
		}

		return distinctIslands.size();
	}

	public boolean dfs(int rOrigin, int cOrigin, int r, int c, List<List<Integer>> islands, int[][] grid) {
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] <= 0) {
			return false;
		}
		islands.add(Arrays.asList(r - rOrigin, c - cOrigin));
		grid[r][c] *= -1;

		for (int[] d : directions) {
			dfs(rOrigin, cOrigin, r + d[0], c + d[1], islands, grid);
		}

		return true;

	}

	public List<Integer> roundValues(float[] X) {
		List<Integer> result = new ArrayList<Integer>();
		for (float n : X) {
			float y = n - (int) n;
			if (y * 100 < 50) {
				result.add((int) Math.floor(n));
			} else {
				result.add((int) Math.ceil(n));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] { { 1, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };
		NumberOfDistinctIslands n = new NumberOfDistinctIslands();
//		System.out.println(n.numDistinctIslands(grid));

		float[] nums = new float[] {30.9f, 2.4f, 3.9f};
		System.out.println(n.roundValues(nums));
		nums = new float[] {30.45f, 2.45f};
		System.out.println(n.roundValues(nums));
	}

}
