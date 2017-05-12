/**
 * 
 */
package com.shubhendu.javaworld.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ssingh
 *
 */
public class Graph {

	private int V;
	private int E;
	private Queue<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.V = v;
		this.adj = (LinkedList<Integer>[]) new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adj[i] = new LinkedList<Integer>();
		}
	}
	
	public int getNumberOfVertices() {
		return V;
	}

	public int getNumberOfEdges() {
		return E;
	}

	public void setEdges(int e) {
		E = e;
	}

	public void addEdge(int v, int w) {
		this.adj[v].add(w);
		this.adj[w].add(v);
		this.setEdges(this.getNumberOfEdges() + 1);
	}

	public Queue<Integer>[] getAdj() {
		return adj;
	}
	
	public static int degree(Graph G, int v) {
		return (v < G.adj.length) ? G.adj[v].size() : 0;
	}

	public static int maxDegree(Graph G) {
		int maxDegree = 0;
		for (int i = 0; i < G.V; i++) {
			int degree = degree(G, i);
			if (degree > maxDegree) {
				maxDegree = degree;
			}
		}
		return maxDegree;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
