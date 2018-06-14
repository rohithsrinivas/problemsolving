package com.problem.linkedlists;

public class PalindromeList {

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
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
	}

	private int getSizeOfTheList() {
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

	private Node findTheMiddleNodeOfLinkedList() {
		Node fast = head,slow = head;
		while(fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == null) {
				break;
			}
		}
		return slow;
		
		//now the slow node will hold the middle of the linked list
	}

	private boolean reverseLinkedList() {
		Node previousNode = null, currentNode = head, nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}

		head = previousNode;

		return false;
	}

	public static void main(String[] args) {
		PalindromeList linkedList = new PalindromeList();
		linkedList.insertInFirstPlace(10);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(30);
		linkedList.insertInLastPlace(40);
		linkedList.insertInLastPlace(50);
		for (int i = 60; i <= 100; i = i + 10) {
			linkedList.insertInLastPlace(i);
		}
		linkedList.printList();
		linkedList.reverseLinkedList();
		linkedList.printList();
		System.out.println("the middle of the linked list is : "+linkedList.findTheMiddleNodeOfLinkedList().data);;

	}

}
