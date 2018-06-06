package com.problem.linkedlists;

public class DoublyLinkedList {

	Node head;

	class Node {
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	private void insertInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.prev = null;
		newNode.next = head;
		head = newNode;
		//System.out.println("Node inserted in first place");
	}

	private void insertInTheLastPlace(int data) {
		if (head == null) {
			System.out.println("list empty!!");
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
		newNode.prev = temp;
		//System.out.println("node inserted in the last place");
	}

	// always move from right to left while modifying pointers, its easy to decode
	private void insertNodeAtPosition(int data, int position) {
		if (position == 1) {
			insertInFirstPlace(data);
			return;
		}

		if (position == getSizeOfList() + 1) {
			insertInTheLastPlace(data);
			return;
		}

		Node temp = head.next;
		for (int i = 2; i < getSizeOfList(); i++) {
			if (position == i)
				break;

			temp = temp.next;
		}

		Node previous = temp.prev;
		Node newNode = new Node(data);
		temp.prev = newNode;
		newNode.next = temp;
		newNode.prev = previous;
		previous.next = newNode;

	}

	private void insertNodeAfterNode(int data, int afterData) {
		if (head == null) {
			System.out.println("list empty!!");
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == afterData)
				break;

			temp = temp.next;
		}

		Node newNode = new Node(data);
		temp.next.prev = newNode;
		newNode.next = temp.next;
		temp.next = newNode;
		newNode.prev = temp;
	}

	// always use 2 pointers while inserting before a node because, it will
	// complicate the procedure if you use
	// one pointer and try to use the prev value of it..
	private void insertNodeBeforeNode(int data, int beforeData) {
		if (head == null) {
			System.out.println("list empty!!");
			return;
		}
		Node current = head.next;
		Node previous = head;
		while (current.next != null) {
			if (current.data == beforeData)
				break;

			current = current.next;
			previous = previous.next;
		}

		Node newNode = new Node(data);
		current.prev = newNode;
		newNode.next = current;
		previous.next = newNode;
		newNode.prev = previous;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	// simply make the head pointer point to the next value, as that is the new head
	// now
	private void deleteFirstNode() {
		head = head.next;
		head.prev = null;
	}

	// after finding the last node, assign that node with the prev value of it, so
	// that the last node is now
	// no longer part of the list
	private void deleteLastNode() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp = temp.prev;
		temp.next = null;
	}

	private void deleteNodeAtPos(int position) {
		if (position == 1) {
			deleteFirstNode();
			return;
		}
		if (position == getSizeOfList()) {
			deleteLastNode();
			return;
		}
		Node temp = head.next;
		for (int i = 2; i < getSizeOfList(); i++) {
			if (position == i) {
				break;
			}
			temp = temp.next;
		}

		// now we have to delete temp node
		// this is an alternative procedure to avoid confusion
		// Node previousNode = temp.prev;
		// Node nextNode = temp.next;
		// previousNode.next = nextNode;
		// nextNode.prev = previousNode;

		temp.next.prev = temp.prev;
		temp.prev.next = temp.next;
	}

	private int getSizeOfList() {
		int counter = 0;
		Node temp = head;
		while (temp != null) {
			counter++;
			temp = temp.next;
		}

		return counter;
	}
	
	/* while checking if a list is palindrome, use two pointers, starting from either ends of the linked list,
	 * then start moving both of them in opposite directions, if the size is odd then they will meet at the middle
	 * node, so the breaking condition will be that they should not be equal, once they are, break from the loop, we
	 * check that the first and last elements are same and so on,.....
	 * if the size is even, then the two middle terms should be equal, which means the while loop is broken
	 * implying they are equal, so the list is palindrome*/

	private boolean checkIfListIsPalindrome() {
		Node temp = head;
		Node first = head, last = null;
		while (temp.next != null) {
			temp = temp.next;
		}
		last = temp;
			while (first.next != last.prev) {
				if (first.data != last.data)
					return false;

				first = first.next;
				last = last.prev;
			}
			
			// when its an even list, then first.next and last.prev will be equal, in which case, we can conclude
			// the list is palindrome
			return true;		

	}

	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		// doublyLinkedList.insertInFirstPlace(10);
		// doublyLinkedList.printList();
		// System.out.println("____________________________");
		// doublyLinkedList.insertInTheLastPlace(12);
		// doublyLinkedList.printList();
		// System.out.println("____________________________");
		// doublyLinkedList.insertInTheLastPlace(10);
		// doublyLinkedList.printList();
		// System.out.println("____________________________");
		// doublyLinkedList.insertNodeAfterNode(15, 10);
		// doublyLinkedList.printList();
		// System.out.println("____________________________");
		// doublyLinkedList.insertNodeBeforeNode(12, 15);
		// doublyLinkedList.printList();
		// System.out.println("____________________________");
		// doublyLinkedList.insertNodeAtPosition(56, 3);
		// doublyLinkedList.printList();
		// System.out.println("____________________________");
		//// System.out.println("____________________________");
		// System.out.println(" node 4 to be deleted");
		// doublyLinkedList.deleteNodeAtPos(4);

		doublyLinkedList.insertInFirstPlace(10);
//		for (int i = 20; i <= 40; i = i + 10) {
//			doublyLinkedList.insertInTheLastPlace(i);
//		}
//		doublyLinkedList.insertInTheLastPlace(50);
//		for (int i = 50; i >= 10; i = i - 10) {
//			doublyLinkedList.insertInTheLastPlace(i);
//		}
		doublyLinkedList.insertInTheLastPlace(20);
		doublyLinkedList.insertInTheLastPlace(30);
		doublyLinkedList.insertInTheLastPlace(30);;
		doublyLinkedList.insertInTheLastPlace(20);
		doublyLinkedList.insertInTheLastPlace(10);
		doublyLinkedList.printList();
		if(doublyLinkedList.checkIfListIsPalindrome())
			System.out.println("the list is palindrome !!");
		else
			System.out.println("the list is not palindrome ..");
	}

}
