package com.problem.stacks;

public class BracketMatching {

	class CustomStack{
		int top;
		int maxSize;
		Character[] stackArray;
		
		public CustomStack(int maxSize) {
			this.maxSize = maxSize;
			this.top = -1;
			this.stackArray = new Character[maxSize];
		}
		
		public boolean isEmpty() {
			return top==-1;
		}
		
		public void push(char c) {
			//top++;
			if(top >= maxSize-1) {
				System.out.println("stack overflow...");
				return;
			}
			stackArray[++top]=c;
		}
		
		public char pop() {
			return stackArray[top--];
		}
		
		public char peek() {
			return stackArray[top];
		}
		
	}
	
	public static void main(String[] args) {
		Character[] expression = {'[','(','[',']',')','{','}','(',')',']','(',')'};
		BracketMatching bracketMatching = new BracketMatching();
		System.out.println(bracketMatching.checkExpressionForMatching(expression));;
	}

	private boolean checkExpressionForMatching(Character[] input) {
		CustomStack stack = new CustomStack(10);
		for(int i=0;i<input.length;i++) {
			if(input[i] == '(' || input[i] == '{' || input[i] == '[')
				stack.push(input[i]);
			
			else if(input[i] == ')' || input[i] == '}' || input[i]== ']') {
				if(stack.isEmpty())
					return false;
				if(isMatchingBracket(stack.peek(), input[i]))
				{
					stack.pop();
				}
				else
					return false;
			}
		}
		
		if(!stack.isEmpty())
			return false;
		return true;
	}
	
	private boolean isMatchingBracket(char opening,char closing) {
		if(opening == '[' && closing == ']')
			return true;
		else if(opening == '{' && closing =='}')
			return true;
		else if(opening == '(' && closing == ')')
			return true;
		else
			return false;
	}
}
