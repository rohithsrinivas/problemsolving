package com.problem.stacks;

import java.util.Arrays;
import java.util.List;

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
		List<Character> openingBrackets = Arrays.asList('(','{','[');
		List<Character> closingBrackets = Arrays.asList(')','}',']');
		CustomStack stack = new CustomStack(10);
		for(int i=0;i<input.length;i++) {
			if(openingBrackets.contains(input[i]))
				stack.push(input[i]);
			
			else if(closingBrackets.contains(input[i])) {
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
