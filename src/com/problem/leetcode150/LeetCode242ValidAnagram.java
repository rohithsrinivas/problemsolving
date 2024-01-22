package com.problem.leetcode150;

import java.util.Arrays;

public class LeetCode242ValidAnagram {

	/**
	 * Given two strings s and t, return true if t is an anagram of s, and false
	 * otherwise.
	 * 
	 * An Anagram is a word or phrase formed by rearranging the letters of a
	 * different word or phrase, typically using all the original letters exactly
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagramUsingSorting(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		Arrays.sort(sArr);
		Arrays.sort(tArr);
		return Arrays.equals(sArr, tArr);
	}

	/**
	 * This method will use the technique that if the all the alphabets are having
	 * the same frequency in the two strings, then they must be anagrams. So count
	 * the frequencies using a fixed size of array of 26 since the alphabets are
	 * only 26, and increment the count for each alphabet.
	 * This has a lesser time complexity and is efficient than sorting the strings.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagramUsingFrequencies(String s, String t) {
		if(s.length() != t.length())
			return false;
		int[] frequencies = new int[26];
		for(int i = 0 ; i < s.length() ; i++) {
			frequencies[s.charAt(i) - 'a']++;
		}
		for(int j =0 ; j < t.length() ; j++) {
			frequencies[t.charAt(j) - 'a']--;
		}
		for(int count : frequencies) {
			if(count != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagramUsingSorting("anagram", "nagaram"));
		System.out.println(isAnagramUsingFrequencies("anagram", "nagaram"));
	}

}
