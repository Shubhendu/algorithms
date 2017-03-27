/**
 * 
 */
package com.shubhendu.javaworld.datastructures.mst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ssingh
 *
 */
public class EdgeWeightedGraph {

	// Number of vertices
	private int V;
	// Number of edges
	private int E;
	private Queue<Edge>[] adj;

	public EdgeWeightedGraph(int v) {
		this.V = v;
		adj = (Queue<Edge>[]) new Object[v];
		for (int i = 0; i < this.V; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	public int numberOfVertices() {
		return this.V;
	}

	public int numberOfEdges() {
		return this.E;
	}

	public void add(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<Edge> adjacent(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		Queue<Edge> queue = new LinkedList<Edge>();
		for (int v = 0; v < V; v++) {
			for (Edge e : adj[v]) {
				if (e.other(v) > v)
					queue.add(e);
			}
		}
		return queue;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
