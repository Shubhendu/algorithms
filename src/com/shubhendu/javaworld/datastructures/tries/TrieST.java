package com.shubhendu.javaworld.datastructures.tries;

import com.shubhendu.javaworld.datastructures.queue.Queue;

/**
- * @author ssingh R-way Trie
- *
- */

public class TrieST<Value> {
	// supports unicode hence R = 256.
	// ASCII A = 65, Z= 90, a= 97, z = 122

	private static final int R = 256;
	private TrieNode root;

	static class TrieNode {
		Object value;
		TrieNode[] next = new TrieNode[R];
	}

	public void put(String key, Value v) {
		root = put(root, key, v, 0);
	}

	private TrieNode put(TrieNode node, String key, Value v, int pos) {
		if (node == null)
			node = new TrieNode();
		if (pos == key.length()) {
			node.value = v;
			return node;
		}
		char c = key.charAt(pos);
		node.next[c] = put(node.next[c], key, v, pos + 1);
		return node;
	}

	public Value get(String key) {
		if (root == null)
			return null;
		TrieNode node = get(root, key, 0);
		if (node != null)
			return (Value) node.value;
		return null;
	}

	private TrieNode get(TrieNode node, String key, int pos) {
		if (node == null)
			return null;
		if (pos == key.length())
			return node;
		char c = key.charAt(pos);
		return get(node.next[c], key, pos + 1);
	}
	
	public Iterable<String> iterator(){
		Queue<String> q = new Queue<String>();
		collect(root, "", q);
		return q;
	}
	
	private void collect(TrieNode node, String prefix, Queue<String> q) {
		if (node == null)
			return;
		if (node.value != null)
			q.enqueue(prefix);
		for (char c = 0; c < R; c++) {
			collect(node.next[c], prefix + c, q);
		}
	}

	public static void main(String[] args) {
		TrieST<Integer> trie = new TrieST<Integer>();

		trie.put("shell", 5);
		trie.put("shells", 10);
		trie.put("shellweb", 10);
		trie.put("boy", 50);
		trie.put("she", 51);
		System.out.println(trie.get("shells"));
		System.out.println(trie.get("boys"));
		System.out.println(trie.get("she"));

	}

}
