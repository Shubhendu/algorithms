/**
 * 
 */
package com.shubhendu.javaworld;

/**
 *	https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/#/description
 *
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        int count = 0;
        while(i < len) {
            if (i < len - 1 && nums[i] == nums[i + 1]) {
                nums[count++] = nums[i++];
                nums[count++] = nums[i++];
                while (i < len && nums[i] == nums[i-1]) {
                    i++;
                }
            } else {
                nums[count++] = nums[i++];
            }
        }
        return count;
        
    }
	
	
	public static int removeDuplicates2(int[] nums) {
		int count = 0;
		
		for (int n : nums) {
			if (count < 2 || n > nums[count - 2]) {
				nums[count++] = n;
			}
		}
		return count;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] nums = new int[] {1,1,1,2,2,2,2,2,3,4};
		System.out.println(removeDuplicates2(nums));
		System.out.println("Done");;

	}

}
