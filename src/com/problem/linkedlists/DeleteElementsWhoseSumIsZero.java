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
		if (data == head.data) {
			System.out.println("cannot delete element before first element");
			return;
		}
		Node current = head.next, previous = head;
		while (current.next != null) {
			if (current.data == data)
				break;
			current = current.next;
			previous = previous.next;
		}
		previous.next = current.next;
		current.next = null;
	}

	private void deleteNodeAfterNode(int data) {
		Node temp = head;
		while (temp.next != null) {
			if (data == temp.data)
				break;
			temp = temp.next;
		}
		// now we need to delete the node after temp node..
		temp.next = temp.next.next;
	}

	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
		temp.next = null;
	}

	private void deleteLastNode() {
		Node current = head.next, previous = head;
		while (current.next != null) {
			current = current.next;
			previous = previous.next;
		}
		previous.next = null;
	}

	private void deleteWhoseSumIsZero() {
		for (Node outer = head, outerPrevious = null; outer != null && outerPrevious != outer; outer = outer.next) {
			for (Node inner = outer.next, previous = outer; inner != null
					&& previous.next != null; inner = inner.next, previous = previous.next) {
				if ((outer.data + inner.data) == 0) {
					System.out.println("pair found " + outer.data + " & " + inner.data);
					// now we have to delete outer node and inner node

					// this condition is if outer is the first node and inner is the last node
					if (inner.next == null && outer == head) {
						deleteFirstNode();
						deleteLastNode();
						outer = head.next;
					}
					// this condition is if outer is first node and inner is not the last node
					else if (inner.next != null && outer == head) {
						deleteFirstNode();
						outer = head;
						previous.next = inner.next;
						inner.next = null;
					}
					// this condition is if outer is not the first node and inner is the last node
					else if (inner.next == null && outer != head) {
						deleteLastNode();
						outerPrevious.next = outer.next;
						outer.next = null;
					}
					// this condition is if both the nodes to be deleted are in the middle of the
					// list
					else {
						outerPrevious.next = outer.next;
						previous.next = inner.next;
						outer.next = null;
						inner.next = null;
					}

				}
			}

			if (outer == head)
				outerPrevious = head;
			else
				outerPrevious = outerPrevious.next;
		}
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
		linkedList.insertInLastPlace(-10);
		linkedList.insertBeforeNode(15, 20);
		linkedList.insertAfterNode(35, 30);
		linkedList.insertInLastPlace(-35);
		linkedList.printList();
		// System.out.println("_____________");
		// // linkedList.deleteNodeBeforeNode(20);
		// System.out.println("_____________");
		// linkedList.printList();
		// System.out.println("_____________");
		// linkedList.deleteNodeAfterNode(20);
		// linkedList.printList();
		linkedList.deleteWhoseSumIsZero();
		linkedList.printList();

	}

}
