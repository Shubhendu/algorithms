package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
	private List<Integer> internalSizeList;
	private Integer outerListIndex;
	private Integer innerListIndex;
	private int size;
	private int currentIndex;

	List<List<Integer>> vec2d;

	public Vector2D(List<List<Integer>> vec2d) {
		internalSizeList = new ArrayList<>(vec2d.size());
		Iterator<List<Integer>> vec2Iterator = vec2d.iterator();
		while (vec2Iterator.hasNext()) {
			int size = vec2Iterator.next().size();
			this.size += size;
			internalSizeList.add(size);
		}
		outerListIndex = innerListIndex = currentIndex = 0;
		this.vec2d = vec2d;

	}

	@Override
	public Integer next() {
		if (!this.hasNext()) {
			return null;
		} else if (this.innerListIndex < this.internalSizeList.get(this.outerListIndex)) {
			currentIndex++;
			return this.vec2d.get(outerListIndex).get(innerListIndex++);
		} else {
			while (this.internalSizeList.get(++this.outerListIndex) == 0) {
				if (!this.hasNext()) {
					return null;
				}
			}
			this.innerListIndex = 0;

			++currentIndex;
			return this.vec2d.get(outerListIndex).get(innerListIndex++);

		}
	}

	@Override
	public boolean hasNext() {
		if (this.currentIndex < this.size) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		// [[1,2],[3],[4,5,6]]
		// [[1,2],[3,3,3],[4,5,6]]
		// [[1,2],[3,3,3],[4,5,6],[]]

		List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(1);
		myList.add(2);
		vec2d.add(myList);
		myList = new ArrayList<Integer>();
		myList.add(3);
		vec2d.add(myList);
		myList = new ArrayList<Integer>();
		myList.add(4);
		myList.add(5);
		myList.add(6);
		myList.add(7);
		vec2d.add(myList);
		myList = new ArrayList<Integer>();
		vec2d.add(myList);
		Vector2D i = new Vector2D(vec2d);
		while (i.hasNext())
			System.out.print(i.next());

		System.out.println("\nSecond test case: ");
		vec2d = new ArrayList<List<Integer>>();
		myList = new ArrayList<Integer>();
		vec2d.add(myList);
		vec2d.add(myList);
		myList = new ArrayList<Integer>();
		myList.add(4);
		vec2d.add(myList);
		myList = new ArrayList<Integer>();
		vec2d.add(myList);
		myList.add(4);
		myList.add(5);
		myList.add(6);
		myList = new ArrayList<Integer>();
		myList.add(4);
		vec2d.add(myList);
		i = new Vector2D(vec2d);
		while (i.hasNext())
			System.out.print(i.next());
	}
}