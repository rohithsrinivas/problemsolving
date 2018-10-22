package com.problem.general;

import java.util.TreeSet;

public class SmallestNumberByRearrangingDigits {

	private int getSmallestNumberByRearranging(int number) {
		TreeSet<Integer> numbers = new TreeSet<>();
		StringBuilder smallest = new StringBuilder();
		StringBuilder smallest2 = new StringBuilder();
		while (number != 0) {
			numbers.add(number % 10);
			number = number / 10;
		}
		numbers.stream().forEach(number2 -> smallest.append(number2));
		char[] charArray = smallest.toString().toCharArray();
		if(charArray[0] == '0')
		{
			char temp = charArray[0];
			charArray[0] = charArray[1];
			charArray[1] = temp;
		}
		for(int i = 0;i<charArray.length;i++)
			smallest2.append(charArray[i]);
		return Integer.parseInt(smallest2.toString());
	}

	public static void main(String[] args) {
		System.out.println(new SmallestNumberByRearrangingDigits().getSmallestNumberByRearranging(176430));
	}

}
