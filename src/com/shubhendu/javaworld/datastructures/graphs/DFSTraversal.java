/**
 * 
 */
package com.shubhendu.javaworld.datastructures.graphs;

/**
 * @author ssingh
 *
 */
public class DFSTraversal {
	private Graph G;
	private boolean[] visited;
	private int[] edgeTo;

	public DFSTraversal(Graph G) {
		this.G = G;
		this.visited = new boolean[this.G.getNumberOfVertices()];
		this.edgeTo = new int[this.G.getNumberOfVertices()];
	}

	public void DFS(Graph G, int s) {
		dfs(s);
	}

	private void dfs(int v) {
		if (visited[v]) {
			return;
		}
		visited[v] = true;

		for (int i = 0; i < this.G.getAdj()[v].size(); i++) {
			if (!visited[i]) {
				edgeTo[i] = v;
				dfs(i);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
