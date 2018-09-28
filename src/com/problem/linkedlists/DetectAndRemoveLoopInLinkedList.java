package com.problem.linkedlists;

public class DetectAndRemoveLoopInLinkedList {

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
		if(isListEmpty())
		{
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

	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
		System.out.println("first node successfully deleted..");
	}
	
	private void deleteLastNode() {
		if(doesListHaveOneNode()) {
			deleteFirstNode();
			return;
		}
		Node prev = head,current = head.next;
		while(current.next != null) {
			current = current.next;
			prev = prev.next;
		}
		prev.next = null;
	}
	
	private void addAfterNode(int data,int afterData) {
		Node temp = head;
		while(temp.next != null) {
			if(temp.data == afterData) {
				break;
			}
			temp = temp.next;
		}
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	private void addBeforeNode(int data,int beforeData) {
		Node current = head.next,prev = head;
		while(current.next != null) {
			if(current.data == beforeData)
				break;
			prev = prev.next;
			current = current.next;
		}
		
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = current;
	}

	private boolean isListEmpty() {
		return head == null;
	}
	
	private boolean doesListHaveOneNode() {
		return head != null && head.next == null;
	}
	
	/* for detecting the loop in a linked list, we use the floyd algorithm which contains two pointers, fast and slow,
	 * where in the fast one will move by 2 nodes and slow one by one node, if at all there is a loop in the linked list
	 * , the fast pointer (which will be the first to reach the end) will never reach null because the last one is pointing
	 * to one of the previous nodes instead of pointing to null, so if at anypoint the fast pointer will meet the slow
	 * pointer, there is definitely a loop in the linked list*/
	private boolean doesListHaveALoop(Node head) {
		Node fast = head,slow = head;
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				System.out.println("loop found !!!! at "+slow.data);
				removeLoop(slow,head);
				return true;
			}
		}
		return false;
	}
	
	/* we use the floyd algorithm based approach again, once find a loop first we need to count the number of nodes
	 * in the linked list that are in a loop, for that start counting from the point where we find a loop and then continue to count until the next
	 * pointer of the current node points to the node where we started counting from, hence signifying the concept of a loop, the initial count should be 1 
	 * because we should count the node from where we start as well.let it be k
	 * 
	 * after finding the number of nodes in the loop, fix one pointer to head and the next at k nodes from the head, move both the pointers with same speed
	 * , they will meet at the loop starting node, now traverse to the end of the loop and change the next reference of the ending node of the loop to null,
	 * now there is no loop in the list as the end points to null*/
	private void removeLoop(Node slow, Node head) {
		Node temp1 = slow;
		Node temp2 = temp1;
		int k = 1;
		/* this will count the number of nodes */
		while(temp1.next != temp2) {
			k++;
			temp1 = temp1.next;
		}
		System.out.println("number of nodes in loop starting from "+temp2.data+" is "+k);
		System.out.println("deleting loop from list..");
		temp1 = head;
		for(int i=0;i<k;i++)
			temp2 = temp2.next;
		/* by the end of the loop we will point to the starting node of the loop*/
		while(temp1 != temp2) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		/* now we reached the starting node of the loop, now we need to traverse to the end of the loop and change the next reference to null */
		while(temp2.next != temp1) {
			temp2 = temp2.next;
		}
		/* now we need to point the end of the loop to null to avoid infinite traversal i.e the loop ,hence removing the loop*/
		temp2.next = null;
	}

	private void printlist() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" --> ");
			if(temp.next == null)
				System.out.print("NULL");
			temp = temp.next;
		}
	}
	
		public static void main(String[] args) {
		DetectAndRemoveLoopInLinkedList linkedList = new DetectAndRemoveLoopInLinkedList();
		linkedList.insertInLastPlace(20); 
		linkedList.insertInLastPlace(4); 
		linkedList.insertInLastPlace(15); 
		//linkedList.addBeforeNode(3,	4);
		//linkedList.addAfterNode(56, 15);
		linkedList.insertInLastPlace(10); 
          
		linkedList.head.next.next.next.next = linkedList.head.next;
		//System.out.println("before removing loop..");
		System.out.println("after removing loop");
		linkedList.doesListHaveALoop(linkedList.head);
		linkedList.printlist();
	}

}
