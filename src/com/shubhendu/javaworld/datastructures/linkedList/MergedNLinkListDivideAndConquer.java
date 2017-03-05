/**
 * 
 */
package com.shubhendu.javaworld.datastructures.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ssingh
 *
 */
public class MergedNLinkListDivideAndConquer {
	

	private ListNode mergedNode;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static class NodeComparator implements Comparator<ListNode> {
		public int compare(ListNode n1, ListNode n2) {
			return n1.val - n2.val;
		}
	}

	public void append(int val) {
		ListNode newNode = new ListNode(val);

		if (this.mergedNode == null) {
			this.mergedNode = newNode;
			return;
		}
		ListNode currentNode = this.mergedNode;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;

	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null)
			return null;
		
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new NodeComparator());

		for (int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			if (node != null)
				pq.add(node);
		}
		while (!pq.isEmpty()) {
			ListNode minNode = pq.poll();
			int val = minNode.val;
			if (minNode.next != null) {
				pq.add(minNode.next);
			}
			append(val);
		}
		printList(this.mergedNode);

		return this.mergedNode;
	}

	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
