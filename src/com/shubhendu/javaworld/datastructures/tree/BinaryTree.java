package com.shubhendu.javaworld.datastructures.tree;

public class BinaryTree {
	private TreeNode<Integer> root;

	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(Integer val) {
		this.root = new TreeNode<Integer>(val);
	}

	public TreeNode<Integer> getRoot() {
		return this.root;
	}

	public int size() {
		return (_size(this.root));
	}

	private int _size(TreeNode<Integer> node) {
		if (node == null)
			return 0;

		if (node.left == null && node.right == null) {
			return 1;
		}
		return (_size(node.left) + 1 + _size(node.right));
	}

	// Given a binary tree, find height of it. Height of empty tree is 0 and
	// height of below tree is 3.

	public int getMaxHeight() {
		if (root == null) {
			return 0;
		}
		return getMaxHeight(this.root, 1);
	}

	

	private int getMaxHeight(TreeNode<Integer> node, int height) {
		if (node == null) {
			return height;
		}
		int leftSubTreeHeight = node.left != null ? getMaxHeight(node.left, height + 1) : height;
		int rightSubTreeHeight = node.right != null ? getMaxHeight(node.right, height + 1) : height;

		return Math.max(leftSubTreeHeight, rightSubTreeHeight);

	}

	public int getLeafCount() {
		return countLeafNodes(root);
	}

	private int countLeafNodes(TreeNode<Integer> x) {
		if (x == null) {
			return 0;
		} else if (x.left == null && x.right == null) {
			return 1;
		} else {
			return countLeafNodes(x.left) + countLeafNodes(x.right);
		}
	}

	/*
	 * Given a Binary Tree and a key, write a function that returns level of the
	 * key.
	 */
	public int getLevelOfANode(int x) {
		return getLevelOfANode(root, x, 1);
	}

	private int getLevelOfANode(TreeNode<Integer> node, int data, int level) {
		if (node == null) {
			return 0;
		}

		if (node.val == data) {
			return level;
		}
		int l = getLevelOfANode(root.left, data, level + 1);
		if (l > 0) {
			return l;
		} else {
			return getLevelOfANode(root.right, data, level + 1);
		}

	}

	public TreeNode<Integer> getLowestCommonAncestor(TreeNode<Integer> a, TreeNode<Integer> b) {
		return getLowestCommonAncestor(root, a, b);
	}

	private TreeNode<Integer> getLowestCommonAncestor(TreeNode<Integer> currentNode, TreeNode<Integer> a,
			TreeNode<Integer> b) {
		if (currentNode == null) {
			return null;
		}

		if (currentNode.val == a.val) {
			return currentNode;
		}

		if (currentNode.val == b.val) {
			return currentNode;
		}

		TreeNode<Integer> leftMatch = getLowestCommonAncestor(currentNode.left, a, b);
		if (leftMatch != null && leftMatch.val != a.val && leftMatch.val != b.val)
			return leftMatch;

		TreeNode<Integer> rightMatch = getLowestCommonAncestor(currentNode.right, a, b);

		if (leftMatch == null && rightMatch == null) {
			return null;
		} else if (leftMatch != null && rightMatch != null) {
			return currentNode;
		} else if (leftMatch != null) {
			return leftMatch;
		} else {
			return rightMatch;
		}
	}

	public static void main(String[] args) {
		/*
		 * 
		 * 12 / \ 8 9 / \ / \ 2 7 10 11 / \ \ / \ 4 3 17 13 15
		 * 
		 */
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode<Integer>(12);
		tree.root.left = new TreeNode<Integer>(8);
		tree.root.left.left = new TreeNode<Integer>(2);
		tree.root.left.right = new TreeNode<Integer>(7);
		tree.root.left.right.left = new TreeNode<Integer>(4);
		tree.root.left.right.right = new TreeNode<Integer>(3);

		tree.root.right = new TreeNode<Integer>(9);
		tree.root.right.left = new TreeNode<Integer>(10);
		tree.root.right.left.right = new TreeNode<Integer>(17);

		tree.root.right.right = new TreeNode<Integer>(11);
		tree.root.right.right.left = new TreeNode<Integer>(13);
		tree.root.right.right.right = new TreeNode<Integer>(15);
		
		TreeNode<Integer> lca = tree.getLowestCommonAncestor(new TreeNode<Integer>(4), new TreeNode<Integer>(12));
		if (lca != null) {
			System.out.println("LCA :-->" + lca.val);
		} else {
			System.out.println("No LCA");
		}

		// tree.root = new TreeNode<Integer>(1);
		// tree.root.left = new Node(2);
		// tree.root.right = new Node(3);
		// tree.root.left.left = new Node(4);
		// tree.root.left.right = new Node(5);
		// tree.root.left.right.right = new Node(6);
		// tree.root.left.right.right.left = new Node(3);
		// tree.root.left.right.right.right = new Node(7);
		// tree.root.left.right.right.right.left = new Node(8);
		//
		// /* get leaf count of the abve tree */
		// System.out.println("The leaf count of binary tree is : "
		// + tree.getLeafCount());
		// System.out.println("The height of binary tree is : "
		// + tree.getMaxHeight());
	}
	// BinaryTree tree = new BinaryTree(45);
	// TreeNode<Integer> root = tree.getRoot();
	// root.left = new TreeNode<Integer>(25);
	// root.right = new TreeNode<Integer>(45);
	//
	// root.left.left = new TreeNode<Integer>(10);
	// root.left.right = new TreeNode<Integer>(15);
	//
	// root.right.left = new TreeNode<Integer>(35);
	// root.right.right = new TreeNode<Integer>(50);
	// root.right.right.left = new TreeNode<Integer>(49);
	// root.right.right.right = new TreeNode<Integer>(51);
	//
	// System.out.println(tree.size());
	//
	// BinaryTree.inOrderTraversal(root);
	// System.out.println(" InOrder Traversal");
	//
	// BinaryTree.postOrderTraversal(root);
	// System.out.println(" PostOrder Traversal");
	//
	// BinaryTree.preOrderTraversal(root);
	// System.out.println(" PreOrder Traversal");
	//
	// // BFS on Binary Tree
	// Queue<TreeNode<Integer>> queue = new ArrayDeque<TreeNode<Integer>>();
	// queue.add(root);
	//
	// while (!queue.isEmpty()) {
	// TreeNode<Integer> elem = queue.poll();
	// System.out.println(elem.val);
	// if (elem.left != null) {
	// queue.add(elem.left);
	// }
	// if (elem.right != null) {
	// queue.add(elem.right);
	// }
	// }
	//
	// // In Order Traversal using stack
	// Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
	// s.add(root);
	// TreeNode<Integer> currentNode = root;
	// while (!s.isEmpty()) {
	// if (currentNode == null) {
	// TreeNode<Integer> currElement = s.pop();
	// System.out.println(currElement.val);
	// currentNode = currElement.right;
	// } else {
	// currentNode = currentNode.left;
	// s.add(currentNode);
	// }
	//
	// }
	//
	// }

	public static void inOrderTraversal(TreeNode<Integer> node) {
		if (node == null)
			return;
		inOrderTraversal(node.left);
		System.out.print(" " + node.val);
		inOrderTraversal(node.right);
	}

	public static void preOrderTraversal(TreeNode<Integer> node) {
		if (node == null)
			return;
		System.out.print(" " + node.val);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public static void postOrderTraversal(TreeNode<Integer> node) {
		if (node == null)
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(" " + node.val);
	}

}
