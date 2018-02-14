package com.shubh.javaworld;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
	int vertices;
	Queue<Integer>[] adj;

	public Graph(int v) {
		createGraph(v);
	}

	public Graph(int[][] edges) {
		createGraph(edges.length);
		for (int r = 0; r < edges.length; r++) {
			for (int c = 0; c < edges[0].length; c++) {
				if (edges[r][c] == 1) {
					addEdge(r, c);
				}
			}
		}
	}

	public void addEdge(int u, int v) {
		this.adj[u].add(v);
	}

	private void createGraph(int n) {
		this.vertices = n;
		this.adj = new LinkedList[this.vertices];
		for (int u = 0; u < this.vertices; u++) {
			this.adj[u] = new LinkedList<Integer>();
		}
	}
}

class GraphTraversal {
	Stack<Integer> reverseOrder;
	Graph graph;
	boolean[] isVisited;
	int count;

	public GraphTraversal(Graph g) {
		this.graph = g;
		this.reverseOrder = new Stack<>();
		this.isVisited = new boolean[this.graph.vertices];
	}

	public void traverse() {
		for (int v = 0; v < this.graph.vertices; v++) {
			if (!this.isVisited[v]) {
				setCount(getCount() + 1);
				dfs(v);
			}
		}
	}

	public void traverseInProvidedOrder(Stack<Integer> order) {
		for (int v : order) {
			if (!this.isVisited[v]) {
				setCount(getCount() + 1);
				dfs(v);
			}
		}
	}

	private void dfs(int u) {
		this.isVisited[u] = true;
		for (int v : this.graph.adj[u]) {
			if (!isVisited[v]) {
				dfs(v);
			}
		}
		this.reverseOrder.push(u);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

public class StronglyConnectedComponent {
	public Graph reverseGraph(Graph g) {
		Graph reversedGraph = new Graph(g.vertices);
		for (int u = 0; u < g.vertices; u++) {
			for (Integer v : g.adj[u]) {
				reversedGraph.addEdge(v, u);
			}
		}
		return reversedGraph;
	}

	public int minNumberOfVertices(int[][] edges) {
		Graph graph = new Graph(edges);
		Graph reversedGraph = reverseGraph(graph);

		GraphTraversal reverseGraphTraversal = new GraphTraversal(reversedGraph);
		reverseGraphTraversal.traverse();
		Stack<Integer> order = reverseGraphTraversal.reverseOrder;

		GraphTraversal graphTraversal = new GraphTraversal(graph);
		graphTraversal.traverseInProvidedOrder(order);

		return graphTraversal.getCount();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = new int[][] { 
			{ 0, 1, 0, 1 }, 
			{ 0, 0, 1, 0 }, 
			{ 0, 1, 0, 0 }, 
			{ 0, 0, 0, 0 }, 
			};
		StronglyConnectedComponent s = new StronglyConnectedComponent();
		int count = s.minNumberOfVertices(edges);
		System.out.println(count);
		
	}

}
