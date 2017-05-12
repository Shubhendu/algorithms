/**
 *
 */
package com.shubhendu.javaworld.recursion;

/**
 * @author ssingh
 *
 */
public class WordSearch {

	private char[][] board;
	private boolean[][] visited;

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0) {
			return false;
		}
		if (word == null || word.length() == 0) {
			return false;
		}

		this.board = board;

		int rows = board.length;
		int cols = board[0].length;

		this.visited = new boolean[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (searchWord(word, r, c, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean searchWord(String word, int r, int c, int strIndex) {
		if (r < 0 || r >= this.board.length || c < 0 || c >= this.board[0].length || strIndex >= word.length()
				|| this.visited[r][c]) {
			return false;
		}

		if (this.board[r][c] != word.charAt(strIndex)) {
			this.visited[r][c] = false;
			return false;
		}

		if (this.board[r][c] == word.charAt(strIndex) && (strIndex == word.length() - 1)) {
			return true;
		}

		this.visited[r][c] = true;

		if (searchWord(word, r + 1, c, strIndex + 1) || searchWord(word, r - 1, c, strIndex + 1)
				|| searchWord(word, r, c + 1, strIndex + 1) || searchWord(word, r, c - 1, strIndex + 1)) {
			return true;
		}

		this.visited[r][c] = false;
		return false;

	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		WordSearch wordSearch = new WordSearch();
		System.out.println(wordSearch.exist(board, "ABCESEEEFS"));
		System.out.println(wordSearch.exist(board, "SEEA"));
	}

}
