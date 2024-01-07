package com.problem.general;

public class BinaryRepOfNumber {
	
	public static void main(String[] args) {
		BinaryRepOfNumber binaryRepOfNumber = new BinaryRepOfNumber();
		binaryRepOfNumber.binary(51);
	}
	
	public void binary(int n) {
		
		if(n > 1) {
			binary(n / 2);
		}
		
		System.out.print(n % 2);
	}

}
