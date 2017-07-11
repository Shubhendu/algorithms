package com.shubhendu.javaworld;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private class DLL {
		private int key;
		private int val;
		private DLL prev;
		private DLL next;

		public DLL(int k, int v) {
			this.key = k;
			this.val = v;
			this.prev = null;
			this.next = null;
		}
	}

	private int maxSize;
	private Map<Integer, DLL> cache;
	private DLL head;
	private DLL tail;

	public LRUCache(int capacity) {
		this.cache = new HashMap<Integer, DLL>();
		this.maxSize = capacity;
	}

	public int get(int key) {
		if (!this.cache.containsKey(key)) {
			return -1;
		}
		DLL node = this.cache.get(key);
		if (node != this.head) {
			deleteNode(node);
			addNodeInFront(node);
		}
		return node.val;
	}

	private void deleteNode(DLL node) {
		if (node == null) {
			return;
		}

		DLL p = node.prev;
		DLL n = node.next;
		if (p != null)
			p.next = n;
		if (n != null)
			n.prev = p;
		if (node == this.tail) {
			this.tail = n;
		}
		if (node == this.head) {
			this.head = p;
		}

	}

	private void addNodeInFront(DLL node) {
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.prev = this.head;
			node.next = null;
			this.head.next = node;
			this.head = node;
		}
	}

	private void removeKey(int key) {
		if (!this.cache.containsKey(key)) {
			return;
		}
		DLL node = this.cache.get(key);
		deleteNode(node);
		this.cache.remove(key);
	}

	public void put(int key, int value) {
		if (this.maxSize < 1) {
			return;
		}
		removeKey(key);

		if (this.cache.size() >= this.maxSize) {
			removeKey(this.tail.key);
		}
		DLL node = new DLL(key, value);
		addNodeInFront(node);
		this.cache.put(key, node);
	}

	public static void main(String[] args) {
		int capacity = 2;
		LRUCache obj = new LRUCache(capacity);
		// System.out.println("get 2: " + obj.get(2));
		obj.put(2, 1);
		// System.out.println("get 1: " + obj.get(1));
		obj.put(2, 2);
		// obj.put(1, 2);
		System.out.println("get 2: " + obj.get(2));
		// System.out.println("get 2: " + obj.get(2));
		obj.put(1, 1);
		// System.out.println("get 2: " + obj.get(2));
		// System.out.println("get 3: " + obj.get(3));
		// System.out.println("get 4: " + obj.get(4));
		obj.put(4, 1);
		System.out.println("get 2: " + obj.get(2));

		// int capacity = 0;
		// LRUCache obj = new LRUCache(capacity);
		// System.out.println("get 2: " + obj.get(2));
		// obj.put(2, 6);
		// System.out.println("get 1: " + obj.get(1));
		// obj.put(1, 5);
		// obj.put(1, 2);
		// System.out.println("get 1: " + obj.get(1));
		// System.out.println("get 2: " + obj.get(2));

		// int capacity = 1;
		// LRUCache obj = new LRUCache(capacity);
		// System.out.println("get 2: " + obj.get(2));
		// obj.put(2, 6);
		// System.out.println("get 1: " + obj.get(1));
		// obj.put(1, 5);
		// obj.put(1, 2);
		// System.out.println("get 1: " + obj.get(1));
		// obj.put(2, 200);
		// System.out.println(obj.get(1));
		// System.out.println("get 2: " + obj.get(2));

	}
}
