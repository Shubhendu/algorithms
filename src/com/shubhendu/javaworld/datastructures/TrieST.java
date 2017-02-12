/**
 * 
 */
package com.shubhendu.javaworld.datastructures;

/**
 * @author ssingh R-way Trie
 *
 */

public class TrieST<Value> {
	// supports unicode hence R = 256.
	// ASCII A = 65, Z= 90, a= 97, z = 122
	private static final int R = 256;
	private Node root;

	private static class Node {
		Object value;
		Node[] next = new Node[R];
	}

	public void put(String key, Value v) {
		root = put(root, key, v, 0);
	}

	private Node put(Node x, String key, Value v, int pos) {
		if (x == null)
			x = new Node();
		if (pos == key.length() - 1) {
			x.value = v;
			return x;
		}
		char c = key.charAt(pos);
		x.next[c] = put(x.next[c], key, v, pos + 1);
		return x;
	}

	public Value get(String key) {
		if (key == null)
			return null;
		return get(root, key, 0);
	}

	@SuppressWarnings("unchecked")
	private Value get(Node x, String key, int pos) {
		if (x == null)
			return null;
		if (pos == key.length() - 1) {
			return x.value != null ? (Value) x.value : null;
		}
		char c = key.charAt(pos);
		return get(x.next[c], key, pos + 1);

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
