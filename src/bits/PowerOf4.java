/**
 * 
 */
package bits;

/**
 * @author ssingh
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * https://leetcode.com/problems/power-of-four/#/description
 *
 */
public class PowerOf4 {
	public boolean isPowerOfFour(int num) {

		if ((num & (num - 1)) != 0) {
			return false;
		}
		int count = 0;
		while (num > 0) {
			num = num >> 1;
			count++;
		}
		return (count % 2) != 0;
	}
	public boolean isPowerOfFourShort(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
