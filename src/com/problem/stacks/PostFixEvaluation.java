package com.problem.stacks;

public class PostFixEvaluation {

	class CustomStack {
		int top;
		int maxSize;
		Integer[] stackArray;

		public CustomStack(int maxSize) {
			this.maxSize = maxSize;
			this.top = -1;
			this.stackArray = new Integer[maxSize];
		}

		private void push(Integer c) {
			if (top >= this.maxSize - 1) {
				System.out.println("stack overflow...!!!");
				return;
			}

			stackArray[++top] = c;
		}

		private Integer pop() {
			if (top == -1) {
				System.out.println("stack underflow... !!!");
				return 0;
			}

			return stackArray[top--];
		}

		private int getSizeOfStack() {
			int count = 0;
			for (int i = top; i >= 0; i--)
				count++;
			return count;
		}
	}

	/*
	 * if the character is an operand or a value push to stack, if we find an
	 * operator, then pop two values from stack and apply that operator to both of
	 * them and again push the result to stack, and this continues until there is
	 * only one element left in the stack, this will be out desired output, as all
	 * the operators have been applied to the relevant operands and we arrive at the
	 * final result of the postfix expression
	 */
	private Integer evaluatePostFixExpression(String input) {
		CustomStack stack = new CustomStack(20);
		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);

			if (current != ' ') {
				if (Character.isDigit(current)) {
					stack.push(Character.getNumericValue(current));
				}

				else {
					int operand1 = stack.pop();
					int operand2 = stack.pop();

					switch (current) {
					case '+':
						stack.push(operand2 + operand1);
						break;
					case '-':
						stack.push(operand2 - operand1);
						break;
					case '*':
						stack.push(operand2 * operand1);
						break;
					case '/':
						stack.push(operand2 / operand1);
						break;
					}

				}

			}
		}

		return stack.pop();

	}

	public static void main(String[] args) {
		String input = "1 2 + 4 * 5 -";
		PostFixEvaluation evaluator = new PostFixEvaluation();
		System.out.println(evaluator.evaluatePostFixExpression(input));
	}

}
