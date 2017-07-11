/**
 * 
 */
package com.shubhendu.javaworld.datastructures.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author ssingh
 *
 */
public class CourseSchedule {
	// private class Graph {
	// private int v;
	// private Queue<Integer>[] adj;
	// private boolean[] visited;
	//
	// public Graph(int v) {
	// this.v = v;
	// this.adj = new LinkedList[v];
	// this.visited = new boolean[v];
	// for (int i = 0; i < v; i++) {
	// this.adj[i] = new LinkedList<Integer>();
	// }
	// }
	//
	// private void addEdge(int u, int v) {
	// this.adj[u].add(v);
	// }
	//
	// public void setVisited(boolean[] visited) {
	// this.visited = visited;
	// }
	// }
	//
	// private class DepthFirstGraphTraversal {
	// Graph G;
	// boolean[] callStack;
	//
	// public DepthFirstGraphTraversal(Graph G) {
	// this.G = G;
	// callStack = new boolean[G.v];
	// }
	//
	// public boolean hasCycle() {
	// for (int u = 0; u < G.v; u++) {
	// if (!G.visited[u]) {
	// callStack = new boolean[G.v];
	// if (hasCycle(u)) {
	// return true;
	// }
	// }
	//
	// }
	// return false;
	// }
	//
	// private boolean hasCycle(int v) {
	// callStack[v] = true;
	// G.visited[v] = true;
	// for (int u : G.adj[v]) {
	// if (callStack[u]) {
	// return true;
	// }
	// if (hasCycle(u)) {
	// return true;
	// }
	//
	// }
	// callStack[v] = false;
	// return false;
	// }
	// }
	//
	// public int[] findOrder(int numCourses, int[][] prerequisites) {
	// if (numCourses < 2 || prerequisites == null) {
	// return null;
	// }
	// Graph graph = new Graph(numCourses);
	// DepthFirstGraphTraversal dfsTraversal = new
	// DepthFirstGraphTraversal(graph);
	// int[] order = new int[0];
	//
	// for (int i = 0; i < prerequisites.length; i++) {
	// graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
	// }
	//
	// if (dfsTraversal.hasCycle()) {
	// return order;
	// }
	//
	// graph.setVisited(new boolean[numCourses]);
	// order = new int[numCourses];
	//
	// Stack<Integer> stack = new Stack<Integer>();
	//
	// for (int i = 0; i < numCourses; i++) {
	// if (!graph.visited[i]) {
	// dfs(graph, i, stack);
	// }
	// }
	//
	// int count = 0;
	// while (!stack.isEmpty()) {
	// order[count++] = stack.pop();
	// }
	//
	// return order;
	// }
	//
	// public void dfs(Graph g, int v, Stack<Integer> stack) {
	// if (g.visited[v]) {
	// return;
	// }
	// g.visited[v] = true;
	// for (int u : g.adj[v]) {
	// if (!g.visited[u]) {
	// dfs(g, u, stack);
	// }
	// }
	//
	// stack.push(v);
	// }

	private class Graph {
		private int V;
		private int E;
		private Queue<Integer>[] adj;
		private Set<Integer> noIncomingEdgeSet;

		public Graph(int v) {
			this.V = v;
			this.adj = new LinkedList[v];
			this.noIncomingEdgeSet = new HashSet<Integer>();
			for (int i = 0; i < V; i++) {
				this.adj[i] = new LinkedList<Integer>();
				this.noIncomingEdgeSet.add(i);
			}
		}

		public void addEdge(int u, int v) {
			this.adj[u].add(v);
			noIncomingEdgeSet.remove(v);
		}
	}

	private class TopologicalSort {
		private boolean[] visited;
		private Graph G;
		private Stack<Integer> reverseOrder;
		private boolean hasCycle;

		public TopologicalSort(Graph G) {
			this.G = G;
			this.visited = new boolean[G.V];
			this.reverseOrder = new Stack<Integer>();
		}

		public void topologicalSort() {
			for (int v : this.G.noIncomingEdgeSet) {
				if (this.hasCycle) {
					break;
				}
				if (!this.visited[v]) {
					traverse(v, new HashSet<Integer>());
					if (this.hasCycle) {
						break;
					}
				}
			}
			if (!this.hasCycle) {
				for (int v = 0; v < this.G.V; v++) {
					if (!this.visited[v]) {
						this.hasCycle = true;
						break;
					}
				}
			}
		}

		private void traverse(int v, Set<Integer> onCallStack) {
		
			this.visited[v] = true;
			onCallStack.add(v);
			for (int u : G.adj[v]) {
			    if (onCallStack.contains(u)) {
				    this.hasCycle = true;
				    return;
    			}
				if (!this.visited[u]) {
					traverse(u, onCallStack);
				}
			}
			onCallStack.remove(v);
			this.reverseOrder.add(v);
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] order = new int[0];
		if (numCourses == 1 && prerequisites == null) {
			order = new int[1];
			return order;
		} else if (prerequisites == null) {
			return order;
		}

		Graph G = new Graph(numCourses);
		for (int i = 0; i < prerequisites.length; i++) {
			G.addEdge(prerequisites[i][1], prerequisites[i][0]);
		}

		TopologicalSort topo = new TopologicalSort(G);
		topo.topologicalSort();
		if (topo.hasCycle) {
			return order;
		}

		int count = 0;
		order = new int[topo.reverseOrder.size()];
		while (!topo.reverseOrder.isEmpty()) {
			order[count++] = topo.reverseOrder.pop();
		}

		return order;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 4;
		int[][] edges = new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2}, { 1, 3 } };// {
		// {
		// 1,
		// 0
		// },
		// {
		// 2,
		// 0
		// },
		// {
		// 1,
		// 3
		// },
		// {
		// 0,
		// 3
		// },
		// {
		// 3,
		// 2
		// }
		// };
		CourseSchedule t = new CourseSchedule();
		int[] result = t.findOrder(v, edges);
		for (int i : result)
			System.out.print(i + " ->");

	}

}
