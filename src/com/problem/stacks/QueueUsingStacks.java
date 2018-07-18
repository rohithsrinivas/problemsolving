package com.problem.stacks;

import java.util.Stack;

public class QueueUsingStacks {

	/*
	 * we maintain two stacks, one for pushing to the queue and one for popping from
	 * the queue
	 */
	Stack<Integer> stack1, stack2;

	public QueueUsingStacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	class CustomStack {

		int top = -1;
		int[] stackArray;

		public CustomStack(int size) {
			this.stackArray = new int[size];
		}

		public void push(int data) {
			stackArray[++top] = data;
		}

		public int pop(int data) {
			return stackArray[top--];
		}

		public int peek(int data) {
			return stackArray[top];
		}
	}

	/*
	 * while pushing to the queue, we directly push to stack1, and hence having the
	 * last inserted element at the top..
	 */
	public void pushToQueue(int data) {
		stack1.push(data);
	}

	/*
	 * while we want to pop from the queue, we check if both the stacks are empty,
	 * if yes then underflow error, else, keep popping from stack1 and pushing to
	 * stack2 until stack1 is empty, hence having the oldest inserted item at the
	 * top of stack 2 , then we just pop stack2, its similar to copying the reverse
	 * of stack1 into stack2
	 */
	public int popFromQueue() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			System.out.println("queue underflow error..");
			return -1;
		} else {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
		QueueUsingStacks queue = new QueueUsingStacks();
		for (int i = 10; i <= 50; i = i + 10)
			queue.pushToQueue(i);
		for (int i = 1; i <= 5; i++)
			System.out.println(queue.popFromQueue());
	}

}
