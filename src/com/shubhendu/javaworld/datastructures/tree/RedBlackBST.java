package com.shubhendu.javaworld.datastructures.tree;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root;

	private class Node {
		Key key;
		Value value;
		Node left, right;
		boolean color;

		public Node(Key key, Value value, boolean color) {
			this.key = key;
			this.value = value;
			this.color = color;
		}
	}

	private Node rotateLeft(Node h) {
		Node x = h.right;
		Node oldXLeft = x.left;
		h.right = oldXLeft;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private Node rotateRight(Node h) {
		Node x = h.left;
		Node oldXRight = x.right;
		h.left = oldXRight;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private Node flipColors(Node h) {
		h.left.color = BLACK;
		h.right.color = BLACK;

		if (h != root) {
			h.color = RED;
		}
		return h;
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	
	private boolean isRed(Node x){
		if (x == null)
			return false;
		return x.color == RED;
	}
	
	private Node put(Node node, Key key, Value value) {
		if (node == null)
			return new Node(key, value, BLACK);
		
		int compare = key.compareTo(node.key);
		if (compare < 0)
			node.left = put(node.left, key, value);
		else if (compare > 0)
			node.right = put(node.right, key, value);
		else
			node.value = value;
		
		if (isRed(node.right) == RED && !isRed(node.left))
			node = rotateLeft(node);
		
		if(isRed(node.left) && isRed(node.left.left))
			node = rotateRight(node);
		
		if(isRed(node.left) && isRed(node.right))
			node = flipColors(node);
	
		return node;
	}

}
