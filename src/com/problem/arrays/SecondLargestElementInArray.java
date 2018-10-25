package com.problem.arrays;

public class SecondLargestElementInArray {
	
	/* the idea is to maintain two variables, highest and secondHighest to store largest and secondLargest values, when we find an element
	 * which is greater than the highest, it means that the highest variable will be the second highest now, so first assign secondHighest with
	 * the value of highest and then assign the array element which is greater than highest to highest, 
	 * if not, then check the array element is between the secondHighest and the highest, in which case, it should be the new value of the secondHighest
	 * ,so assign it. finally return the secondHighest*/
	private int getSecondLargestElementInArray(int[] input) {
		int highest = Integer.MIN_VALUE,secondHighest = Integer.MIN_VALUE;
		for(int i = 0;i<input.length;i++) {
			if(input[i] > highest) {
				secondHighest = highest;
				highest = input[i];
			}
			else if(input[i] > secondHighest && input[i] < highest) {
				secondHighest = input[i];
			}
		}
		
		return secondHighest;
	}

	public static void main(String[] args) {
		int[] input = {12, 35, 1, 10, 34, 1,36};
		System.out.println(new SecondLargestElementInArray().getSecondLargestElementInArray(input));
	}

}
