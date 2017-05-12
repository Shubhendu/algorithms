/**
 * 
 */
package com.shubhendu.javaworld.datastructures.linkedList;

import java.util.ArrayList;

/**
 * @author ssingh
 *
 */
public class Reverse {

	private ListNode reverseList(ListNode prev, ListNode curr) {
		if (curr == null) {
			return prev;
		}

		if (curr.next == null) {
			prev.next = null;
			curr.next = prev;
			return curr;
		}

		ListNode r = reverseList(curr, curr.next);

		prev.next = null;
		curr.next = prev;
		return r;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		return reverseList(head, head.next);
	}
	
	private static void printLinkedList(ListNode head) {
		System.out.println("\nPrint linkedList ==> ");
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
//		l1.next.next = new ListNode(3);
//		l1.next.next.next = new ListNode(4);
//		l1.next.next.next.next = new ListNode(5);
//		l1.next.next.next.next.next = new ListNode(6);
//		l1.next.next.next.next.next.next = new ListNode(7);
		Reverse rev = new Reverse();
		printLinkedList(rev.reverseList(l1));
		
		ArrayList<Integer> arr = new ArrayList<Integer>();

	}

}
