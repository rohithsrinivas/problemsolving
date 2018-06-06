package com.problem.linkedlists;

public class CircularLinkedList {

	Node head, tail;

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
		if (head == null) {
			head = newNode;
			newNode.next = head;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			head = newNode;
		}
	}

	private void insertInLastPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		if(head == null) {
			head = newNode;
			newNode.next = head;
			tail = newNode;
		}
		
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	private int deleteFirstNode() {
		Node temp = head;
		head = head.next;
		temp.next = null;
		return temp.data;
	}

	private int deleteLastNode() {
		Node current = head.next, previous = head;
		while (current.next != head) {
			current = current.next;
			previous = previous.next;
		}

		previous.next = null;
		return current.data;
	}

	private void insertBeforeNode(int data, int beforeData) {
		Node current = head.next, previous = head;
		while (current.next != null) {
			if (current.data == beforeData)
				break;
			current = current.next;
			previous = previous.next;
		}
		Node newNode = new Node(data);
		newNode.next = current;
		previous.next = newNode;
	}

	private void insertAfterNode(int data, int afterData) {
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

	private void insertAtPosition(int position, int data) {
		if (position == 1) {
			insertInFirstPlace(data);
			return;
		}
		if (position == getSizeOfList() + 1) {
			insertInLastPlace(data);
			return;
		}

		Node temp = head.next;
		for (int i = 2; i < getSizeOfList(); i++) {
			if (i == position)
				break;
			temp = temp.next;
		}
		insertBeforeNode(data, temp.data);

	}

	private void deleteAtPosition(int position) {
		if (position == 1) {
			deleteFirstNode();
			return;
		}

		if (position == getSizeOfList()) {
			deleteLastNode();
			return;
		}

		Node current = head.next;
		Node previous = head;
		for (int i = 2; i < getSizeOfList(); i++) {
			if (i == position)
				break;
			current = current.next;
			previous = previous.next;
		}

		// now we should delete the current node..
		previous.next = current.next;
		current.next = null;
	}

	private int getSizeOfList() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	private void printList() {
		Node temp = head;
		System.out.println(temp.data);
		temp = head.next;
		while (temp != head) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		//System.out.println(temp.data);
	}

	public static void main(String[] args) {
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		// circularLinkedList.insertAtPosition(1, 10);
		// circularLinkedList.insertAtPosition(2, 20);
		// circularLinkedList.insertAtPosition(3, 30);
		circularLinkedList.insertInFirstPlace(10);
		circularLinkedList.insertInLastPlace(20);
		circularLinkedList.insertInLastPlace(30);
		circularLinkedList.printList();
	}

}
