/**
 * 
 */
package dynamicProgramming;

/**
 *   A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate between positive and negative. 
 *   The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a zig-zag sequence.
 *   For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. 
 *   In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences are positive and the second because its last difference is zero.
 *   Given a sequence of integers, sequence, return the length of the longest subsequence of sequence that is a zig-zag sequence. 
 *   A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
 *
 */
public class ZigZag {

	public int zigZag(int[] arr) {
		int n = arr.length;
		int[][] z = new int[n][2];
		int maxZigZagCount = 0;

		for (int i = 0; i < n; i++) {
			z[i][0] = 1;
			z[i][1] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {

				if ((arr[i] - arr[j]) > 0) {
					z[i][0] = max(z[i][0], (z[j][1] + 1));
				} else if ((arr[i] - arr[j] < 0)) {
					z[i][1] = max(z[i][1], z[j][0] + 1);
				}
			}

			maxZigZagCount = max(max(z[i][0], z[i][1]), maxZigZagCount);

		}

		return maxZigZagCount;
	}

	private int max(int x, int y) {
		if (x > y)
			return x;
		else
			return y;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] { 3, 17, 18, 4, 16, 29, 15, 33, 19, 22 };

		ZigZag z = new ZigZag();
		System.out.println(z.zigZag(arr));
	}
}
