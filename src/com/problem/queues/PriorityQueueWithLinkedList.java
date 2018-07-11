package com.problem.queues;

import java.util.TreeMap;

public class PriorityQueueWithLinkedList {

	Node head;
	
	TreeMap<Integer, Node> sortingMap = new TreeMap<>();

	class Node {
		String data;
		int priority;
		Node next;

		public Node(String data, int priority) {
			this.data = data;
			this.next = null;
			this.priority = priority;
		}
	}

	/*
	 * in priority queues, each item in the queue will have the data and an
	 * associated priority with it, we insert an item with a given priority into the
	 * queue such that the item with the highest priority is always at the front end
	 * of the queue so that, the item with highest priority will be the first to be
	 * popped, or for peeking
	 */
	private void insertIntoPriorityQueue(String data, int priority) {
		
		Node newNode = new Node(data, priority);
		/*
		 * if the priority is more than the priority of head node, then directly push at
		 * first place, because the new node should be in the first place from the front
		 * end..
		 */
		if ((head == null) || (priority > head.priority)) {
			newNode.next = head;
			head = newNode;
		}
		/*
		 now when we are inserting a new node, we add the node at the ending of the list, and add it to the sorting map to get the highest priority value
		 while popping from the queue, so every time we pop and element, we retrieve the highest value i.e the last entry from the tree map and return it
		 */
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			newNode.next = null;
			temp.next = newNode;
		}
		
		this.sortingMap.put(newNode.priority, newNode);

	}

	private Node getHighestValueInTheBeginning() {
		return sortingMap.pollLastEntry().getValue();
	}

	private String getItemWithHighestPriority() {
		if (head == null) {
			return "queue is empty";
		}
		return head.data;
	}

	private int popItemWithHighestPriority() {
		if (head == null) {
			return -1;
		}
		return getHighestValueInTheBeginning().priority;
	}

	private void printQueue() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.priority);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		PriorityQueueWithLinkedList priorityQueue = new PriorityQueueWithLinkedList();
		// for(int i=10;i<=50;i=i+10) {
		// priorityQueue.insertIntoPriorityQueue(new Integer(i).toString(), i/10);
		// }

		priorityQueue.insertIntoPriorityQueue(new Integer(80).toString(), 8);
		priorityQueue.insertIntoPriorityQueue(new Integer(50).toString(), 11);
		priorityQueue.insertIntoPriorityQueue(new Integer(90).toString(), 5);
		priorityQueue.insertIntoPriorityQueue(new Integer(70).toString(), 6);
		priorityQueue.insertIntoPriorityQueue(new Integer(60).toString(), 1);

		// priorityQueue.printQueue();

		System.out.println(priorityQueue.popItemWithHighestPriority());
		System.out.println(priorityQueue.popItemWithHighestPriority());
		System.out.println(priorityQueue.popItemWithHighestPriority());
		System.out.println(priorityQueue.popItemWithHighestPriority());
		System.out.println(priorityQueue.popItemWithHighestPriority());
	}

}
