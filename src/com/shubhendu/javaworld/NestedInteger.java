/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ssingh
 *
 */
class NestedInteger {
	private Integer value;
	private List<NestedInteger> nestedIntegers;

	// Constructor initializes an empty nested list.
	public NestedInteger() {
		this.value = null;
		this.nestedIntegers = new ArrayList<NestedInteger>();
	}

	// Constructor initializes a single integer.
	public NestedInteger(int value) {
		this.value = value;
		this.nestedIntegers = new ArrayList<NestedInteger>();
	}

	// @return true if this NestedInteger holds a single integer, rather
	// than a nested list.
	public boolean isInteger() {
		return this.value != null && this.nestedIntegers.isEmpty();
	}

	// @return the single integer that this NestedInteger holds, if it holds
	// a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return this.value;
	}

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value) {
		this.value = value;
	}

	// Set this NestedInteger to hold a nested list and adds a nested
	// integer to it.
	public void add(NestedInteger ni) {
		this.nestedIntegers.add(ni);
	}

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return this.nestedIntegers;
	}
}
