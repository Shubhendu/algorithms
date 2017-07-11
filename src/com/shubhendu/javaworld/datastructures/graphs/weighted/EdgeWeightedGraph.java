/**
 * 
 */
package com.shubhendu.javaworld.datastructures.graphs.weighted;

import com.shubhendu.javaworld.datastructures.queue.Queue;

/**
 * @author ssingh
 *
 */
public class EdgeWeightedGraph{
	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public Queue<Edge>[] getAdj() {
		return adj;
	}

	public void setAdj(Queue<Edge>[] adj) {
		this.adj = adj;
	}

	private int V;
	private Queue<Edge>[] adj;
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.adj = (Queue<Edge>[]) new Queue[V];
		for (int v = 0; v < this.V; v++) {
			this.adj[v] = new Queue<Edge>();
		}
	}
	
	public void addEdge(Edge e){
		int v = e.either();
		int w = e.other(v);
		this.adj[v].enqueue(e);
		this.adj[w].enqueue(e);
	}
	
	public Iterable<Edge> adj(int v){
		return this.adj[v];
	}
	
}
