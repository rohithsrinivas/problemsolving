package com.problem.linkedlists;

public class ReversingSingleLinkedList {

	Node head;

	class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}

	private void insertAtPosition(int data, int position) {
		if (position == 1) {
			insertAtFirstPlace(data);
			return;
		}

		if (position == getSizeOfList() + 1) {
			insertAtLastPlace(data);
			return;
		}
		Node temp = head.next;

		for (int i = 2; i < getSizeOfList(); i++) {
			if (position == i)
				break;

			temp = temp.next;
		}

		insertBeforeNode(data, temp.data);

	}

	private void insertBeforeNode(int data, int beforeData) {
		Node current = head.next, previous = head;
		while (current.next != null) {
			if (current.data == beforeData) {
				break;
			}

			current = current.next;
			previous = previous.next;
		}

		Node newNode = new Node(data);
		previous.next = newNode;
		newNode.next = current;
	}

	private void insertAfterNode(int data, int afterData) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == afterData)
				break;
			temp = temp.next;
		}
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;

	}

	private void insertAtFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	private void insertAtLastPlace(int data) {
		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
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
	
	private void deleteFirstNode() {
		if(head == null)
		{
			System.out.println("list empty!!");
			return;
		}
		
		Node temp = head;
		head = head.next;
		temp.next = null;
	}
	
	
	private void deleteLastNode() {
		Node current = head.next,previous = head;
		while(current.next!=null) {
			
			current = current.next;
			previous = previous.next;
		}
		previous.next = null;
		current.next = null;
		
	}
	
	private void deleteAtPosition(int position) {
		if(position==1) {
			deleteFirstNode();
			return;
		}
		
		if(position == getSizeOfList()) {
			deleteLastNode();
			return;
		}
		
		Node current = head.next,previous = head;
		for(int i=2;i<getSizeOfList();i++) {
			if(position == i)
				break;
			
			current = current.next;
			previous = previous.next;
		}
		
		//now we should delete the current node
		
		previous.next = current.next;
		current.next = null;
		
		
	}
	
	/*use 3 pointers previous current and null, current will initially be head, and others will be null
	 * start looping from head and assign next reference of each node to its previous node*/
	private void reverseLinkedList() {
		Node previousNode = null,currentNode = head,nextNode = null;
		while(currentNode!=null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		
		//now after the loop, currentNode will point to the node next to the last node, so now previousNode
		// point to the actual last node, so now as we want to reverse the list, the last node should be the
		// first node, hence we make the last node (previousNode) the new head, so the list will start from the last
		head = previousNode;
	}
	
	private Node reverseWithRecursion(Node current,Node prev) {
		if(current.next == null) {
			head = current;
			current.next = prev;
			return head;
		}
		Node next = current.next;
		current.next = prev;
		return reverseWithRecursion(next, current);
	}
	
	private boolean isEmpty() {
		return head==null;
	}

	public static void main(String[] args) {
		ReversingSingleLinkedList linkedList = new ReversingSingleLinkedList();
		linkedList.insertAtPosition(10, 1);
		linkedList.insertAtPosition(20, 2);
		linkedList.insertAtPosition(15, 2);
		linkedList.insertAtPosition(30, 4);
		linkedList.insertAtPosition(25, 4);
		//linkedList.deleteAtPosition(1);
		//linkedList.deleteAtPosition(4);
		linkedList.printList();
		System.out.println(" reversing list .. __________________________");
		linkedList.reverseWithRecursion(linkedList.head, null);
		linkedList.printList();
	}

}
