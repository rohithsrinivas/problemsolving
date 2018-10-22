package com.problem.stacks;

import java.util.Stack;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.problem.trees.MinimumDepthOfBinaryTree;

public class MinumimValueInStack {

	class CustomStack {
		
		Stack<Integer> stack;
		Stack<Integer> minStack;
		
		public CustomStack() {
			stack = new Stack<>();
			minStack = new Stack<>();
		}
		
		private void push(int data) {
			if(stack.isEmpty()) {
				stack.push(data);
				minStack.push(data);
				return;
			}

			stack.push(data);
			if(stack.peek() < minStack.peek()) {
				minStack.push(data);
			}
		}
		
		private int pop() {
			if(stack.isEmpty()) {
				System.out.println("stack underflow...");
				return -1;
			}
			int result = stack.pop();
			if(result == minStack.peek()) {
				minStack.pop();
			}
			
			return result;
		}
		
		private int getMin() {
			return minStack.pop();
		}
	}

	public static void main(String[] args) {
		MinumimValueInStack inStack = new MinumimValueInStack();
		CustomStack customStack = inStack.new CustomStack();
		customStack.push(10);
		customStack.push(15);
		customStack.push(3);
		customStack.push(90);
		customStack.push(24);
		customStack.pop();
		customStack.pop();
		System.out.println(customStack.getMin());

	}

}
