/**
 * 
 */
package com.shubhendu.javaworld.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ssingh
 *
 */
public class ContainsDuplicate {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		if (k == 0) {
			return false;
		}
		Map<Integer, Integer> numMap = new HashMap<>(k);
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>((a, b) -> (b - a));
		numMap.put(nums[0], 0);
		maxPQ.add(nums[0]);
		minPQ.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			int min = minPQ.peek();
			int max = maxPQ.peek();
			int diff = 0;
			if (nums[i] < min) {
				diff = Math.abs(min - nums[i]);
			} else if (nums[i] > max) {
				diff = Math.abs(max - nums[i]);
			} else {
				diff = Math.min(Math.abs(max - nums[i]), Math.abs(min - nums[i]));
			}

			if (diff <= t) {
				return true;
			}
			numMap.put(nums[i], i);
			minPQ.add(nums[i]);
			maxPQ.add(nums[i]);

			if (numMap.size() > k) {
				int numDel = nums[i - k];
				System.out.println(numDel);
				numMap.remove(numDel);
				minPQ.remove(numDel);
				maxPQ.remove(numDel);
			}

		}
		return false;
	}
	
    public boolean detectCapitalUse(String word) {
        boolean lowerCaseFound = false;
        boolean upperCaseFound = false;
        int i = 0;
        int firstIndex = 0;
        for (char c : word.toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' < 26) {
                if (upperCaseFound && firstIndex != 0) {
                    return false;
                }
                lowerCaseFound = true;
            } else if (c - 'A' >= 0 && c - 'A' < 26) {
                if(lowerCaseFound) {
                    return false;
                }
                if (!upperCaseFound) {
                	upperCaseFound = true;
                	firstIndex = i;
                }
                
            }
            i++;
        }
        return true;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {4,1,6,3}; // { 30, 40, 60, 17, 2, 10, -10 };
		ContainsDuplicate c = new ContainsDuplicate();
//		System.out.println(c.containsNearbyAlmostDuplicate(nums, 2, 7));
		System.out.println(c.containsNearbyAlmostDuplicate(nums, 100, 1));
		
		System.out.println(c.detectCapitalUse("USA"));
		System.out.println(c.detectCapitalUse("USa"));
		System.out.println(c.detectCapitalUse("UaS"));
		System.out.println(c.detectCapitalUse("Uas"));
		System.out.println(1 ^ 1 ^ 2);

	}

}
