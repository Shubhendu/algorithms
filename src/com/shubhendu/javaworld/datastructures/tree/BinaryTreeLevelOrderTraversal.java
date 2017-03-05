package com.shubhendu.javaworld.datastructures.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	
	TreeNode<Integer> root;
	
	private int depth(TreeNode<Integer> node) {
		return depth(node, 0);
	}

	private int depth(TreeNode<Integer> node, int d) {
		if (node == null)
			return d;
		d++;
		return Math.max(depth(node.left, d), depth(node.right, d));
	}

	public List<List<Integer>> levelOrder(TreeNode<Integer> root) {

		int height = depth(root);
		List<List<TreeNode<Integer>>> levelOrderNodes = new ArrayList<List<TreeNode<Integer>>>(height);

		
		List<TreeNode<Integer>> nextLevelNodes = null;
		levelOrderNodes.add(new ArrayList<TreeNode<Integer>>(Arrays.asList((TreeNode<Integer>[]) new TreeNode[] {root})));
		for (int i = 0; i < height; i++) {
			levelOrderNodes.get(i);
			nextLevelNodes = new ArrayList<TreeNode<Integer>>();
			for (TreeNode<Integer> curreLevelNode: levelOrderNodes.get(i)) {
				if (curreLevelNode.left != null)
					nextLevelNodes.add(curreLevelNode.left);
				if (curreLevelNode.right != null)
					nextLevelNodes.add(curreLevelNode.right);
			}
			levelOrderNodes.add(i+1, nextLevelNodes);
		}
		
		List<List<Integer>> levelOrder = new ArrayList<List<Integer>>(height);
		List<Integer> currentLevelVals = null;
		for (int i = 0; i < height; i++) {
			List<TreeNode<Integer>> currentLevelNodes = levelOrderNodes.get(i);
			currentLevelVals = new ArrayList<Integer>(currentLevelNodes.size());
			for(TreeNode<Integer> currentLevelNode: currentLevelNodes){
				System.out.print(" "+currentLevelNode.val);
				currentLevelVals.add(currentLevelNode.val);
			}
			System.out.println("\n");
			levelOrder.add(i, currentLevelVals);
		}

		return levelOrder;

	}
	
	
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
        tree.root = new TreeNode<Integer>(1);
		tree.root.left = new TreeNode<Integer>(2);
        tree.root.right = new TreeNode<Integer>(3);
        tree.root.left.left = new TreeNode<Integer>(4);
        tree.root.left.right = new TreeNode<Integer>(5);
        tree.root.left.right.right = new TreeNode<Integer>(6);
        tree.root.left.right.right.left = new TreeNode<Integer>(3);
        tree.root.left.right.right.right = new TreeNode<Integer>(7);
        tree.root.left.right.right.right.left = new TreeNode<Integer>(8);
          
        /* get leaf count of the abve tree */
       
        System.out.println("The height of binary tree is : "
                + tree.depth(tree.root));
        
        tree.levelOrder(tree.root);
	}
}
