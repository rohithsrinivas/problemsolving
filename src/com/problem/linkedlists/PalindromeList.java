package com.problem.linkedlists;

public class PalindromeList {

	Node head, left;

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

	private int getSizeOfTheList() {
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

	private Node findTheMiddleNodeOfLinkedList() {
		Node fast = head, slow = head;
		while (fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == null) {
				break;
			}
		}
		return slow;

		// now the slow node will hold the middle of the linked list
	}

	private boolean reverseLinkedList() {
		Node previousNode = null, currentNode = head, nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}

		head = previousNode;

		return false;
	}

	private boolean isListPalindrome(Node head) {
		return isPalindromeUtil(head);
	}

	/* the main idea to find if its palindrome is to compare the first and last nodes and then the second and second last nodes and so on upto middle, but we
	 * cannot traverse backwards from the last node in a single linked list, so we use recursion i.e we use the recursive call stack as the container for
	 * storing the values in the linked list that we need to compare, initially we pass head as the right pointer, then we call the recursive function again
	 * for right.next and this will continue until last node i.e when right.next will be null, now we are at the last node, and left is pointing to the head 
	 * of the linked list, now we compare head with last node, and return the result, i.e if the outer node sublist of 1,n-1 is equal(returns true) then
	 * we move to 2,n-2 then 3,n-3 and so on.. we can break and return false the moment we find an un-equal sublist of left and right data pointers */
	private boolean isPalindromeUtil(Node right) {
		left = head;

		/* this is the terminating condition for recursion. i.e when the right pointer reaches null, and we did not return false, that means all the sub-lists
		 * of left and right pointers are equal*/
		if (right == null) {
			return true;
		}
		
		/* this flag is for checking the equality of sub-lists, if at any stage the sub-lists are not equal, we break and return false
		 * initially before any comparisons, this will help reach the last node of the list, hence retaining all the previous nodes in the recursion call 
		 * stack, so that we can use them later while we want to compare sub lists*/
		boolean flag1 = isPalindromeUtil(right.next);
		if(!flag1)
			return false;
		
		/* this flag will be returned at each stage to compare if the data from the left and right pointers are equal*/
		boolean flag2 = (right.data == left.data);
		
		/* this is because we also need to move the left pointer by one node for the next step of recursion*/
		left = left.next;
		
		return flag2;
	}

	public static void main(String[] args) {
		PalindromeList linkedList = new PalindromeList();
		linkedList.insertInFirstPlace(10);
		linkedList.insertInLastPlace(20);
		linkedList.insertInLastPlace(30);
		linkedList.insertInLastPlace(40);
		linkedList.insertInLastPlace(50);
		for (int i = 60; i >= 10; i = i - 10) {
			linkedList.insertInLastPlace(i);
		}
		linkedList.printList();
		linkedList.reverseLinkedList();
		linkedList.printList();
		System.out.println("the middle of the linked list is : " + linkedList.findTheMiddleNodeOfLinkedList().data);
		if(linkedList.isListPalindrome(linkedList.head))
			System.out.println("list is palindrome");
		else
			System.out.println("list is not palindrome");
	}

}
