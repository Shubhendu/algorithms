package dynamicProgramming;

import java.util.ArrayList;

public class BombEnemy {

	// public int maxKilledEnemies(char[][] grid) {
	// if (grid == null || grid.length == 0) {
	// return 0;
	// }
	// int[][] dp = new int[grid.length][grid[0].length];
	//
	// int max = 0;
	// for (int r = 0; r < grid.length; r++) {
	// for (int c = 0; c < grid[0].length; c++) {
	// if (grid[r][c] == '0') {
	// dp[r][c] = killRows(grid, r, c) + killCols(grid, r, c);
	// max = Math.max(max, dp[r][c]);
	// }
	// }
	// }
	// return max;
	// }
	//
	// private int killRows(char[][] grid, int r, int c) {
	// int count = 0;
	// int originalRow = r;
	// while (r >= 0 && grid[r][c] != 'W') {
	// if (grid[r--][c] == 'E') {
	// count++;
	// }
	// }
	// r = originalRow;
	// while (r < grid.length && grid[r][c] != 'W') {
	// if (grid[r++][c] == 'E') {
	// count++;
	// }
	// }
	// return count;
	// }
	//
	// private int killCols(char[][] grid, int r, int c) {
	// int count = 0;
	// int originalCol = c;
	// while (c >= 0 && grid[r][c] != 'W') {
	// if (grid[r][c--] == 'E') {
	// count++;
	// }
	// }
	// c = originalCol;
	// while (c < grid[0].length && grid[r][c] != 'W') {
	// if (grid[r][c++] == 'E') {
	// count++;
	// }
	// }
	// return count;
	// }

	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int[] dp = new int[grid[0].length];

		int max = 0;
		int row = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 'W')
					continue;

				if (r == 0 || grid[r - 1][c] == 'W') {
					dp[c] = killCols(grid, r, c);
				}

				if (c == 0 || grid[r][c - 1] == 'W') {
					row = killRows(grid, r, c);
				}

				if (grid[r][c] == '0') {
					max = Math.max(max, row + dp[c]);
				}
			}
		}
		return max;
	}

	private int killCols(char[][] grid, int r, int c) {
		int count = 0;
		while (r < grid.length && grid[r][c] != 'W') {
			if (grid[r++][c] == 'E') {
				count++;
			}
		}
		return count;
	}

	private int killRows(char[][] grid, int r, int c) {
		int count = 0;
		while (c < grid[0].length && grid[r][c] != 'W') {
			if (grid[r][c++] == 'E') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		BombEnemy b = new BombEnemy();
		char[][] grid = new char[][] { { '0', 'E', '0', '0' }, { 'E', '0', 'W', 'E' }, { '0', 'E', '0', '0' } };
		System.out.println(b.maxKilledEnemies(grid));

	}
}
