package com.problem.queues;

import java.util.Queue;

public class StacksUsingQueues {

	/*
	 * we will need two queues to mimic a stack's functionality, so we create two
	 * instances of the queue
	 */
	CustomQueue queue1 = new CustomQueue(5);
	CustomQueue queue2 = new CustomQueue(5);

	class CustomQueue {
		int[] queueArray;
		int size;
		int front = -1, rear = -1;

		public int getFront() {
			return front;
		}

		public void setFront(int front) {
			this.front = front;
		}

		public int getRear() {
			return rear;
		}

		public void setRear(int rear) {
			this.rear = rear;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public void enqueue(int data) {
			if (rear >= size - 1) {
				System.out.println("queue overflow error !!!");
				return;
			}
			if (front == -1 && rear == -1) {
				front++;
				rear++;
				queueArray[rear] = data;
				return;
			}

			if (rear < size - 1) {
				queueArray[++rear] = data;
				return;
			}
		}

		public int dequeue() {
			if (rear == front) {
				int pop = queueArray[front];
				front = -1;
				rear = -1;
				return pop;
			}

			if (rear == -1 && front == -1) {
				System.out.println("queue underflow error.. !!!");
				return -1;
			}

			return queueArray[front++];
		}

		public boolean isEmpty() {
			return front == -1;
		}

		public void printQueue() {
			for (int i = front; i <= rear; i++) {
				System.out.println(queueArray[i]);
			}
		}

		public CustomQueue(int size) {
			this.size = size;
			this.queueArray = new int[size];
		}

	}

	/*
	 * while pushing to the stack, we directly enqueue the element to the first
	 * queue (queue1), simply push to queue1
	 */
	private void pushToStack(int data) {
		if(queue1.getRear() >= queue1.getSize()-1) {
			System.out.println("stack overflow error");
			return;
		}
		queue1.enqueue(data);
	}

	/*
	 * while we want to pop from the stack, we will make this operation costly, i.e
	 * we will pop from queue1 and push it into queue2 until there is only one
	 * element left in queue1, which is our desired result, then we need to swap
	 * queue1 and queue2 because all the elements except the desired result in
	 * queue1 were already moved to queue2, we swap them and maintain the same the
	 * same condition as before except the popped element.
	 */
	private int popFromStack() {
		if (queue1.isEmpty()) {
			System.out.println("stack underflow error");
			return -1;
		}
		while (queue1.getFront() != queue1.getRear()) {
			queue2.enqueue(queue1.dequeue());
		}
		int element = queue1.dequeue();
		CustomQueue temp = queue1;
		queue1 = queue2;
		queue2 = temp;
		System.out.println(element);
		return element;
	}

	public static void main(String[] args) {
		StacksUsingQueues stacksUsingQueues = new StacksUsingQueues();
		stacksUsingQueues.pushToStack(10);
		stacksUsingQueues.pushToStack(20);
		stacksUsingQueues.pushToStack(30);
		stacksUsingQueues.pushToStack(40);
		stacksUsingQueues.pushToStack(50);
		stacksUsingQueues.pushToStack(60);

		stacksUsingQueues.popFromStack();
		stacksUsingQueues.popFromStack();
		stacksUsingQueues.popFromStack();
		stacksUsingQueues.popFromStack();
		stacksUsingQueues.popFromStack();
		stacksUsingQueues.popFromStack();
	}

}
