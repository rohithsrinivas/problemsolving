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
		 * now when we are inserting a new node, we add the node at the ending of the
		 * list, and add it to the sorting map to get the highest priority value while
		 * popping from the queue, so every time we pop and element, we retrieve the
		 * highest value i.e the last entry from the tree map and return it
		 */
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			newNode.next = null;
			temp.next = newNode;
		}

		/*
		 * we add it to the sorting map, with the priority of the node as the key and
		 * the node itself as the value, so that when we poll the last entry from the
		 * tree map, we always get the latest value..
		 */
		this.sortingMap.put(newNode.priority, newNode);

	}

	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
	}

	private void deleteNode(String data) {
		if (head == null) {
			System.out.println("list empty");
			return;
		}
		Node current = head.next, prev = head;
		boolean matchFound = false;
		while (current != null) {
			if (data == current.data) {
				matchFound = true;
				break;
			}
			current = current.next;
			prev = prev.next;
		}
		if (matchFound) {
			prev.next = current.next;
			current.next = null;
		}
	}

	private Node getHighestValueInTheBeginning() {
		/*
		 * polling the last entry will pop the item from the map and return the entry..
		 */
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
		Node highestValueNode = getHighestValueInTheBeginning();
		deleteNode(highestValueNode.data);
		return highestValueNode.priority;
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

		priorityQueue.insertIntoPriorityQueue(new Integer(80).toString(), 8);
		priorityQueue.insertIntoPriorityQueue(new Integer(50).toString(), 11);
		priorityQueue.insertIntoPriorityQueue(new Integer(90).toString(), 5);
		priorityQueue.insertIntoPriorityQueue(new Integer(70).toString(), 6);
		priorityQueue.insertIntoPriorityQueue(new Integer(60).toString(), 1);

		System.out.println(priorityQueue.popItemWithHighestPriority());
		System.out.println(priorityQueue.popItemWithHighestPriority());
		System.out.println(priorityQueue.popItemWithHighestPriority());
		System.out.println(priorityQueue.popItemWithHighestPriority());
		System.out.println(priorityQueue.popItemWithHighestPriority());
		
		priorityQueue.deleteFirstNode();

		System.out.println("__________");

		priorityQueue.printQueue();
	}

}
