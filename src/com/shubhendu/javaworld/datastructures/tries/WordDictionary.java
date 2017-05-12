/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tries;

import java.util.HashSet;

/**
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word) 
 * 
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") 
 * addWord("dad") 
 * addWord("mad") 
 * search("pad") -> false
 * search("bad") -> true 
 * search(".ad") -> true 
 * search("b..") -> true 
 * Note: You may assume that all words are consist of lowercase letters a-z.
 *
 */
public class WordDictionary {
	private Trie trie;
	private HashSet<String> dataSet;

	private class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		private class TrieNode {
			boolean isLastChar;
			TrieNode[] childrens;

			public TrieNode() {
				childrens = new TrieNode[26];
			}
		}

		public void put(String word) {
			root = put(root, word, 0);
		}

		private int getIndexFromChar(char c) {
			return c - 'a';
		}

		private char getCharFromIndex(int idx) {
			return (char) (97 + idx);
		}

		private TrieNode put(TrieNode node, String word, int index) {
			if (node == null) {
				node = new TrieNode();
			}

			if (index == word.length()) {
				node.isLastChar = true;
				return node;
			}
			int charIndex = getIndexFromChar(word.charAt(index));
			node.childrens[charIndex] = put(node.childrens[charIndex], word, index + 1);

			return node;
		}

		public boolean search(String word) {
			return searchRec(root, "", 0, word);

		}

		private boolean searchRec(TrieNode node, String prefix, int prefixLength, String word) {
			if (node == null || prefix.length() > word.length()) {
				return false;
			}

			if (node.isLastChar) {
				if (matchWord(word, prefix)) {
					return true;
				}
			}

			if (prefixLength > 0) {
				if (!matchWord(word.substring(0, prefixLength), prefix)) {
					return false;
				}
			}

			if (prefix.length() == word.length()) {
				return false;
			}

			for (int i = 0; i < 26; i++) {
				if (searchRec(node.childrens[i], prefix + getCharFromIndex(i), prefixLength + 1, word)) {
					return true;
				}
			}
			return false;
		}

	}

	/** Initialize your data structure here. */
	public WordDictionary() {
		this.dataSet = new HashSet<String>();
		this.trie = new Trie();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		this.trie.put(word);
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		if (word == null)
			return false;

		if (this.dataSet.contains(word)) {
			return true;
		}

		return this.trie.search(word);
	}

	private boolean matchWord(String wordToMatch, String wordFromDict) {
		if (wordToMatch.length() != wordFromDict.length())
			return false;

		for (int i = 0; i < wordToMatch.length(); i++) {
			if (wordToMatch.charAt(i) != '.' && wordToMatch.charAt(i) != wordFromDict.charAt(i)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();
		obj.addWord("a");
		obj.addWord("ab");
		obj.addWord("aaaaa");

		 System.out.println(obj.search("a"));
		 System.out.println(obj.search("a."));
		 System.out.println(obj.search("ab"));
		 System.out.println(obj.search(".a"));
		 System.out.println(obj.search(".b"));
		 System.out.println(obj.search("ab."));
		 System.out.println(obj.search("."));
		 System.out.println(obj.search(".."));
		System.out.println(obj.search("aaaaa"));
		System.out.println(obj.search("aaaaab"));

	}
}
