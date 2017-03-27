/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.Stack;

/**
 * @author ssingh
 *
 */
public class TreeTraversal {
	private static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public void inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty())
					break;
				
				TreeNode x = stack.pop();
				System.out.print(x.val + " ");
				root = x.right;
			}
		}
	}
	
	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
	}
	
	private int getRightIndex(int[] arr, int rootIndex) {
		int rightIndex = rootIndex + 1;
		while(rightIndex < arr.length && arr[rightIndex] < arr[rootIndex]) {
			rightIndex ++;
		}
		
		return rightIndex;
	}
	
	public void printLeafNodeInPreNode() {
		int[] preOrder = new int[] {10, 5, 3, 6, 12, 18, 17};
		int root = preOrder[0];
		int rightTreeIndex = getRightIndex(preOrder, 0);
	}
	public void postOrder(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		stack1.push(root);
		Stack<TreeNode> stack2 = new Stack<TreeNode>();

		while (!stack1.isEmpty()) {
			TreeNode node = stack1.pop();
			
			if (node.left != null) {
				stack1.push(node.left);
			}
			
			if (node.right != null) {
				stack1.push(node.right);
			}
			stack2.push(node);
			
		}
		
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().val +" ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(6);
		
		node.right = new TreeNode(12);
		node.right.right = new TreeNode(18);
		node.right.right.left = new TreeNode(17);
		
		TreeTraversal traversal = new TreeTraversal();
		System.out.println("\nPreOrder");
		traversal.preOrder(node);
		
		System.out.println("\nInOrder");
		traversal.inOrder(node);

		System.out.println("\nPostOrder");
		traversal.postOrder(node);
	}

}
