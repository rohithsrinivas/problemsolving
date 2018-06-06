package com.problem.linkedlists;

/* use two pointers, one will move two places, and one will move by one place, so when 
 * the fast pointer reaches the last node, the slow pointer will point to the middle node*/
public class SingleLinkedList {
	
	static Node head;
	static int size;

	static class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public static void insertInFirstPlace(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		System.out.println("node inserted in first place");
	}
	
	public static void insertInLastPlace(int data) {
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
		System.out.println("node inserted in the last place..");
	}
	
	public static void insertAfterNode(int data,Node afterNode) {
		Node temp = head;
		while(temp.next!=null) {
			if(temp.data == afterNode.data) {
				//temp.next = afterNode.next;
				break;
			}
			temp = temp.next;
		}
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
		System.out.println("node successfully inserted after "+afterNode.data);
		
	}
	
	public static void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	private static void insertBeforeNode(int data, Node node) {
		Node current = head.next;
		Node prev = head;
		while(current.next!=null) {
			if(current.data == node.data) {
				//current.next = node.next;
				break;
			}
			current=current.next;
			prev=prev.next;
		}
		
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = current;
		
	}
	
	private static int getSizeOfTheList() {
		Node temp = head;
		int counter = 0 ;
		while(temp!=null) {
			counter++;
			temp = temp.next;
		}
		//System.out.println("the size of the linked list is "+(counter));
		size = counter;
		return counter;
		
	}
	
	/* We should decrement the position value because, we need to 
	 * find a node before the given position, so that we can insert the new node
	 * as a successor to the previous node. 
	 * for inserting at a particular position, you definitely need the for loop
	 * because in linked list, you cannot fetch the position of a particular node
	 * in the list.. so we use array for matching the position, once we find a match
	 * , we can insert the node after temp, and use the same logic as insert
	 * node after a given node..*/
	private static void insertNodeAtPosition(int position,int data) {
		if(position == 1) {
			insertInFirstPlace(data);
			
			return;
		}
		
		if(position == getSizeOfTheList()+1)
		{
			insertInLastPlace(data);
			
			return;
		}
		
		Node temp = head.next;
		for(int i=2;i<getSizeOfTheList();i++) {
			if(i == position) {
				break;
			}
			temp = temp.next;
		}
		insertBeforeNode(data, new Node(temp.data));
		
		
	}
	
	private static void deleteElementAtPosition(int position) {
		if(position == 1) {
			deleteFirstNode();
			
			return;
		}
		if(position == getSizeOfTheList()) {
			deleteLastNode();
			
			return;
		}
		
		Node current = head.next;
		Node previous = head;
		for(int i=2;i<getSizeOfTheList();i++) {
			if(i==position)
				break;
			
			current = current.next;
			previous = previous.next;
		}
		
		// now we should delete the 'current' named node..
		previous.next = current.next;
		current.next = null;
		
	}

	private static void deleteLastNode() {
		Node current = head.next;
		Node previous = head;
		while(current.next!=null) {
			current = current.next;
			previous = previous.next;
		}
		
		//now we have to delete the current node, making the previous node as the last node
		previous.next = null;
	}

	private static void deleteFirstNode() {
		Node temp = head;
		head = head.next;
		temp.next = null;
	}
	
	public static void main(String[] args) {
		insertInFirstPlace(10);
		insertInLastPlace(35);
		insertAfterNode(12, new Node(10));
		insertBeforeNode(78, new Node(35));
		//System.out.println(getSizeOfTheList());
		insertNodeAtPosition(4, 48);
		insertNodeAtPosition(5, 25);
		insertNodeAtPosition(7, 95);
		printList();
		System.out.println("_______________");
		System.out.println("4rd to be deleted");
		deleteElementAtPosition(4);
		printList();
//		getSizeOfTheList();
		
	}

	

	

	
}
