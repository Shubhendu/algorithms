/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.Stack;

/**
 * @author Shubhendu Singh
 * Given a binary tree and a number(sum), return a path from root to leaf nodes that is equal to that sum.
 * 				4
 * 		
 * 		15				7
 * 	
 * 	  2	  18					21		
 * 	 /    /					  /    \
 * -2	-4					9		5
// * 					  /   \
 * 					 	6		-1
 * sum = 40, output - 4 -> 7 -> 21 -> 9 -> -1
 * sum = 37, output = 4 -> 7 -> 21 -> 9 -> -1	
 * sum = 21, output = Null
 * 
 */
public class RootToLeafSumBinaryTree {

	public Stack<Integer> rootToLeafSum(BinaryTree tree, int sum) {
		Stack<Integer> path = new Stack<Integer>();
		boolean pathExists =  rootToLeafRec(tree.getRoot(), sum, path);
		System.out.println("\n Path exists for sum: "+sum + " : "+ pathExists);
		if (pathExists) {
			
			while(!path.isEmpty()) {
				System.out.print(path.pop() + " ");
			}
			return path;
		}
		return null;
	}

	private boolean rootToLeafRec(Node<Integer> x, int sum, Stack<Integer> path) {
		if (x == null)
			return false;
		if (x.left == null && x.right == null) {
			if (sum - x.value == 0) {
				path.push(x.value);
				return true;
			} else {
				return false;
			}
		}
		boolean leftPath = rootToLeafRec(x.left, sum - x.value, path);
		boolean rightPath = rootToLeafRec(x.right, sum - x.value, path);

		if (leftPath) {
			path.push(x.value);
			return true;
		} else if (rightPath) {
			path.push(x.value);
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(4);
		bt.getRoot().left = new Node<Integer>(15);
		bt.getRoot().left.left = new Node<Integer>(2);
		bt.getRoot().left.left.left = new Node<Integer>(-2);
		bt.getRoot().left.right = new Node<Integer>(18);
		bt.getRoot().left.right.left = new Node<Integer>(-4);
		
		bt.getRoot().right = new Node<Integer>(7);
		bt.getRoot().right.right = new Node<Integer>(21);
		bt.getRoot().right.right.left = new Node<Integer>(9);
		bt.getRoot().right.right.left.left = new Node<Integer>(6);
		bt.getRoot().right.right.left.right = new Node<Integer>(-1);
		bt.getRoot().right.right.right = new Node<Integer>(5);
		
		RootToLeafSumBinaryTree sumTree = new RootToLeafSumBinaryTree();
		sumTree.rootToLeafSum(bt, 40);
		
		sumTree.rootToLeafSum(bt, 37);
		sumTree.rootToLeafSum(bt, 19);
		sumTree.rootToLeafSum(bt, 21);
		
	}

}
