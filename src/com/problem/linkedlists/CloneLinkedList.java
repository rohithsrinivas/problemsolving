package com.problem.linkedlists;

public class CloneLinkedList {
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private void printList(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	private Node cloneLinkedList(Node head) {
		Node tail = null;
		Node newHead = null;
		Node current = head;
		
		while(current != null) {
			if(newHead == null) {
				Node newNode = new Node(current.data);
				newHead = newNode;
				tail = newHead;
			}
			else {
				Node newNode = new Node(current.data);
				tail.next = newNode;
				tail = newNode;
				newNode.next = null;
			}
			
			current = current.next;
		}
		
		return newHead;
	}
	
	

	public static void main(String[] args) {
		Node newNode = new Node(10);
		newNode.next = new Node(20);
		newNode.next.next = new Node(30);
		newNode.next.next.next = new Node(40);
		newNode.next.next.next.next = new Node(50);
		CloneLinkedList linkedList = new CloneLinkedList();
		linkedList.printList(newNode);
		Node newHead = linkedList.cloneLinkedList(newNode);
		
		System.out.println();
		linkedList.printList(newHead);
		
	}

}
