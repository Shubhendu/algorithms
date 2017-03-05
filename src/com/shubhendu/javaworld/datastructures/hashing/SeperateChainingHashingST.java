/**
 * 
 */
package com.shubhendu.javaworld.datastructures.hashing;

/**
 * @author ssingh
 *
 */
public class SeperateChainingHashingST<Key, Value> {
	private static final int M = 97;
	private Node[] st;

	static class Node {
		Object key;
		Object value;
		Node next;

		Node(Object k, Object v, Node next) {
			this.key = k;
			this.value = v;
			this.next = next;
		}
	}

	public int hash(Key key) {
		return key.hashCode() % M;
	}

	public Value get(Key k) {
		int i = hash(k);
		for (Node node = st[i]; node != null; node = node.next) {
			if (node.key.equals(k))
				return (Value) node.value;
		}
		return null;
	}

	public void put(Key k, Value v) {
		int i = hash(k);
		for (Node node = st[i]; node != null; node = node.next) {
			if (node.key.equals(k)) {
				node.value = v;
				return;
			}
		}
		st[i] = new Node(k, v, st[i]);
	}
}
