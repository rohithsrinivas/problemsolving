package com.problem.general;

import java.util.HashSet;
import java.util.Set;

public class RemoveVowelsFromString {
	
	private String removeVowelsFromString(String input) {
		StringBuilder builder = new StringBuilder(input);
		for(int i = 0;i < input.length() ; i++) {
			if(isVowel(input.charAt(i))) {
				builder.replace(i, i+1, "");
				i--;
			}
		}
		return builder.toString();
	}
	
	private boolean isVowel(char input) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		if (vowels.contains(input)) 
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new RemoveVowelsFromString().removeVowelsFromString("rohith"));
	}

}
