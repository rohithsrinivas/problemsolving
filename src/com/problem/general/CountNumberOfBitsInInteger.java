package com.problem.general;

import java.util.LinkedList;
import java.util.Queue;

public class CountNumberOfBitsInInteger {
	
	private int countNumberOfBitsInInteger(int n) {
		int count = 0;
		while(n > 0) {
			n = n & (n-1);
			count++;
		}
		return count;
	}
	
	private void printBinaryNumbers(int n) {
		Queue<String> queue = new LinkedList<>();
		queue.add("1");
		int i = 1;
		while( i <= n) {
			queue.add(queue.peek() + "0");
			queue.add(queue.peek() + "1");
			
			System.out.println(queue.poll());
			i++;
		}
	}

	public static void main(String[] args) {
		System.out.println(new CountNumberOfBitsInInteger().countNumberOfBitsInInteger(99));
		new CountNumberOfBitsInInteger().printBinaryNumbers(100);
	}

}
