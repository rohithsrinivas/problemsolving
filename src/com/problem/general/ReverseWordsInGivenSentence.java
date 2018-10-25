package com.problem.general;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ReverseWordsInGivenSentence {

	private String reverseWordsInGivenSentence(String input) {
		StringBuilder result = new StringBuilder(input.length());
		String[] splitWords = input.split("\\s");
		for (int i = splitWords.length - 1; i >= 0; i--)
			result.append(splitWords[i] + " ");
		return result.toString();
	}

	private String reverseEachWordInSentence(String input) {
		StringBuilder result = new StringBuilder(input.length());
		String[] splitWords = input.split("\\s");
		for (int i = 0; i < splitWords.length; i++)
			result.append(reverseString(splitWords[i]) + " ");
		return result.toString();
	}

	private String reverseString(String input) {
		char[] chars = input.toCharArray();
		for (int i = 0, j = chars.length - 1; i < chars.length / 2 && j >= chars.length / 2; i++, j--) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		ReverseWordsInGivenSentence inverter = new ReverseWordsInGivenSentence();
		System.out.println(inverter.reverseWordsInGivenSentence("this is a sample sentence"));
		System.out.println(inverter.reverseEachWordInSentence("welcome to mindtree"));
	}

}
