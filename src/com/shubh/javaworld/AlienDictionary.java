package com.shubh.javaworld;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {

	class Graph {
		Map<Character, HashSet<Character>> edges;

		public Graph() {
			this.edges = new HashMap<Character, HashSet<Character>>();
		}

		public void addVertex(Character u) {
			if (this.edges.containsKey(u)) {
				return;
			}
			this.edges.put(u, new HashSet<Character>());
		}

		public void addEdge(Character u, Character v) {
			if (u.equals(v)){
				return;
			}
			HashSet<Character> adjs = this.edges.get(u);
			adjs.add(v);
			this.edges.put(u, adjs);
		}
	}

	public String alienOrder(String[] words) {
		int[] inComingEdgesCount = new int[26];
		Graph graph = buildGraph(words, inComingEdgesCount);

		Queue<Character> q = new LinkedList<>();

		for (char c : graph.edges.keySet()) {
			if (inComingEdgesCount[c - 'a'] == 0) {
				q.add(c);
			}
		}
		StringBuilder sb = new StringBuilder();

		while (!q.isEmpty()) {
			Character c = q.poll();
			sb.append(c);
			if (!graph.edges.containsKey(c)) {
				continue;
			}
			Iterator<Character> iter = graph.edges.get(c).iterator();
			while (iter.hasNext()) {
				char u = iter.next();
				iter.remove();
				inComingEdgesCount[u - 'a']--;
				if (inComingEdgesCount[u - 'a'] == 0) {
					q.add(u);
				}
			}
		}

		for (int i = 0; i < inComingEdgesCount.length; i++) {
			if (inComingEdgesCount[i] > 0) {
				return "";
			}
		}
		return sb.toString();
	}

	private void fillVertex(Graph g, String[] words) {
		for (int i = 0; i < words.length; i++) {
			for (char c : words[i].toCharArray()) {
				g.addVertex(c);
			}
		}
	}

	private Graph buildGraph(String[] words, int[] inComingEdgesCount) {
		Graph g = new Graph();
		fillVertex(g, words);

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			int idx = 0;
			while (idx < word1.length() && idx < word2.length()) {
				char c1 = word1.charAt(idx);
				char c2 = word2.charAt(idx);
				idx++;
				if (c1 != c2) {
					if (g.edges.containsKey(c1) && g.edges.get(c1).contains(c2)) {
						break;
					}
					inComingEdgesCount[c2 - 'a']++;
					g.addEdge(c1, c2);
					break;
				}
			}
		}
		return g;
	}

	public static void main(String[] args) {
		String[] words = new String[] { "wrt", "wrf", "er", "ett", "rftt" };
		AlienDictionary a = new AlienDictionary();
		String w = a.alienOrder(words);
		System.out.println(w);
		Deque<Integer> q = new ArrayDeque<>();
		Queue<Integer> q1 = new LinkedList<>();
		System.out.println(q.isEmpty());
		
		Deque<Integer> d = new ArrayDeque<>();
		d.addLast(2);
		d.addLast(3);
		d.addLast(4);
		d.addLast(5);
		System.out.println(d.peek());
		System.out.println(d.peekLast());
		System.out.println(d.peekFirst());

	}

}
