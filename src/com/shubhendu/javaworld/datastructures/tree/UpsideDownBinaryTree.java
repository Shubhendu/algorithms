/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tree;

import java.util.Random;

/**
 * @author ssingh
 *
 */
public class UpsideDownBinaryTree {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return root;

		TreeNode newRoot = upsideDownBinaryTree(root.left);

		root.left.left = root.right;
		root.left.right = root;

		root.left = null;
		root.right = null;

		return newRoot;
	}
	
	public void shuffle(int[] arr) {
		Random random = new Random();
		for (int i=1; i<arr.length; i++) {
			int r = random.nextInt(i);
			swap(arr, i, r);
		}
	}
	private void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}
	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
/**
 * @param args
 */
public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
	UpsideDownBinaryTree u = new UpsideDownBinaryTree();
	u.shuffle(arr);
	printArr(arr);
//	2 9 7 8 4 5 10 1 3 6 
}

}
