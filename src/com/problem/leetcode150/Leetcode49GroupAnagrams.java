package com.problem.leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leetcode49GroupAnagrams {

	/**
	 * Given an array of strings strs, group the anagrams together. You can return
	 * the answer in any order.
	 * 
	 * An Anagram is a word or phrase formed by rearranging the letters of a
	 * different word or phrase, typically using all the original letters exactly
	 * once.
	 * 
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anagramMap = new HashMap<>();
		for(String str : strs) {
			char[] input = str.toCharArray();
			Arrays.sort(input);
			String sortedString = new String(input);
			if(!anagramMap.containsKey(sortedString)) {
				anagramMap.put(sortedString, new ArrayList<>());
			}
			anagramMap.get(sortedString).add(str);
		}
		return new ArrayList<>(anagramMap.values());
	}
	
	public static void main(String[] args) {
		String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
		groupAnagrams(strs);
	}

}
