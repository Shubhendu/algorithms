/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ssingh
 *
 *         Given a root node reference of a BST and a val, delete the node with
 *         the given val in the BST. Return the root node reference (possibly
 *         updated) of the BST.
 * 
 *         Basically, the deletion can be divided into two stages:
 * 
 *         Search for a node to remove. If the node is found, delete the node.
 *         Note: Time complexity should be O(height of tree).
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}

}

public class DeleteNodeBST {
	private static void bfsTree(TreeNode root) {
		if (root == null) {
			System.out.println("Null BST");
			return;
		}
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode elem = queue.poll();
			System.out.print("\t" + elem.val);
			if (elem.left != null) {
				queue.add(elem.left);
			}
			if (elem.right != null) {
				queue.add(elem.right);
			}
		}
	}

	private TreeNode maxNodeInLeftSubTree(TreeNode node) {
		TreeNode maxNodesParentInLeftSubTree = findParentOfMaximumNodeInLeftSubTree(node);
		if (maxNodesParentInLeftSubTree == node) {
			if (maxNodesParentInLeftSubTree.left == null && maxNodesParentInLeftSubTree.right == null) {
				node = null;
				return node;
			} else if (maxNodesParentInLeftSubTree.right == null) {
				node = maxNodesParentInLeftSubTree.left;
				return node;
			}
		}
		TreeNode maxNodeInLeftSubTree = null;
		if (maxNodesParentInLeftSubTree == node.left && maxNodesParentInLeftSubTree.right == null) {
			maxNodeInLeftSubTree = maxNodesParentInLeftSubTree;
		} else {
			maxNodeInLeftSubTree = maxNodesParentInLeftSubTree.right;
			maxNodesParentInLeftSubTree.right = null;
			maxNodeInLeftSubTree.left = node.left;
		}
		maxNodeInLeftSubTree.right = node.right;

		return maxNodeInLeftSubTree;
	}

	public TreeNode deleteNode(TreeNode root, int val) {
		if (root == null)
			return null;

		if (root.val == val) {
			return maxNodeInLeftSubTree(root);
		}
		TreeNode parentNode = findNode(root, val);
		if (parentNode != null) {
			TreeNode node = null;
			String nodeSide = null;
			if (parentNode.left.val == val) {
				node = parentNode.left;
				nodeSide = "left";
			} else {
				node = parentNode.right;
				nodeSide = "right";
			}

			if (node.left == null && node.right == null) {
				if (nodeSide == "left") {
					parentNode.left = null;
				} else {
					parentNode.right = null;
				}
			} else if (node.left == null) {
				if (nodeSide == "left") {
					parentNode.left = node.right;
				} else {
					parentNode.right = node.right;
				}
			} else if (node.right == null) {
				if (nodeSide == "left") {
					parentNode.left = node.left;
				} else {
					parentNode.right = node.left;
				}
			} else {
				TreeNode maxNodeInLeftSubTree = maxNodeInLeftSubTree(node);
				if (nodeSide == "left") {
					parentNode.left = maxNodeInLeftSubTree;
				} else {
					parentNode.right = maxNodeInLeftSubTree;
				}

			}
		}
		return root;

	}

	private TreeNode findParentOfMaximumNodeInLeftSubTree(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode maxNodeInLeftSubTree = node.left;

		if (maxNodeInLeftSubTree == null || maxNodeInLeftSubTree.right == null) {
			return node;
		}

		while (maxNodeInLeftSubTree.right.right != null) {
			maxNodeInLeftSubTree = maxNodeInLeftSubTree.right;
		}
		return maxNodeInLeftSubTree;
	}

	private TreeNode findNode(TreeNode node, int val) {
		if (node == null)
			return null;
		else if (node.right != null && node.right.val == val)
			return node;
		else if (node.left != null && node.left.val == val)
			return node;
		else if (node.val < val)
			return findNode(node.right, val);
		else
			return findNode(node.left, val);

	}

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(59);
//		root.left = new TreeNode(36);
//		root.right = new TreeNode(61);
//
//		root.left.left = new TreeNode(29);
//		root.left.right = new TreeNode(41);
//
//		root.left.right.left = new TreeNode(37);
//		root.left.right.right = new TreeNode(42);
//
//		root.right.left = new TreeNode(55);
//		root.right.right = new TreeNode(74);
//
//		root.right.left.left = new TreeNode(54);
//		root.right.left.right = new TreeNode(60);
//
//		root.right.right.left = new TreeNode(70);
//		root.right.right.right = new TreeNode(75);
//
//		System.out.println("Before delete");
//		DeleteNodeBST.bfsTree(root);
//
//		DeleteNodeBST deleteNodeBST = new DeleteNodeBST();
//		TreeNode deletedNode = deleteNodeBST.deleteNode(root, 59);
//
//		System.out.println("\n After delete");
//		DeleteNodeBST.bfsTree(deletedNode);
//		
//		root = new TreeNode(5);
//		root.left = new TreeNode(3);
//		root.right = new TreeNode(6);
//
//		root.left.left = new TreeNode(2);
//		root.left.right = new TreeNode(4);
//
//		
//		root.right.right = new TreeNode(7);
//
//		System.out.println("Before delete");
//		DeleteNodeBST.bfsTree(root);
//
//		deleteNodeBST = new DeleteNodeBST();
//		deletedNode = deleteNodeBST.deleteNode(root, 5);
//
//		System.out.println("\n After delete");
//		DeleteNodeBST.bfsTree(deletedNode);
		
		DeleteNodeBST deleteNodeBST = new DeleteNodeBST();
		TreeNode root = new TreeNode(5);
		 root.left = new TreeNode(4);
		 root.left.left = new TreeNode(3);
		
		TreeNode deletedNode = deleteNodeBST.deleteNode(root, 5);
		DeleteNodeBST.bfsTree(deletedNode);


	}

}
