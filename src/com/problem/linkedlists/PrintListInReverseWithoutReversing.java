package com.problem.linkedlists;

public class PrintListInReverseWithoutReversing {

	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	class CustomStack {
		int[] stackArray;
		int top;

		public CustomStack(int size) {
			stackArray = new int[size];
			top = -1;
		}

		private boolean isStackFull() {
			return top >= stackArray.length - 1;
		}

		private void push(int data) {
			if (isStackFull()) {
				System.out.println(" Stack overflow !!");
				return;
			}
			stackArray[++top] = data;
		}

		private int pop() {
			if (isStackEmpty()) {
				System.out.println("Stack underflow");
				return -1;
			}
			return stackArray[top--];
		}

		private boolean isStackEmpty() {
			return top == -1;
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

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data + "  ");
			temp = temp.next;
		}
	}

	private void printListInReverseOrder() {
		System.out.println("printing list in reverse order...");
		Node temp = head;
		CustomStack stack = new CustomStack(getListSize());
		while (temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		while(!stack.isStackEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private int getListSize() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	private boolean isListHavingOneNode() {
		return head != null && head.next == null;
	}

	private boolean isListEmpty() {
		return head == null;
	}

	public static void main(String[] args) {
		PrintListInReverseWithoutReversing linkedList = new PrintListInReverseWithoutReversing();
		for (int i = 10; i <= 100; i = i + 10)
			linkedList.insertInLastPlace(i);
		linkedList.deleteFirstNode();
		linkedList.deleteLastNode();
		linkedList.printList();
		linkedList.printListInReverseOrder();
	}

}
