package com.problem.general;

import java.util.ArrayList;
import java.util.List;

/*
 * the idea is to maintain an array which will store the occurences of characters in
 * the input string*/
public class MinimumSubStringContainingAnotherString {
	
	private void printMinimumSubstringContainingString(String input , String pattern) {
		/* store lengths of input and pattern*/
		int inputLength = input.length();
		int patternLength = pattern.length();
		if(inputLength < patternLength) {
			System.out.println("no window exists for the given pattern");
			return;
		}
		/* declare 2 arrays which will store the occurrences of each character separately
		 * in input string and pattern*/
		int[] patternArray = new int[256];
		int[] inputArray = new int[256];
		/* increment the value of each character in array while iterating*/
		for(int i = 0 ; i < patternLength ; i++) {
			int val = pattern.charAt(i);
			patternArray[val]++;
		}
		
		/* as we find an occurence from pattern string in the input string we increment the count
		 * stating the count of the number of characters from pattern which found a hit in the input
		 * string*/
		int count = 0 , start = 0 , startIndex = -1 , minLength = Integer.MAX_VALUE;
		for(int j = 0 ; j < inputLength ; j++) {
			/* increment the count of that char for input string*/
			inputArray[input.charAt(j)]++;
			/* this condition will check that the current character has atleast one occurence in 
			 * the pattern array and it occurs less than or equal to times that it occurred in the
			 * pattern array and increment the count for each succesful character hit*/
			if(patternArray[input.charAt(j)] != 0 
					&& inputArray[input.charAt(j)] <= patternArray[input.charAt(j)]) {
				count++;
			}
			
			/* now we are sure that the full pattern exists in the string*/
			if(count == patternLength) {
				/* now we need a character to appear in input only as the number of times
				 * it appeared in the pattern, so loop through and reduce the number of occurrences
				 * in the input to the occurrence in the pattern*/
				while(inputArray[input.charAt(start)] == 0 || inputArray[input.charAt(start)] >
				patternArray[input.charAt(start)]) {
					if(inputArray[input.charAt(start)] > patternArray[input.charAt(start)])
						inputArray[input.charAt(start)] = patternArray[input.charAt(start)];
					start++;
				}
				
				int windowLength = j - start + 1;
				if(windowLength < minLength) {
					minLength = windowLength;
					startIndex = start;
				}
			}
			
		}
		
		if(startIndex == -1) {
			System.out.println("no window could be found");
		}
		
		else
			System.out.println(input.substring(startIndex, startIndex+minLength));
	}
	

	public static void main(String[] args) {
		MinimumSubStringContainingAnotherString minimumSubString = new MinimumSubStringContainingAnotherString();
		minimumSubString.printMinimumSubstringContainingString("this is a very good book", "ry og");
	}

}
