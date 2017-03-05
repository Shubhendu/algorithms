/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

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


public class DeleteNodeBST {
	private static void bfsTree(TreeNode<Integer> root) {
		if (root == null) {
			System.out.println("Null BST");
			return;
		}
		Queue<TreeNode<Integer>> queue = new ArrayDeque<TreeNode<Integer>>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode<Integer> elem = queue.poll();
			System.out.print("\t" + elem.val);
			if (elem.left != null) {
				queue.add(elem.left);
			}
			if (elem.right != null) {
				queue.add(elem.right);
			}
		}
	}

	private TreeNode<Integer> maxNodeInLeftSubTree(TreeNode<Integer> node) {
		TreeNode<Integer> maxNodesParentInLeftSubTree = findParentOfMaximumNodeInLeftSubTree(node);
		if (maxNodesParentInLeftSubTree == node) {
			if (maxNodesParentInLeftSubTree.left == null && maxNodesParentInLeftSubTree.right == null) {
				node = null;
				return node;
			} else if (maxNodesParentInLeftSubTree.right == null) {
				node = maxNodesParentInLeftSubTree.left;
				return node;
			}
		}
		TreeNode<Integer> maxNodeInLeftSubTree = null;
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

	public TreeNode<Integer> deleteNode(TreeNode<Integer> root, int val) {
		if (root == null)
			return null;

		if (root.val == val) {
			return maxNodeInLeftSubTree(root);
		}
		TreeNode<Integer> parentNode = findNode(root, val);
		if (parentNode != null) {
			TreeNode<Integer> node = null;
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
				TreeNode<Integer> maxNodeInLeftSubTree = maxNodeInLeftSubTree(node);
				if (nodeSide == "left") {
					parentNode.left = maxNodeInLeftSubTree;
				} else {
					parentNode.right = maxNodeInLeftSubTree;
				}

			}
		}
		return root;

	}

	private TreeNode<Integer> findParentOfMaximumNodeInLeftSubTree(TreeNode<Integer> node) {
		if (node == null) {
			return null;
		}
		TreeNode<Integer> maxNodeInLeftSubTree = node.left;

		if (maxNodeInLeftSubTree == null || maxNodeInLeftSubTree.right == null) {
			return node;
		}

		while (maxNodeInLeftSubTree.right.right != null) {
			maxNodeInLeftSubTree = maxNodeInLeftSubTree.right;
		}
		return maxNodeInLeftSubTree;
	}

	private TreeNode<Integer> findNode(TreeNode<Integer> node, int val) {
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
//		TreeNode<Integer> root = new TreeNode<Integer>(59);
//		root.left = new TreeNode<Integer>(36);
//		root.right = new TreeNode<Integer>(61);
//
//		root.left.left = new TreeNode<Integer>(29);
//		root.left.right = new TreeNode<Integer>(41);
//
//		root.left.right.left = new TreeNode<Integer>(37);
//		root.left.right.right = new TreeNode<Integer>(42);
//
//		root.right.left = new TreeNode<Integer>(55);
//		root.right.right = new TreeNode<Integer>(74);
//
//		root.right.left.left = new TreeNode<Integer>(54);
//		root.right.left.right = new TreeNode<Integer>(60);
//
//		root.right.right.left = new TreeNode<Integer>(70);
//		root.right.right.right = new TreeNode<Integer>(75);
//
//		System.out.println("Before delete");
//		DeleteNodeBST.bfsTree(root);
//
//		DeleteNodeBST deleteNodeBST = new DeleteNodeBST();
//		TreeNode<Integer> deletedNode = deleteNodeBST.deleteNode(root, 59);
//
//		System.out.println("\n After delete");
//		DeleteNodeBST.bfsTree(deletedNode);
//		
//		root = new TreeNode<Integer>(5);
//		root.left = new TreeNode<Integer>(3);
//		root.right = new TreeNode<Integer>(6);
//
//		root.left.left = new TreeNode<Integer>(2);
//		root.left.right = new TreeNode<Integer>(4);
//
//		
//		root.right.right = new TreeNode<Integer>(7);
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
		TreeNode<Integer> root = new TreeNode<Integer>(5);
		 root.left = new TreeNode<Integer>(4);
		 root.left.left = new TreeNode<Integer>(3);
		
		TreeNode<Integer> deletedNode = deleteNodeBST.deleteNode(root, 5);
		DeleteNodeBST.bfsTree(deletedNode);


	}

}
