package com.problem.general;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharacterInString {

	private Character findFirstNonRepeatingCharacterInString(String input) {
		Map<Character, Integer> characters = new LinkedHashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char currentCharacter = input.charAt(i);
			if (characters.containsKey(currentCharacter)) {
				characters.put(currentCharacter, characters.get(currentCharacter) + 1);
			} else
				characters.put(currentCharacter, 1);

		}
		boolean found = false;
		if (characters.size() > 0) {
			for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
				if (entry.getValue() == 1) {
					System.out.println(entry.getKey());
					found = true;
					break;
				}
			}
		} 
		
		if(!found)
			System.out.println("no unique character found in string ");
		return '\0';
	}

	public static void main(String[] args) {
		System.out.println(
				new FirstNonRepeatingCharacterInString().findFirstNonRepeatingCharacterInString("prohithrohithrp"));
	}

}
