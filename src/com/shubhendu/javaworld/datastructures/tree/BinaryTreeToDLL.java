/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

/**
 * @author ssingh 
 * Given a Binary Tree (Bt), convert it to a Doubly Linked
 *         List(DLL). The left and right pointers in nodes are to be used as
 *         previous and next pointers respectively in converted DLL. The order
 *         of nodes in DLL must be same as Inorder of the given Binary Tree. The
 *         first node of Inorder traversal (left most node in BT) must be head
 *         node of the DLL.
 *         http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-
 *         doubly-linked-list/
 */
public class BinaryTreeToDLL {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode convertToDLL(TreeNode root) {
		root = convertToDLLUtil(root);

		if (root == null) {
			return null;
		}
		while (root.left != null) {
			root = root.left;
		}

		return root;
	}

	private TreeNode convertToDLLUtil(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			root.left = convertToDLL(root.left);
			TreeNode rightMostNode = root.left;
			while (rightMostNode.right != null) {
				rightMostNode = rightMostNode.right;
			}
			rightMostNode.right = root;
			root.left = rightMostNode;
		}

		if (root.right != null) {
			root.right = convertToDLL(root.right);
			TreeNode leftMostNode = root.right;
			while (leftMostNode.left != null) {
				leftMostNode = leftMostNode.left;
			}
			leftMostNode.left = root;
			root.right = leftMostNode;
		}

		return root;
	}

	private static void printIncreasingOrder(TreeNode node) {
		System.out.println("\nIncreasing Order\n");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
		}
	}

	private static void printDecreasingOrder(TreeNode node) {
		while (node.right != null) {
			node = node.right;
		}
		System.out.println("\nDecreasing Order\n");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.left;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(9);
		root.left.right.right = new TreeNode(10);

		root.right = new TreeNode(14);
		root.right.left = new TreeNode(11);

		BinaryTreeToDLL binaryTreeToDLL = new BinaryTreeToDLL();
		TreeNode convertedNode = binaryTreeToDLL.convertToDLL(root);
		printDecreasingOrder(convertedNode);
		printIncreasingOrder(convertedNode);
	}

}
