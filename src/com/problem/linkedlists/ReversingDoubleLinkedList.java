package com.problem.linkedlists;

public class ReversingDoubleLinkedList {

	Node head;

	class Node {
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	private void insertInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		newNode.prev = null;
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
		newNode.prev = temp;
	}

	private void insertNodeAfterNode(int data, int afterData) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == afterData)
				break;
			temp = temp.next;
		}

		Node newNode = new Node(data);
		temp.next.prev = newNode;
		newNode.next = temp.next;
		temp.next = newNode;
		newNode.prev = temp;
	}

	private void insertNodeBeforeNode(int data, int beforeData) {
		Node current = head.next;
		Node previous = head;
		while (current.next != null) {
			if (beforeData == current.data) {
				break;
			}

			current = current.next;
			previous = previous.next;
		}

		// now we have to insert the node between current and previous
		Node newNode = new Node(data);
		current.prev = newNode;
		newNode.next = current;
		previous.next = newNode;
		newNode.prev = previous;
	}

	private void insertNodeAtPosition(int position, int data) {
		if (position == 1) {
			insertInFirstPlace(data);
			return;
		}

		if (position == getSizeOfTheList() + 1) {
			insertInLastPlace(data);
			return;
		}
		Node temp = head.next;
		for (int i = 2; i < getSizeOfTheList(); i++) {
			if (position == i)
				break;
			temp = temp.next;
		}

		// now we have to insert the node before current node and after the previous
		// node of current node..
		Node newNode = new Node(data);
		Node previousNode = temp.prev;
		temp.prev = newNode;
		newNode.next = temp;
		previousNode.next = newNode;
		newNode.prev = previousNode;

	}

	private void deleteFirstNode() {
		if (isEmpty()) {
			System.out.println("list is empty, deleting first node failed");
			return;
		}
		Node temp = head;
		head = temp.next;
		temp.prev = null;
	}

	private void deleteLastNode() {
		if (isEmpty()) {
			System.out.println("list is empty, deleting last node failed");
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp = temp.prev;
		temp.next = null;

	}

	private void deleteNodeAtPosition(int position) {
		if (position == 1) {
			deleteFirstNode();
			return;
		}

		if (position == getSizeOfTheList()) {
			deleteLastNode();
			return;
		}

		Node temp = head.next;
		for (int i = 2; i < getSizeOfTheList(); i++) {
			if (position == i)
				break;
			temp = temp.next;
		}
		// now we have to delete the node named temp, bypass the temp node and change
		// pointer references of
		// previous and next nodes
		temp.next.prev = temp.prev;
		temp.prev.next = temp.next;

	}

	private boolean isEmpty() {
		return head == null;
	}

	private int getSizeOfTheList() {
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
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private void reverseList() {
		Node previousNode = null,currentNode = head,nextNode = null;
		while(currentNode!=null) {
			nextNode = currentNode.next;
			currentNode.next = currentNode.prev;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		
		head = previousNode;
	}
	
	private Node reverseWithRecursion(Node current,Node prev) {
		if(current.next == null) {
			head = current;
			current.next = prev;
			return head;
		}
		Node next = current.next;
		current.next = prev;
		return reverseWithRecursion(next, current);
	}
	
//	private void reverseListWith2Pointers() {
//		Node temp = null,current = head;
//		while(current != null) {
//			temp = current.prev;
//			
//			temp = current;
//			current = current.next;
//		}
//	}

	public static void main(String[] args) {
		ReversingDoubleLinkedList doubleLinkedList = new ReversingDoubleLinkedList();
		doubleLinkedList.insertNodeAtPosition(1, 10);
		doubleLinkedList.insertNodeAtPosition(2, 20);
		doubleLinkedList.insertNodeAtPosition(2, 15);
		doubleLinkedList.insertNodeAtPosition(4, 25);
		doubleLinkedList.insertNodeAfterNode(18, 15);
		doubleLinkedList.insertNodeBeforeNode(23, 25);
		doubleLinkedList.deleteNodeAtPosition(3);
		doubleLinkedList.printList();
		System.out.println("after reversing list...........");
		doubleLinkedList.reverseWithRecursion(doubleLinkedList.head, null);
		doubleLinkedList.printList();
	}

}
