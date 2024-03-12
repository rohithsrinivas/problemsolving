package com.problem.leetcode150;

import java.util.HashSet;
import java.util.Set;

public class PalindromString {

	public static String isPalindrome(String S) {
//		for(int i = 0, j  = S.length() - 1 ; i < j ; i++,j--) {
//			if(S.charAt(i) != S.charAt(j)) {
//				if(S.charAt(i) == '?' || S.charAt(j) == '?') {
//					
//				}
//			}
//			if(S.charAt(i) == '?' && S.charAt(j) == '?') {
//				S.replace
//			}
//		}
		char[] charArray = S.toCharArray();
		for(int i = 0 , j = charArray.length - 1 ; i < j ; i++,j--) {
			if(charArray[i] == '?' && charArray[j] == '?') {
				charArray[i] = 'a';
				charArray[j] = 'a';
				continue;
			}
			if(charArray[i] == charArray[j]) {
				continue;
			}
			if(charArray[i] == '?') {
				charArray[i] = charArray[j];
				continue;
			}
			if(charArray[j] == '?') {
				charArray[j] = charArray[i];
				continue;
			}
			if(charArray[i] != charArray[j] && charArray[i] != '?' && charArray[j] != '?') {
				return "NO";
			}
		}
		return new String(charArray);
	}
	
	public static int solution(String S) {
		Set<String> uniqueThreeLetterWords = new HashSet<>();
		for(int i = 0 ; i <= S.length() - 3 ; i++) {
			uniqueThreeLetterWords.add(S.substring(i, i + 3));
		}
		return uniqueThreeLetterWords.size();
	}
	
	public static void main(String[] args) {
//		isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(isPalindrome("?ab??a"));
		System.out.println(isPalindrome("bab??a"));
		System.out.println(isPalindrome("?a?"));
	}

}
