package com.shubhendu.javaworld.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Provides shortest path from source to all the other vertices.
 * Does not work with Graph having edges with negative weight.
 * Greedy Algorithm
 * Space Complexity V 
 * Time complexity O(ElogV)
 *  
 */

public class DijkstraShortestPath {

	static class Graph {
		boolean isDirected;
		Set<String> vertices;
		Set<Edge> edges;
		Map<String, ArrayList<Edge>> adjacencyList;

		public Graph(boolean isDirected) {
			this.isDirected = isDirected;
			this.vertices = new HashSet<String>();
			this.edges = new HashSet<Edge>();
			this.adjacencyList = new HashMap<String, ArrayList<Edge>>();
		}

		public void addVertices(String v) {
			this.vertices.add(v);
			this.adjacencyList.put(v, new ArrayList<Edge>());

		}

		public void addEdge(String from, String to, double weight) {
			Edge edge = new Edge(from, to, weight);
			ArrayList<Edge> currentEdges = this.adjacencyList.get(from);
			currentEdges.add(edge);
			this.adjacencyList.put(from, currentEdges);
		}
	}

	static class Edge {
		String from;
		String to;
		double weight;

		public Edge(String f, String t, double weight) {
			this.from = f;
			this.to = t;
			this.weight = weight;
		}

	}

	static class Node implements Comparable<Node> {
		String vertex;
		double cost;
		
		public Node (String name, double c) {
			this.vertex = name;
			this.cost = c;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return (int) (this.cost - o.cost);
		}
	}

	private Map<String, Double> distance;
	private Map<String, String> parent;
	private PriorityQueue<Node> pq;

	public DijkstraShortestPath(Graph G, String source) {
		this.parent = new HashMap<>();
		this.distance = new HashMap<>();
		this.pq = new PriorityQueue<Node>();

		for (String vertex : G.vertices) {
			this.distance.put(vertex, Double.POSITIVE_INFINITY);
		}
		this.distance.put(source, 0.0);
		this.parent.put(source, null);
		pq.add(new Node(source, 0.0));

		while (!pq.isEmpty()) {
			relax(G, pq.poll());
		}
	}

	private void relax(Graph G, Node node) {
		String fromVertex = node.vertex;
		for (Edge edge : G.adjacencyList.get(fromVertex)) {
			String toVertex = edge.to;
			double reducedDistance = this.distance.get(fromVertex) + edge.weight;
			if (this.distance.get(toVertex) > reducedDistance) {
				this.distance.put(toVertex, reducedDistance);
				this.parent.put(toVertex, fromVertex);

				if (pq.contains(node)) {
					pq.remove(node);
				}
				pq.add(new Node(toVertex, reducedDistance));

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph = new Graph(true);
		graph.addVertices("A");
		graph.addVertices("B");
		graph.addVertices("C");
		graph.addVertices("D");
		graph.addVertices("E");
		graph.addVertices("F");

		graph.addEdge("A", "B", 5.0);
		graph.addEdge("B", "C", 2.0);
		graph.addEdge("A", "D", 9.0);
		graph.addEdge("A", "E", 3.0);
		graph.addEdge("E", "F", 2.0);
		graph.addEdge("F", "D", 2.0);
		graph.addEdge("C", "D", 2.0);

		DijkstraShortestPath dsp = new DijkstraShortestPath(graph, "A");
		for (String v : graph.vertices) {
			System.out.println(dsp.parent.get(v) + " - >" + v + " : " + dsp.distance.get(v));
		}
	}

}
