/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.Stack;

/**
 * @author ssingh
 * https://leetcode.com/problems/validate-binary-search-tree/#/description
 */
public class IsValidBST {

	private class TreeNode {
		private int val; // long value;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int value) {
			this.val = value;
		}

		// getters and setters
	}
	
	/*
	 * Recursive method. But the worst approach. This will not handle scenario when we change node.val to long.
	 */
	public boolean isValidBST1(TreeNode root) {
		return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
		// return isValidBST1(root, Double.NEGATIVE_INFINITY,
		// Double.POSITIVE_INFINITY);
	}

	private boolean isValidBST1(TreeNode node, long minValue, long maxValue) {

		if (node == null) {
			return true;
		}

		if (node.val >= maxValue || node.val <= minValue) {
			return false;
		}

		return isValidBST1(node.left, minValue, node.val) && isValidBST1(node.right, node.val, maxValue);

	}
	
	/*
	 * Recursive method using min/max value at each level of recursion.
	 * At each level, root.val should be the max value in the left subtree.
	 * root.val should be the min val in the right subtree.
	 * Handles edge case for null checks.
	 */
	public boolean isValidBST2(TreeNode root) {
		return isValidBST2(root, null, null);
	}

	private boolean isValidBST2(TreeNode node, Integer minValue, Integer maxValue) {
		if (node == null) {
			return true;
		}

		if ((minValue != null && node.val <= minValue) || (maxValue != null && node.val >= maxValue)) {
			return false;
		}
		return isValidBST2(node.left, minValue, node.val) && isValidBST2(node.right, node.val, maxValue);
	}

	/*
	 * Recursive method using gloval prev variable.
	 * In-order traversal
	 */
	private TreeNode prev;
	public boolean isValidBST3(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (!isValidBST3(root.left)) {
			return false;
		}

		if (this.prev != null && root.val <= this.prev.val) {
			return false;
		}

		this.prev = root;

		return isValidBST3(root.right);
	}
	
	/*
	 * Iterative method using stack.
	 * In-order traversal with link to previous node.
	 */
    public boolean isValidBST4(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode p = null;
        TreeNode c = root;
        while (!stack.isEmpty()) {
            if (c.left != null) {
                c = c.left;
                stack.push(c);
            } else {
                if (p != null && !stack.isEmpty() && p.val >= stack.peek().val) {
                    return false;
                }
                
                p = stack.pop();
                
                if (p.right != null) {
                    c = p.right;
                    stack.push(c);
                }
            }
        }
        
        return true;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
