package com.shubh.javaworld;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInOrderAndPreOrder {
	private int preOrderIndex;

	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		preOrderIndex = 0;
		Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inOrderMap.put(inorder[i], i);
		}
		return build2(0, inorder.length, preorder, inOrderMap);
	}

	private TreeNode build2(int s, int e, int[] preorder, Map<Integer, Integer> inOrderMap) {
		if (preOrderIndex < 0 || preOrderIndex >= preorder.length || s > e) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[preOrderIndex]);
		int inOrderIdx = inOrderMap.get(preorder[preOrderIndex]);
		preOrderIndex++;
		if (s == e) {
			return node;
		}

		node.left = build2(s, inOrderIdx - 1, preorder, inOrderMap);
		node.right = build2(inOrderIdx + 1, e, preorder, inOrderMap);
		return node;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inOrderMap.put(inorder[i], i);
		}
		return build(0, inorder.length, preOrderIndex, preorder, inOrderMap);
	}

	private TreeNode build(int s, int e, int preOrderIndex, int[] preorder, Map<Integer, Integer> inOrderMap) {
		if (preOrderIndex < 0 || preOrderIndex >= preorder.length || s > e) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[preOrderIndex]);
		int inOrderIdx = inOrderMap.get(preorder[preOrderIndex]);
		if (s == e) {
			return node;
		}

		node.left = build(s, inOrderIdx - 1, preOrderIndex + 1, preorder, inOrderMap);
		node.right = build(inOrderIdx + 1, e, preOrderIndex + inOrderIdx - s + 1, preorder, inOrderMap);
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = new int[] { 15, 10, 8, 12, 11, 17, 21, 18 };
		int[] inorder = new int[] { 8, 10, 11, 12, 15, 17, 18, 21 };

		BinaryTreeFromInOrderAndPreOrder b = new BinaryTreeFromInOrderAndPreOrder();
		TreeNode node = b.buildTree(preorder, inorder);
		System.out.println(node.val);
	}

}
