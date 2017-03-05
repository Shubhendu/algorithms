/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ssingh
 *
 */
public class MedianFinder {
	private PriorityQueue<Integer> minHeap = null;
	private PriorityQueue<Integer> maxHeap = null;

	public MedianFinder() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(new DescendingComparator());
	}

	private static class DescendingComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b.compareTo(a);
		}
	}

	public void addNum(int num) {
		if (!isEmpty() && num < findMedian())
			maxHeap.add(num);
		else
			minHeap.add(num);
		balanceHeaps();
	}

	public double findMedian() {
		if (isEmpty()){
			return Double.NaN;
		}

		if (maxHeap.size() == minHeap.size())
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		else if ((maxHeap.size() - minHeap.size()) == 1)
			return maxHeap.peek()  != null ? (double) maxHeap.peek() : Double.NaN;
		else
			return minHeap.peek() != null ? (double) minHeap.peek() : Double.NaN;
	}
	
	private boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return maxHeap.size() + minHeap.size();
	}

	private void balanceHeaps() {
		if ((maxHeap.size() - minHeap.size()) > 1) {
			int num = maxHeap.poll();
			minHeap.add(num);
		} else if ((minHeap.size() - maxHeap.size()) > 1) {
			int num = minHeap.poll();
			maxHeap.add(num);
		}
	}

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(15);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(7);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(8);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(9);
		medianFinder.addNum(2);
		medianFinder.addNum(1);
		medianFinder.addNum(25);
		medianFinder.addNum(30);
		System.out.println(medianFinder.findMedian());
	}

}
