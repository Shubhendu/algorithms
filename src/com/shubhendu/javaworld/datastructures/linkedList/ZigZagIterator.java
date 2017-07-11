/**
 * 
 */
package com.shubhendu.javaworld.datastructures.linkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;;

/**
 * https://leetcode.com/problems/zigzag-iterator/#/description
 *
 */
public class ZigZagIterator {
	private LinkedList<Iterator<Integer>> q;

	public ZigZagIterator(List<Integer> v1, List<Integer> v2, List<Integer> v3) {
		q = new LinkedList<Iterator<Integer>>();
		if (!v1.isEmpty()) {
			q.add(v1.iterator());
		}
		if (!v2.isEmpty()) {
			q.add(v2.iterator());
		}
		if (!v3.isEmpty()) {
			q.add(v3.iterator());
		}
	}

	public int next() {
		Iterator<Integer> i = q.poll();
		int val = i.next();
		if (i.hasNext()) {
			q.add(i);
		}

		return val;

	}

	public boolean hasNext() {
		return !q.isEmpty();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);

		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		l2.add(5);
		l2.add(6);

		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(8);
		l3.add(9);
		l3.add(10);

		ZigZagIterator i = new ZigZagIterator(l1, l2, l3);
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
