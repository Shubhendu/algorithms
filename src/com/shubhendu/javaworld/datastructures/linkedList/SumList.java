/**
 * 
 */
package com.shubhendu.javaworld.datastructures.linkedList;

/**
 * @author ssingh
 *
 */
public class SumList {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	static class PartialSum {
		int carryOver;
		ListNode node;

	}

	public ListNode sum(ListNode n1, ListNode n2) {
		PartialSum p = sumRecursive(n1, n2);
		if (p == null) {
			return null;
		}
		if (p.carryOver == 0) {
			return p.node;
		}
		ListNode node = new ListNode(p.carryOver);
		node.next = p.node;
		return node;
	}

	private PartialSum sumRecursive(ListNode n1, ListNode n2) {

		if (n1 == null && n2 == null) {
			return null;
		}

		if (n1.next == null && n2.next == null) {
			int carryOver = 0;
			int sum = n1.val + n2.val;
			carryOver = sum / 10;
			sum = sum % 10;
			ListNode node = new ListNode(sum);
			PartialSum newPartial = new PartialSum();
			newPartial.node = node;
			newPartial.carryOver = carryOver;
			return newPartial;
		}
		
		PartialSum p = null;
		if (n1.next == null) {
			p = sumRecursive(n1, n2.next);
		}
		if (n2.next == null) {
			p = sumRecursive(n1.next, n2);
		} else {
			p = sumRecursive(n1.next, n2.next);
		}

		int carryOver = p == null ? 0 : p.carryOver;
		int sum = n1.val + n2.val + carryOver;

		carryOver = sum / 10;
		sum = sum % 10;

		ListNode node = new ListNode(sum);
		node.next = p == null ? null : p.node;
		PartialSum newPartial = new PartialSum();
		newPartial.node = node;
		newPartial.carryOver = carryOver;
		return newPartial;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n1 = new ListNode(8);
		n1.next = new ListNode(5);

		ListNode n2 = new ListNode(4);

		SumList sum = new SumList();
		ListNode n3 = sum.sum(n1, n2);
		while (n3 != null) {
			System.out.print(n3.val + " - >");
			n3 = n3.next;
		}

	}

}
