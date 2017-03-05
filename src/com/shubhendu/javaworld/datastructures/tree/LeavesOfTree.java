/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Shubhendu Singh
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * 				4
 * 		
 * 		15				7
 * 	
 * 	  2	  18					21		
 * 	 /    /					  /    \
 * -2	-4					9		5
 * 					  	  /   \
 * 					 	6		-1
 * [[-2,-4, 6, -1, 5], [2, 18,9], [15, 21], [7], [4]]
 * 
 */
public class LeavesOfTree {
	public List<List<Integer>> findLeaves(TreeNode<Integer> root) {
		if (root == null)
			return null;

		List<List<Integer>> leafNodes = new ArrayList<List<Integer>>();
		Set<TreeNode<Integer>> visitedNodes = new HashSet<TreeNode<Integer>>();

		while (!visitedNodes.contains(root)) {
			List<Integer> leaves = getLeaves(root, new ArrayList<Integer>(), visitedNodes);
			leafNodes.add(leaves);
		}

		return leafNodes;
	}
	
	private boolean isNodeVisited(TreeNode<Integer> x, Set<TreeNode<Integer>> vistedNodes){
		return (x.left == null && x.right == null || vistedNodes.contains(x.right) &&  vistedNodes.contains(x.left) || x.left == null && vistedNodes.contains(x.right)
				|| vistedNodes.contains(x.left) && x.right == null);
	}

	private List<Integer> getLeaves(TreeNode<Integer> x, List<Integer> leaves, Set<TreeNode<Integer>> vistedNodes) {
		if (x == null || vistedNodes.contains(x))
			return null; 
		if (isNodeVisited(x, vistedNodes)) {
			leaves.add(x.val);
			vistedNodes.add(x);
			return leaves;
		}

		getLeaves(x.left, leaves, vistedNodes);
		getLeaves(x.right, leaves, vistedNodes);

		return leaves;

	}
	
	private static void printLeaves(List<List<Integer>> output){
		System.out.println("Print Leaves -->");
		for(List<Integer> leaves : output) {
			for (Integer leaf : leaves) {
				System.out.print(" " +leaf);
			}
			System.out.println("\n");
			
		}
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree(4);
		bt.getRoot().left = new TreeNode<Integer>(15);
		bt.getRoot().left.left = new TreeNode<Integer>(2);
		bt.getRoot().left.left.left = new TreeNode<Integer>(-2);
		bt.getRoot().left.right = new TreeNode<Integer>(18);
		bt.getRoot().left.right.left = new TreeNode<Integer>(-4);

		bt.getRoot().right = new TreeNode<Integer>(7);
		bt.getRoot().right.right = new TreeNode<Integer>(21);
		bt.getRoot().right.right.left = new TreeNode<Integer>(9);
		bt.getRoot().right.right.left.left = new TreeNode<Integer>(6);
		bt.getRoot().right.right.left.right = new TreeNode<Integer>(-1);
		bt.getRoot().right.right.right = new TreeNode<Integer>(5);
		
		LeavesOfTree leavesOfTree = new LeavesOfTree();
		List<List<Integer>> output =  leavesOfTree.findLeaves(bt.getRoot());
		
		LeavesOfTree.printLeaves(output);
		
		
		bt = new BinaryTree(5); 
		bt.getRoot().left = new TreeNode<Integer>(15);
		bt.getRoot().left.left = new TreeNode<Integer>(14);
		bt.getRoot().right = new TreeNode<Integer>(-7);
		output =  leavesOfTree.findLeaves(bt.getRoot());
		LeavesOfTree.printLeaves(output);
	}
}
