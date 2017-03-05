package com.shubhendu.javaworld.datastructures.queue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{

	private Node firstNode;
	private Node lastNode;
	private int size;

	private class Node{
		Item item;
		Node next;

		public Node(Item item) {
			this.item = item;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public Item peek() {
		if (isEmpty()) 
			return null;
		
		return this.firstNode.item;
	}

	public void enqueue(Item item) {
		if (isEmpty()) {
			this.firstNode = new Node(item);
			this.lastNode = firstNode;
			
		} else {
			Node oldLastNode = this.lastNode;
			this.lastNode = new Node(item);
			oldLastNode.next = this.lastNode;
		}
		this.size++;
	}
	
	public Item dequeue() {
		if (isEmpty()) {
			return null;
		}
		
		Node oldFirstNode = this.firstNode;
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

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		Node current = firstNode;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(hasNext()){
				Item item = current.item;
				current = current.next;
				return item;
			}
				return null;
		}
		
	}

}
