package dynamicProgramming;

import java.util.Arrays;

// Given an integer matrix, find the length of the longest increasing path.

// From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

// Example 1:

// nums = [
//   [9,9,4],
//   [6,6,8],
//   [2,1,1]
// ]
// Return 4
// The longest increasing path is [1, 2, 6, 9].

// Example 2:

// nums = [
//   [3,4,5],
//   [3,2,6],
//   [2,2,1]
// ]
// Return 4
// The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
public class LongestIncreasingPath {
	private boolean[][] visited;
	private int[][] longestPath;

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		this.visited = new boolean[matrix.length][matrix[0].length];
		this.longestPath = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			Arrays.fill(longestPath[i], 1);
		}
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (!this.visited[i][j]) {
					count = dfs(matrix, i, j, 1);
					maxCount = Math.max(count, maxCount);
				}
			}
		}
		return maxCount;
	}

	private int dfs(int[][] matrix, int r, int c, int count) {
		if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || this.visited[r][c]) {
			return count;
		}

		this.visited[r][c] = true;
		this.longestPath[r][c] = 0;

		int leftCount = count;
		int rightCount = count;
		int topCount = count;
		int bottomCount = count;

		if (r > 0 && matrix[r - 1][c] > matrix[r][c]) {
			// Go top
			if (visited[r - 1][c]) {
				topCount = 1 + longestPath[r - 1][c];
			} else {
				topCount = 1 + dfs(matrix, r - 1, c, 1);
			}
		}

		if (r < matrix.length - 1 && matrix[r + 1][c] > matrix[r][c]) {
			// Go down
			if (visited[r + 1][c]) {
				bottomCount = 1 + longestPath[r + 1][c];
			} else {
				bottomCount = 1 + dfs(matrix, r + 1, c, 1);
			}
		}

		if (c > 0 && matrix[r][c - 1] > matrix[r][c]) {
			// Go left
			if (visited[r][c - 1]) {
				leftCount = 1 + longestPath[r][c - 1];
			} else {
				leftCount = 1 + dfs(matrix, r, c - 1, 1);
			}
		}

		if (c < matrix[0].length - 1 && matrix[r][c + 1] > matrix[r][c]) {
			// Go right
			if (visited[r][c + 1]) {
				rightCount = 1 + longestPath[r][c + 1];
			} else {
				rightCount = 1 + dfs(matrix, r, c + 1, 1);
			}
		}
		int maxPath = Math.max(Math.max(leftCount, rightCount), Math.max(topCount, bottomCount));
		this.longestPath[r][c] = maxPath;
		return maxPath;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 2, 1 } };
		int[][] matrix2 = new int[][] {{3,4,5}, {3,2,6}, {2,2,1}};
		int[][] matrix3 = new int[][] {{10,5,1}, {10,5,1}, {10,5,1}};
		int[][] matrix4 = new int[][] {{10,5,1}, {10,5,1}, {10,5,1}};
		int[][] matrix5 = new int[][] {{10,15,16}, {19,18,17}, {20,21,22}};
		LongestIncreasingPath lip = new LongestIncreasingPath();
		int count = lip.longestIncreasingPath(matrix5);
		System.out.println(count);
	}

}
