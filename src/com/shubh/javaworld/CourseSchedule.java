package com.shubh.javaworld;

import java.util.LinkedList;

public class CourseSchedule {

	class Graph {
		private int V;
		private LinkedList<Integer>[] adj;

		public Graph(int n) {
			this.V = n;
			this.adj = new LinkedList[n];
			for (int i = 0; i < n; i++) {
				this.adj[i] = new LinkedList<Integer>();
			}
		}

		public void addEdges(int u, int v) {
			this.adj[u].add(v);
		}
	}

	class GraphTraversal {
		private Graph graph;
		private boolean[] visited;
		private boolean hasCycle;

		public GraphTraversal(Graph g) {
			this.graph = g;
			this.visited = new boolean[g.V];
			dfs();
		}

		private void dfs() {
			for (int v = 0; v < this.graph.V; v++) {
				if (!this.graph.adj[v].isEmpty() && !this.visited[v]) {
					dfs(v);
				}
			}
		}

		private void dfs(int v) {
			this.visited[v] = true;

			for (int u : this.graph.adj[v]) {
				if (!this.visited[u]) {
					dfs(u);
				} else {
					this.hasCycle = true;
					break;
				}
			}
			this.visited[v] = false;
		}

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Graph g = new Graph(numCourses);
		int source = 0;
		for (int i = 0; i < prerequisites.length; i++) {
			g.addEdges(prerequisites[i][0], prerequisites[i][1]);
			if (prerequisites[i][1] == source) {
				source = prerequisites[i][0];
			}
		}

		GraphTraversal dfsTraversal = new GraphTraversal(g);
		return !dfsTraversal.hasCycle;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
