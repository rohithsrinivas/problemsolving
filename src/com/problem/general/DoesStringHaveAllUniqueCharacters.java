package com.problem.general;

public class DoesStringHaveAllUniqueCharacters {

	/*
	 * the idea is to maintain a boolean array which will indicate the presence of
	 * each character that we have in the string, so when we read a character, we
	 * check if the particular boolean value associated with the ascii index of it
	 * is true, if yes, then we obviously have a duplicate, so we return false
	 * immediately, if not, then we simply make that value true and proceed to the
	 * next character
	 */

	/*
	 * the problem with this approach is that it takes O(n) time for running and
	 * also extra space of O(n), so we need to find another approach which will
	 * reduce the running time and not use extra storage
	 */
	private boolean doesStringHaveAllUniqueCharacters(String input) {
		boolean[] asciiStatusArray = new boolean[256];
		for (int i = 0; i < input.length(); i++) {
			/* this will return the ascii value of a character if it is assigned to int */
			int val = input.charAt(i);
			/*
			 * we check the boolean value for the ascii index of that character in the
			 * boolean array
			 */
			if (asciiStatusArray[val])
				return false;
			asciiStatusArray[val] = true;
		}
		int j = 0;
		for(int i = 0;i<100;i++)
			j = j++;
		System.out.println("the value of j is "+j);
		return true;
	}
	
//	private boolean doesStringHaveUniqueCharactersWithoutExtraStorage(String input) {
//		
//	}

	public static void main(String[] args) {
		String input = "rohit";
		System.out.println(new DoesStringHaveAllUniqueCharacters().doesStringHaveAllUniqueCharacters(input));
	}

}
