package com.shubh.javaworld;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedSum2 {
	interface NestedInteger {
		// // Constructor initializes an empty nested list.
		// public NestedInteger();
		//
		// // Constructor initializes a single integer.
		// public NestedInteger(int value);

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value);

		// Set this NestedInteger to hold a nested list and adds a nested
		// integer to it.
		public void add(NestedInteger ni);

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public int depthSumInverse(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.isEmpty()) {
			return 0;
		}
		Queue<NestedInteger> q = new LinkedList<NestedInteger>();

		q.addAll(nestedList);
		int prevLevel = 0;
		int totalSum = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			int levelSum = 0;
			for (int i = 0; i < size; i++) {
				NestedInteger ni = q.poll();
				if (ni.isInteger()) {
					levelSum += ni.getInteger();
				} else {
					for (NestedInteger n : ni.getList()) {
						q.add(n);
					}
				}
			}
			prevLevel += levelSum;
			totalSum += prevLevel;
		}

		return totalSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
