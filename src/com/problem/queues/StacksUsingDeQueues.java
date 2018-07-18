package com.problem.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StacksUsingDeQueues {

	static Deque<Integer> doubleEndedQueue;
	
	public StacksUsingDeQueues() {
		doubleEndedQueue = new ArrayDeque<>();
	}

	private static void pushToStack(int data) {
		doubleEndedQueue.push(data);
	}

	private static int popFromStack() {
		return doubleEndedQueue.pollFirst();
	}

	public static void main(String[] args) {
		StacksUsingDeQueues stacksUsingQueues = new StacksUsingDeQueues();
		for (int i = 10; i <= 50; i = i + 10)
			pushToStack(i);
		
		for (int i = 10; i <= 50; i = i + 10)
			System.out.println(popFromStack());

	}

}
