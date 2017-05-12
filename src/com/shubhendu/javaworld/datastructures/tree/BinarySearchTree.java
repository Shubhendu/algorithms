package com.shubhendu.javaworld.datastructures.tree;

import java.util.LinkedList;

public class BinarySearchTree {
	private Node root;

	private class Node {
		int value;
		int sz;
		Node left, right;

		public Node(int value) {
			this.value = value;
			this.sz = 1;
		}
	}

	public BinarySearchTree(int value) {
		this.root = new Node(value);
	}

	public void put(int value) {
		root = put(root, value);
	}

	private Node put(Node node, int value) {
		if (node == null)
			return new Node(value);

		if (value < node.value)
			node.left = put(node.left, value);
		else if (value > node.value)
			node.right = put(node.right, value);
		else
			node.value = value;

		node.sz = size(node.left) + 1 + size(node.right);
		return node;

	}

	public void delete(int value) {
		root = delete(root, value);
	}

	public Node findMin(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}

	private int size(Node node) {
		return node == null ? 0 : node.sz;
	}

	public int select(int k) {
		return select(root, k).value;
	}

	private Node select(Node x, int k) { // Return k ranked node

		if (x == null)
			return null;

		int rank = size(x) - size(x.right);
		
		if (rank == k)
			return x;
		else if (rank > k)
			return select(x.left, k);
		else 
			return select(x.right, k - rank);

	}

	public int rank(Node node) {
		if (node == null)
			return 0;

		return rank(root, node);
	}

	private int rank(Node root, Node node) {
		if (node == null) {
			return 0;
		}

		if (node.value == root.value) {
			return size(root) - size(root.right);
		} else if (node.value < root.value) {
			return rank(root.left, node);
		} else {
			int size = size(root.left) + 1 + rank(root.right, node);
			System.out.println("size: " + size + " root: " + root.value + " node:  " + node.value);
			return size;
		}

	}

	private Node deleteMin(Node x) {
		if (x == null)
			return null;
		while (x.left != null && x.left.left != null) {
			x = x.left;
		}
		Node minNode = x.left;
		x.left = minNode.right;
		return minNode;
	}

	private Node delete(Node node, int value) {
		if (value == node.value) {
			if (node.left == null && node.right == null)
				return null;
			else if (node.left == null && node.right != null)
				return node.right;
			else if (node.left != null && node.right == null)
				return node.left;
			else {
				Node minNode = deleteMin(node.right);
				minNode.right = node.right;
				minNode.left = node.left;
				node = null;
				return minNode;
			}
		} else if (value < node.value) {
			node.left = delete(node.left, value);
		} else {
			node.right = delete(node.right, value);
		}

		return node;

	}

	public int floor(int value) {
		Node x = floor(root, value);
		return x.value;
	}

	private Node floor(Node node, int value) {
		if (value > node.value) {
			Node minRight = findMin(node.right);
			return minRight.value < value ? minRight : node;
		} else if (value < node.value) {
			return node.left != null ? floor(node.left, value) : node;
		} else {
			return node;
		}

	}

	public void inOrderTraversal(Node node) {
		if (node == null)
			return;

		inOrderTraversal(node.left);
		System.out.print(node.value + " ");
		inOrderTraversal(node.right);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(36);
		bst.put(42);
		bst.put(38);
		bst.put(28);
		bst.put(12);
		bst.put(15);
		bst.put(30);
		bst.put(29);
		bst.put(31);
		bst.put(32);

		bst.inOrderTraversal(bst.root);
		System.out.println("Rank: " + bst.root.left.left.right.value + " : " + bst.rank(bst.root.left.left.right));
		System.out.println("Rank: " + bst.root.left.right.value + " : " + bst.rank(bst.root.left.right));
		System.out.println("Rank: " + bst.root.left.left.value + " : " + bst.rank(bst.root.left.left));
		
		System.out.println(bst.select(5));
		System.out.println(bst.select(2));
		System.out.println(bst.select(9));
		// System.out.println(bst.findMin(bst.root).value);
		// bst.delete(32);
		// bst.delete(42);
		
		LinkedList ll = new LinkedList();
	}

}
