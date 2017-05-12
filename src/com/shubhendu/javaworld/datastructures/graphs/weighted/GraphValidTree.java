/**
 * 
 */
package com.shubhendu.javaworld.datastructures.graphs.weighted;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class GraphValidTree {
	private Graph G;

	private class Graph {
		private int V;
		private int cc;
		private List<Integer>[] adj;
		private boolean[] visited;
		private int[] edgeTo;

		public Graph(int v) {
			this.V = v;
			this.visited = new boolean[v];
			this.edgeTo = new int[v];
			this.adj = (ArrayList<Integer>[]) new ArrayList[v];

			for (int i = 0; i < V; i++) {
				this.adj[i] = new ArrayList<Integer>();
			}
		}

		public void addEdges(int v, int w) {
			this.adj[v].add(w);
			this.adj[w].add(v);
		}
	}

	public boolean validTree(int n, int[][] edges) {
		this.G = new Graph(n);
		for (int i = 0; i < edges.length; i++) {
			this.G.addEdges(edges[i][0], edges[i][1]);
		}
		this.G.edgeTo[0] = 0;
		return !hasCycle(0) && checkEachNodeVisited();
	}

	private boolean checkEachNodeVisited() {
		for (int i = 0; i < this.G.V; i++) {
			if (!this.G.visited[i]) {
				return false;
			}
		}
		return true;
	}

	private boolean hasCycle(int v) {
		this.G.visited[v] = true;
		for (int x : this.G.adj[v]) {
			if (this.G.visited[x] && this.G.edgeTo[x] != v) {
				return true;
			}
			return hasCycle(x);
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] edges = new int[][] {{0,1},{0,2},{2,3},{2,4}};
		GraphValidTree gvt = new GraphValidTree();
		boolean isValid = gvt.validTree(5, edges);
		System.out.println(isValid);
	}
}
