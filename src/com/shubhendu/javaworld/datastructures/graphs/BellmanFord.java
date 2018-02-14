package com.shubhendu.javaworld.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.shubhendu.javaworld.datastructures.graphs.DijkstraShortestPath.Edge;

public class BellmanFord {
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
			this.edges.add(edge);
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

	private Map<String, Double> distance;
	private Map<String, String> parent;

	public BellmanFord(Graph g, String source) {
		distance = new HashMap<>();
		parent = new HashMap<>();

		for (String v : g.vertices) {
			distance.put(v, Double.POSITIVE_INFINITY);
			parent.put(v, null);
		}

		distance.put(source, 0.0);
		relaxEdges(g);
	}

	private void relaxEdges(Graph g) {
		for (int i = 0; i < g.vertices.size() - 1; i++) {
			for (Edge e : g.edges) {
				String from = e.from;
				String to = e.to;
				double newDistance = distance.get(from) + e.weight;
				if (distance.get(to) > newDistance) {
					distance.put(to, newDistance);
					parent.put(to, from);
				}

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
