package com.problem.queues;

public class DoubleEndedQueueUsingLinkedList {

	Node head, rear;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void pushToQueueFromRearEnd(int data) {
		if(head == null) {
			pushToQueueFromFrontEnd(data);
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
		System.out.println(data + "pushed to rear end");
	}

	private void pushToQueueFromFrontEnd(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		System.out.println(data + "pushed to front end");
	}

	private int popFromFrontEndOfQueue() {
		if(head == null) {
			System.out.println("queue is empty");
			return -1;
		}
		Node temp = head;
		head = temp.next;
		temp.next = null;
		return temp.data;
	}

	private int popFromRearEndOfQueue() {
		if(head == null) {
			System.out.println("queue is empty");
			return -1;
		}
		Node current = head.next,prev = head;
		while(current.next != null) {
			current = current.next;
			prev = prev.next;
		}
		prev.next = null;
		return current.data;
	}
	
	private void printQueue() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		DoubleEndedQueueUsingLinkedList dequeue = new DoubleEndedQueueUsingLinkedList();
		dequeue.pushToQueueFromRearEnd(10);
		dequeue.pushToQueueFromRearEnd(20);
		dequeue.pushToQueueFromRearEnd(30);
		dequeue.pushToQueueFromRearEnd(40);
		dequeue.printQueue();
		System.out.println(dequeue.popFromRearEndOfQueue() + "popped");
		System.out.println(dequeue.popFromFrontEndOfQueue() + "popped");
		dequeue.printQueue();
	}

}
