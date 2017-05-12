package com.shubhendu.javaworld.datastructures.stack;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxStack<T extends Comparable<T>> {
	private LinkedList<T> stack;
	private PriorityQueue<T> pq;

	private class PQMaxComparator implements Comparator<T> {
		public int compare(T o1, T o2) {
			return o2.compareTo(o1);
		}
	}

	public MaxStack() {
		stack = new LinkedList<T>();
		pq = new PriorityQueue<T>(new PQMaxComparator());
	}

	public T pop() {
		T val = this.stack.removeLast();
		this.pq.remove(val);
		return val;
	}

	public void push(T val) {
		this.stack.addLast(val);
		this.pq.add(val);
	}

	public T popMax() {
		T maxVal = this.pq.poll();
		this.stack.remove(maxVal);
		return maxVal;
	}

	public static void main(String[] args) {
		MaxStack<Integer> maxStack = new MaxStack<Integer>();
		maxStack.push(20);
		maxStack.push(15);
		maxStack.push(25);
		maxStack.push(5);
		maxStack.push(2);
		
		System.out.println(maxStack.pop());
		System.out.println(maxStack.popMax());
		System.out.println(maxStack.popMax());
	}

}
