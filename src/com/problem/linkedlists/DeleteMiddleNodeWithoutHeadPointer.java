package com.problem.linkedlists;

import com.problem.linkedlists.DeleteDuplicatesFromUnsortedList.Node;

public class DeleteMiddleNodeWithoutHeadPointer {
	
	Node head;
	
	class Node{
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
	
	/* when we don't have a head pointer, then we need cannot have the previous node, so
	 * for this we simply copy data from the next-to-middle node to the middle node and 
	 * delete the next-to-middle node, hence having the next-to-middle node as the new 
	 * middle Node*/
	private Node deleteMiddleNodeWithoutHeadPointer(Node middleNode) {
		middleNode.data = middleNode.next.data;
		middleNode.next = middleNode.next.next;
		return middleNode;
	}


	public static void main(String[] args) {
		DeleteMiddleNodeWithoutHeadPointer linkedList = new DeleteMiddleNodeWithoutHeadPointer();
		for (int i = 10; i <= 50; i = i + 10)
			linkedList.insertInLastPlace(i);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(10);
		linkedList.printList(linkedList.head);
	}

}
