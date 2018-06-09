package com.problem.linkedlists;

public class DeleteElementsWhoseSumIsZero {

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
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
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
		previous.next = newNode;
		newNode.next = current;
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

	private void deleteNodeBeforeNode(int data) {
		Node current = head.next, previous = head;
		while (current.next != null) {
			if(current.data == data)
				break;
			current = current.next;
			previous = previous.next;
		}
		previous.next = current.next;
		current.next = null;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		DeleteElementsWhoseSumIsZero linkedList = new DeleteElementsWhoseSumIsZero();
		linkedList.insertInFirstPlace(10);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(30);
		linkedList.insertBeforeNode(15, 20);
		linkedList.insertAfterNode(35, 30);
		linkedList.printList();

	}

}
