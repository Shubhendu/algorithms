/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

/**
 * @author ssingh
 *
 */
public class BinaryIndexTree2D {
	private int[][] binaryIndexTree;
	private int[][] numArr;

	public BinaryIndexTree2D(int[][] arr) {
		this.numArr = arr;
		this.binaryIndexTree = new int[arr.length + 1][arr[0].length + 1];
		for (int r = 0; r < this.numArr.length; r++) {
			for (int c = 0; c < this.numArr[0].length; c++) {
				updateRegion(r, c, this.numArr[r][c]);
			}
		}
	}

	public void update(int row, int col, int val) {
		updateRegion(row, col, val - numArr[row][col]);
		this.numArr[row][col] = val;
	}

	private void updateRegion(int row, int col, int val) {
		for (int r = row + 1; r < this.binaryIndexTree.length; r += (r & -r)) {
			for (int c = col + 1; c < this.binaryIndexTree[0].length; c += (c & -c)) {
				this.binaryIndexTree[r][c] += val;
			}
		}
	}

	private int sum(int row, int col) {
		int sum = 0;
		for (int r = row + 1; r > 0; r -= (r & -r)) {
			for (int c = col + 1; c > 0; c -= (c & -c)) {
				sum += this.binaryIndexTree[r][c];
			}
		}
		return sum;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sum(row2, col2) - sum(row2, col1 - 1) - sum(row1 - 1, col2) + sum(row1 - 1, col1 - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		BinaryIndexTree2D bit2D = new BinaryIndexTree2D(matrix);
		System.out.println(bit2D.sumRegion(2, 1, 4, 3));
		bit2D.update(3, 2, 2);
		System.out.println(bit2D.sumRegion(2, 1, 4, 3));
			
		double x = 1.2;
		int y = 2;
		System.out.println(x < y);
		
	}

}
