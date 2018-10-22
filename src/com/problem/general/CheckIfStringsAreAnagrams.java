package com.problem.general;

public class CheckIfStringsAreAnagrams {
	
	private boolean isAnagram(String input1,String input2) {
		if(input1.length() != input2.length())
			return false;
		char[] input1chars = input1.toCharArray();
		StringBuilder input2builder = new StringBuilder(input2);
		for(char ch : input1chars) {
			int index = input2builder.indexOf(""+ch);
			if(index >= 0)
				input2builder.deleteCharAt(index);
			else
				return false;
		}
		
		return input2builder.length() > 0 ? false : true;
	}

	public static void main(String[] args) {
		System.out.println(new CheckIfStringsAreAnagrams().isAnagram("rohith", "thhiro"));;
	}

}
