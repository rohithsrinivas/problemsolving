package com.problem.linkedlists;

import com.problem.linkedlists.CloneLinkedList.Node;

public class CloneLinkedListsWithArbitraryPointer {

	Node head;

	static class Node {
		int data;
		Node next;
		Node random;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.random = null;

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
		newNode.random = temp;
	}

	private boolean isListHavingOneNode() {
		return head != null && head.next == null;
	}

	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
		temp.next = null;
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
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
	}

	/*
	 * for this the idea is to first create a copy of each node just after it, so
	 * that now node.next will be same as node, so we will make changes on the copy
	 * of each node
	 */
	private Node copyList(Node head) {
		Node current = head;
		/* first copy each node just next to it */
		while(current != null) {
			Node newNode = new Node(current.data);
			newNode.next = current.next;
			current.next = newNode;
			
			current = current.next.next;
		}
		/* so after this loop finished, each node will have its copy, right next to it, but the original has its random pointer and the random pointer
		 * value for the copy is null, so now we need to copy all the random pointer values from the original nodes to the copy nodes next to it, so now
		 * for each node, */
		
		current = head;
		
		while(current != null) {
			current.next.random = current.random;

			current = current.next.next;
		}
		
		
		Node originalHead = head,copyHead = head.next;
		
		Node newHead = copyHead;
		while(originalHead != null && copyHead != null) {
			originalHead.next = originalHead.next != null ? originalHead.next.next : originalHead.next;
			copyHead.next = copyHead.next != null ? copyHead.next.next : copyHead.next;
			
			originalHead = originalHead.next;
			copyHead = copyHead.next;
		}
		
		return newHead;
		
	}

	public static void main(String[] args) {
		Node start = new Node(1);
		start.next = new Node(2);
		start.next.next = new Node(3);
		start.next.next.next = new Node(4);
		start.next.next.next.next = new Node(5);

		// 1's random points to 3
		start.random = start.next.next;

		// 2's random points to 1
		start.next.random = start;

		// 3's and 4's random points to 5
		start.next.next.random = start.next.next.next.next;
		start.next.next.next.random = start.next.next.next.next;

		// 5's random points to 2
		start.next.next.next.next.random = start.next;
		CloneLinkedListsWithArbitraryPointer linkedList = new CloneLinkedListsWithArbitraryPointer();
		System.out.println("printing original list");
		linkedList.printList(start);
		Node copyHead = linkedList.copyList(start);
		System.out.println("printing cloned list");
		linkedList.printList(copyHead);

	}

}
