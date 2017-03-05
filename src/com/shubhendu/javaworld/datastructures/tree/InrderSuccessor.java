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
public class InrderSuccessor {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null)
			return null;

		List<TreeNode> inOrderTraversalList = new ArrayList<TreeNode>();
		traverseInorder(root, inOrderTraversalList);

		int index = binarySearchNode(p, inOrderTraversalList);

		if (index == -1)
			return null;

		return index < inOrderTraversalList.size() - 1 ? inOrderTraversalList.get(index + 1) : null;

	}

	private void traverseInorder(TreeNode node, List<TreeNode> inOrderTraversalList) {
		if (node == null)
			return;

		traverseInorder(node.left, inOrderTraversalList);
		inOrderTraversalList.add(node);
		traverseInorder(node.right, inOrderTraversalList);
	}

	private int binarySearchNode(TreeNode node, List<TreeNode> inOrderTraversalList) {
		int lo = 0;
		int hi = inOrderTraversalList.size() - 1;
		TreeNode midNode = null;
		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			midNode = inOrderTraversalList.get(mid);
			if (node == midNode)
				return mid;
			else if (node.val < midNode.val)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return -1;

	}

	private void printNode(TreeNode node) {
		if (node == null)
			System.out.println("Null");
		else
			System.out.println("Inorder: " + node.val);
	}

	public static void main(String[] args) {
		int x = 4 ^ 1;
		int count = 0;
		while (x != 0) {
			System.out.println(count + " : " + x);
			x = x & (x- 1);
			count++;
		}

		// TreeNode root = new TreeNode(23);
		// root.left = new TreeNode(15);
		// root.left.left = new TreeNode(10);
		// root.left.right = new TreeNode(18);
		//
		// root.right = new TreeNode(34);
		// root.right.left = new TreeNode(28);
		// root.right.right = new TreeNode(35);
		// root.right.left.left = new TreeNode(25);
		// root.right.left.right = new TreeNode(29);
		// root.right.left.right.right = new TreeNode(30);
		//
		// InrderSuccessor inrderSuccessor = new InrderSuccessor();
		//// inrderSuccessor.printNode(inrderSuccessor.inorderSuccessor(root,
		// root.right.left));
		//// inrderSuccessor.printNode(inrderSuccessor.inorderSuccessor(root,
		// root));
		//// inrderSuccessor.printNode(inrderSuccessor.inorderSuccessor(root,
		// root.left.left));
		//// inrderSuccessor.printNode(inrderSuccessor.inorderSuccessor(root,
		// root.left));
		//// inrderSuccessor.printNode(inrderSuccessor.inorderSuccessor(root,
		// new TreeNode(35)));
		// inrderSuccessor.printNode(inrderSuccessor.inorderSuccessor(root,
		// root.right.right));
		//// inrderSuccessor.printNode(inrderSuccessor.inorderSuccessor(root,
		// root.left.right));
	}

}
