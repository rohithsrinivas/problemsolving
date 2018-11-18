package com.problem.general;

public class ReverseString {
	
	private String reverseStringRecursively(String input) {
		if(input == null || input.length() <= 1)
			return input;
		else
			return reverseStringRecursively(input.substring(1)) + input.charAt(0);
		
	}

	public static void main(String[] args) {
		System.out.println(new ReverseString().reverseStringRecursively("rohith"));
	}

}
