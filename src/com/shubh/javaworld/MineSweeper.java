package com.shubh.javaworld;

import java.util.Arrays;
import java.util.Random;

public class MineSweeper {
	private static final char MINE_CHAR = '*';
	private int[][] adjacents = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
			{ -1, 1 } };

	public char[][] createMineSweeper(int r, int c, int numOfMines) {
		char[][] board = null;
		if (r < 1 || c < 1) {
			return board;
		}
		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			Arrays.fill(board[i], '0');
		}

		updateBoardWithMines(board, numOfMines);
		return board;
	}

	private void updateBoardWithMines(char[][] board, int numOfMines) {
		Random random = new Random();
		int rows = board.length;
		int cols = board[0].length;
		while (numOfMines > 0) {
			int idx = random.nextInt(rows * cols);
			int r = idx / cols;
			int c = idx % cols;
			if (board[r][c] == MINE_CHAR) {
				continue;
			}
			board[r][c] = MINE_CHAR;
			updateNeighbors(board, r, c);
			numOfMines--;
		}
	}

	private void updateNeighbors(char[][] board, int row, int col) {

		for (int[] adj : adjacents) {
			int r = row + adj[0];
			int c = col + adj[1];
			if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == MINE_CHAR) {
				continue;
			}
//			if (!Character.isDigit(board[r][c])) {
//				board[r][c] = '0';
//			}
			int count = board[r][c] - '0';
			count++;
			board[r][c] = (char) (count + '0');
		}

	}

	private void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		MineSweeper m = new MineSweeper();
		m.printBoard(m.createMineSweeper(4, 4, 4));
	}

}
