package com.problem.linkedlists;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RemovingDulicatesFromSortedLinkedList {

	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void insertInPosition(int position, int data) {
		if (position == 1) {
			insertInFirstPlace(data);
			return;
		}

		if (position == getSizeOfList() + 1) {
			insertInLastPlace(data);
			return;
		}

		Node previous = head, current = head.next;
		for (int i = 2; i < getSizeOfList(); i++) {
			if (i == position)
				break;
			previous = previous.next;
			current = current.next;
		}

		/*
		 * now we have to insert the node node between previous and current nodes, i.e
		 * if we want to insert the node at third , then the node previously at third
		 * position will now move to fourth position
		 */

		Node newNode = new Node(data);
		previous.next = newNode;
		newNode.next = current;
	}

	private int getSizeOfList() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private void insertInLastPlace(int data) {
		Node lastNode = getLastNode();
		Node newNode = new Node(data);
		lastNode.next = newNode;
		newNode.next = null;
	}

	private Node getLastNode() {
		Node temp = head;
		while (temp.next != null)
			temp = temp.next;
		return temp;
	}

	private void insertInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	private void removeDuplicatesFromLinkedList() {
		Map<Integer, Integer> values = new HashMap<>();
		Node temp = head;
		while (temp != null) {
			if (values.containsKey(temp.data))
				values.put(temp.data, values.get(temp.data) + 1);
			else
				values.put(temp.data, 1);
			temp = temp.next;
		}

		Iterator<Map.Entry<Integer, Integer>> mapIterator = values.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Entry<Integer, Integer> entry = mapIterator.next();
			if (entry.getValue() > 1) {
				System.out.println("found duplicate .." + entry.getKey());
				// now all the nodes having data as this need to be deleted.
				deleteNodesWithData(entry.getKey());
				System.out.println();

			}
		}

	}

	private void deleteNodesWithData(int data) {
		Node temp = head;
		Node startingPoint = null;
		while (temp.next != null) {
			if (temp.data == data) {
				startingPoint = temp;
				break;
			}
			temp = temp.next;
		}
		// now we have to delete all nodes from the next node of starting point till the
		// end with the same data
		Node current = startingPoint.next.next, previous = startingPoint.next;
		while (current != null) {
			//this is for the case that immediately after the first occurence, the second occurence is found, so we
			// compare it with the previous pointers data
			if(previous.data == data) {
				startingPoint.next = current;
			}
			if (current.data == data) {
				previous.next = current.next;
				current.next = null;
			}
			current = current.next;
			previous = previous.next;
		}
	}

	public static void main(String[] args) {
		RemovingDulicatesFromSortedLinkedList linkedList = new RemovingDulicatesFromSortedLinkedList();
		linkedList.insertInPosition(1, 10);
		linkedList.insertInPosition(1, 10);
		linkedList.insertInPosition(2, 20);
		linkedList.insertInPosition(3, 30);
		linkedList.insertInPosition(2, 15);
		linkedList.insertInPosition(4, 25);
		linkedList.insertInPosition(6, 35);
		linkedList.insertInPosition(4, 10);
		linkedList.insertInPosition(6, 25);
		linkedList.insertInPosition(9, 30);

		linkedList.printList();
		System.out.println("_____________");
		linkedList.removeDuplicatesFromLinkedList();
		linkedList.printList();
	}

}
