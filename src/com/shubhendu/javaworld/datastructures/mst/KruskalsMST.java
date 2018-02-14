/**
 * 
 */
package com.shubhendu.javaworld.datastructures.mst;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.shubhendu.javaworld.datastructures.unionFind.UnionFind;

/**
 * @author ssingh
 *
 */
public class KruskalsMST {

	private Queue<Edge> mst;

	public KruskalsMST(EdgeWeightedGraph G) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((Comparator<Edge>)((a, b) -> (int) (a.getWeight() - b.getWeight())));
		UnionFind uf = new UnionFind(G.numberOfVertices());
		this.mst = new LinkedList<Edge>();

		for (Edge e : G.edges()) {
			pq.add(e);
		}

		while (!pq.isEmpty() && this.mst.size() < G.numberOfVertices() - 1) {
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if (!uf.connected(v, w)) {
				uf.union(v, w);
				mst.add(e);
			}

		}

	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public Double weight() {
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
