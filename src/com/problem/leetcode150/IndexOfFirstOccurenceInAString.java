package com.problem.leetcode150;

public class IndexOfFirstOccurenceInAString {

	/**
	 * Given two strings needle and haystack, return the index of the first
	 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: haystack = "sadbutsad", needle = "sad" Output: 0 Explanation: "sad"
	 * occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.
	 * Example 2:
	 * 
	 * Input: haystack = "leetcode", needle = "leeto" Output: -1 Explanation:
	 * "leeto" did not occur in "leetcode", so we return -1.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= haystack.length, needle.length <= 104 haystack and needle consist of
	 * only lowercase English characters.
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
		int index = 0;
		for(int i = 0 ; i < haystack.length() ; i++) {
			if(haystack.charAt(i) == needle.charAt(index)) {
				while((haystack.charAt(i) == needle.charAt(index)) && 
						i < haystack.length() && 
						index < needle.length()) {
					i++;
					index++;
				}
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		System.out.println(strStr("sadbutsad", "sad"));
		System.out.println(strStr("leetcode", "leeto"));
	}
}
