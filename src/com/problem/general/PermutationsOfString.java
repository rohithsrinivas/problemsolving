package com.problem.general;

public class PermutationsOfString {

	private static int permutationCount = 1;

	private void printPermutationsOfString(String input, int startingIndex,int endingIndex) {
		if(startingIndex == endingIndex) {
			permutationCount++;
			System.out.println(input);
		}
		else {
			for(int i = startingIndex;i <= endingIndex;i++) {
				input = swap(input,startingIndex,i);
				printPermutationsOfString(input, startingIndex + 1, endingIndex);
				input = swap(input, startingIndex, i);
			}
		}
	}
	
	private String swap(String input,int a,int b) {
		char[] inputChars = input.toCharArray();
		char temp = inputChars[a];
		inputChars[a] = inputChars[b];
		inputChars[b] = temp;
		return String.valueOf(inputChars);
		
	}

	public static void main(String[] args) {
		String input = "abc";
		new PermutationsOfString().printPermutationsOfString(input, 0,input.length() - 1);
		System.out.println("total permutations " + (permutationCount - 1));
	}

}
