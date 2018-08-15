package com.problem.linkedlists;

public class MergingLinkedLists {

	Node head;

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
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	/* the idea is to simply traverse to the end of the first list and change the pointer reference from null to the head of the second head, as a result
	 * , now they are merged*/
	private static void mergeLinkedLists(Node head1,Node head2) {
		Node temp = head1;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = head2;
	}
	
	private Node getFirstNode() {
		return head;
	}

	public static void main(String[] args) {
		MergingLinkedLists linkedList1 = new MergingLinkedLists();
		for (int i = 10; i <= 50; i = i + 10)
			linkedList1.insertInLastPlace(i);
		linkedList1.insertBeforeNode(15, 20);
		linkedList1.insertAfterNode(35, 30);
		linkedList1.printList();
		linkedList1.deleteFirstNode();
		linkedList1.deleteLastNode();
		System.out.println("_____________");
		linkedList1.printList();
		System.out.println("first list ends _____________");
		MergingLinkedLists linkedList2 = new MergingLinkedLists();
		for (int i = 100; i <= 500; i = i + 100)
			linkedList2.insertInLastPlace(i);
		linkedList2.insertBeforeNode(150, 200);
		linkedList2.insertAfterNode(350, 300);
		linkedList2.printList();
		linkedList2.deleteFirstNode();
		linkedList2.deleteLastNode();
		System.out.println("_____________");
		linkedList2.printList();
		System.out.println("lists merged (((((((((((((((((");
		mergeLinkedLists(linkedList1.getFirstNode(), linkedList2.getFirstNode());
		linkedList1.printList();
	}

}
