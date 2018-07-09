package com.problem.linkedlists;

public class SortedInsertInLinkedList {

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
			System.out.println("list is empty.. inserting in first place");
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
			System.out.println("deletion failed.. list empty!!");
			return;
		}
		Node temp = head;
		head = temp.next;
		System.out.println("deleted element from first place " + temp.data);
	}

	private void deleteFromLastPlace() {
		if (doesListHaveOneNode()) {
			System.out.println("list contains only one node, deleting the first node");
			deleteFromFirstPlace();
			return;
		}
		Node current = head.next, prev = head;
		while (current.next != null) {
			current = current.next;
			prev = prev.next;
		}
		prev.next = null;
		System.out.println("deleted the element in the last place " + current.data);
	}

	private Node getLastElement() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	private boolean isListEmpty() {
		return head == null;
	}

	private boolean doesListHaveOneNode() {
		return (head != null && head.next == null);
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private void sortedInsert(int data) {

		/*
		 * if the list is empty, then directly insert in the first place, as no checking
		 * is required, also in case the data is less than the data contained in the
		 * head, we can insert it directly before the head node as the starting node, in
		 * either ways, we insert the new node in the first place
		 */
		if (isListEmpty() || (data < head.data)) {
			System.out.println("list is empty.. inserting in first place");
			insertInFirstPlace(data);
			return;
		}

		/*
		 * if the given data is larger than the last element, then we directly insert it
		 * at the last place
		 */
		if (data > getLastElement().data) {
			insertInLastPlace(data);
			return;
		}

		/*
		 * if the list has only one node, then we check if it is greater then or less
		 * than the head, if it is greater, then we insert it after head, if not we
		 * insert it in the first place
		 */
		if (doesListHaveOneNode()) {
			if (data < head.data) {
				insertInFirstPlace(data);
				return;
			}
			insertInLastPlace(data);
			return;
		}

		/*
		 * now we need to find a node such that it should fit properly in the sorted
		 * list in the middle
		 */
		Node temp = head;
		while (temp.next != null) {
			/* we need to find a node such that, the new node's data value should be greater than a current node and it should be less than the next node,
			 * so that we can insert it in between the current node being iterated and current.next*/
			if (data > temp.data && data < temp.next.data) {
				break;
			}
			temp = temp.next;
		}
		
		/* now insert the new node between temp and temp.next*/
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;

	}

	public static void main(String[] args) {
		SortedInsertInLinkedList linkedList = new SortedInsertInLinkedList();
		linkedList.insertInLastPlace(10);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(30);
		linkedList.printList();
		System.out.println("______________");
		linkedList.sortedInsert(8);
		linkedList.printList();
	}

}
