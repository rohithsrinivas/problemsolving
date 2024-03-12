package com.interview.wipro;

public class ReplaceQuestionMarkAndFormPalindromeString {
	
	/**
	 * We are given a string as input which will contain question marks, our task is to replace all the question
	 * marks in the string and return any palindrome string by doing so, if this is not possible, then return "NO"
	 * @param S
	 * @return
	 */
	
	public static String replaceQuestionMarksAndFormPalindromeString(String S) {
		
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
	
	public static void main(String[] args) {
		System.out.println(replaceQuestionMarksAndFormPalindromeString("?ab??a"));
		System.out.println(replaceQuestionMarksAndFormPalindromeString("bab??a"));
		System.out.println(replaceQuestionMarksAndFormPalindromeString("?a?"));
	}

}
