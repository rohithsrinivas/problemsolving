package com.problem.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupingAnagramsOfAString {

	/**
	 * Given an array of strings strs, group the anagrams together. You can return
	 * the answer in any order.
	 * <p>
	 * An Anagram is a word or phrase formed by rearranging the letters of a
	 * different word or phrase, typically using all the original letters exactly
	 * once.
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
	 * [["bat"],["nat","tan"],["ate","eat","tea"]]
	 */

	public static List<List<String>> groupAnagrams(String[] strs) {
		String[] sortedArray = new String[strs.length];
		Map<String, List<String>> anagramMap = new HashMap<>();
		for (int i = 0; i < sortedArray.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String sortedString = new String(chars);
			List<String> anagrams;
			if (anagramMap.containsKey(sortedString)) {
				anagrams = anagramMap.get(sortedString);
			} else {
				anagrams = new ArrayList<>();
			}
			anagrams.add(strs[i]);
			anagramMap.put(sortedString, anagrams);
		}
		return new ArrayList<>(anagramMap.values());

	}

	public static void main(String[] args) {
		List<List<String>> groupAnagrams = groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		groupAnagrams.stream().forEach(group -> System.out.println(group));

	}

}
