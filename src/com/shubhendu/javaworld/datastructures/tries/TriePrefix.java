package com.shubhendu.javaworld.datastructures.tries;

public class TriePrefix {
	private TrieNode root;
	private static final int R = 26;

	private class TrieNode {
		TrieNode[] childrens;
		boolean isLastCharInWord;
		int count;

		public TrieNode() {
			this.childrens = new TrieNode[R];
		}
	}

	private int getCharIndex(char c) {
		return c - 'a';
	}

	public void add(String name) {
		if (name == null)
			return;
		root = put(root, name, 0);
	}

	public int find(String partial) {
		TrieNode partialNode = get(root, partial, 0);
		if (partialNode == null)
			return 0;

		return partialNode.count;

	}

	private TrieNode put(TrieNode node, String str, int pos) {
		if (node == null)
			node = new TrieNode();

		if (pos == str.length()) {
			node.isLastCharInWord = true;
			node.count = node.count + 1;
			return node;
		}

		char c = str.charAt(pos);
		TrieNode childNode = put(node.childrens[getCharIndex(c)], str, pos + 1);
		node.childrens[getCharIndex(c)] = childNode;
		node.count = node.count + 1;

		return node;
	}

	public boolean get(String str) {
		TrieNode x = get(root, str, 0);
		if (x == null)
			return false;

		return x.isLastCharInWord;
	}

	private TrieNode get(TrieNode x, String str, int pos) {
		if (x == null)
			return null;

		if (pos == str.length())
			return x;

		char c = str.charAt(pos);
		return get(x.childrens[getCharIndex(c)], str, pos + 1);

	}

	public static void main(String[] args) {
		TriePrefix trie = new TriePrefix();
		trie.add("cars"); 
		trie.add("car");
		trie.add("cab");
		trie.add("bartender");
		 trie.add("bar");
		 trie.add("bars");
		 trie.add("baring");
		 trie.add("batsmen");
		
		 System.out.println("cars: " + trie.find("cars"));
		 System.out.println("ca: " + trie.find("ca"));
		 System.out.println("c: " + trie.find("c"));
		 System.out.println("b: " + trie.find("b"));
		 System.out.println("bar: " + trie.find("bar"));

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		for (int i = 0; i < n; i++) {
//			String op = sc.next();
//			String word = sc.next();
//			if (op.equals("add")) {
//				trie.add(word);
//			} else {
//				System.out.println(trie.find(word));
//			}
//		}
//		sc.close();
	}

}
