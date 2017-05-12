/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.Stack;

import com.shubhendu.javaworld.datastructures.queue.Queue;

/**
 * @author ssingh
 *
 */
class BSTNode<T extends Comparable<T>> {
	T value;
	BSTNode<T> left;
	BSTNode<T> right;

	public BSTNode(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class BST<T extends Comparable<T>> {
	BSTNode<T> root;

	public void printAncestors(BSTNode<T> rootNode, T value) {
		BSTNode<T> currentNode = rootNode;
		Stack<T> values = new Stack<T>();
		boolean foundValue = false;

		while (currentNode != null) {
			values.push(currentNode.value);
			if (currentNode.value.compareTo(value) < 0) {
				currentNode = currentNode.right;
			} else if (currentNode.value.compareTo(value) > 0) {
				currentNode = currentNode.left;
			} else {
				foundValue = true;
				break;
			}
		}

		if (foundValue) {
			while (!values.isEmpty()) {
				System.out.print(values.pop() + "->");
			}
		}

	}
	
	public T kthSmallest(BSTNode<T> node, int k) {
		Queue<T> queue = new Queue<T>();
		
		while(node != null) {
			if (queue.size() == k)
				queue.dequeue();
			queue.enqueue(node.value);
			node = node.left;
		}
		
		return queue.peek();
	}
	
	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>();
        
	       /* Construct the following binary tree
	                 10
	               /   \
	              5     31
	             /  \
	            4    8
	           /
	          3
	       */
       
		tree.root = new BSTNode<Integer>(10);
		tree.root.left = new BSTNode<Integer>(5);
		tree.root.right = new BSTNode<Integer>(31);
		tree.root.left.left = new BSTNode<Integer>(4);
		tree.root.left.right = new BSTNode<Integer>(8);
		tree.root.left.left.left = new BSTNode<Integer>(3);

		tree.printAncestors(tree.root, 3);
		
	}

}
