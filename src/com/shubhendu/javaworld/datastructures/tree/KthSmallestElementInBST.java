/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.Stack;

/**
 * @author ssingh
 *
 */
public class KthSmallestElementInBST {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		int rank = count(root.left);
		if (k <= rank) {
			return kthSmallest(root.left, k);
		} else if (k > rank + 1) {
			return kthSmallest(root.right, k - rank - 1);
		}

		return root.val;
	}

	private int count(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return 1 + count(node.left) + count(node.right);

	}

	// Iterative In-order traversal
	public int kthSmallest2(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		int count = 0;
		TreeNode curr = root;
		while (!stack.isEmpty()) {
			if (curr.left != null) {
				stack.push(curr.left);
				curr = curr.left;
			} else {
				TreeNode node = stack.pop();
				count++;
				if (count == k) {
					return node.val;
				}
				if (node.right != null) {
					stack.push(node.right);
					curr = node.right;
				}
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
