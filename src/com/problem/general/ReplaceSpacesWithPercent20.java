package com.problem.general;

public class ReplaceSpacesWithPercent20 {

	private String replaceSpaceWithPercent20WithStringBuilder(String input) {
		StringBuilder result = new StringBuilder(input);
		for (int i = 0; i < input.length(); i++) {
			int asciiCode = result.charAt(i);
			if (asciiCode == 32)
				result.replace(i, i + 1, "%20");
		}
		return result.toString();
	}

	/* the idea is to first identify the number of spaces in the current input and calculate the new length, then when we find a space
	 * , we replace that space with the required characters as per the indexes, else, simply copy the character*/
	private String replaceSpaceWith20(String input) {
		char[] chars = input.toCharArray();
		int spaceCount = 0;
		char[] newChars;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ')
				spaceCount++;
		}
		/* we multiply spaceCount by 2 because we need 2 extra characters for each space in the new String*/
		int newLength = chars.length + spaceCount * 2;
		newChars = new char[newLength];
		/* loop backwards and assign the required characters, i.e length decremented by 3 in case of a space because, we replace 
		 * 1 with 3 characters*/
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == ' ') {
				newChars[newLength - 1] = '0';
				newChars[newLength - 2] = '2';
				newChars[newLength - 3] = '%';
				newLength = newLength - 3;
			} 
			/* if it is not a space, just copy and decrement by 1 */
			else {
				newChars[newLength - 1] = chars[i];
				newLength = newLength - 1;
			}
		}
		return new String(newChars);
	}

	public static void main(String[] args) {
		ReplaceSpacesWithPercent20 replaceSpacesWithPercent20 = new ReplaceSpacesWithPercent20();
		System.out.println(replaceSpacesWithPercent20.replaceSpaceWithPercent20WithStringBuilder("roh ith is"));
		System.out.println(replaceSpacesWithPercent20.replaceSpaceWith20("roh ith "));
	}

}
