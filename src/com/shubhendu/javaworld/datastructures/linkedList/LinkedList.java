package com.shubhendu.javaworld.datastructures.linkedList;

public class LinkedList<Item> {
	Node<Item> head;

	static class Node<Item> {
		Item value;
		Node<Item> next;

		public Node(Item item) {
			this.value = item;
			this.next = null;
		}
	}

	public LinkedList() {
		this.head = null;
	}

	public LinkedList(Node<Item> head) {
		this.head = head;
	}

	public void printList() {
		Node<Item> currentNode = this.head;
		while (currentNode != null) {
			System.out.print(currentNode.value + "\t");
			currentNode = currentNode.next;
		}
	}

	/*
	 * Inserts element in front of the linkedList.
	 */
	public void push(Item item) {
		Node<Item> node = new Node<Item>(item);
		node.next = this.head;
		this.head = node;
	}

	/*
	 * Inserts element in the linkedList after the given node.
	 */
	public void insertAfter(Node<Item> node, Item item) {
		Node<Item> newNode = new Node<Item>(item);
		Node<Item> currentNodeNext = node.next;
		newNode.next = currentNodeNext;
		node.next = newNode;
	}

	public void append(Item item) {
		Node<Item> newNode = new Node<Item>(item);

		if (this.head == null) {
			this.head = newNode;
			return;
		}
		Node<Item> currentNode = this.head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;

	}
	
	public void printLinkedListReversed(Node node) {
		if (node == null)
			return;

		printLinkedListReversed(node.next);
		System.out.println(node.value);
	}

	public void delete(Item item) {
		if (this.head == null) {
			return;
		}

		if (this.head.next == null) {
			this.head = null;
			return;
		}

		Node<Item> currentNode = this.head;
		while (currentNode.next != null) {
			if (currentNode.next.value == item) {
				currentNode.next = currentNode.next.next;
				break;
			}
			currentNode = currentNode.next;
		}
	}

	public void delete(int position) {
		if (this.head == null || position < 0) {
			return;
		}
		if (position == 0) {
			this.head = this.head.next;
			return;
		}

		int counter = 0;
		Node<Item> currentNode = this.head;
		while (currentNode.next != null) {
			if ((position - 1) == counter++) {
				currentNode.next = currentNode.next.next;
				break;
			}
			currentNode = currentNode.next;
		}
	}

	public int size() {
		if (this.head == null) {
			return 0;
		}

		int counter = 0;
		Node<Item> currentNode = this.head;
		while (currentNode != null) {
			counter++;
			currentNode = currentNode.next;
		}

		return counter;
	}

	public Node<Item> reverse(Node<Item> node) {
		if (node == null)
			return null;

		Node<Item> previous = null;
		Node<Item> current = node;
		Node<Item> next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
//		node = previous;
		return previous;

	}

	public static void main(String[] args) {
		Node<String> firstNode = new Node<String>("S");
		Node<String> secondNode = new Node<String>("H");
		Node<String> thirdNode = new Node<String>("U");
		secondNode.next = thirdNode;

		firstNode.next = secondNode;

		LinkedList<String> linkedList = new LinkedList<String>(firstNode);

		System.out.println("Print first list ");
		linkedList.printList();

		linkedList.push("B");
		System.out.println("\nPrint second list ");
		linkedList.printList();

		linkedList.insertAfter(secondNode, "B");
		System.out.println("\nPrint insertAfter ");
		linkedList.printList();

		linkedList.append("H");
		System.out.println("\nPrint insertAfter ");
		linkedList.printList();

		linkedList = new LinkedList<String>();
		linkedList.append("S");
		linkedList.append("H");
		linkedList.append("U");
		System.out.println("\nPrint insertAfter ");
		linkedList.printList();
		System.out.println("\n=======Reverse=====");
		linkedList.printLinkedListReversed(linkedList.head);

		LinkedList reversedLinkedList = new LinkedList(linkedList.reverse(linkedList.head));
		System.out.println("\nPrint reversed ");
		reversedLinkedList.printList();

		// linkedList.delete("U");
		// System.out.println("\nPrint delete ");
		// linkedList.printList();
		// System.out.println("\nPrint delete3 ");
		// linkedList.delete("H");
		// linkedList.delete("S");
		// linkedList.printList();

		linkedList.printList();
		linkedList.delete(1);
		System.out.println("\nPrint delete ");
		linkedList.printList();

		System.out.println("\nSize: " + linkedList.size());

	}
}
