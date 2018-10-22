package com.problem.linkedlists;

public class CircularLinkedList2 {

	Node head, tail;

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
		if (head == null)
			tail = newNode;
		else
			tail.next = newNode;
		head = newNode;

	}

	private void insertInLastPlace(int data) {
		if (head == null) {
			insertInFirstPlace(data);
			return;
		}
		Node newNode = new Node(data);
		tail.next = newNode;
		newNode.next = head;
		tail = newNode;
	}

	private void deleteFirstNode() {
		head = head.next;
		tail.next = head;
	}
	
	private Node reverseList(Node head) {
		Node previous = null,current = head,next = null;
		
		do {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}while(current != head);
		
		head.next = previous;
		head = previous;
		return head;
	}

	private void deleteLastNode() {
		Node current = head.next, prev = head;
		while (current.next != head) {
			current = current.next;
			prev = prev.next;
		}

		prev.next = head;
		tail = prev;
		current.next = null;
	}

	private boolean isListHavingOneNode() {
		return head == tail && head != null && tail != null;
	}

	private boolean isListEmpty() {
		return head == null && tail == null;
	}

	private void printList(Node head) {
		if (!isListEmpty()) {
			System.out.println(head.data);
			if (!isListHavingOneNode()) {
				Node temp = head.next;
				while (temp != head) {
					System.out.println(temp.data);
					temp = temp.next;
				}
			}
		} else
			System.out.println("list empty...");
	}

	private void insertAfterNode(int data, int afterData) {
		Node temp = head;
		while (temp != tail) {
			if (temp.data == afterData) {
				break;
			}
			temp = temp.next;
		}
		
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	private int getSizeOfList() {
		int count = 1;
		Node temp = head;
		while(temp != tail) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	private void insertBeforeNode(int data,int beforeData) {
		Node current = head.next,prev = head;
		while(current != tail) {
			if(current.data == beforeData)
				break;
			current = current.next;
			prev = prev.next;
		}
		
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = current;
	}

	public static void main(String[] args) {
		CircularLinkedList2 linkedList = new CircularLinkedList2();
		linkedList.insertInFirstPlace(10);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(40);
		linkedList.insertInLastPlace(50);
		linkedList.insertInFirstPlace(5);
		linkedList.insertBeforeNode(30, 40);
		linkedList.insertAfterNode(25, 20);
		linkedList.printList(linkedList.head);
		System.out.println("the size of the list is "+linkedList.getSizeOfList());
		Node new1 = linkedList.reverseList(linkedList.head);
		linkedList.printList(new1);
	}

}
