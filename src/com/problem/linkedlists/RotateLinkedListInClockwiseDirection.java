package com.problem.linkedlists;

public class RotateLinkedListInClockwiseDirection {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0 || head.next == null)
			return head;
		ListNode slow = head, fast = head;
		int count = 0;
		int size = getSize(head);
		if(k > size)
			k = k % getSize(head);
		while(count < k) {
			count++;
			fast = fast.next;
		}
		ListNode newTail = fast, newHead;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		newHead = slow.next;
		newTail.next = null;
		fast.next = head;
		
		return newHead;

	}
	
	public int getSize(ListNode head) {
		ListNode temp = head;
		int size = 0;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}
	
	
	public static void main(String[] args) {
		RotateLinkedListInClockwiseDirection rotateLinkedListInClockwiseDirection = new RotateLinkedListInClockwiseDirection();
		ListNode head = rotateLinkedListInClockwiseDirection.new ListNode(1);
		head.next = rotateLinkedListInClockwiseDirection.new ListNode(2);
//		head.next.next = rotateLinkedListInClockwiseDirection.new ListNode(3);
//		head.next.next.next = rotateLinkedListInClockwiseDirection.new ListNode(4);
//		head.next.next.next.next = rotateLinkedListInClockwiseDirection.new ListNode(5);
//		head.next.next.next.next.next = rotateLinkedListInClockwiseDirection.new ListNode(6);
//		head.next.next.next.next.next.next = rotateLinkedListInClockwiseDirection.new ListNode(7);
		rotateLinkedListInClockwiseDirection.rotateRight(head, 1);
	}

}
