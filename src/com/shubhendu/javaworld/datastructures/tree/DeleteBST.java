/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

/**
 * @author ssingh
 *
 */
public class DeleteBST {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}
		if (root.val == key) {
			root = deleteNode(root);
		} else if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else {
			root.right = deleteNode(root.right, key);
		}
		
		return root;
	}

	private TreeNode deleteNode(TreeNode node) {
		if (node.left == null) {
			return node.right;
		}
		if (node.right == null) {
			return node.left;
		}
		TreeNode maxNode = deleteMax(node);
		node.val = maxNode.val;
		return node;
	}

	private TreeNode deleteMax(TreeNode node) {
		TreeNode parent = node.left;
		TreeNode child = parent.right;

		while (child != null && child.right != null) {
			parent = child;
			child = child.right;
		}
		
		if (child != null) {
			parent.right = child.left;
			child.left = null;
			return child;
		} else {
			return parent;
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		5,3,6,2,4,null,7]
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		DeleteBST d = new DeleteBST();
		TreeNode result = d.deleteNode(root, 5);
		System.out.println(result.val);

	}

}
