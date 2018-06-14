package com.problem.linkedlists;

public class DeleteLinkedList {

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
		Node temp = head;
		Node newNode = new Node(data);
		newNode.next = temp;
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
		if (head == null) {
			System.out.println("deletion failed.. linked list is empty");
			return;
		}
		Node temp = head;
		head = temp.next;
		temp.next = null;
	}

	private void deleteLastNode() {
		if (head.next == null)
			deleteFirstNode();
		Node current = head.next, previous = head;
		while (current.next != null) {
			current = current.next;
			previous = previous.next;
		}

		previous.next = null;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/* loop through the list and dereference the pointers of each node, we will still have the head node, after the
	 * loop completes, so we assign the head to null after the loop completes */
	private void deleteFullLinkedList() {
		Node temp = head;
		while(temp != null) {
			Node proxy = temp;
			proxy.next = null;
			temp = temp.next;
		}
		
		/* we still have the head node, so we assign it to null*/
		head = null;
	}

	private int getSizeOfList() {
		Node temp = head;
		int count = 0;
		while (temp.next != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public static void main(String[] args) {
		DeleteLinkedList deleteLinkedList = new DeleteLinkedList();
		deleteLinkedList.insertInLastPlace(10);
		deleteLinkedList.insertInLastPlace(20);
		deleteLinkedList.insertInLastPlace(30);
		deleteLinkedList.insertInLastPlace(40);
		deleteLinkedList.printList();
		System.out.println("_______________");
		deleteLinkedList.deleteFullLinkedList();
		deleteLinkedList.printList();
	}
}
