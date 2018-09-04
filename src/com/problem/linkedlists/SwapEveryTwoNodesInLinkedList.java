package com.problem.linkedlists;

public class SwapEveryTwoNodesInLinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void insertNodeInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	private void insertNodeInLastPlace(int data) {
		if (isLinkedListEmpty()) {
			insertNodeInFirstPlace(data);
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

	/* the idea is to simply swap the data fields, do not touch the pointer references for this problem!!!!! check whether the current node and its next node
	 * are not null so that they can be swapped, then swap them and increment the pointer by two shifts so that we now move to the next pair of nodes,
	 * hence we use temp =temp.next.next instead of temp = temp.next*/
	private void swapEveryTwoNodesInList() {
		Node temp = head;
		while (temp != null && temp.next != null) {
			swap(temp, temp.next);
			temp = temp.next.next;
		}
	}

	private void swap(Node currentNode, Node nextNode) {
		int temp = currentNode.data;
		currentNode.data = nextNode.data;
		nextNode.data = temp;
	}

	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
		temp.next = null;
		System.out.println("first node deleted successfully");
	}

	private void deleteLastNode() {
		if (isListContainsOneNode()) {
			deleteFirstNode();
			return;
		}
		Node current = head.next, prev = head;
		while (current.next != null) {
			current = current.next;
			prev = prev.next;
		}
		prev.next = null;
		System.out.println("last node deleted successfully");
	}

	private boolean isListContainsOneNode() {
		return head != null && head.next == null;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private boolean isLinkedListEmpty() {
		return head == null;
	}

	public static void main(String[] args) {
		SwapEveryTwoNodesInLinkedList list = new SwapEveryTwoNodesInLinkedList();
		for (int i = 10; i <= 50; i = i + 10)
			list.insertNodeInLastPlace(i);
		list.printList();
		System.out.println("________________");
		System.out.println("after swapping");
		list.swapEveryTwoNodesInList();
		list.printList();
	}
}
