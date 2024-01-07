package com.problem.general;

public class PrintingAllAnagramsOfString {

	public static void main(String[] args) {
		PrintingAllAnagramsOfString anagrams = new PrintingAllAnagramsOfString();
		anagrams.printAnagrams("abc");
	}

	private void printAnagrams(String s) {
		permute(s, 0, s.length() - 1);
	}

	private void permute(String s, int l, int r) {
		if (l == r)
			System.out.println(s);
		else {
			for(int i = l ; i <= r ; i++) {
				s = swap(s, l, i);
				permute(s, l + 1, r);
				s = swap(s, l, i);
			}
		}
	}

	private String swap(String s, int l, int r) {
		char[] charArray = s.toCharArray();
		char temp = charArray[l];
		charArray[l] = charArray[r];
		charArray[r] = temp;
		return String.valueOf(charArray);
	}

}
