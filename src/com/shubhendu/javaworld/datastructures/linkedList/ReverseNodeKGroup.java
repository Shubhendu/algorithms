/**
 * 
 */
package com.shubhendu.javaworld.datastructures.linkedList;

/**
 * @author ssingh
 *
 */
public class ReverseNodeKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k < 2) {
			return head;
		}
		ListNode prevChunkTail = null;
		ListNode chunkStart = head;
		ListNode chunkTail = head.next;
		int nodeCount = 1;
		ListNode currentNode = head;

		while (currentNode != null) {
			if (nodeCount % k == 0) {
				ListNode reversedNode = reverseChunk(chunkStart, chunkTail);
				if (prevChunkTail != null) {
					prevChunkTail.next = reversedNode;
				} else {
					head = reversedNode;
				}
				prevChunkTail = chunkStart;
				currentNode = prevChunkTail;
				chunkStart = chunkTail;
			} 
			currentNode = currentNode.next;
			chunkTail = chunkTail != null ? chunkTail.next : null;
			nodeCount++;
		}
		return head;

	}

	private ListNode reverseChunk( ListNode current, ListNode end) {
		ListNode prev = end;
		while (current != end) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static void printLinkedList(ListNode head, int k) {
		System.out.println("\nPrint linkedList ==> "+k);
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
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next = new ListNode(6);
		l1.next.next.next.next.next.next = new ListNode(7);
		ReverseNodeKGroup reverseNodeKGroup = new ReverseNodeKGroup();
		printLinkedList(l1, 7);
		ListNode reversedNode = reverseNodeKGroup.reverseKGroup(l1, 2);
		printLinkedList(reversedNode, 2);
		reversedNode = reverseNodeKGroup.reverseKGroup(reversedNode, 4);
		printLinkedList(reversedNode, 4);
		reversedNode = reverseNodeKGroup.reverseKGroup(reversedNode, 3);
		printLinkedList(reversedNode, 3);
		reversedNode = reverseNodeKGroup.reverseKGroup(reversedNode, 4);
		printLinkedList(reversedNode, 4);
		reversedNode = reverseNodeKGroup.reverseKGroup(reversedNode, 8);
		printLinkedList(reversedNode, 8);
		reversedNode = reverseNodeKGroup.reverseKGroup(reversedNode, 7);
		printLinkedList(reversedNode,7);

	}

}
