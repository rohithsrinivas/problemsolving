package com.problem.stacks;

public class InfixToPostfix {

	public InfixToPostfix() {

	}

	class CustomStack {
		private int top;
		private int maxSize;
		private Character[] stackArray;

		public CustomStack(int maxSize) {
			this.maxSize = maxSize;
			this.stackArray = new Character[maxSize];
			this.top = -1;
		}

		public void push(char c) {
			top++;
			stackArray[top] = c;
		}

		public char pop() {
			return stackArray[top--];
		}

		public char peek() {
			return stackArray[top];
		}

		public boolean isEmpty() {
			return top == -1;
		}

	}

	public static void main(String[] args) {
		InfixToPostfix converter = new InfixToPostfix();
		String input = "A+(B*C-(D/E-F)*G)*H";
		System.out.println(converter.convertToPostfix(input));
	}

	private String convertToPostfix(String input) {
		CustomStack stack = new CustomStack(50);
		StringBuilder output = new StringBuilder("");
		for(int i=0;i<input.length();i++) {
			char current = input.charAt(i);
			if(current == '(') {
				stack.push(current);
			}
			
			else if(Character.isLetterOrDigit(current)) {
				output.append(current);
			}
			
			else if(current == ')') {
				while(stack.peek()!='(' && !stack.isEmpty()) {
					output.append(stack.pop());
				}
				stack.pop();
			}
			
			/* this is the case when a operator in encounters, check if the precedence of the scanned operator is greater than the operator on top and if
			 * not, then pop the elements of stack and append it to the output until the precedence is lesser.
			 * 
			 */
			else {
				while(!stack.isEmpty() && getPrecedence(current)<=getPrecedence(stack.peek())) {
					output.append(stack.pop());
				}
				stack.push(current);
			}
		}
		
		while(!stack.isEmpty())
			output.append(stack.pop());
					
		return output.toString();
		
		
		
	}

	private int getPrecedence(char ch) {
		switch (ch) {

		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

}
