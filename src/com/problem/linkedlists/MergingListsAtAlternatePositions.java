package com.problem.linkedlists;

public class MergingListsAtAlternatePositions {

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
	}

	private boolean isListHavingOneNode() {
		return head != null && head.next == null;
	}

	private void deleteLastNode() {
		if (isListHavingOneNode()) {
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

	private boolean isListEmpty() {
		return head == null;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -->");
			temp = temp.next;
		}
	}

	private int getSize() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	private void mergeLinkedListsAtAlternatePositions(MergingListsAtAlternatePositions linkedList1,
			MergingListsAtAlternatePositions linkedList2, MergingListsAtAlternatePositions linkedList3) {
		Node temp1 = linkedList1.head, temp2 = linkedList2.head;
		int count = 0;
		while (temp1 != null && temp2 != null) {
			if (count % 2 == 0) {
				linkedList3.insertInLastPlace(temp1.data);
				temp1 = temp1.next;
			} else {
				linkedList3.insertInLastPlace(temp2.data);
				temp2 = temp2.next;
			}
			count++;
		}

		while (temp1 != null) {
			linkedList3.insertInLastPlace(temp1.data);
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			linkedList3.insertInLastPlace(temp2.data);
			temp2 = temp2.next;
		}
	}

	public static void main(String[] args) {
		MergingListsAtAlternatePositions linkedList1 = new MergingListsAtAlternatePositions();
		MergingListsAtAlternatePositions linkedList2 = new MergingListsAtAlternatePositions();
		MergingListsAtAlternatePositions linkedList3 = new MergingListsAtAlternatePositions();
		linkedList1.insertInLastPlace(1);
		linkedList1.insertInLastPlace(3);
		// linkedList1.insertInLastPlace(5);
		// linkedList1.insertInLastPlace(7);
		// linkedList1.insertInLastPlace(9);
		System.out.println("first list ___________");
		linkedList1.printList();
		linkedList2.insertInLastPlace(2);
		linkedList2.insertInLastPlace(4);
		linkedList2.insertInLastPlace(6);
		linkedList2.insertInLastPlace(8);
		System.out.println("second list ___________");
		linkedList2.printList();
		linkedList3.mergeLinkedListsAtAlternatePositions(linkedList1, linkedList2, linkedList3);
		System.out.println("merged linked list is ");
		linkedList3.printList();
	}

}
