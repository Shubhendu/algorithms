package com.shubhendu.javaworld.datastructures.stack;

import java.util.NoSuchElementException;

public class MinStack {
	private Node top;
	

	class Node {
		int value;
		int minValue;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	/** initialize your data structure here. */
	public MinStack() {
		
	}

	public void push(int x) {
		if (top == null) {
			top = new Node(x);
			top.minValue = x;
		} else {
			Node newNode = new Node(x);
			newNode.minValue = Math.min(x, top.minValue);
			newNode.next = top;
			top = newNode;
		}
	}

	public void pop() {
		if (top == null)
			return;
		Node oldTop = top;
		top = oldTop.next;
		oldTop = null;
	}

	public int top() {
		if (this.top == null)
			throw new NoSuchElementException("Stack is Empty");
		return this.top.value;
	}

	public int getMin() {
		if (this.top == null)
			throw new NoSuchElementException("Stack is Empty");
		return this.top.minValue;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.push(-2);
		minStack.push(1);
		minStack.push(2);
		minStack.push(-15);
		System.out.println("Min: " + minStack.getMin());
		minStack.pop();
		System.out.println("Top: " + minStack.top());
		System.out.println("Min: " + minStack.getMin());
		minStack.pop();
		System.out.println("Top: " + minStack.top());
	}

}