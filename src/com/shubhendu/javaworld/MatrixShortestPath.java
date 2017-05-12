package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixShortestPath {
	private int[][] matrix;
	private boolean[][] visited;
	private Point[][] edgeTo;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(Point b) {
			return this.x == b.x && this.y == b.y;
		}
	}

	public List<Point> shortestPathMatrix(int[][] matrix, Point srcPoint, Point destinationPoint) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		Queue<Point> q = new LinkedList<Point>();
		this.matrix = matrix;
		this.visited = new boolean[rows][cols];
		this.edgeTo = new Point[rows][cols];

		q.add(srcPoint);

		while (!q.isEmpty()) {
			Point p = q.poll();
			visited[p.x][p.y] = true;

			if (destinationPoint.equals(p)) {
				return findPath(srcPoint, destinationPoint);
			}
			boolean leftPointAdded = addToQueue(p, p.x - 1, p.y, q);
			boolean rightPointAdded = addToQueue(p, p.x + 1, p.y, q);
			boolean topPointAdded = addToQueue(p, p.x, p.y - 1, q);
			boolean bottomPointAdded = addToQueue(p, p.x, p.y + 1, q);
			if (!(leftPointAdded || rightPointAdded || topPointAdded || bottomPointAdded)) {
				continue;
			}
		}

		return null;

	}

	private List<Point> findPath(Point srcPoint, Point destinationPoint) {
		List<Point> path = new ArrayList<Point>();
		if (!visited[srcPoint.x][srcPoint.y] || !visited[destinationPoint.x][destinationPoint.y]) {
			return path;
		}
		while (!destinationPoint.equals(srcPoint)) {
			path.add(destinationPoint);
			destinationPoint = edgeTo[destinationPoint.x][destinationPoint.y];
		}
		path.add(srcPoint);
		return path;
	}

	private boolean addToQueue(Point srcPoint, int r, int c, Queue<Point> q) {
		if (r < 0 || r >= matrix.length || c < 0 || c > matrix[0].length || matrix[r][c] == 0 || visited[r][c]) {
			return false;
		}
		this.edgeTo[r][c] = srcPoint;
		q.add(new Point(r, c));
		return true;
	}

	private static void printList(List<Point> list) {
		System.out.print("[");
		for (Point a : list) {
			System.out.print("(" + a.x + ", " + a.y + "), ");
		}
		System.out.print("]\n");
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
				{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 0 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

		MatrixShortestPath sp = new MatrixShortestPath();
		List<Point> path = sp.shortestPathMatrix(matrix, new Point(0, 0), new Point(3, 4));
		printList(path);
		
		path = sp.shortestPathMatrix(matrix, new Point(4, 4), new Point(5, 7));
		printList(path);

	}

}
