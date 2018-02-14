package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
	private static final int N = 26;
	private int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	class TrieNode {
		private boolean isWord;
		private TrieNode[] childrens;

		public TrieNode() {
			this.childrens = new TrieNode[N];
			this.isWord = false;
		}
	}

	class Trie {
		private TrieNode root;

		public void add(String word) {
			this.root = add(root, word, 0);
		}

		private TrieNode add(TrieNode node, String word, int idx) {
			if (node == null) {
				node = new TrieNode();
			}
			if (idx == word.length()) {
				node.isWord = true;
				return node;
			}
			char c = word.charAt(idx);
			node.childrens[c - 'a'] = add(node.childrens[c - 'a'], word, idx + 1);
			return node;
		}

		public boolean hasWordsWithPrefix(String prefix) {
			TrieNode node = get(root, prefix, 0);
			if (node == null) {
				return false;
			}
			return true;
		}

		public TrieNode get(TrieNode node, String prefix, int idx) {
			if (node == null) {
				return node;
			}
			if (idx == prefix.length()) {
				return node;
			}
			char c = prefix.charAt(idx);
			return get(node.childrens[c - 'a'], prefix, idx + 1);
		}
	}

	private Trie trie;

	public List<String> findWords(char[][] board, String[] words) {
		trie = new Trie();
		for (String w : words) {
			trie.add(w);
		}
		List<String> result = new ArrayList<String>();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				dfs(board, r, c, trie.root, result, "" + board[r][c], new HashSet<String>());
			}
		}

		return result;
	}

	public void dfs(char[][] board, int r, int c, TrieNode node, List<String> result, String prefix,
			Set<String> visited) {
		if (visited.contains(prefix)) {
			return;
		}
		visited.add(prefix);
		TrieNode childNode = trie.get(node, prefix, prefix.length() - 1);
		if (childNode == null) {
			return;
		}
		if (childNode.isWord) {
			result.add(prefix);
		}

		for (int[] dir : dirs) {
			int x = r + dir[0];
			int y = c + dir[1];
			if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
				continue;
			}
			dfs(board, x, y, childNode, result, prefix + board[x][y], visited);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'a', 'h', 'k', 'r' },
				{ 'e', 'p', 'l', 'v' } };

		String[] words = new String[] { "oath", "pea", "eat", "rain" };
		WordSearch2 search = new WordSearch2();
		List<String> results = search.findWords(board, words);
		System.out.println(results);

	}

}
