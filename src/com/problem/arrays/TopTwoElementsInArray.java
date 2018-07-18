package com.problem.arrays;

public class TopTwoElementsInArray {

	private static void findTopTwoElementsInArray(int[] input) {
		int maxValue1 = Integer.MIN_VALUE;
		int maxValue2 = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			if(input[i] > maxValue1) {
				/* we assign maxValue1 to maxValue2 because we want a value which is next to maxValue1 in terms of magnitude
				 * , so if input is greater than maxValue1, then we assign maxValue1 to maxValue2, so that maxValue2
				 * will hold the second highest value in the list..*/
				maxValue2 = maxValue1;
				maxValue1 = input[i];
			}
			/* if input is already greater than maxValue2, then we directly assign it to maxValue2, this occurs in case, the
			 * above case is not true, hence the else if condition*/
			else if(input[i] > maxValue2) {
				maxValue2 = input[i];
			}
		}
		
		System.out.println(maxValue1);
		System.out.println(maxValue2);
	}

	public static void main(String[] args) {
		int[] input = { 22, 56, 12, 34, 27, 13, 32, 90 };
		findTopTwoElementsInArray(input);
	}

}
