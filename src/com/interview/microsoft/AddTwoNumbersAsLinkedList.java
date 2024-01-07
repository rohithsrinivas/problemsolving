package com.interview.microsoft;

public class AddTwoNumbersAsLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	ListNode resultHead, resultTail;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode temp1 = l1, temp2 = l2;
		int sum = 0;
		int carry = 0;
		while (temp1 != null || temp2 != null) {
			sum = carry + (temp1 != null ? temp1.val : 0) + (temp2 != null ? temp2.val : 0);
			carry = sum / 10;
			addToResult(sum % 10);
			if (temp1 != null)
				temp1 = temp1.next;
			if (temp2 != null)
				temp2 = temp2.next;
		}
		if (carry > 0)
			addToResult(carry);
		return resultHead;
	}

	private void addToResult(int data) {
		if (resultHead == null) {
			resultHead = new ListNode(data);
			resultTail = resultHead;
		} else {
			resultTail.next = new ListNode(data);
			resultTail = resultTail.next;
		}

	}

	public static void main(String[] args) {
		AddTwoNumbersAsLinkedList linkedList = new AddTwoNumbersAsLinkedList();
		ListNode l1 = linkedList.new ListNode(2);
		l1.next = linkedList.new ListNode(4);
		l1.next.next = linkedList.new ListNode(3);
		ListNode l2 = linkedList.new ListNode(5);
		l2.next = linkedList.new ListNode(6);
		l2.next.next = linkedList.new ListNode(4);
		linkedList.addTwoNumbers(l1, l2);

	}

}
