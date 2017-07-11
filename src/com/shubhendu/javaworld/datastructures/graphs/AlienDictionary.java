/**
 * 
 */
package com.shubhendu.javaworld.datastructures.graphs;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/alien-dictionary/#/description
 *
 */
public class AlienDictionary {
	private String[] words;

	private class Graph {
		private int V;
		private Set<Character>[] adj;
		private boolean[] hasEdge;
		private Set<Character> charSet;

		public Graph(Set<Character> charSet) {
			this.V = 26;
			this.charSet = new HashSet<Character>(charSet);
			this.adj = new LinkedHashSet[this.V];
			hasEdge = new boolean[V];
			for (int i = 0; i < this.V; i++) {
				this.adj[i] = new LinkedHashSet<Character>();
			}
		}

		public void addEdge(Character u, Character v) {
			hasEdge[v - 'a'] = true;
			hasEdge[u - 'a'] = true;
			if (u.equals(v)) {
				return;
			}
			this.adj[u - 'a'].add(v);
		}
	}

	private class DFSTraversal {
		private Graph G;
		private boolean[] inCallStack;
		private boolean[] visited;
		private Stack<Character> stack;

		public DFSTraversal(Graph G) {
			this.G = G;
			this.inCallStack = new boolean[G.V];
			this.visited = new boolean[G.V];
			this.stack = new Stack<Character>();
		}

		private boolean hasCycle() {
			for (char c : G.charSet) {
				int index = c - 'a';
				if (G.hasEdge[index] && !visited[index] && hasCycle(index)) {
					return true;
				}
			}
			return false;
		}

		private boolean hasCycle(int v) {
			visited[v] = true;
			inCallStack[v] = true;
			for (char c : G.adj[v]) {
				if (inCallStack[c - 'a']) {
					return true;
				}
				int index = c - 'a';
				if (!visited[index] && hasCycle(index)) {
					return true;
				}
			}
			this.stack.push((char) (97 + v));
			inCallStack[v] = false;
			return false;
		}
	}

	private Set<Character> buildCharSet() {
		Set<Character> charSet = new HashSet<Character>();

		for (int i = 0; i < words.length; i++) {
			for (char c : words[i].toCharArray()) {
				charSet.add(c);
			}
		}
		return charSet;
	}

	private Graph buildGraph(Set<Character> charSet) {
		Graph g = new Graph(charSet);
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				int idx = 0;
				while (idx < words[i].length() && idx < words[j].length()) {
					if (words[i].charAt(idx) != words[j].charAt(idx)) {
						charSet.remove(words[i].charAt(idx));
						charSet.remove(words[j].charAt(idx));
						g.addEdge(words[i].charAt(idx), words[j].charAt(idx));
						break;
					}
					idx++;
				}
			}
		}
		return g;
	}

	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}

		this.words = words;
		Set<Character> charSet = buildCharSet();
		Graph g = buildGraph(charSet);
		DFSTraversal dfs = new DFSTraversal(g);
		if (dfs.hasCycle()) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			while (!dfs.stack.isEmpty()) {
				sb.append(dfs.stack.pop());
			}
			for (char c : charSet) {
				sb.append(c);
			}
			return sb.toString();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[] { "wrt", "wrf", "er", "ett", "rftt" };
		String[] strs1 = new String[] { "z", "x" };
		String[] strs2 = new String[] { "z", "x", "z" };
		AlienDictionary a = new AlienDictionary();
		String response = a.alienOrder(strs);
		System.out.println(strs + " : " + response);
		response = a.alienOrder(strs1);
		System.out.println(strs1 + " : " + response);
		response = a.alienOrder(strs2);
		System.out.println(strs2 + " : " + response);

		String[] strs3 = new String[] { "z", "z" };
		response = a.alienOrder(strs3);
		System.out.println(strs3 + " : " + response);

		String[] str4 = new String[] { "wrt", "wrf", "er", "ett", "rftt", "te" };
		response = a.alienOrder(str4);
		System.out.println(str4 + " : " + response);

		String[] str5 = new String[] { "wrt", "wbc" };
		response = a.alienOrder(str5);
		System.out.println(str5 + " : " + response);

	}

}
