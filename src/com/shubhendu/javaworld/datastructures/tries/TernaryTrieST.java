/**
 * 
 */
package com.shubhendu.javaworld.datastructures.tries;

/**
 * @author ssingh
 * Space efficient Trie implementation.
 */
public class TernaryTrieST<Value> {
	private Node root;

	private class Node {
		Value val;
		char c;
		Node left, middle, right;
	}

	public void put(String key, Value v) {
		root = put(root, key, v, 0);
	}

	private Node put(Node x, String key, Value v, int pos) {
		char c = key.charAt(pos);

		if (x == null) {
			x = new Node();
			x.c = c;
		}

		if (c < x.c)
			x.left = put(x.left, key, v, pos);
		else if (c > x.c)
			x.right = put(x.right, key, v, pos);
		else if (pos < key.length() - 1)
			x.middle = put(x.middle, key, v, pos + 1);
		else
			x.val = v;
		return x;
	}

	public Value get(String key) {
		Node node = get(root, key, 0);
		if (node != null)
			return (Value) node.val;
		return null;
	}

	private Node get(Node x, String key, int pos) {
		if (x == null)
			return null;

		char c = key.charAt(pos);

		if (c < x.c)
			return get(x.left, key, pos);
		else if (c > x.c)
			return get(x.right, key, pos);
		else if (pos < key.length() - 1)
			return get(x.middle, key, pos + 1);

		return x;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TernaryTrieST<Integer> ternaryTrie = new TernaryTrieST<Integer>();
		ternaryTrie.put("tvis", 1);
		ternaryTrie.put("shubh", 11);
		ternaryTrie.put("shubhash", 111);
		ternaryTrie.put("shell", 1111);
		ternaryTrie.put("she", 112);

		System.out.println(ternaryTrie.get("she"));
		System.out.println(ternaryTrie.get("shell"));
		System.out.println(ternaryTrie.get("shells"));
		System.out.println(ternaryTrie.get("tvis"));

	}

}
