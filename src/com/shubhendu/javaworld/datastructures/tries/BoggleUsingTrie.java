/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tries;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. 
 * Find all possible words that can be formed by a sequence of adjacent characters. 
 * Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
 *
 */
public class BoggleUsingTrie {
	private Trie trie = null;

	public BoggleUsingTrie(Set<String> dictionary) {
		trie = new Trie();
		Iterator<String> iterator =  dictionary.iterator();
		while(iterator.hasNext()){
			trie.put(iterator.next());;
		}
	}

	private class Trie {
		private Node root;
		private static final int NUM_OF_CHARACTERS = 26;

		private class Node {
			boolean isLastChar;
			Node[] children;

			public Node() {
				this.children = new Node[NUM_OF_CHARACTERS];
			}
		}

		public void put(String s) {
			root = put(root, s, 0);
		}
		
		private int getCharacterIndex(char c){
			return c - 'a';
		}

		private Node put(Node x, String s, int pos) {
			if (x == null)
				x = new Node();
			
			if (pos == s.length()) {
				x.isLastChar = true;
				return x;
			}
			
			char c = s.charAt(pos);
			int charIndex = getCharacterIndex(c);
			
			x.children[charIndex] = put(x.children[charIndex], s, pos + 1);

			return x;
		}

		public boolean search(String s) {
			Node x = search(root, s, 0);
			if (x != null)
				return x.isLastChar;
			return false;
		}

		private Node search(Node x, String s, int pos) {
			if (x == null)
				return null;
			if (pos == s.length())
				return x;
			char c = s.charAt(pos);
			int charIndex = getCharacterIndex(c);
			return search(x.children[charIndex], s, pos + 1);
		}

	}

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("geek");
		dictionary.add("geeks");
		dictionary.add("quiz");
		dictionary.add("for");
		dictionary.add("go");
		BoggleUsingTrie trie = new BoggleUsingTrie(dictionary);

		char[][] boggle = new char[][] { { 'g', 'i', 'z' }, { 'u', 'e', 'k' }, { 'q', 's', 'e' } };
	}

}
