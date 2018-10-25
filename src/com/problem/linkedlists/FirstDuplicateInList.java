package com.problem.linkedlists;

import java.util.HashSet;
import java.util.Set;

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
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
	}
	
	private void insertBeforeNode(int data,int beforeData) {
		if(isListHavingOneNode()) {
			insertInFirstPlace(data);
			return;
		}
		Node current = head.next,prev = head;
		while(current.next != null) {
			if(current.data == beforeData)
				break;
			current = current.next;
			prev = prev.next;
		}
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = current;
	}
	
	private void insertAfterNode(int data,int afterData) {
		if(isListHavingOneNode()) {
			insertInLastPlace(data);
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			if(temp.data == afterData)
				break;
			temp = temp.next;
		}
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	private void findFirstDuplicateInLinkedList(Node head) {
		Set<Integer> values = new HashSet<>();
		Node temp = head;
		while(temp.next != null) {
			if(values.contains(temp.data)) {
				System.out.println("first duplicate element found "+ temp.data);
				return;
			}
			else {
				values.add(temp.data);
			}
			
			temp = temp.next;
		}
	}
	
	private boolean isListEmpty() {
		return head == null;
	}
	
	private boolean isListHavingOneNode() {
		return head != null && head.next == null;
	}
	
	private void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data +" --> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		FirstDuplicateInList linkedList = new FirstDuplicateInList();
		linkedList.insertInLastPlace(10);
		linkedList.insertBeforeNode(5, 10);
		linkedList.insertAfterNode(15, 10);
		linkedList.insertInLastPlace(5);
		linkedList.insertInLastPlace(30);
		linkedList.printList();
		linkedList.findFirstDuplicateInLinkedList(linkedList.head);
	}

}
