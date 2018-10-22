package com.problem.linkedlists;

public class ReverseSecondHalfOfLinkedList {

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
		Node temp = head;
		head = temp.next;
	}

	private boolean isListHavingOnlyOneNode() {
		return head != null && head.next == null;
	}

	private void deleteLastNode() {
		if (isListHavingOnlyOneNode()) {
			deleteFirstNode();
			return;
		}
		Node fast = head.next, slow = head;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = null;
	}

	private void insertNodeBeforeNode(int data, int beforeData) {
		if (isListHavingOnlyOneNode() && beforeData == head.data) {
			insertInFirstPlace(data);
			return;
		}
		Node current = head.next, prev = head;
		while (current.next != null) {
			if (data == beforeData)
				break;
			current = current.next;
			prev = prev.next;
		}
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = current;
	}

	private Node reverseLinkedList(Node head) {
		Node prev = null, current = head, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
		return head;
	}

	private void insertNodeAfterNode(int data, int afterData) {
		if (isListHavingOnlyOneNode() && head.data == afterData) {
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

	private void printList(Node head) {
		System.out.println("______________");
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}

	private Node findMiddleNodeOfLinkedList(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private Node findPartingNode(Node head,Node middleNode) {
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			if (fast.next.next == null || slow.next == middleNode) {
				return slow;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private void reverseSecondHalfOfLinkedList() {
		Node headForSecondHalf = null;
		Node middleNode = findMiddleNodeOfLinkedList(this.head);
		Node partingNode = findPartingNode(this.head, middleNode);
		headForSecondHalf = reverseLinkedList(middleNode);

		partingNode.next = headForSecondHalf;
	}

	public static void main(String[] args) {
		ReverseSecondHalfOfLinkedList linkedList = new ReverseSecondHalfOfLinkedList();
		linkedList.insertInLastPlace(10);
		linkedList.insertNodeBeforeNode(5, 10);
		linkedList.insertNodeAfterNode(8, 5);
		linkedList.insertInLastPlace(15);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(25);
		linkedList.insertInLastPlace(30);
		linkedList.printList(linkedList.head);
		linkedList.reverseSecondHalfOfLinkedList();
		linkedList.printList(linkedList.head);
	}

}
