package com.shubh.javaworld;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
}

public class SortedListToBst {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}

		return createBST(head, null);
	}

	private TreeNode createBST(ListNode head, ListNode tail) {
		if (head == null) {
			return null;
		}

		if (head == tail || head.next == null) {
			return new TreeNode(head.val);
		}
		
		if (head.next == tail) {
			TreeNode n = new TreeNode(head.val);
			n.right = new TreeNode(tail.val);
		}
		
		ListNode p = null;
		ListNode s = head;
		ListNode f = head;
		while (f != null && f.next != null && f != tail) {
			p = s;
			f = f.next.next;
			s = s.next;
		}
		ListNode nextNode = s.next;
		if (s != null)
			s.next = null;

		if (p != null) {
			p.next = null;
		}
		
		TreeNode node = new TreeNode(s.val);
		node.left = createBST(head, p);
		node.right = createBST(nextNode, tail);
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		SortedListToBst s = new SortedListToBst();
		TreeNode node = s.sortedListToBST(head);
		System.out.println(node.val);

	}

}
