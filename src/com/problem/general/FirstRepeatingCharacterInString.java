package com.problem.general;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingCharacterInString {

	private Character findFirstRepeatedCharacterInString(String input) {
		Set<Character> characters = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			if(characters.contains(input.charAt(i))){
					return input.charAt(i);
			}
			else
				characters.add(input.charAt(i));
		}
		System.out.println("no repeating character found");
		return '\0';
	}

	public static void main(String[] args) {
		System.out.println(new FirstRepeatingCharacterInString().findFirstRepeatedCharacterInString("abcdaefbgh"));
	}
}
