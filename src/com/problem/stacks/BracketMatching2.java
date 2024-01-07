package com.problem.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BracketMatching2 {
	
	class Stack{
		int top;
		char[] stackArray;
		
		Stack(int size){
			this.stackArray = new char[size];
			top = -1;
		}
		
		public void push(char data) {
			if(top >= stackArray.length - 1) {
				System.out.println("Stack Overflow");
				return;
			}
			stackArray[++top] = data;
		}
		
		public char pop() {
			if(top == -1) {
				System.out.println("Stack underflow");
				return '\0';
			}
			return stackArray[top--];
		}
		
		public int peek() {
			if(top == -1) {
				System.out.println("Stack underflow");
				return -1;
			}
			return stackArray[top];
		}
		
	}
	
	public static void main(String[] args) {
		BracketMatching2 bracketMatching = new BracketMatching2();
		bracketMatching.validateBrackets(new char[] {'(','{','}',')'});
	}

	private void validateBrackets(char[] inputString) {
		List<Character> openingBrackets = Arrays.asList('(','{','[');
		 
		
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
	
	private boolean isOpeningBracket() {
		
	}

}
