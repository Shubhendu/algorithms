/**
 * 
 */
package com.shubhendu.javaworld.datastructures.linkedList;

/**
 * @author ssingh
 *
 */
public class LinkedListCycle {

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (slow == fast) {
				break;
			}
		}

		if (fast == null || fast.next == null) {
			return null;
		}

		slow = head;

		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);

		LinkedListCycle c = new LinkedListCycle();
		ListNode n = c.detectCycle(head);
		System.out.println(n.val);

	}

}
