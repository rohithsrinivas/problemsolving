package com.problem.linkedlists;

/* let us say a number is represented as a linked list like 1->9->9->9 , adding 1 to it should give us the linked list
 * as output containing 2000 */
public class Add1ToNumberAsLinkedList {

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
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
	}

	private void deleteFromFirstPlace() {
		Node temp = head;
		head = temp.next;
		temp.next = null;
	}

	private void deleteFromLastPlace() {
		Node previous = head, current = head.next;
		while (current.next != null) {
			previous = previous.next;
			current = current.next;
		}
		previous.next = null;
	}

	private void reverseLinkedList() {
		Node previousNode = null, current = head, nextNode = null;
		while (current != null) {
			nextNode = current.next;
			current.next = previousNode;
			previousNode = current;
			current = nextNode;
		}
		head = previousNode;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/* idea is to reverse the list first before addition because we always start addition from the end, so after reversing, for the first node use a flag,
	 * add one to it and check if it is greater than 10, if not, we simply increment the current node and break, as there is no need to go further due to
	 * no carry , if there is a carry for the first node, then we increment the next node's data by 1 and set the current node's data to 0. and this continues
	 * after adding is done, now reverse the list..*/
	private void add1ToNumberAsLinkedList() {
		Node temp = head;
		boolean isFirst = true;
		while (temp.next != null) {
			/* we need to add 1 for the first node irrespective of a carry, so if it is first, increment it and set the flag to false, as the parsing is now
			 * done for the first node*/
			if (isFirst) {
				++temp.data;
				isFirst = false;
			}
			/* if the first node has a carry, then we set it to 0 and increment the next node's data by 1, from now on, the first if condition will not run
			 * as it is the second, third,... so on.*/
			if (temp.data >= 10) {
				temp.data = 0;
				++temp.next.data;
			}

			/*no carry for the first node, so simply break from the loop*/
			else
				break;
			temp = temp.next;
		}

		/* now the temp pointer points to the last node, now if still this node's value is greater than 10, which means it has a carry, we need to create a 
		 * new node with data as 1 and the last node as 0... this is executed under the input of 99, 999, 9999 where it there will be one more digit like
		 * 100,1000,10000 etc*/
		if (temp.data >= 10) {
			temp.data = 0;
			Node newNode = new Node(1);
			temp.next = newNode;
			newNode.next = null;
		}

	}

	public static void main(String[] args) {
		Add1ToNumberAsLinkedList linkedList = new Add1ToNumberAsLinkedList();
		linkedList.insertInFirstPlace(9);
		linkedList.insertInLastPlace(9);
		linkedList.insertInLastPlace(9);
		linkedList.insertInLastPlace(9);
		System.out.println("____________ before reversing");
		linkedList.printList();
		linkedList.reverseLinkedList();
		System.out.println("____________after reversing");
		linkedList.printList();
		linkedList.add1ToNumberAsLinkedList();
		System.out.println("_______________after adding 1");
		linkedList.reverseLinkedList();
		linkedList.printList();
	}
}
