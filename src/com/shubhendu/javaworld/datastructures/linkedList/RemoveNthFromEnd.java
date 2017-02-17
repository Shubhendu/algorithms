package com.shubhendu.javaworld.datastructures.linkedList;

/*
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.

	For example,

   	Given linked list: 1->2->3->4->5, and n = 2.
   	After removing the second node from the end, the linked list becomes 1->2->3->5.

	Note:
		Given n will always be valid.
		Try to do this in one pass.

 */

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null) {
			return null;
		}

		int count = 1;
		ListNode nThNode = head;

		while (count != n && nThNode.next != null) {
			nThNode = nThNode.next;
			count++;
		}

		if (count != n) {
			return head; // or throw exceptions
		}

		// First node from the head
		if (nThNode.next == null) {
			head = head.next;
			return head;
		}

		ListNode currentNode = null;

		while (nThNode.next != null) {
			currentNode = currentNode == null ? head : currentNode.next;
			nThNode = nThNode.next;
		}

		if (currentNode != null)
			currentNode.next = currentNode.next.next;

		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
		

		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		head = removeNthFromEnd.removeNthFromEnd(head, 1);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
	}
}
