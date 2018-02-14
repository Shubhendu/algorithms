package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Itinerary {
	private static final String SOURCE = "JFK";

	class Graph {
		List<String> nodes;
		Map<String, PriorityQueue<String>> edgeMap;

		public Graph() {
			this.edgeMap = new HashMap<String, PriorityQueue<String>>();
		}

		public void addEdge(String s, String t) {
			PriorityQueue<String> sEdges = this.edgeMap.getOrDefault(s, new PriorityQueue<String>());
			sEdges.add(t);
			this.edgeMap.put(s, sEdges);
		}
	}

	class DFSTraversal {
		private Graph graph;
		private List<String> paths;
		private Set<String> visited;

		public DFSTraversal(Graph graph) {
			this.graph = graph;
			this.visited = new HashSet<String>();
			this.paths = new LinkedList<String>();
		}

		public void dfs(String source) {
			paths.add(source);

			for (String node : this.graph.edgeMap.get(source)) {
				// String path = source + "->" + node;
				// if (!this.visited.contains(path)) {
				// this.visited.add(path);
				if (this.graph.edgeMap.containsKey(node) && !this.graph.edgeMap.get(node).isEmpty()) {
					dfs(node);
				}
				// }
			}
		}

	}

	public List<String> findItinerary(String[][] tickets) {
		Graph graph = new Graph();
		List<String> itinerary = new ArrayList<String>();
		boolean validGraph = false;

		for (int i = 0; i < tickets.length; i++) {
			if (SOURCE.equals(tickets[i][0])) {
				validGraph = true;
			}
			graph.addEdge(tickets[i][0], tickets[i][1]);
		}
		if (!validGraph) {
			return itinerary;
		}

		DFSTraversal dfsTraversal = new DFSTraversal(graph);
		dfsTraversal.dfs(SOURCE);
		return dfsTraversal.paths;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] edges = new String[][] { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		// { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR",
		// "SFO" } };
		Itinerary i = new Itinerary();
		List<String> itinerary = i.findItinerary(edges);
		System.out.println(itinerary);

	}

}
