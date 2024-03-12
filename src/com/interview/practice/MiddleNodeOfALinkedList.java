package com.interview.practice;

public class MiddleNodeOfALinkedList {
	
	Node head;
	
	class Node {
		int data;
		Node next;
		
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		
	}
	
	public void printTheMiddleNodeOfTheLinkedList(Node head) {
		Node slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("The middle node of the linked list is " + slow.data);
	}
	
	public void insertNodeAtTheBeginning(int data) {
		Node newNode = new Node(data, null);
		newNode.next = head;
		head = newNode;
	}
	
	public void addNodeAtTheEnd(int data) {
		if(head == null) {
			insertNodeAtTheBeginning(data);
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		Node newNode = new Node(data, null);
		current.next = newNode;
		newNode.next = null;
		
	}
	
	public static void main(String[] args) {
		MiddleNodeOfALinkedList middle = new MiddleNodeOfALinkedList();
		middle.addNodeAtTheEnd(5);
		middle.addNodeAtTheEnd(10);
		middle.addNodeAtTheEnd(15);
		middle.addNodeAtTheEnd(20);
		middle.addNodeAtTheEnd(25);
		middle.addNodeAtTheEnd(30);
		middle.printTheMiddleNodeOfTheLinkedList(middle.head);

		
	}

}
