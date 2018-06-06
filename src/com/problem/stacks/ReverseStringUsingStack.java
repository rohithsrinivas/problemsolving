package com.problem.stacks;

public class ReverseStringUsingStack {
	
	/*  the idea is to simply push all the elements to the stack and pop them one by one and put it 
	 * into another string, which will return the reverse of the string...*/
	static public class CustomStack{
		int top;
		int maxSize;
		Character[] stackArray;
		
		public CustomStack(int maxSize) {
			this.top = -1;
			this.stackArray = new Character[maxSize];
			this.maxSize = maxSize;
		}
		
		private void push(char c) {
		
			if(top >= maxSize-1) {
				System.out.println("stack overflow");
				return;
			}
			
			stackArray[++top] = c;
		}
		
		private char pop() {
			if(top == -1)
			{
				System.out.println("stack underflow...");
				return '\0';
			}
			
			return stackArray[top--];
			
		}
		
		private int getStackSize() {
			int count = 0;
			for(int i=top;i>=0;i--) {
				count++;
			}
			return count;
		}
		
		private String reverseStringUsingStack(String input) {
			
			StringBuilder reverse = new StringBuilder();
			for(int i=0;i<input.length();i++) {
				push(input.charAt(i));
			}
			for(int i=top;i>=0;i--) {
				reverse.append(pop());
			}
			
			return reverse.toString();
		}
		
	}

	public static void main(String[] args) {
		CustomStack stack = new ReverseStringUsingStack.CustomStack(10);
		System.out.println(stack.reverseStringUsingStack("rohith"));
		
		

	}

}
