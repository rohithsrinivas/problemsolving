package com.problem.general;

import java.util.LinkedList;
import java.util.Queue;

public class PrintingBinaryNumbers {
	
	private void generateBinaryNumbers(int n) {
		Queue<String> queue = new LinkedList<>();
		queue.add("1");
		int i = 1;
		while(i <= n) {
			queue.add(queue.peek() + "0");
			queue.add(queue.peek() + "1");
			
			System.out.println(queue.poll() + " ");
			i++;
		}
	}

	public static void main(String[] args) {
		new PrintingBinaryNumbers().generateBinaryNumbers(10);
	}

}
