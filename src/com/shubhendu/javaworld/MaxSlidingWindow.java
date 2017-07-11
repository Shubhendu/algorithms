/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author ssingh
 *
 */
public class MaxSlidingWindow {
	class Element {
		int index;
		int value;

		public Element(int idx, int v) {
			this.index = idx;
			this.value = v;
		}
	}

	public int[] maxSlidingWindowPq(int[] nums, int k) {
		PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> b.value - a.value);
		Element[] elementArr = new Element[k];
		int[] maxResult = new int[nums.length - k + 1];
		int elemIndex = 0;
		int count = 0;
		int removeCount = 0;
		for (int i = 0; i < nums.length; i++) {
			Element e = new Element(i, nums[i]);
			pq.add(e);
			elementArr[elemIndex++] = e;
			
			if (i >= (k - 1)) {
				maxResult[count++] = pq.peek().value;
				pq.remove(elementArr[removeCount++]);
				elemIndex=0;
				if (removeCount >= k) {
					removeCount = 0;
				}
			}
			
		}

		return maxResult;
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		Deque<Integer> dequeue = new ArrayDeque<Integer>();
		int[] maxResult = new int[nums.length - k + 1];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			// remove elements that are no longer required
			while (!dequeue.isEmpty() && dequeue.peekFirst() < i - k + 1) {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		MaxSlidingWindow m = new MaxSlidingWindow();
		int[] results = m.maxSlidingWindow(nums, k);
		for (int n : results) {
			System.out.print(n + " ");
		}
		System.out.println("\nPQ == \n");
		results = m.maxSlidingWindowPq(nums, k);
		for (int n : results) {
			System.out.print(n + " ");
		}

	}

}
