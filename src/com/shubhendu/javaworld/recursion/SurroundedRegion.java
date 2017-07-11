/**
 * 
 */
package com.shubhendu.javaworld.recursion;

/**
 * @author ssingh
 *
 */
public class SurroundedRegion {

	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int rows = board.length;
		int cols = board[0].length;
		for (int i = 0; i < cols; i++) {
			if (board[0][i] == 'O') {
				convertBorder(board, 0, i);
			}
			if (board[rows - 1][i] == 'O') {
				convertBorder(board, rows - 1, i);
			}
		}
		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O') {
				convertBorder(board, i, 0);
			}
			if (board[i][cols - 1] == 'O') {
				convertBorder(board, i, cols - 1);
			}
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (board[r][c] == 'O') {
					board[r][c] = 'X';
				} else if (board[r][c] == '1') {
					board[r][c] = 'O';
				}
			}
		}

	}

	private class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private void convertBorder(char[][] board, int r, int c) {
		if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') {
			return;
		}

		board[r][c] = '1';
		// go left
		if (c > 0 && board[r][c - 1] == 'O') {
			convertBorder(board, r, c - 1);
		}
		// go right
		if (c < board[0].length - 1 && board[r][c + 1] == 'O') {
			convertBorder(board, r, c + 1);
		}
		// go up
		if (r > 0 && board[r - 1][c] == 'O') {
			convertBorder(board, r - 1, c);
		}
		// go down
		if (r < board.length - 1 && board[r + 1][c] == 'O') {
			convertBorder(board, r + 1, c);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
