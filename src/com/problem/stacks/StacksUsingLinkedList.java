package com.problem.stacks;

public class StacksUsingLinkedList {
	
	private Node top;

	public static void main(String[] args) {
		StacksUsingLinkedList linkedList = new StacksUsingLinkedList();
		linkedList.push(10);
		linkedList.push(20);
		linkedList.push(45);
		linkedList.push(60);
		linkedList.pop();
		System.out.println("the size of the stack is "+linkedList.getSizeOfStack());
		linkedList.printList();
		System.out.println(linkedList.peek());
	}

	//pushing is inserting node in first place LIFO
	private void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	
	//popping in deleting node from the first place LIFO
	private void pop() {
		if(isEmpty())
		{
			System.out.println("stack is empty, underflow error");
			return;
		}
		Node temp = top;
		top = top.next;
		temp.next = null;
	}
	
	private int peek() {
		if(isEmpty())
		{
			System.out.println("stack is empty, peek failed");
			return -1;
		}
		return top.data;
	}
	
	private boolean isEmpty() {
		return top == null;
	}
	
	private int getSizeOfStack() {
		Node temp = top;
		int count = 0;
		while(temp!=null) {
			count++;
		
			temp = temp.next;
		}
		
		return count;
	}
	
	private void printList() {
		Node temp = top;
		while(temp!=null) {
			System.out.println(temp.data);
			
			temp = temp.next;
		}
	}
	
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
