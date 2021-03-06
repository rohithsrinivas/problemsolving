package com.problem.linkedlists;

public class NthNodeFromEndOfList {

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
		if(head == null) {
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

	private void printNthNodeFromEnd(int position) {
		Node temp = head;
		for (int i = 0; i < getSizeOfList() - (position); i++) {
			temp = temp.next;
		}

		System.out.println("the required node data is " + temp.data);
	}

	private void printNthNodeFromEndUsing2Pointers(int position) {
		Node slow = head, fast = head;
		for (int i = 1; i < position; i++) {
			fast = fast.next;
		}
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		System.out.println(" the "+position+"th node is "+slow.data);
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

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

	public static void main(String[] args) {
		NthNodeFromEndOfList list = new NthNodeFromEndOfList();
		for (int i = 10; i <= 50; i = i + 10) {
			list.insertInLastPlace(i);
		}
		list.printList();
		list.printNthNodeFromEndUsing2Pointers(1);
		list.printNthNodeFromEnd(4);

	}

}
