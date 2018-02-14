package com.shubh.javaworld;

import java.util.PriorityQueue;

public class KthElementSortedMatrix {
	class Tuple implements Comparable<Tuple> {
		int r;
		int c;
		int val;

		public Tuple(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

		public int compareTo(Tuple other) {
			return this.val - other.val;
		}
	}

	public int kthSmallest(int[][] matrix, int k) {
		int cols = matrix[0].length;
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();

		for (int c = 0; c < cols; c++) {
			pq.add(new Tuple(0, c, matrix[0][c]));
		}
		for (int i = 0; i < k - 1; i++) {
			Tuple t = pq.poll();
			if (t.r == matrix.length - 1) {
				continue;
			}
			pq.add(new Tuple(t.r + 1, t.c, matrix[t.r + 1][t.c]));
		}
		return pq.peek().val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
