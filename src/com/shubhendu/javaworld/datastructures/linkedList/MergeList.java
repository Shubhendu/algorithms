/**
 * 
 */
package com.shubhendu.javaworld.datastructures.linkedList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ssingh
 *
 */
public class MergeList {
	/**
	 * 
	 * @param ListNode
	 * @param ListNode
	 * @return ListNode
	 * Recursive solution
	 */
	public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		
		ListNode mergedHead = null;
		if (l1.val <= l2.val) {
			mergedHead = l1;
			mergedHead.next = mergeTwoListsRec(l1.next, l2);
		} else {
			mergedHead = l2;
			mergedHead.next = mergeTwoListsRec(l1, l2.next);
		}
		
		return mergedHead;
		
	}
	
	public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        
        if (l2 == null)
            return l1;
        
        ListNode mergedHeadNode = null;
        ListNode mergedTailNode = null;
        ListNode minNode = null;
       
        
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                minNode = l1;
                l1 = l1.next;
            } else {
                minNode = l2;
                l2 = l2.next;
            }
            if (mergedHeadNode == null) {
                mergedHeadNode = new ListNode(minNode.val);
                mergedTailNode = mergedHeadNode;
            } else {
                mergedTailNode.next = new ListNode(minNode.val);
                mergedTailNode = mergedTailNode.next;
            }
        }
        
        minNode = null;
        if (l1 != null) {
            minNode = l1;
        }else if (l2 != null) {
            minNode = l2;
        }
        
        while (minNode != null) {
             mergedTailNode.next = new ListNode(minNode.val);
             mergedTailNode = mergedTailNode.next;
             minNode = minNode.next;
        }
        
        
        return mergedHeadNode;
		
	}
	
	private void printLinkedList(ListNode head) {
		System.out.println("\nPrint linkedList==>");
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(11);
		l1.next.next.next = new ListNode(12);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(15);
		
		MergeList mergeList = new MergeList();
		mergeList.printLinkedList(mergeList.mergeTwoListsIterative(l1, l2));
		mergeList.printLinkedList(mergeList.mergeTwoListsRec(l1, l2));
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		String str = "dasdadger";
		for (char c : str.toCharArray()) {
			System.out.println(c);
		}
	}

}
