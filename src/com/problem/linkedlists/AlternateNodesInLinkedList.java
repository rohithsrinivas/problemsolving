package com.problem.linkedlists;

public class AlternateNodesInLinkedList {
	
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
	
	private void insertInLastplace(int data) {
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
	}
	
	private void printAlternateNodes() {
		Node temp = head;
		int count = 0;
		while(temp != null) {
			if(count % 2 == 0) {
				System.out.println(temp.data);
			}
			
			count++;
			
			
			temp = temp.next;
		}
	}
	
	private int getSizeOfList() {
		int count = 0;
		Node temp = head;
		while(temp != null) {
			count++;
		}
		return count;

	}

	public static void main(String[] args) {
		AlternateNodesInLinkedList linkedList = new AlternateNodesInLinkedList();
		linkedList.insertInFirstPlace(10);
		for(int i=20;i<=60;i=i+10)
		linkedList.insertInLastplace(i);

		linkedList.printAlternateNodes();
	}

}
