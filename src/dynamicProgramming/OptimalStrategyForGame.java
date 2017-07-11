/**
 * 
 */
package dynamicProgramming;

/**
 * @author ssingh
 *
 */
public class OptimalStrategyForGame {

	private class GameResult {
		long totalPoints;
		long maxPoints;
	}

	public boolean PredictTheWinner(int[] nums) {
		if (nums == null || nums.length < 2) {
			return true;
		}
		GameResult gameResult = maxPoints(nums);

		return gameResult.maxPoints >= (gameResult.totalPoints - gameResult.maxPoints);
	}

	public GameResult maxPoints(int[] nums) {

		long[][] maxPoints = new long[nums.length][nums.length];
		long totalSum = 0L;

		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
			maxPoints[i][i] = nums[i];
			if (i < nums.length - 1) {
				maxPoints[i][i + 1] = Math.max(maxPoints[i][i], nums[i + 1]);
			}
		}
		int curr = 0;
		for (int j = 2; j < nums.length; j++) {
			for (int i = 0; i + j < nums.length; i++) {
				curr = i + j;
				long left = nums[i] + Math.min(maxPoints[i + 2][curr], maxPoints[i + 1][curr - 1]);
				long right = nums[curr] + Math.min(maxPoints[i + 1][curr - 1], maxPoints[i][curr - 2]);
				maxPoints[i][curr] = Math.max(left, right);
			}
		}

		GameResult gameResult = new GameResult();
		gameResult.maxPoints = maxPoints[0][nums.length - 1];
		gameResult.totalPoints = totalSum;
		// return maxPoints[0][nums.length - 1];
		return gameResult;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr1[] = new int[] { 8, 15, 16, 3, 7 };
		int arr2[] = new int[] {2, 4, 55, 6, 8}; //{ 2, 2, 2, 2 };
		int arr3[] = new int[] { 1, 1, 567, 1, 1, 99 }; // { 20, 30, 2, 2, 2, 10
														// };
		OptimalStrategyForGame op = new OptimalStrategyForGame();
		// System.out.println(op.PredictTheWinner(arr1));
		// System.out.println(op.PredictTheWinner(arr2));
		System.out.println(op.PredictTheWinner(arr2));

	}

}
