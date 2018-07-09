package com.problem.linkedlists;

public class CompareStringsAsLinkedLists {

	Node head;
	Node head1, head2;

	class Node {
		char data;
		Node next;

		public Node(char data) {
			this.data = data;
			this.next = null;
		}
	}

	private void insertInFirstPlace(int listIndex, char data) {
		Node newNode = new Node(data);
		if (listIndex == 1) {
			newNode.next = head1;
			head1 = newNode;
			return;
		}
		newNode.next = head2;
		head2 = newNode;
	}

	private void insertInLastPlace(int listIndex, char data) {
		if (isListEmpty(listIndex)) {
			System.out.println("list is empty.. inserting in first place");
			insertInFirstPlace(listIndex, data);
			return;
		}
		Node temp = null;
		if (listIndex == 1)
			temp = head1;
		else
			temp = head2;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
	}

	private boolean isListEmpty(int listIndex) {
		if (listIndex == 1)
			return head1 == null;
		return head2 == null;
	}

	private int calculatSize(int listIndex) {
		Node temp = null;
		if (listIndex == 1) {
			temp = head1;
		} else
			temp = head2;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	private void printList(int listIndex) {
		Node temp = null;
		if (listIndex == 1) {
			temp = head1;
		} else
			temp = head2;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private boolean compareStringsAsLinkedLists() {
		if (calculatSize(1) != calculatSize(2)) {
			System.out.println("Strings are not equal due to different sizes");
			return false;
		}
		if (head1 == null && head2 == null) {
			System.out.println("strings are equal as they are null");
			return true;
		}
		Node temp1 = head1, temp2 = head2;
		while (temp1.next != null && temp2.next != null) {
			if (temp1.data != temp2.data) {
				System.out.println("strings are not equal due to different contents");
				return false;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return true;
	}

	public static void main(String[] args) {
		CompareStringsAsLinkedLists linkedLists = new CompareStringsAsLinkedLists();
		linkedLists.insertInLastPlace(1, 'r');
		linkedLists.insertInLastPlace(1, 'o');
		linkedLists.insertInLastPlace(1, 'h');
		linkedLists.insertInLastPlace(1, 'i');
		linkedLists.insertInLastPlace(1, 't');
		linkedLists.insertInLastPlace(1, 'h');
		System.out.println("____________");
		linkedLists.printList(1);
		linkedLists.insertInLastPlace(2, 'r');
		linkedLists.insertInLastPlace(2, 'o');
		linkedLists.insertInLastPlace(2, 'h');
		linkedLists.insertInLastPlace(2, 'i');
		linkedLists.insertInLastPlace(2, 't');
		linkedLists.insertInLastPlace(2, 'h');
		System.out.println("____________");
		linkedLists.printList(2);
		if(linkedLists.compareStringsAsLinkedLists()) {
			System.out.println("the Strings are equal...");
		}
		
	}

}
