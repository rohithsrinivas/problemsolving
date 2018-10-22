package com.problem.linkedlists;

public class FirstDuplicateInList {
	
	Node head;
	
	class Node{
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
		if(isListEmpty()) {
			insertInFirstPlace(data);
			return;
		}
	}
	
	private boolean isListEmpty() {
		return head == null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
