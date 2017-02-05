package com.shubhendu.javaworld;

import java.util.HashMap;
import java.util.Map;

class DoublyLinkedNode {
	private int value;
	private DoublyLinkedNode left;
	private DoublyLinkedNode right;

	public DoublyLinkedNode(int value) {
		this.setValue(value);
		this.setLeft(null);
		this.setRight(null);
	}

	public DoublyLinkedNode getLeft() {
		return left;
	}

	public void setLeft(DoublyLinkedNode left) {
		this.left = left;
	}

	public DoublyLinkedNode getRight() {
		return right;
	}

	public void setRight(DoublyLinkedNode right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

class MapValue {
	private Integer value;
	private DoublyLinkedNode mapNode;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public DoublyLinkedNode getMapNode() {
		return mapNode;
	}

	public void setMapNode(DoublyLinkedNode mapNode) {
		this.mapNode = mapNode;
	}
}

public class LRUCache {
	private int capacity;
	private Map<Integer, MapValue> cacheMap;
	private DoublyLinkedNode leastRecentlyUsedNode;
	private DoublyLinkedNode mostRecentlyUsedNode;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cacheMap = new HashMap<Integer, MapValue>(capacity);
	}

	public int get(int key) {
		MapValue cacheMap = getMapValue(key);
		if (cacheMap != null) {
			return cacheMap.getValue();
		} else {
			return -1;
		}
	}

	private MapValue getMapValue(int key) {
		MapValue cacheValue = this.cacheMap.get(key);
		if (cacheValue != null) {
			DoublyLinkedNode oldNode = cacheValue.getMapNode();

			// If get is called on the MRU node, we do not need to change it.
			if (oldNode.equals(this.mostRecentlyUsedNode)) {
				return cacheValue;
			}

			// If LRU node is fetched, update LRU pointer
			if (oldNode.equals(this.leastRecentlyUsedNode)) {
				this.leastRecentlyUsedNode = this.leastRecentlyUsedNode.getRight();
				this.leastRecentlyUsedNode.setLeft(null);
			}
			DoublyLinkedNode oldLeftNode = oldNode.getLeft();
			DoublyLinkedNode oldRightNode = oldNode.getRight();

			if (oldLeftNode != null)
				oldLeftNode.setRight(oldRightNode);
			if (oldRightNode != null)
				oldRightNode.setLeft(oldLeftNode);

			// Update MRU pointer to MRU.right
			oldNode.setLeft(this.mostRecentlyUsedNode);
			this.mostRecentlyUsedNode.setRight(oldNode);
			this.mostRecentlyUsedNode = oldNode;
			this.mostRecentlyUsedNode.setRight(null);

			return cacheValue;
		} else {
			return null;
		}

	}

	public void put(int key, int value) {
		if (this.capacity <= 0) {
			return;
		}
		MapValue cachedValue = this.getMapValue(key);
		if (cachedValue == null) {
			DoublyLinkedNode newNode = new DoublyLinkedNode(key);
			if (this.cacheMap.size() < capacity) {
				if (this.leastRecentlyUsedNode == null) {
					this.mostRecentlyUsedNode = newNode;
					this.leastRecentlyUsedNode = this.mostRecentlyUsedNode;
				} else {
					DoublyLinkedNode oldMostRecentlyUsedNode = this.mostRecentlyUsedNode;
					oldMostRecentlyUsedNode.setRight(newNode);
					newNode.setLeft(oldMostRecentlyUsedNode);
					this.mostRecentlyUsedNode = newNode;
				}
			} else {
				if (this.leastRecentlyUsedNode != null) {
					this.cacheMap.remove(this.leastRecentlyUsedNode.getValue());
					newNode.setLeft(this.mostRecentlyUsedNode);
					this.mostRecentlyUsedNode.setRight(newNode);
					this.mostRecentlyUsedNode = newNode;
					if (this.leastRecentlyUsedNode.equals(this.mostRecentlyUsedNode)) {
						this.leastRecentlyUsedNode = this.mostRecentlyUsedNode;
					} else {
						this.leastRecentlyUsedNode = this.leastRecentlyUsedNode.getRight();
						this.leastRecentlyUsedNode.setLeft(null);
					}
				}
			}
			if (this.cacheMap.size() < capacity) {
				MapValue mapValue = new MapValue();
				mapValue.setValue(value);
				mapValue.setMapNode(newNode);
				this.cacheMap.put(key, mapValue);
			}
		} else {
			cachedValue.setValue(value);
			this.cacheMap.put(key, cachedValue);
		}

	}

	public static void main(String[] args) {
		// int capacity = 2;
		// LRUCache obj = new LRUCache(capacity);
		// System.out.println("get 2: " + obj.get(2));
		// obj.put(2, 6);
		// System.out.println("get 1: " + obj.get(1));
		// obj.put(1, 5);
		// obj.put(1, 2);
		// System.out.println("get 1: " + obj.get(1));
		// System.out.println("get 2: " + obj.get(2));

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
		String[] instructionList = new String[] { "LRUCache", "put", "put", "put", "put", "put", "get", "put", "get",
				"get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get",
				"get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get",
				"put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put",
				"put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get",
				"put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get",
				"put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put",
				"put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put" };
		Integer[] expectedOutput = new Integer[] { null, null, null, null, null, null, -1, null, 19, 17, null, -1, null,
				null, null, -1, null, -1, 5, -1, 12, null, null, 3, 5, 5, null, null, 1, null, -1, null, 30, 5, 30,
				null, null, null, -1, null, -1, 24, null, null, 18, null, null, null, null, -1, null, null, 18, null,
				null, -1, null, null, null, null, null, 18, null, null, -1, null, 4, 29, 30, null, 12, -1, null, null,
				null, null, 29, null, null, null, null, 17, 22, 18, null, null, null, -1, null, null, null, 20, null,
				null, null, -1, 18, 18, null, null, null, null, 20, null, null, null, null, null, null, null };

		String ops = "{10},{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}";
		String[] opsArray = ops.split(",");

		LRUCache obj = new LRUCache(10);
		int count = 1;
		obj.put(10, 13);
		count++;
		obj.put(3, 17);
		count++;
		obj.put(6, 11);
		count++;
		obj.put(10, 5);
		count++;
		obj.put(9, 10);
		count++;
		System.out.println("13" + ":" + obj.get(13) + ":" + expectedOutput[count++]);
		obj.put(2, 19);
		count++;
		System.out.println("2" + ":" + obj.get(2) + ":" + expectedOutput[count++]);
		System.out.println("3" + ":" + obj.get(3) + ":" + expectedOutput[count++]);
		obj.put(5, 25);
		count++;
		System.out.println("8" + ":" + obj.get(8) + ":" + expectedOutput[count++]);
		obj.put(9, 22);
		count++;
		obj.put(5, 5);
		count++;
		obj.put(1, 30);
		count++;
		System.out.println("11" + ":" + obj.get(11) + ":" + expectedOutput[count++]);
		obj.put(9, 12);
		count++;
		System.out.println("7" + ":" + obj.get(7) + ":" + expectedOutput[count++]);
		System.out.println("5" + ":" + obj.get(5) + ":" + expectedOutput[count++]);
		System.out.println("8" + ":" + obj.get(8) + ":" + expectedOutput[count++]);
		System.out.println("9" + ":" + obj.get(9) + ":" + expectedOutput[count++]);
		obj.put(4, 30);
		count++;
		obj.put(9, 3);
		count++;
		System.out.println("9" + ":" + obj.get(9) + ":" + expectedOutput[count++]);
		System.out.println("10" + ":" + obj.get(10) + ":" + expectedOutput[count++]);
		System.out.println("10" + ":" + obj.get(10) + ":" + expectedOutput[count++]);
		obj.put(6, 14);
		count++;
		obj.put(3, 1);
		count++;
		System.out.println("3" + ":" + obj.get(3) + ":" + expectedOutput[count++]);
		obj.put(10, 11);
		count++;
		System.out.println("8" + ":" + obj.get(8) + ":" + expectedOutput[count++]);
		obj.put(2, 14);
		count++;
		System.out.println("1" + ":" + obj.get(1) + ":" + expectedOutput[count++]);
		System.out.println("5" + ":" + obj.get(5) + ":" + expectedOutput[count++]);
		System.out.println("4" + ":" + obj.get(4) + ":" + expectedOutput[count++]);
		obj.put(11, 4);
		count++;
		obj.put(12, 24);
		count++;
		obj.put(5, 18);
		count++;
		System.out.println("13" + ":" + obj.get(13) + ":" + expectedOutput[count++]);
		obj.put(7, 23);
		count++;
		System.out.println(
				"MRU: " + obj.mostRecentlyUsedNode.getValue() + ": LRU: " + obj.leastRecentlyUsedNode.getValue());
		System.out.println("8" + ":" + obj.get(8) + ":" + expectedOutput[count++]);
		System.out.println("12" + ":" + obj.get(12) + ":" + expectedOutput[count++]);
		obj.put(3, 27);
		count++;
		obj.put(2, 12);
		count++;
		System.out.println("5" + ":" + obj.get(5) + ":" + expectedOutput[count++]);
		obj.put(2, 9);
		count++;
		obj.put(13, 4);
		count++;
		obj.put(8, 18);
		count++;
		obj.put(1, 7);
		count++;
		System.out.println("6" + ":" + obj.get(6) + ":" + expectedOutput[count++]);
		obj.put(9, 29);
		count++;
		obj.put(8, 21);
		count++;
		System.out.println("5" + ":" + obj.get(5) + ":" + expectedOutput[count++]);
		obj.put(6, 30);
		count++;
		obj.put(1, 12);
		count++;
		System.out.println("10" + ":" + obj.get(10) + ":" + expectedOutput[count++]);
		obj.put(4, 15);
		count++;
		obj.put(7, 22);
		count++;
		obj.put(11, 26);
		count++;
		obj.put(8, 17);
		count++;
		obj.put(9, 29);
		count++;
		System.out.println("5" + ":" + obj.get(5) + ":" + expectedOutput[count++]);
		obj.put(3, 4);
		count++;
		obj.put(11, 30);
		count++;
		System.out.println("12" + ":" + obj.get(12) + ":" + expectedOutput[count++]);
		obj.put(4, 29);
		count++;
		System.out.println("3" + ":" + obj.get(3) + ":" + expectedOutput[count++]);
		System.out.println("9" + ":" + obj.get(9) + ":" + expectedOutput[count++]);
		System.out.println("6" + ":" + obj.get(6) + ":" + expectedOutput[count++]);
		obj.put(3, 4);
		count++;
		System.out.println("1" + ":" + obj.get(1) + ":" + expectedOutput[count++]);
		System.out.println("10" + ":" + obj.get(10) + ":" + expectedOutput[count++]);
		obj.put(3, 29);
		count++;
		obj.put(10, 28);
		count++;
		obj.put(1, 20);
		count++;
		obj.put(11, 13);
		count++;
		System.out.println("3" + ":" + obj.get(3) + ":" + expectedOutput[count++]);
		obj.put(3, 12);
		count++;
		obj.put(3, 8);
		count++;
		obj.put(10, 9);
		count++;
		obj.put(3, 26);
		count++;
		System.out.println("8" + ":" + obj.get(8) + ":" + expectedOutput[count++]);
		System.out.println("7" + ":" + obj.get(7) + ":" + expectedOutput[count++]);
		System.out.println("5" + ":" + obj.get(5) + ":" + expectedOutput[count++]);
		obj.put(13, 17);
		count++;
		obj.put(2, 27);
		count++;
		obj.put(11, 15);
		count++;
		System.out.println("12" + ":" + obj.get(12) + ":" + expectedOutput[count++]);
		obj.put(9, 19);
		count++;
		obj.put(2, 15);
		count++;
		obj.put(3, 16);
		count++;
		System.out.println("1" + ":" + obj.get(1) + ":" + expectedOutput[count++]);
		obj.put(12, 17);
		count++;
		obj.put(9, 1);
		count++;
		obj.put(6, 19);
		count++;
		System.out.println("4" + ":" + obj.get(4) + ":" + expectedOutput[count++]);
		System.out.println("5" + ":" + obj.get(5) + ":" + expectedOutput[count++]);
		System.out.println("5" + ":" + obj.get(5) + ":" + expectedOutput[count++]);
		obj.put(8, 1);
		count++;
		obj.put(11, 7);
		count++;
		obj.put(5, 2);
		count++;
		obj.put(9, 28);
		count++;
		System.out.println("1" + ":" + obj.get(1) + ":" + expectedOutput[count++]);
		obj.put(2, 2);
		count++;
		obj.put(7, 4);
		count++;
		obj.put(4, 22);
		count++;
		obj.put(7, 24);
		count++;
		obj.put(9, 26);
		count++;
		obj.put(13, 28);
		count++;
		obj.put(11, 26);
		count++;

	}
}
