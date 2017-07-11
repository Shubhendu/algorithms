package com.shubhendu.javaworld.datastructures.graphs;

import com.shubhendu.javaworld.datastructures.graphs.weighted.EdgeWeightedGraph;
import com.shubhendu.javaworld.datastructures.heap.IndexMinPQ;

/*
 * Provides shortest path from source to all the other vertices.
 * Does not work with Graph having edges with negative weight.
 * Greedy Algorithm
 * Space Complexity V 
 * Time complexity O(ElogV)
 *  
 */
public class DijkstraShortestPath {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	public DijkstraShortestPath(EdgeWeightedGraph G, int s) {
		this.edgeTo = new DirectedEdge[G.getV()];
		this.distTo = new double[G.getV()];
		this.pq = new IndexMinPQ<>(G.getV());
		for (int v = 0; v < G.getV(); v++) {
			this.distTo[v] = Double.POSITIVE_INFINITY;
		}
		this.distTo[s] = 0;
		pq.insert(s, 0.0);
		while (!pq.isEmpty()) {
			relax(G, pq.delMin());
		}
	}

	private void relax(EdgeWeightedGraph G, int v) {
		for (DirectedEdge e : G.getAdj()[v]) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (pq.contains(w)) {
					pq.changeKey(w, distTo[w]);
				} else {
					pq.insert(w, distTo[w]);
				}

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
