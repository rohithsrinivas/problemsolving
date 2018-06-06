package com.problem.arrays;

import java.util.Arrays;

public class NthSmallestElementUnsortedArray {

	public static void main(String[] args) {
		findNthSmallestElementInArray(2);
		findNthLargestElementInArray(2);

	}

	private static void findNthLargestElementInArray(int n) {
		int a[] = {2,8,1,78,43,23};
		Arrays.sort(a);
		System.out.println(a[a.length-n]);
		
	}

	private static void findNthSmallestElementInArray(int n) {
		int a[] = {2,8,1,78,43,23};
		Arrays.sort(a);
		System.out.println(a[n-1]);
		
	}

}
