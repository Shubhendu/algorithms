package com.shubhendu.javaworld.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.shubhendu.javaworld.datastructures.tree.InrderSuccessor.TreeNode;

public class MinDepth {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		int min = 0;
		if (root == null) {
			return min;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			count = q.size();
			int i = 0;
			min++;
			while (i < count) {
				TreeNode node = q.poll();
				if (node.left == null && node.right == null) {
					return min;
				}
				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
				i++;
			}

		}
		return min;
	}

	public int minDepth2(TreeNode root) {
		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
