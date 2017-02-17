/**
 * 
 */
package com.shubhendu.javaworld.datastructures.linkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Notes:
 * 	If the two linked lists have no intersection at all, return null.
 * 	The linked lists must retain their original structure after the function returns.
 * 	You may assume there are no cycles anywhere in the entire linked structure.
 * 	Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class IntersectionOfLinkedList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
			this.next = null;
		}
		
	}
	
	private int getLinkedListSize(ListNode currNode) {
		int size = 0;
		while (currNode.next != null) {
			size++;
			currNode = currNode.next;
		}
		return size;
	}
	
	private ListNode moveNodeByNPos(ListNode node, int n){
		int count = 0;
		while(count < n && node != null){
			node = node.next;
			count++;
		}
		return node;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		
		int sizeA = getLinkedListSize(headA);
		int sizeB = getLinkedListSize(headB);
		
		int diff = 0;
		if (sizeA > sizeB) {
			diff = sizeA - sizeB;
			headA = moveNodeByNPos(headA, diff);
		} else if (sizeB > sizeA) {
			diff = sizeB - sizeA;
			headB = moveNodeByNPos(headB, diff);
		}

		ListNode intersectionNode = null;
		while (headA != null && headB != null) {
			if (headA == headB) {
				intersectionNode = headA;
				break;
			}
			headA = headA.next;
			headB = headB.next;
		}
		
		return intersectionNode;
	}
	
	public static void printLinkedList(ListNode head) {
		System.out.println("\n Printing List");
		while(head != null) {
			System.out.print(" "+head.val);
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode headA = new ListNode(10);
		headA.next = new ListNode(20);
		headA.next.next = new ListNode(30);
		headA.next.next.next = new ListNode(40);
		headA.next.next.next.next = new ListNode(50);
		
		
		IntersectionOfLinkedList.printLinkedList(headA);
		
		ListNode headB = new ListNode(25);
//		headB.next = new ListNode(25);
//		headB.next.next = new ListNode(35);
//		headB.next.next.next = headA;
		
		
		IntersectionOfLinkedList.printLinkedList(headB);
		IntersectionOfLinkedList intersection = new IntersectionOfLinkedList();
		ListNode i = intersection.getIntersectionNode(headA, headB);
		System.out.println("\n List intersects at "+ i);
	}
}
