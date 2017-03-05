/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 */
public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {

		int[] output = new int[nums.length];
		int[] leftProduct = new int[nums.length];
		int[] rightProduct = new int[nums.length];
		leftProduct[0] = 1;
		rightProduct[nums.length - 1] = 1;
		for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
			leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
			rightProduct[j] = rightProduct[j + 1] * nums[j + 1];
//			System.out.println("leftProduct[i]: "+leftProduct[i]+" rightProduct[j]: "+rightProduct[j]);
		}
		
		for (int i=0; i<nums.length; i++) {
			output[i] = leftProduct[i] * rightProduct[i];
//			System.out.println("output[i]: "+output[i]);
		}

		return output;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductOfArrayExceptSelf arr = new ProductOfArrayExceptSelf();
		int[] output = arr.productExceptSelf(new int[] {2,3});
		for (int i : output){
			System.out.print(i+" : ");
		}

	}

}
