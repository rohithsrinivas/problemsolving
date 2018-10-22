package com.problem.arrays;

public class CheckIfArraysIsSortedOrNot {

	private boolean isArraySorted(int[] input) {
		int n = input.length;

		if (n == 0 || n == 1)
			return true;

		for (int i = 1; i < n; i++) {
			if(input[i] < input[i-1])
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		int a[] = { 1, 5, 10, 20, 40, 80 ,55};
		System.out.println(new CheckIfArraysIsSortedOrNot().isArraySorted(a));
	}

}
