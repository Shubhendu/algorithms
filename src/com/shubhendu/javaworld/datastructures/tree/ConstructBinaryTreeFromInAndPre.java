package com.shubhendu.javaworld.datastructures.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInAndPre {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	private Map<Integer, Integer> inOrderIndex = new HashMap<Integer, Integer>();
	private int preIndex = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			inOrderIndex.put(inorder[i], i);
		}
		return buildTree(preorder, inorder, 0, preorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
		if (preIndex >= preorder.length) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[preIndex]);
		int inIndex = inOrderIndex.get(preorder[preIndex]);
		preIndex++;

		if (inStart == inEnd) {
			return node;
		}

		node.left = buildTree(preorder, inorder, inStart, inIndex - 1);
		node.right = buildTree(preorder, inorder, inIndex + 1, inEnd);

		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
