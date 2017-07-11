/**
 * 
 */
package com.shubhendu.javaworld.datastructures.matrix;

/**
 * @author ssingh
 *
 */
public class KSmallestMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;

		int left = matrix[0][0], right = matrix[n - 1][n - 1];

		while (left < right) {
			int mid = (left + right) / 2;
			int count = 0; // number of elements no bigger than mid

			for (int i = 0; i < n; i++) {
				int[] row = matrix[i];

				int t_left = 0, t_right = row.length;
				while (t_left < t_right) {
					int t_mid = (t_left + t_right) / 2;
					int value = row[t_mid];
					if (value > mid) {
						t_right = t_mid;
					} else {
						t_left = t_mid + 1;
					}
				}
				count += t_left;
			}

			if (count < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
