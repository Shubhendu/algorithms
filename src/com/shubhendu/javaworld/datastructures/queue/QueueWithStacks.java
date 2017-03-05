/**
 * 
 */
package com.shubhendu.javaworld.datastructures.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author ssingh
 *
 */
public class QueueWithStacks<T> {

	Stack<T> firstStack = new Stack<T>();
	Stack<T> secondStack = new Stack<T>();

	public void enqueue(T x) {
		firstStack.push(x);
	}

	public boolean isEmpty() {
		return firstStack.isEmpty() && secondStack.isEmpty();
	}

	public int size() {
		return firstStack.size() + secondStack.size();
	}

	public T peek() {
		if (isEmpty())
			return null;

		if (!secondStack.isEmpty()) {
			return secondStack.peek();
		} else {
			while (!firstStack.isEmpty()) {
				secondStack.push(firstStack.pop());
			}
			return secondStack.peek();
		}
	}

	public T dequeue() {
		if (isEmpty())
			return null;

		if (secondStack.isEmpty()) {
			while (!firstStack.isEmpty()) {
				secondStack.push(firstStack.pop());
			}
		}
		if (!secondStack.isEmpty())
			return secondStack.pop();
		else
			return null;
	}

	public static void main(String[] args) {
		QueueWithStacks<Integer> queue = new QueueWithStacks<Integer>();
		System.out.println("isEmpty: "+queue.isEmpty());
		System.out.println("Size: "+queue.size());
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println("Peek: "+queue.peek());
		System.out.println("Pop: "+queue.dequeue());
		System.out.println("Pop: "+queue.dequeue());
		System.out.println("isEmpty: "+queue.isEmpty());
		System.out.println("Size: "+queue.size());
		queue.enqueue(11);
		queue.enqueue(12);
		queue.enqueue(13);
		System.out.println("Peek: "+queue.peek());
		System.out.println("isEmpty: "+queue.isEmpty());
		System.out.println("Size: "+queue.size());
		
		Deque<Integer> deQueue = new ArrayDeque<Integer>();

	}
}
