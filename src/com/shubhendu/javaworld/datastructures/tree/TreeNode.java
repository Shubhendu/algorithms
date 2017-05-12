package com.shubhendu.javaworld.datastructures.tree;

public class TreeNode<T extends Comparable<T>> {
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode(T val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public T getval() {
		return val;
	}

	public void setval(T val) {
		this.val = val;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
}
