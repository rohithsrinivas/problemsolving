package com.problem.linkedlists;

public class RotateLinkedListCounterClockwise {

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

	private void reverseLinkedList() {
		Node previous = null, next = null, current = head;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		head = previous;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private void insertBeforeNode(int data, int beforeData) {
		if (beforeData == head.data) {
			insertInFirstPlace(data);
			return;
		}
		Node current = head.next, previous = head;
		while (current.next != null) {
			if (current.data == beforeData) {
				break;
			}
			current = current.next;
			previous = previous.next;
		}
		Node newNode = new Node(data);
		previous.next = newNode;
		newNode.next = current;
	}

	private void insertAfterNode(int data, int afterData) {
		if (data == afterData) {
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

	/*
	 * the problem is to rotate the linked list around a given node like this
	 * initially 10-20-30-40-50-60, now if I want to rotate the list around 4th
	 * position, the new list will be 50-60-10-20-30-40
	 */
	private void rotateListInClockwiseDirectionAround(int rotatingIndex) {
		Node temp = head;
		for (int i = 1; i <= getSizeOfList(); i++) {
			if (i == rotatingIndex)
				break;
			temp = temp.next;
		}
		/*
		 * now the node at the rotating index should be the last node, the next node of
		 * it should be null, and the previous head node should be the next node to the
		 * previous last node
		 */
		/* store the previous head node for attaching at the end of the new list */
		Node previousHeadNode = head;
		/* temp will point to the required index node according to our position*/
		Node indexNode = temp;
		/* now the new head will be the next node of index node */
		head = indexNode.next;
		/* find the last node by parsing through the list */
		Node lastNode = getLastNode();

		/* as index node will now be the new last node, it will point to null */
		indexNode.next = null;
		/* now the last nodes next pointer should point to the previous head node */
		lastNode.next = previousHeadNode;
	}

	private Node getLastNode() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
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

	public static void main(String[] args) {
		RotateLinkedListCounterClockwise linkedList = new RotateLinkedListCounterClockwise();
		linkedList.insertInFirstPlace(10);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(40);
		linkedList.insertInLastPlace(50);
		linkedList.insertBeforeNode(30, 40);
		linkedList.insertAfterNode(60, 50);
		linkedList.printList();
		linkedList.rotateListInClockwiseDirectionAround(4);
		System.out.println("__________________");
		linkedList.printList();
		// linkedList.reverseLinkedList();
		// linkedList.printList();

	}

}
