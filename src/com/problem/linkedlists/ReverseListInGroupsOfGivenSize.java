package com.problem.linkedlists;

import java.beans.beancontext.BeanContext;

public class ReverseListInGroupsOfGivenSize {

	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void insertInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	private void insertInLastPlace(int data) {
		if (head == null) {
			insertInFirstPlace(data);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
	}

	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
	}

	private boolean isListHavingOneNode() {
		return head != null && head.next == null;
	}

	private void deleteLastNode() {
		if (isListHavingOneNode()) {
			deleteFirstNode();
			return;
		}
		Node current = head.next, prev = head;
		while (current.next != null) {
			current = current.next;
			prev = prev.next;
		}
		prev.next = null;
	}

	private void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private void insertBeforeNode(int data, int beforeData) {
		if (isListHavingOneNode()) {
			insertInFirstPlace(beforeData);
			return;
		}
		Node current = head.next, prev = head;
		while (current.next != null) {
			if (current.data == beforeData)
				break;
			current = current.next;
			prev = prev.next;
		}
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = current;
	}

	private void insertAfterNode(int data, int afterData) {
		if (isListHavingOneNode()) {
			insertInLastPlace(data);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == afterData)
				break;
			temp = temp.next;
		}
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
	}

	private Node reverseLinkedList(Node head, Node tail) {
		Node current = head, prev = null, next = null;
		while (current != tail) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
		return head;
	}

	private Node reverseListInGroupsOfSize(int k, Node head) {
		Node current = head, prev = null, next = null;
		int count = 0;

		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null)
			head.next = reverseListInGroupsOfSize(k, current);

		return prev;

	}

	private Node reverseAlternateKNodes(int k,Node head) {
		Node current = head,prev= null,next = null;
		int count = 0;
		while(current != null  && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(head != null)
			head.next = current;
		
		count = 0;
		while(count < k-1 && current != null) {
			current = current.next;
			count++;
		}
		
		if(current != null)
			current.next = reverseAlternateKNodes(k, current.next);
		
		return prev;
	}
	
	private Node reverseInGroups(int k ,Node head) {
		int count = 0;
		Node current = head,prev = null,next = null;
		while(current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(next != null)
			head.next = reverseInGroups(k, current);
		
		return prev;
	}

	public static void main(String[] args) {
		ReverseListInGroupsOfGivenSize linkedList = new ReverseListInGroupsOfGivenSize();
		linkedList.insertInLastPlace(10);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(30);
		linkedList.insertInLastPlace(40);
		linkedList.insertBeforeNode(15, 20);
		linkedList.insertAfterNode(35, 30);
		linkedList.insertInLastPlace(100);
		linkedList.insertInLastPlace(200);
		linkedList.insertInLastPlace(300);
		linkedList.printList(linkedList.head);
		// Node reversedLinkedListHead = linkedList.reverseLinkedList(linkedList.head);
		// linkedList.printList(reversedLinkedListHead);
		Node newHead = linkedList.reverseListInGroupsOfSize(3, linkedList.head);
		System.out.println("))))))))))))))))");
		linkedList.printList(newHead);
		Node newHead2 = linkedList.reverseAlternateKNodes(3, newHead);
		System.out.println("************");
		linkedList.printList(newHead2);

	}

}
