package com.problem.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubstringWithNonRepeatingCharacters {
	
	public static void main(String[] args) {
		LargestSubstringWithNonRepeatingCharacters substring = new LargestSubstringWithNonRepeatingCharacters();
		System.out.println("largest non repeating substring is " + substring.getLargestSubString("abcabceff"));;
	}

	/* The algorithm works like this, maintain a track of all the visited characters
	 * in the string, if you find a character that has already been visited, the new substring 
	 * should start from the next character of the previous index of that same character, so
	 * that the earlier repeating character will be removed from the final output substring, and
	 * the new start index will be from the greatest of the existing index and the existing start index */
	private String getLargestSubString(String input) {
		Map<Character, Integer> visited = new HashMap<>();
		String output = "";
		for(int start = 0, end = 0; end < input.length() ; end++) {
			char currentChar = input.charAt(end);
			if(visited.containsKey(currentChar)) {
				start = start > visited.get(currentChar) + 1 ? start : visited.get(currentChar) + 1;
			}
			if(output.length() < end - start + 1) {
				output = input.substring(start, end + 1);
			}
			visited.put(currentChar, end);
		}
		return output;
	}

}
