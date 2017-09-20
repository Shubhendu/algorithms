/**
 * 
 */
package bits;

import java.util.Arrays;

/**
 * @author ssingh
 *
 */
public class TotalHamminDistance {
	//O(nLog(k))
	public int totalHammingDistance(int[] nums) {
		
		
		int totalDistance = 0;
		int numberOfZeroes = 0;
		int[] zeroesOnes = new int[2];
		while(numberOfZeroes < nums.length) {
			numberOfZeroes = 0;
			Arrays.fill(zeroesOnes, 0);
			for (int i = 0 ; i < nums.length; i++) {
				if (nums[i] == 0) {
					numberOfZeroes++;
				}
				zeroesOnes[nums[i] % 2]++;
				nums[i] = nums[i] >> 1;
			}
			totalDistance += (zeroesOnes[0] * zeroesOnes[1]);
			
		}
		return totalDistance;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[] {4,2,14};
		TotalHamminDistance t = new TotalHamminDistance();
		System.out.println(t.totalHammingDistance(nums));
		

	}

}
