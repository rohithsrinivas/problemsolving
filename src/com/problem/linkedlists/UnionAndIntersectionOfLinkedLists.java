package com.problem.linkedlists;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UnionAndIntersectionOfLinkedLists {

	Node head;

	private static Map<Integer, Integer> counts1 = new LinkedHashMap<>();
	private static Map<Integer, Integer> counts2 = new LinkedHashMap<>();
	public UnionAndIntersectionOfLinkedLists unionList;
	public UnionAndIntersectionOfLinkedLists intersectionList;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void insertInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	private void insertInLastPlace(int data) {
		if (isListEmpty()) {
			insertInFirstPlace(data);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
	}

	private boolean isListEmpty() {
		return head == null;
	}

	private void insertBeforeNode(int data, int beforeData) {
		Node prev = head, current = head.next;
		while (current.next != null) {
			if (beforeData == current.data)
				break;
			current = current.next;
			prev = prev.next;
		}
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = current;
	}

	private void insertAfterNode(int data, int afterData) {
		Node temp = head;
		while (temp.next != null) {
			if (afterData == temp.data)
				break;
			temp = temp.next;
		}
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
	}

	private boolean listContainsOneNode() {
		return head != null && head.next == null;
	}

	private void deleteFirstNode() {
		if (isListEmpty()) {
			System.out.println("the list is empty.. deletion failed");
			return;
		}
		Node temp = head;
		head = temp.next;
	}

	private void deleteLastNode() {
		Node prev = head, current = head.next;
		while (current.next != null) {
			current = current.next;
			prev = prev.next;
		}
		prev.next = null;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/*
	 * the idea is to simply traverse to the end of the first list and change the
	 * pointer reference from null to the head of the second head, as a result , now
	 * they are merged
	 */
	private static void mergeLinkedLists(Node head1, Node head2) {
		Node temp = head1;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head2;
	}

	/*
	 * while we are finding the intersection of two linked lists, we count the
	 * occurrences and store them in a map for both the lists, we insert all the
	 * counts in the map and then iterate through each element of the map and then
	 * check if it exists in the second map, if yes then that's a common element
	 * print it or store it in another linked list
	 */
	private void intersectionOfLinkedLists(Node head1, Node head2) {
		countOccurences(head1, 1);
		countOccurences(head2, 2);
		Iterator<Map.Entry<Integer, Integer>> mapIterator = counts1.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Entry<Integer, Integer> currentNode = mapIterator.next();
			if (counts2.containsKey(currentNode.getKey())) {
				addToIntersectionList(currentNode.getKey());
			}
		}
	}

	private void unionOfLinkedLists(Node head1, Node head2) {
		Node temp = head1;
		while (temp != null) {
			addToUnionList(temp.data);
			temp = temp.next;
		}
		temp = head2;
		while(temp != null) {
			if(!isPresentInUnionList(temp.data)) {
				addToUnionList(temp.data);
			}
			temp = temp.next;
		}
	}
	
	private void printUnionList() {
		Node temp = unionList.getFirstNode();
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	private void printIntersectionList() {
		Node temp = intersectionList.getFirstNode();
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private boolean isPresentInUnionList(int data) {
		Node temp = unionList.getFirstNode();
		while(temp != null) {
			if(temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	private void addToUnionList(int data) {
		if(unionList == null)
		unionList = new UnionAndIntersectionOfLinkedLists();
		unionList.insertInLastPlace(data);
	}

	private void addToIntersectionList(int data) {
		if(intersectionList == null)
		intersectionList = new UnionAndIntersectionOfLinkedLists();
		intersectionList.insertInLastPlace(data);
	}

	private static void countOccurences(Node head, int listIndex) {
		Node temp = head;
		while (temp != null) {
			if (listIndex == 1)
				counts1.put(temp.data, 1);
			else
				counts2.put(temp.data, 1);
			temp = temp.next;
		}
	}

	private Node getFirstNode() {
		return head;
	}

	public static void main(String[] args) {
		UnionAndIntersectionOfLinkedLists linkedList1 = new UnionAndIntersectionOfLinkedLists();
		for (int i = 10; i <= 50; i = i + 10)
			linkedList1.insertInLastPlace(i);
		linkedList1.insertBeforeNode(15, 20);
		linkedList1.insertAfterNode(35, 30);
		linkedList1.printList();
		linkedList1.deleteFirstNode();
		linkedList1.deleteLastNode();
		linkedList1.insertInLastPlace(150);
		linkedList1.insertInLastPlace(400);
		System.out.println("_____________");
		linkedList1.printList();
		System.out.println("first list ends _____________");
		UnionAndIntersectionOfLinkedLists linkedList2 = new UnionAndIntersectionOfLinkedLists();
		for (int i = 100; i <= 500; i = i + 100)
			linkedList2.insertInLastPlace(i);
		linkedList2.insertBeforeNode(150, 200);
		linkedList2.insertAfterNode(350, 300);
		linkedList2.insertInLastPlace(40);
		linkedList2.insertInLastPlace(15);
		linkedList2.insertInLastPlace(300);
		linkedList2.printList();
		linkedList2.deleteFirstNode();
		// linkedList2.deleteLastNode();
		System.out.println("_____________");
		linkedList2.printList();
		//System.out.println("printing common elements from both lists");
		UnionAndIntersectionOfLinkedLists finalList = new UnionAndIntersectionOfLinkedLists();
		//finalList.intersectionOfLinkedLists(linkedList1.getFirstNode(), linkedList2.getFirstNode());
		//System.out.println("lists merged (((((((((((((((((");
		//mergeLinkedLists(linkedList1.getFirstNode(), linkedList2.getFirstNode());
		linkedList1.printList();
		finalList.intersectionOfLinkedLists(linkedList1.getFirstNode(), linkedList2.getFirstNode());
		finalList.unionOfLinkedLists(linkedList1.getFirstNode(), linkedList2.getFirstNode());
		System.out.println("final output./....._________________");
		System.out.println("intersection of lists-->");
		finalList.printIntersectionList();
		System.out.println("union of lists -->");
		finalList.printUnionList();
	}

}
