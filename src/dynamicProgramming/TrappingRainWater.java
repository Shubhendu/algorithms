/**
 * 
 */
package dynamicProgramming;

import java.util.LinkedHashSet;
import java.util.LinkedList;


/**
 * @author ssingh
 *         https://leetcode.com/problems/trapping-rain-water/#/description
 */
public class TrappingRainWater {

	public int trap(int[] height) {
		int maxWater = 0;
		// Max height to the left of height[i]
		int[] maxLeftHeights = new int[height.length];
		// Max height to the right of height[i]
		int[] maxRightHeights = new int[height.length];
		int j = maxLeftHeights.length - 2;
		for (int i = 1; i < height.length; i++) {
			maxLeftHeights[i] = Math.max(height[i - 1], maxLeftHeights[i - 1]);
			maxRightHeights[j] = Math.max(height[j + 1], maxRightHeights[j + 1]);
			j--;
		}
		int minMaxAdjacent = 0; 
		for (int i = 1; i < height.length - 1; i++) {
			minMaxAdjacent = Math.min(maxLeftHeights[i], maxRightHeights[i]);
			if (minMaxAdjacent > height[i]) {
				maxWater += Math.min(maxLeftHeights[i], maxRightHeights[i]) - height[i];
			}
		}

		return maxWater;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] elevations = new int[] {1,2,1}; //{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		TrappingRainWater t = new TrappingRainWater();
		int waterTrapped = t.trap(elevations);
		System.out.println(waterTrapped);
		LinkedHashSet<Integer> s = new LinkedHashSet<>();
		LinkedList<Integer> l = new LinkedList<>();
	}

}
