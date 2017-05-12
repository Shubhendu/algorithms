package com.shubhendu.javaworld.datastructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

public class StackUsingArray<T> implements Iterable<T> {
	private int size;
	private T[] stack;
	private static final int DEFAULT_SIZE = 16;

	@SuppressWarnings("unchecked")
	public StackUsingArray() {
		stack = (T[]) new Object[DEFAULT_SIZE];
	}

	public void push(T t) {
		if (size >= stack.length) {
			resizeArray(size << 1);
		}
		stack[size++] = t;
	}

	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T val = stack[--size];
		stack[size] = null;
		if (size < stack.length / 4) {
			resizeArray(stack.length >> 1);
		}

		return val;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	private void resizeArray(int length) {
		T[] tempArray = (T[]) new Object[length];
		for (int i = 0; i < size; i++) {
			tempArray[i] = stack[i];
		}
		stack = tempArray;
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {
		int idx;

		public ListIterator() {
			idx = 0;
		}

		public T next() {
			if (hasNext())
				return stack[idx++];
			return null;
		}

		public boolean hasNext() {
			return idx < size;
		}
	}

	public static void main(String[] args) {
		StackUsingArray<Integer> s = new StackUsingArray<Integer>();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		
		for (Iterator<Integer> iterator = s.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		
		s.push(40);
		s.push(50);
		s.push(40);
		s.push(50);
		s.push(40);
		s.push(50);
		s.push(40);
		s.push(50);
		
		for (Iterator<Integer> iterator = s.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

	}

}
