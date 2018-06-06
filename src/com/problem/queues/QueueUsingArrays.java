package com.problem.queues;

public class QueueUsingArrays {

	int front, rear;
	int[] queueArray;
	int maxSize;

	public QueueUsingArrays(int maxSize) {
		this.queueArray = new int[maxSize];
		this.front = -1;
		this.rear = -1;
		this.maxSize = maxSize;
	}

	private void enqueue(int data) {
		if (front == -1 && rear == -1) {
			front++;
			rear++;
			queueArray[rear] = data;
			return;
		}

		else if (rear >= this.maxSize - 1) {
			System.out.println("queue overflow.. !!!");
			return;
		}

		else if (rear < this.maxSize - 1) {
			queueArray[++rear] = data;
		}
	}

	private boolean isEmpty() {
		return front == -1;
	}

	private int peek() {
		if (isEmpty()) {
			System.out.println("queue empty...");
			return -1;
		}

		return queueArray[front];
	}

	private int dequeue() {
		if (isEmpty()) {
			System.out.println("queue  underflow...!!!");
			return -1;
		} else {
			int element = queueArray[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			}
			
			else {
				front++;
				
			}
			return element;
		}
	}

	private int getSizeOfQueue() {
		int count = 0;
		for (int i = front; i <= rear; i++) {
			count++;
		}
		return count;
	}

	private void printQueue() {
		for (int i = front; i <= rear; i++) {
			System.out.println(queueArray[i]);
		}
	}

	public static void main(String[] args) {
		QueueUsingArrays queue = new QueueUsingArrays(10);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.printQueue();
		queue.dequeue();
		System.out.println("after dequeing");
		queue.printQueue();
		System.out.println(queue.peek());
	}

}
