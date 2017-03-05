/**
 * 
 */
package com.shubhendu.javaworld.datastructures.graphs.weighted;

/**
 * @author ssingh
 *
 */
public class Edge implements Comparable<Edge> {
	private int v;
	private int w;
	private double weight;

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int either() {
		return this.v;
	}

	public int other(int vertex) {
		return vertex == v ? w : v;
	}
	
	

	public int compareTo(Edge that) {
		if (this.weight < that.weight)
			return -1;
		else if (this.weight > that.weight)
			return 1;
		else
			return 0;
	}

}
