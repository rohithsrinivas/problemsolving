package com.problem.linkedlists;

import com.problem.linkedlists.SwapEveryTwoNodesInLinkedList.Node;

public class AddNodeInMiddleOfLinkedList {

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
		if (isListEmpty()) {
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

	private void deleteFromFirstPlace() {
		if (isListEmpty()) {
			System.out.println("list empty.. deletion failed");
			return;
		}
		Node temp = head;
		head = temp.next;
		temp.next = null;
	}

	private void deleteFromLastPlace() {
		if (listContainsOneNode()) {
			deleteFromFirstPlace();
			return;
		}
		Node current = head.next, prev = head;
		while (current.next != null) {
			current = current.next;
			prev = prev.next;
		}
		prev.next = null;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private void addNodeInMiddle(int data) {
		Node current = head, prev = head;
		while(current !=null && current.next!=null) {
			current = current.next.next;
			prev = prev.next;
		}
		System.out.println("the middle node is "+prev.data);
		/* now we need to insert the new node after prev node*/
		Node newNode = new Node(data);
		newNode.next = prev.next;
		prev.next = newNode;
	}

	private boolean listContainsOneNode() {
		return head != null && head.next == null;
	}

	private boolean isListEmpty() {
		return head == null;
	}

	public static void main(String[] args) {
		AddNodeInMiddleOfLinkedList list = new AddNodeInMiddleOfLinkedList();
		for (int i = 10; i <= 70; i = i + 10)
			list.insertInLastPlace(i);
		list.printList();
		System.out.println("________________");
		list.addNodeInMiddle(45);
		list.printList();
	}

}
