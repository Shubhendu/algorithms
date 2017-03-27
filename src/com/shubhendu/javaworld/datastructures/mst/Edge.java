/**
 * 
 */
package com.shubhendu.javaworld.datastructures.mst;

/**
 * @author ssingh
 *
 */
public class Edge implements Comparable<Edge> {

	private int v;
	private int w;
	private double weight;

	public int either() {
		return this.v;
	}

	public int other(int that) {
		if (that == v)
			return w;
		else
			return v;
	}
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge that) {
		// TODO Auto-generated method stub
		if (this.weight < that.weight)
			return -1;
		else if (this.weight > that.weight)
			return 1;
		else 
			return 0;
	}

}
