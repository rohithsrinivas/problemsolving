package com.problem.linkedlists;

public class MergeSortForLinkedLists {
	
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
		if(head == null) {
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
	
	private boolean isListHavingOneNode() {
		return head != null && head.next == null;
	}
	
	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
		temp.next = null;
	}
	
	private void deleteLastNode() {
		if(isListHavingOneNode()) {
			deleteFirstNode();
			return;
		}
		Node current = head.next,prev = head;
		while(current.next != null) {
			current = current.next;
			prev = prev.next;
		}
		
		prev.next = null;
	}
	
	private void printList(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	private Node findMiddleNode(Node head) {
		if(head == null || head.next == null)
			return head;
		Node fast = head.next,slow = head;
		while(fast != null && slow != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private Node sortUsingMergeSort(Node head) {
		if(head == null || head.next == null)
			return head;
		Node middleNode = findMiddleNode(head);
		Node nextToMiddle = middleNode.next;
		
		middleNode.next = null;
		
		Node firstHalf = sortUsingMergeSort(head);
		Node secondHalf = sortUsingMergeSort(nextToMiddle);
		
		Node newHead = merge(firstHalf,secondHalf);
		
		return newHead;
		
	}
	
	private Node merge(Node firstHalf, Node secondHalf) {
		Node sortedList = null;
		if(firstHalf == null)
			return secondHalf;
		if(secondHalf == null)
			return firstHalf;
		
		if(firstHalf.data < secondHalf.data) {
			sortedList = firstHalf;
			sortedList.next = merge(firstHalf.next, secondHalf);
		}
		
		else {
			sortedList = secondHalf;
			sortedList.next = merge(firstHalf,secondHalf.next);
		}
		
		return sortedList;
		
	}

	public static void main(String[] args) {
		MergeSortForLinkedLists linkedList = new MergeSortForLinkedLists();
		linkedList.insertInLastPlace(109);
		linkedList.insertInLastPlace(29);
		linkedList.insertInLastPlace(12);
		linkedList.insertInLastPlace(14);
		//linkedList.deleteFirstNode();
		//linkedList.deleteLastNode();
		linkedList.printList(linkedList.head);
		System.out.println("after sorting");
		linkedList.printList(linkedList.sortUsingMergeSort(linkedList.head));
		
	}

}
