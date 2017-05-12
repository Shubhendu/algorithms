/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class LeavesOfBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> allLeaves = new ArrayList<List<Integer>>();
		while (root != null) {
			ArrayList<Integer> leaves = new ArrayList<Integer>();
			root = removeLeaves(root, leaves);
			allLeaves.add(leaves);
		}
		return allLeaves;
	}

	private TreeNode removeLeaves(TreeNode node, ArrayList<Integer> leaves) {
		if (node == null) {
			return null;
		}

		if (node.left == null && node.right == null) {
			leaves.add(node.val);
			return null;
		}

		node.left = removeLeaves(node.left, leaves);
		node.right = removeLeaves(node.right, leaves);
		return node;
	}

	private static void printLeaves(List<List<Integer>> output) {
		System.out.println("Print Leaves -->");
		for (List<Integer> leaves : output) {
			for (Integer leaf : leaves) {
				System.out.print(" " + leaf);
			}
			System.out.println("\n");

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		LeavesOfBinaryTree leavesOfBinaryTree = new LeavesOfBinaryTree();
		printLeaves(leavesOfBinaryTree.findLeaves(root));

	}

}
