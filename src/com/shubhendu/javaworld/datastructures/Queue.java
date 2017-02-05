package com.shubhendu.javaworld.datastructures;

public class Queue<Item> {

	private Node<Item> firstNode;
	private Node<Item> lastNode;
	private int size;

	private static class Node<Item> {
		Item item;
		Node<Item> next;

		public Node(Item item) {
			this.item = item;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void enqueue(Item item) {
		if (isEmpty()) {
			this.firstNode = new Node<Item>(item);
			this.lastNode = firstNode;
			
		} else {
			Node<Item> oldLastNode = this.lastNode;
			this.lastNode = new Node<Item>(item);
			oldLastNode.next = this.lastNode;
		}
		this.size++;
	}
	
	public Item dequeue() {
		if (isEmpty()) {
			return null;
		}
		
		Node<Item> oldFirstNode = this.firstNode;
		this.firstNode = oldFirstNode.next;
		this.size--;
		return oldFirstNode.item;
	}
	
	public Item front() {
		if (isEmpty()) {
			return null;
		}
		
		return this.firstNode.item;
	}
	
	public Item rear() {
		if (isEmpty()) {
			return null;
		}
		
		return this.lastNode.item;
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println("Size: "+queue.size);
		queue.enqueue(3);
		System.out.println("Size: "+queue.size);
		
		System.out.println("front: "+queue.front());
		System.out.println("Rear: "+queue.rear());
		
		System.out.println("Item: "+queue.dequeue());
		System.out.println("Size: "+queue.size);
		System.out.println("Item: "+queue.dequeue());
		System.out.println("Size: "+queue.size);
		System.out.println("Item: "+queue.dequeue());
		System.out.println("Size: "+queue.size);
		System.out.println("Item: "+queue.dequeue());
		System.out.println("Size: "+queue.size);
	}

}
