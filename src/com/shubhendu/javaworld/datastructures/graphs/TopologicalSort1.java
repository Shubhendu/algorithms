package com.shubhendu.javaworld.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort1 {

	private class Graph {
		private int V;
		private int E;
		private Queue<Integer>[] adj;
		private boolean[] visited;

		public Graph(int v) {
			this.V = v;
			this.adj = new LinkedList[v];
			this.visited = new boolean[v];
			for (int i = 0; i < v; i++) {
				this.adj[i] = new LinkedList<Integer>();
			}
		}

		public void addEdge(int v, int u) {
			this.adj[v].add(u);
		}

		public void setVisited(boolean[] visited) {
			this.visited = visited;
		}
	}

	private class DFSGraphTraversal {
		Graph G;
		boolean[] inCallStack;

		public DFSGraphTraversal(Graph graph) {
			this.G = graph;
			inCallStack = new boolean[graph.V];
		}

		public boolean hasCycle() {
			for (int v = 0; v < G.V; v++) {
				if (!G.visited[v] && hasCycle(v)) {
					return true;
				}
			}
			return false;
		}

		private boolean hasCycle(int v) {
			inCallStack[v] = true;
			G.visited[v] = true;

			for (int u : G.adj[v]) {
				if (inCallStack[u]) {
					return true;
				}
				if (!G.visited[u] && hasCycle(u)) {
					return true;
				}
			}
			inCallStack[v] = false;
			return false;
		}

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0) {
			return true;
		}
		Graph graph = new Graph(numCourses);

		for (int i = 0; i < prerequisites.length; i++) {
			graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
		}

		DFSGraphTraversal dfs = new DFSGraphTraversal(graph);
		if (dfs.hasCycle()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 4;
		int[][] edges = new int[][] { { 1, 0 }, { 2, 0 }, {0, 3}, { 3, 1 }, { 3, 2 } };
		TopologicalSort1 t1 = new TopologicalSort1();
		System.out.println(t1.canFinish(v, edges));
	}

}
