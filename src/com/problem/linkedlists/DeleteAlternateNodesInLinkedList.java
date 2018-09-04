package com.problem.linkedlists;

import com.problem.linkedlists.SwapEveryTwoNodesInLinkedList.Node;

public class DeleteAlternateNodesInLinkedList {

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

	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
		temp.next = null;
	}

	private void deleteLastNode() {
		if (listContainsOneElement()) {
			System.out.println("list contains only one element, deleting first element");
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
	
	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/*  the idea is to simply eliminate the alternate nodes starting from the second node, so we need to point the next reference of the first node to the third
	 * node and so on, such that second, fourth, sixth nodes are deleted. so we assign temp.next with temp.next.next, we need to add a null check to
	 * make this work with odd and even number of nodes*/
	private void deleteAlternateNodes() {
		Node temp = head;
		while (temp.next != null) {
			if(temp.next.next != null)
			temp.next = temp.next.next;
			temp = temp.next;
		}
	}

	private boolean isListEmpty() {
		return head == null;
	}

	private boolean listContainsOneElement() {
		return head != null && head.next == null;
	}

	public static void main(String[] args) {
		DeleteAlternateNodesInLinkedList list = new DeleteAlternateNodesInLinkedList();
		for (int i = 10; i <= 60; i = i + 10)
			list.insertInLastPlace(i);
		list.printList();
		System.out.println("________________");
		list.deleteAlternateNodes();
		list.printList();
	}

}
