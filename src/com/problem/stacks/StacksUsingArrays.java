package com.problem.stacks;

public class StacksUsingArrays {

	class CustomStack {

		int size;
		int[] stackArray;
		int top = -1;

		public CustomStack(int size) {
			this.size = size;
			this.stackArray = new int[size];
		}

		public void push(int data) {
			if (isFull()) {
				System.out.println("stack overflow.. !!!");
				return;
			}
			stackArray[++top] = data;
		}
		
		public int pop() {
			if(isEmpty()) {
				System.out.println("stack underflow .. !!");
				return -1;
			}
			return stackArray[top--];
		}

		public boolean isEmpty() {
			return top == -1;
		}

		public boolean isFull() {
			return top >= this.size - 1;
		}
		
		public void printStack() {
			for(int i=top;i>=0;i--) {
				System.out.println(stackArray[i]);
			}
		}
	}

	public static void main(String[] args) {
		CustomStack customStack = new StacksUsingArrays(). new CustomStack(5);
		customStack.push(10);
		customStack.push(20);
		customStack.push(30);
		customStack.push(40);
		customStack.push(50);
		customStack.push(60);
		customStack.printStack();
		System.out.println("____________");
		customStack.pop();
		customStack.pop();
		customStack.pop();
		customStack.printStack();
		customStack.pop();
		customStack.pop();
		customStack.pop();
		customStack.pop();
		System.out.println("_____ after ");;
		customStack.printStack();
		
	}

}
