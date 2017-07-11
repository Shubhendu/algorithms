package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.List;

public class WordSerach2 {
	private Trie trie;
	private static final int R = 26;

	private class TrieNode {
		private TrieNode[] children;
		private boolean isLastChar;

		public TrieNode() {
			this.children = new TrieNode[R];
		}
	}

	private class Trie {

		private TrieNode root;

		public void put(String str) {
			this.root = put(this.root, str, 0);
		}

		private int getIndexForChar(char c) {
			return c - 'a';
		}

		public TrieNode put(TrieNode node, String str, int pos) {
			if (node == null) {
				node = new TrieNode();
			}
			if (pos == str.length()) {
				node.isLastChar = true;
				return node;
			}
			char c = str.charAt(pos);
			int i = getIndexForChar(c);
			node.children[i] = put(node.children[i], str, pos + 1);
			return node;
		}

		private TrieNode getByPrefix(String prefix) {
			return get(root, prefix, 0);
		}

		private TrieNode get(TrieNode node, String str, int pos) {
			if (node == null) {
				return null;
			}

			if (pos == str.length()) {
				return node;
			}
			char c = str.charAt(pos);
			int i = getIndexForChar(c);
			if (node.children[i] == null) {
				return null;
			}
			return get(node.children[i], str, pos + 1);
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<String>();
		if (words == null || words.length == 0 || board == null || board.length == 0) {
			return result;
		}
		this.trie = new Trie();
		for (String word : words) {
			trie.put(word);
		}
		
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				StringBuilder sb = new StringBuilder();
				dfs(board, r, c, result, sb);
			}
		}
		return result;
	}

	private void dfs(char[][] board, int r, int c, List<String> result, StringBuilder sb) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#') {
			return;
		}

		sb.append(board[r][c]);

		char currChar = board[r][c];
		board[r][c] = '#';

		TrieNode trieNode = trie.getByPrefix(sb.toString());
		if (trieNode == null) {
			board[r][c] = currChar;
			return;
		}

		if (trieNode.isLastChar) {
			trieNode.isLastChar = false;
			result.add(sb.toString());
		}

		if (c > 0 && board[r][c - 1] != '#') {
			// left
			dfs(board, r, c - 1, result, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (c < board[0].length - 1 && board[r][c + 1] != '#') {
			// right
			dfs(board, r, c + 1, result, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (r > 0 && board[r - 1][c] != '#') {
			// top
			dfs(board, r - 1, c, result, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (r < board.length - 1 && board[r + 1][c] != '#') {
			// bottom
			dfs(board, r + 1, c, result, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		
		
		board[r][c] = currChar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "oath", "pea", "eat", "rain" };

		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

//		board = new char[][] { { 'a', 'b' }, { 'c', 'd' } };
//		words = new String[] { "abcd" };
		WordSerach2 w2 = new WordSerach2();
		List<String> result = w2.findWords(board, words);
		for (String w : result) {
			System.out.println(w);
		}

	}

}
