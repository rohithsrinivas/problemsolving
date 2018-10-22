package com.problem.linkedlists;

public class MiddleOfLinkedList {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// the idea is to use two pointers, fast and slow, fast will move by 2 places and slow will move by one place, so when fast pointer
	// reaches the end of the list, slow will stay at the middle of the list. We can print the data of slow pointer
	private void printMiddleOfLinkedList() {
		Node fast = head, slow = head;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		System.out.println("the middle element is "+slow.data);
	}
	
	// its the same as printing the middle node but we have to also know the previous node to adjust the pointer references, so we maintain
	// a node called previous, when fast pointer is null, the list has ended, now we should delete the node between previous and slow.
	private void deleteTheMiddleNodeInTheLinkedList() {
		Node fast = head,slow= head;
		Node previous = null;
		while(fast != null && fast.next!=null) {
			fast = fast.next.next;
			previous = slow;
			slow = slow.next;
		}
		
		//now we should delete the slow node
		previous.next = slow.next;
		slow.next = null;
	}
	
	private void insertInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	private void insertInLastPlace(int data) {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
	}
	
	private int getSizeOfTheList() {
		Node temp = head;
		int count = 0;
		while(temp !=null) {
			count++;
			temp = temp.next;
		}
		
		return count;
	}
	
	private void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		MiddleOfLinkedList linkedList = new MiddleOfLinkedList();
		linkedList.insertInFirstPlace(10);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(30);
		linkedList.insertInLastPlace(40);
		linkedList.insertInLastPlace(50);
		for(int i=60;i<=100;i=i+10) {
			linkedList.insertInLastPlace(i);
		}
		linkedList.printList();
		linkedList.printMiddleOfLinkedList();
		linkedList.deleteTheMiddleNodeInTheLinkedList();
		linkedList.printList();
	}

}
