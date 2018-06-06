package com.problem.stacks;

public class StackSorting {
	
	static class CustomStack{
		int top ;
		int maxSize;
		int[] stackArray;
		
		public CustomStack(int maxSize) {
			this.maxSize = maxSize;
			this.top = -1;
			this.stackArray = new int[maxSize];
		}
		
		private  void push(int data) {
			if(isFull()) {
				System.out.println("stack overflow...");
				return;
			}
			
			this.stackArray[++top] = data;
		}
		
		private int pop() {
			if(isEmpty())
			{
				System.out.println("stack underflow...");
				return -1;
			}
			
			return this.stackArray[top--];
		}
		
		private int peek() {
			return this.stackArray[top];
		}
		
		private boolean isFull() {
			return top >= this.maxSize-1;
		}
		
		private boolean isEmpty() {
			return top == -1;
		}
		
		private void sortStack() {
			int leastIndex = 0;
			for(int i=0;i<top;i++) {
				leastIndex = i;
				for(int j=i+1;j<=top;j++) {
					if(stackArray[j] < stackArray[leastIndex]) {
						leastIndex = j;
					}
				}
				
				int temp = stackArray[i];
				stackArray[i] = stackArray[leastIndex];
				stackArray[leastIndex] = temp;
			}
			
			printStack();
		}

		private void printStack() {
			for(int i = 0;i<=top;i++) {
				System.out.println(stackArray[i]);
			}
			
		}
	}

	public static void main(String[] args) {
		CustomStack stack = new CustomStack(10);
		stack.push(10);
		stack.push(45);
		stack.push(31);
		stack.push(9);
		stack.sortStack();
	}

}
