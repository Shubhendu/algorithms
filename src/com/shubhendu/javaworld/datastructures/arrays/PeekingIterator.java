/**
 * 
 */
package com.shubhendu.javaworld.datastructures.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class PeekingIterator implements Iterator<Integer> {

	// private List<Integer> numList;
	// private int count;
	//
	// public PeekingIterator(Iterator<Integer> iterator) {
	// // initialize any member here.
	// numList = new ArrayList<Integer>();
	// count = 0;
	// while (iterator.hasNext()) {
	// numList.add(iterator.next());
	// }
	//
	// }
	//
	// // Returns the next element in the iteration without advancing the
	// iterator.
	// public Integer peek() {
	// return hasNext() ? numList.get(count) : null;
	// }
	//
	// // hasNext() and next() should behave the same as in the Iterator
	// interface.
	// // Override them if needed.
	// @Override
	// public Integer next() {
	// if (hasNext()) {
	// return numList.get(count++);
	// }
	// return null;
	// }
	//
	// @Override
	// public boolean hasNext() {
	// return count < numList.size();
	// }

	private Iterator<Integer> listIterator;
	private Integer nextElement;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		if (iterator != null) {
			this.nextElement = null;
			this.listIterator = iterator;
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (!hasNext()) {
			return null;
		}
		
		return this.nextElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (!hasNext()) {
			return null;
		}
		
		Integer valueToReturn = this.nextElement;
		this.nextElement = null;
		return valueToReturn;
	}

	@Override
	public boolean hasNext() {
		if (this.listIterator == null) {
			return false;
		}
		
		if (this.nextElement != null ) {
			return true;
		}
		
		if (this.listIterator.hasNext())
			this.nextElement = this.listIterator.next();
		return this.nextElement != null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);

		PeekingIterator p = new PeekingIterator(l.iterator());
		while (p.hasNext()) {
//			System.out.println("1 Peek: " + p.peek());
			System.out.println("Next: " + p.next());
//			System.out.println("2 Peek: " + p.peek());
		}
	}

}
