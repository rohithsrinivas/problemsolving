package com.problem.general;

public class PalindromeString {

	private boolean checkIfStringIsPalindrome(String input) {
		for(int i = 0,j = input.length() - 1; i < input.length()/2 && j >= input.length()/2; i++,j--) {
			if(input.charAt(i) != input.charAt(j))
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new PalindromeString().checkIfStringIsPalindrome("abccba"));
	}

}
