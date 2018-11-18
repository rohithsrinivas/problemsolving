package com.problem.general;

public class CheckIfStringsAreAnagrams {
	
	private boolean isAnagram(String input1,String input2) {
		if(input1.length() != input2.length())
			return false;
		StringBuilder inputBuilder2 = new StringBuilder(input2);
		char[] input1chars = input1.toCharArray();
		int index = 0;
		for(char ch : input1chars) {
			index = inputBuilder2.indexOf(""+ch);
			if(index >= 0)
				inputBuilder2.deleteCharAt(index);
			else
				return false;
		}
		return inputBuilder2.length() == 0 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(new CheckIfStringsAreAnagrams().isAnagram("rohith", "thhiro"));;
	}

}
