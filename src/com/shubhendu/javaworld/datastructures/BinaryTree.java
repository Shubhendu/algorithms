package com.shubhendu.javaworld.datastructures;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Node<T extends Comparable<T>> {
	T value;
	Node<T> left;
	Node<T> right;

	public Node(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree{
	private Node<Integer> root;

	public BinaryTree(){
		this.root = null;
	}

	public BinaryTree(Integer value){
		this.root = new Node<Integer>(value);
	}
	
	public Node<Integer> getRoot() {
		return this.root;
	}
	
	public int size(){
		return (_size(this.root));
	}
	
	private int _size(Node<Integer> node){
		if (node == null) return 0;
		
		if (node.left == null && node.right == null) {
			return 1;
		}
		return (_size(node.left) + 1 + _size(node.right));
	}
	
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(45);
		Node<Integer> root = tree.getRoot();
		root.left = new Node<Integer>(25);
		root.right = new Node<Integer>(45);
		
		root.left.left = new Node<Integer>(10);
		root.left.right = new Node<Integer>(15);
		
		
		root.right.left = new Node<Integer>(35);
		root.right.right = new Node<Integer>(50);
		root.right.right.left = new Node<Integer>(49);
		root.right.right.right = new Node<Integer>(51);
		
		System.out.println(tree.size());
		
		BinaryTree.inOrderTraversal(root);
		System.out.println(" InOrder Traversal");
		
		BinaryTree.postOrderTraversal(root);
		System.out.println(" PostOrder Traversal");
		
		
		BinaryTree.preOrderTraversal(root);
		System.out.println(" PreOrder Traversal");
		
//		BFS on Binary Tree
		Queue<Node<Integer>> queue = new ArrayDeque<Node<Integer>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node<Integer> elem = queue.poll();
			System.out.println(elem.value);
			if (elem.left != null) {
				queue.add(elem.left);
			}
			if (elem.right != null) {
				queue.add(elem.right);
			}
		}
		
//	In Order Traversal using stack
		Stack<Node<Integer>> s = new Stack<Node<Integer>>();
		s.add(root);
		Node<Integer> currentNode = root;
		while(!s.isEmpty()) {
				if (currentNode == null) {
					Node<Integer> currElement = s.pop();
					System.out.println(currElement.value);
					currentNode = currElement.right;
				} else {
					currentNode = currentNode.left;
					s.add(currentNode);
				}
				
		}
		
	}
	
	private static void inOrderTraversal(Node<Integer> node) {
		if (node == null)  return;
		inOrderTraversal(node.left);
		System.out.print(" "+ node.value);
		inOrderTraversal(node.right);
	}
	
	private static void preOrderTraversal(Node<Integer> node) {
		if (node == null)  return;
		System.out.print(" "+ node.value);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	private static void postOrderTraversal(Node<Integer> node) {
		if (node == null)  return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(" "+ node.value);
	}

}

