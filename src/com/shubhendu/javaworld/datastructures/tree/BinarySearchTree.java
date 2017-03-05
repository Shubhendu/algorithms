package com.shubhendu.javaworld.datastructures.tree;

public class BinarySearchTree {
	private Node root;
	
	private class Node{
		int value;
		Node left,right;
		
		public Node(int value){
			this.value = value;
		}
	}
	
	public BinarySearchTree(int value) {
		this.root = new Node(value);
	}
	
	public void put(int value){
		root = put(root, value);
	}
	
	private Node put(Node node, int value) {
		if (node == null)
			return new Node(value);
		
		if (value < node.value)
			node.left = put(node.left, value);
		else if(value > node.value)
			node.right = put(node.right, value);
		else
			node.value = value;
		
		return node;
		
	}
	
	public void delete(int value){
		root = delete(root, value);
	}
	
	public Node findMin(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	
	
	private Node deleteMin(Node x){
		if (x == null)
			return null;
		while(x.left != null && x.left.left != null){
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
	
	public int floor(int value){
		Node x =  floor(root, value);
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
	
	public static void main(String[] args){
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
		
		bst.delete(28); 
		System.out.println(bst.findMin(bst.root).value);
		bst.delete(32);
		bst.delete(42);
		
	}
	
}
