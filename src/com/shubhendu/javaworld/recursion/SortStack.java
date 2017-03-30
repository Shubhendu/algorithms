package com.shubhendu.javaworld.recursion;

import java.util.Stack;

public class SortStack {
	public Stack<Integer> sortStack(Stack<Integer> stack) {
		sort(stack);
		return stack;
	}

	private void sort(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;

		int num = stack.pop();
		sort(stack);
		insert(stack, num);

	}

	private void insert(Stack<Integer> stack, Integer num) {
		if (stack.isEmpty()) {
			stack.push(num);
			return;
		}
		Integer top = stack.peek();
		if (num <= top) {
			Integer temp = stack.pop();
			insert(stack, num);
			stack.push(temp);
		} else {
			stack.push(num);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(8);
		stack.push(2);
		stack.push(3);
		stack.push(6);
		stack.push(1);
		stack.push(0);

		SortStack sort = new SortStack();
		stack = sort.sortStack(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
