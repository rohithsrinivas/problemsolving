package com.problem.linkedlists;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeleteDuplicatesFromUnsortedList {

	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private boolean isListEmpty() {
		return head == null;
	}

	private boolean isListHavingOneNode() {
		return head != null && head.next == null;
	}

	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
		temp.next = null;
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

	private void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("NULL");
	}

	private Node removeDuplicatesFromSortedList(Node head) {
		Node temp = head , next = null;
		while (temp != null && temp.next != null) {
			if (temp.data == temp.next.data) {
				next = temp.next.next;
				temp.next = null;
				temp.next = next;
			}
			else
				temp = temp.next;
		}
		
		return head;
		
	}

	private Node removeDuplicatesFromList(Node head) {
		if (isListHavingOneNode())
			return head;
		Node current = head.next, prev = head;
		Set<Integer> nodeSet = new HashSet<>();
		nodeSet.add(prev.data);
		while (current != null) {
			if (nodeSet.contains(current.data)) {
				prev.next = current.next;
			} else {
				nodeSet.add(current.data);
				prev = prev.next;
			}
			current = current.next;

		}
		return head;
	}

	private Node removeDuplicatesWithoutExtraStorage(Node head) {
		return null;
	}

	public static void main(String[] args) {
		DeleteDuplicatesFromUnsortedList linkedList = new DeleteDuplicatesFromUnsortedList();
		for (int i = 10; i <= 50; i = i + 10)
			linkedList.insertInLastPlace(i);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(10);
		linkedList.printList(linkedList.head);
		System.out.println("after removing duplicates  ");
		Node newHead = linkedList.removeDuplicatesFromList(linkedList.head);
		linkedList.printList(newHead);

	}

}
