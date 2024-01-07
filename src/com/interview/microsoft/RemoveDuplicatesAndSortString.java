package com.interview.microsoft;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesAndSortString {
	
	public String removeDuplicatesAndSortString(String input) {
		Set<Character> treeSet = new TreeSet<>();
		StringBuilder result = new StringBuilder();
		for(char c : input.toCharArray()) {
			treeSet.add(c);
		}
		treeSet.stream().forEach(letter -> result.append(letter));
		return result.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println(new RemoveDuplicatesAndSortString().removeDuplicatesAndSortString("leetcodeeehgddn"));
	}

}
