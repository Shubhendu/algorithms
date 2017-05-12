/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author ssingh
 *
 */
public class LFUCache {
	private class MapNode {
		DoublyLinkedNode dllNode;
		int value;
		int frequency;
	}

	private class FrequencyNode {
		DoublyLinkedNode head;
		DoublyLinkedNode tail;
	}

	private class DoublyLinkedNode {
		DoublyLinkedNode prev;
		DoublyLinkedNode next;
		int key;

		public DoublyLinkedNode(int k) {
			this.key = k;
		}
	}

	private int maxCapacity;
	private Map<Integer, MapNode> cache;
	private Map<Integer, FrequencyNode> frequencyMap;
	private PriorityQueue<Integer> frequencyKeys;

	public LFUCache(int capacity) {
		maxCapacity = capacity;
		cache = new HashMap<Integer, MapNode>();
		frequencyMap = new HashMap<Integer, FrequencyNode>();
		frequencyKeys = new PriorityQueue<Integer>();
	}

	public int get(int key) {
		if (!cache.containsKey(key)) {
			return -1;
		}
		MapNode node = cache.get(key);
		int frequency = node.frequency;
		incrementFrequency(frequency, node.dllNode);
		node.frequency = frequency + 1;
		return node.value;
	}

	private void incrementFrequency(int key, DoublyLinkedNode node) {
		FrequencyNode frequencyNode = frequencyMap.get(key);
		if (frequencyNode != null) {
			if (frequencyNode.head == node && frequencyNode.head == frequencyNode.tail) {
				frequencyNode.head = null;
				frequencyNode.tail = null;
				frequencyMap.remove(key);
				frequencyKeys.remove();
			} else if (frequencyNode.head == node) {
				DoublyLinkedNode nextNode = frequencyNode.head.next;
				nextNode.prev = null;
				frequencyNode.head.next = null;
				frequencyNode.head = nextNode;
			} else if (frequencyNode.tail == node) {
				DoublyLinkedNode prevNode = frequencyNode.tail.prev;
				prevNode.next = null;
				frequencyNode.tail.prev = null;
				frequencyNode.tail = prevNode;
			} else if (node.next != null && node.prev != null) {
				DoublyLinkedNode nextNode = node.next;
				DoublyLinkedNode prevNode = node.prev;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
			}
		}
		if (frequencyMap.containsKey(key + 1)) {
			FrequencyNode nextFrequencyNode = frequencyMap.get(key + 1);
			DoublyLinkedNode oldTail = nextFrequencyNode.tail;
			oldTail.next = node;
			node.prev = oldTail;
			nextFrequencyNode.tail = node;
		} else {
			FrequencyNode newFrequencyNode = new FrequencyNode();
			newFrequencyNode.head = node;
			newFrequencyNode.tail = node;
			frequencyMap.put(key + 1, newFrequencyNode);
			frequencyKeys.add(key + 1);
		}
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			MapNode node = cache.get(key);
			int frequency = node.frequency;
			incrementFrequency(frequency, node.dllNode);
			node.frequency = frequency + 1;
			node.value = value;
			cache.put(key, node);
		} else {
			if (cache.size() >= maxCapacity) {
				evictLRUKey();
			}
			MapNode node = new MapNode();
			node.value = value;
			node.frequency = 1;
			DoublyLinkedNode dll = new DoublyLinkedNode(key);
			node.dllNode = dll;
			incrementFrequency(0, node.dllNode);
			cache.put(key, node);
		}
	}

	private void evictLRUKey() {
		int lowestFrequency = frequencyKeys.peek();
		FrequencyNode frequencyNode = frequencyMap.get(lowestFrequency);
		DoublyLinkedNode head = frequencyNode.head;
		int key = head.key;
		cache.remove(key);
		if (head.next == null) {
			frequencyKeys.remove();
			frequencyMap.remove(key);
		} else {
			head.next.prev = null;
			head = head.next;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// LFUCache lfuCache = new LFUCache(4);
		// lfuCache.put(10, 1);
		// lfuCache.put(20, 2);
		// System.out.println(lfuCache.get(10));
		// lfuCache.put(20, 3);
		// lfuCache.put(30, 4);
		// lfuCache.put(40, 5);
		// System.out.println(lfuCache.get(20));
		// lfuCache.put(50, 6);
		// System.out.println(lfuCache.get(30));

		LFUCache cache = new LFUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		Set<String> s = new HashSet<String>();
		

	}

}
