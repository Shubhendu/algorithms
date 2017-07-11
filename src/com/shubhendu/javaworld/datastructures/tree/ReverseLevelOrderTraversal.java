/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ssingh
 *
 */
public class ReverseLevelOrderTraversal {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int count = 0;
		Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
		while (!q.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			count = q.size();
			int i = 0;
			while (i < count) {
				TreeNode node = q.poll();
				level.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				i++;
			}
			stack.push(level);
		}

		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}

		return result;
	}

	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			count = q.size();
			int i = 0;
			while (i < count) {
				TreeNode node = q.poll();
				level.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				i++;
			}
			result.addFirst(level);
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
