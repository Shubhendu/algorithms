/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

/**
 * @author Shubhendu Singh
 * Given a binary tree and a number(sum), return a path from root to leaf nodes that is equal to that sum.
 * 				4
 * 		
 * 		15				7
 * 	
 * 	  2	  18					21		
 * 	 /    /					  /    \
 * -2	-4					9		5
 * 					  	  /   \
 * 					 	6		-1
 * getLowestCommonAncestor(tree, 6, 18) , output = 4
 * getLowestCommonAncestor(tree, 18, 15) , output = 15	
 * getLowestCommonAncestor(tree, 21, -1) , output = 21
 * 
 */
public class LowestCommonAncestor {

	public TreeNode<Integer> getLowestCommonAncestor(BinaryTree tree, TreeNode<Integer> n1, TreeNode<Integer> n2) {
		TreeNode<Integer> lca = getLowestCommonAncestor(tree.getRoot(), n1, n2);
		System.out.println("Lowest common ancestor of node1: " + n1.val + " node2: " + n2.val + " is: "
				+ lca.val);
		return lca;
	}

	private TreeNode<Integer> getLowestCommonAncestor(TreeNode<Integer> x, TreeNode<Integer> n1, TreeNode<Integer> n2) {
		if (x == null)
			return null;

		if (x == n1 || x == n2)
			return x;

		TreeNode<Integer> leftMatchNode = getLowestCommonAncestor(x.left, n1, n2);

		if (leftMatchNode != null && leftMatchNode != n1 && leftMatchNode != n2) {
			return leftMatchNode;
		}

		TreeNode<Integer> rightMatchNode = getLowestCommonAncestor(x.right, n1, n2);

		if (leftMatchNode == null && rightMatchNode == null) {
			return null;
		} else if (leftMatchNode != null && rightMatchNode != null)
			return x;
		else if (leftMatchNode != null)
			return leftMatchNode;
		else
			return rightMatchNode;

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

		LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
		lowestCommonAncestor.getLowestCommonAncestor(bt, bt.getRoot().left.left.left, bt.getRoot().right.right.left);
		lowestCommonAncestor.getLowestCommonAncestor(bt, bt.getRoot().right.right.right, bt.getRoot().right);
		lowestCommonAncestor.getLowestCommonAncestor(bt, bt.getRoot().left.right, bt.getRoot().right);
		lowestCommonAncestor.getLowestCommonAncestor(bt, bt.getRoot(), bt.getRoot().left.right.left);
		lowestCommonAncestor.getLowestCommonAncestor(bt, bt.getRoot().left.left, bt.getRoot().left.right);
		lowestCommonAncestor.getLowestCommonAncestor(bt, bt.getRoot().left.left, new TreeNode<Integer>(25));

	}

}
