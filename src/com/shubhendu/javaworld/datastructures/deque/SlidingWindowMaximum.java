/**
 * 
 */
package com.shubhendu.javaworld.datastructures.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

import org.junit.Assert;

/**
 * https://leetcode.com/problems/sliding-window-maximum/#/description
 *
 */
public class SlidingWindowMaximum {

	public int[] maxSlidingWindowUsingDeque(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		Deque<Integer> dequeue = new ArrayDeque<Integer>();
		int[] maxResult = new int[nums.length - k + 1];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			// remove elements that are no longer required
			while (!dequeue.isEmpty() && dequeue.peekFirst() < i - k - 1) {
				dequeue.pollFirst();
			}

			// remove elements from the end if current element is > than
			// those elements at the end
			while (!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]) {
				dequeue.pollLast();
			}
			dequeue.addLast(i);
			if (i >= k - 1) {
				maxResult[count++] = nums[dequeue.peek()];
			}
		}

		return maxResult;
	}

	public int[] maxSlidingWindowUsingHeap(int[] nums, int k) {
		if (nums == null) {
			return null;
		}
		int[] maxResult;
		if (nums.length == 0) {
			maxResult = new int[0];
			return maxResult;
		}
		maxResult = new int[nums.length - k + 1];
		int arrLength = nums.length;
		int i = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, (a, b) -> (b - a));
		while (i < k) {
			pq.add(nums[i++]);
		}
		i = 0;
		while ((i + k) < arrLength) {
			maxResult[i] = pq.poll();
			if (maxResult[i] != nums[i]) {
				pq.remove(nums[i]);
				pq.add(maxResult[i]);
			}
			pq.add(nums[i + k]);
			i++;
		}
		maxResult[i] = pq.poll();
		return maxResult;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		SlidingWindowMaximum sl = new SlidingWindowMaximum();
		int[] result = sl.maxSlidingWindowUsingDeque(nums, 3);

		Assert.assertArrayEquals(new int[] { 3, 3, 5, 5, 6, 7 }, result);
		for (int n : result) {
			System.out.print(n + " ");
		}

	}

}
