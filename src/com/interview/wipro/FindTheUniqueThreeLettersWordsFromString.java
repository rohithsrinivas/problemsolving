package com.interview.wipro;

import java.util.HashSet;
import java.util.Set;

public class FindTheUniqueThreeLettersWordsFromString {
	
	/**
	 * Given a string, we have to return the number of unique three letter words from the string.
	 * @param S
	 * @return
	 */
	public static int findTheNumberOfUniqueThreeLetterWords(String S) {
		Set<String> uniqueThreeLetterWords = new HashSet<>();
		for(int i = 0 ; i <= S.length() - 3 ; i++) {
			uniqueThreeLetterWords.add(S.substring(i, i + 3));
		}
		return uniqueThreeLetterWords.size();	
	}

	public static void main(String[] args) {
		System.out.println(findTheNumberOfUniqueThreeLetterWords("bbaaabb"));
	}
}
