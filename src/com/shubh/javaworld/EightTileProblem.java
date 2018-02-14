package com.shubh.javaworld;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EightTileProblem {
	class Node {
		// stores parent node of current node
		// helps in tracing path when answer is found
		Node parent;
		int[][] matrix;
		int x, y;
		int cost;
		int level;
	}

	public Node newNode(int[][] mat, int[][] finalMatrix, int x, int y, int newX, int newY, int level, Node parent) {
		Node node = new Node();
		// set pointer for path to root
		node.parent = parent;

		// copy data from parent node to current node

		// move tile by 1 postion

		// set number of misplaced tiles
		node.cost = Integer.MAX_VALUE;

		// set number of moves so far
		node.level = level;

		node.x = newX;
		node.y = newY;
		return node;

	}

	private class NodeComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return (o1.cost + o1.level - o2.cost + o2.level);
		}

	}

	private int calculateCost(int[][] original, int[][] finalMatrix) {
		int count = 0;
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[0].length; j++) {
				if (original[i][j] != finalMatrix[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

	public void solve(int[][] original, int[][] finalMatrix, int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
		Node root = newNode(original, finalMatrix, x, y, x, y, 0, null);
		root.cost = calculateCost(original, finalMatrix);
		pq.add(root);

		while (!pq.isEmpty()) {
			Node min = pq.poll();
			if (min.cost == 0) {
				System.out.println("solved it");
				return;
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
