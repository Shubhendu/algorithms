/**
 * 
 */
package com.shubhendu.javaworld.datastructures.linkedList;

/**
 * @author ssingh
 *
 */
public class DeleteNode {

	public void deleteNode(ListNode node) {
//		ListNode p = null;
//		while (node != null && node.next != null) {
//			p = node;
//			node.val = node.next.val;
//			node = node.next;
//		}
//		if (p != null)
//			p.next = null;
		if (node == null || node.next == null)
			return;
		node.val = node.next.val;
		node.next = node.next.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		DeleteNode d = new DeleteNode();
		d.deleteNode(head.next.next);
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}

	}

}
