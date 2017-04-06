/**
 * 
 */
package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssingh
 * Problem - https://leetcode.com/problems/spiral-matrix/#/description
 * Recursive solution
 */
public class MatrixSnakeOrder {
	private boolean[][] visited;
	private int[][] matrix;

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return result;
		}

		this.matrix = matrix;
		int rows = matrix.length;
		int cols = matrix[0].length;
		this.visited = new boolean[rows][cols];

		for (int i = 0; i < rows; i++) {
			printMatrixSnakeOrder(i, i, result, i, (rows - 1) - i, i, (cols - 1) - i);
		}
		return result;
	}

	private void printMatrixSnakeOrder(int r, int c, List<Integer> result, int startRow, int endRow, int startCol,
			int endCol) {
		if (r < 0 || r >= this.matrix.length || c < 0 || c >= this.matrix[0].length || this.visited[r][c]) {
			return;
		}

		if (r != startRow && r != endRow) {
			if (c != startCol && c != endCol) {
				return;
			}
		}

		result.add(this.matrix[r][c]);
		this.visited[r][c] = true;

		printMatrixSnakeOrder(r, c + 1, result, startRow, endRow, startCol, endCol);
		printMatrixSnakeOrder(r + 1, c, result, startRow, endRow, startCol, endCol);
		printMatrixSnakeOrder(r, c - 1, result, startRow, endRow, startCol, endCol);
		printMatrixSnakeOrder(r - 1, c, result, startRow, endRow, startCol, endCol);
	}

	private static void printList(List<Integer> list) {
		System.out.println("\nPrinting list");
		for (int x : list) {
			System.out.print(x + " ");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[][] { { 2, 5, 9, 11 }, { 4, 6, 8, 10 }, { 1, 2, 3, 34 }, { 35, 5, 8, 9 } };

		MatrixSnakeOrder matrixSnakeOrder = new MatrixSnakeOrder();
		printList(matrixSnakeOrder.spiralOrder(arr));

		arr = new int[][] { { 2, 5, 9 }, { 4, 6, 8 }, { 1, 2, 3 } };
		printList(matrixSnakeOrder.spiralOrder(arr));

	}

}
