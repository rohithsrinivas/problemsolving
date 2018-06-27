package com.problem.queues;

public class DoubleEndedQueueWithDoublyLinkedList {

	Node head;

	class Node {
		int data;
		Node prev, next;

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	private void pushToQueueFromRearEnd(int data) {
		if(head == null) {
			pushToQueueFromFrontEnd(data);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.prev = temp;
		newNode.next = null;
	}

	private void pushToQueueFromFrontEnd(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		newNode.prev = null;
		if (head != null)
			head.prev = newNode;
		head = newNode;
	}

	private int popFromFrontEndOfQueue() {
		if(head == null)
		{
			System.out.println("queue is empty");
			return -1;
		}
		Node temp = head;
		head = temp.next;
		head.prev = null;
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
		current.prev = null;
		prev.next = null;
		return current.data;
	}

	private void printQueue() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		DoubleEndedQueueWithDoublyLinkedList dequeue = new DoubleEndedQueueWithDoublyLinkedList();
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
