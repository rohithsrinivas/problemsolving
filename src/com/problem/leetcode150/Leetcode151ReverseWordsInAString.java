package com.problem.leetcode150;

public class Leetcode151ReverseWordsInAString {

	public static String reverseWords(String s) {
		String reversedString = null;
		int startingIndex = 0;
		for(int i = 0 ; i < s.length() ; i++) {
			if(s.charAt(i) == '\s') {
				s.substring(i, i)
			}
		}
		return reversedString;
	}
	
	public static void main(String[] args) {
		System.out.println("The reverse of the words is: " + reverseWords("the sky is blue"));
	}

}
