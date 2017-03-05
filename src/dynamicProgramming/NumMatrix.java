/**
 * 
 */
package dynamicProgramming;

/**
 * @author ssingh
 *
 */
public class NumMatrix {
	
	private int[][] sumArr;
	
	public NumMatrix(int [][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		sumArr = new int[m + 1][n + 1];

		for (int r=1; r < m + 1; r++) {
			for (int c=1; c < n + 1; c++){
				sumArr[r][c] = matrix[r-1][c-1] + sumArr[r][c-1] + sumArr[r-1][c] - sumArr[r-1][c-1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		row1 = row1 + 1;
		col1 = col1 + 1;
		row2 = row2 + 1;
		col2 = col2 + 1;

		int sum = sumArr[row2][col2] - sumArr[row1 - 1][col2] - sumArr[row2][col1 - 1] + sumArr[row1 - 1][col1 - 1];
		System.out.println("Sum: "+sum);
		return sum;
	}

	
	public static void main(String[] args) {
		int[][] arr = new int[][] 
		{ 
			{ 12, 5, -13, 1, 0 }, 
			{ 13, 9, 4, 6, 3 }, 
			{ 11, 2, -1, 15, 7 },
			{ 21, 22, 12, 14, 46},
		};
		NumMatrix twoDimMatrix = new NumMatrix(arr);
		twoDimMatrix.sumRegion(1, 2, 2, 3);
		twoDimMatrix.sumRegion(1, 1, 2, 3);
		twoDimMatrix.sumRegion(1, 0, 2, 3);
		twoDimMatrix.sumRegion(0, 0, 0, 3);
		twoDimMatrix.sumRegion(0, 0, 0, 2);
		twoDimMatrix.sumRegion(0, 0, 3, 4);
		
		System.out.println("=======");
		
		int [][] arr2 = new int[][]{
			{3, 0, 1, 4, 2},
			{5, 6, 3, 2, 1},
			{1, 2, 0, 1, 5},
			{4, 1, 0, 1, 7},
			{1, 0, 3, 0, 5}
		};
		
		twoDimMatrix = new NumMatrix(arr2);
			
		twoDimMatrix.sumRegion(2, 1, 4, 3);
		twoDimMatrix.sumRegion(1, 1, 2, 2);
		twoDimMatrix.sumRegion(1, 2, 2, 4);
	}
}
