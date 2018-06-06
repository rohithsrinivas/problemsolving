package com.problem.queues;

/* as insertion will happen at the rear and deletion will happen at the front, we will insert at last place operation
 * for inserting and delete at first place operation for deleting the nodes.. so initially front and rear
 * pointers will be declared..*/
public class QueueUsingLinkedLists {
	
	Node front,rear;
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private boolean isEmpty() {
		return front == null;
	}
	
	private void enqueue(int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			rear = newNode;
			front = newNode;
			return;
		}
		Node temp = front;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.next = null;
		rear = newNode;
	}
	
	private int dequeue() {
		if(isEmpty()) {
			System.out.println("queue underflow");
			return -1;
		}
		
		Node temp = front;
		front = temp.next;
		temp.next = null;
		
		return temp.data;
		
		
	}
	
	private void printQueue() {
		Node temp = front;
		while(temp != rear.next) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private int peek() {
		if(isEmpty()) {
			System.out.println("queue underflow.. peek failed");
			return -1;
		}
		return front.data;
	}
	
	private int getSize() {
		Node temp = front;
		int count = 0 ;
		while(temp != rear.next) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	

	public static void main(String[] args) {
		QueueUsingLinkedLists queue = new QueueUsingLinkedLists();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		System.out.println("the size of the queue is "+queue.getSize());
		queue.dequeue();
		queue.dequeue();
		queue.printQueue();
		System.out.println("the peek is "+queue.peek());
		System.out.println("the size of the queue is "+queue.getSize());

	}

}
