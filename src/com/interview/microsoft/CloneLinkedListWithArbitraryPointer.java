package com.interview.microsoft;

public class CloneLinkedListWithArbitraryPointer {
	
	class Node{
		int data;
		Node next;
		Node random;
		Node(int data){
			this.data = data;
		}
	}
	
	public Node cloneLinkedListWithRandomPointer(Node head) {
		Node temp = head;
		while(temp != null && temp.next != null) {
			Node newNode = new Node(temp.data);
			newNode.next = temp.next;
			temp.next = newNode;
			temp = temp.next.next;
		}
		temp = head;
		while(temp != null && temp.next != null) {
			temp.next.random = temp.random != null ? temp.random.next : null;
			temp = temp.next.next;
		}
		Node actual = head, clone = head.next;
		while(clone != null && clone.next != null) {
			actual = actual.next.next;
			clone = clone.next.next;
		}
		return clone;
	}

}
