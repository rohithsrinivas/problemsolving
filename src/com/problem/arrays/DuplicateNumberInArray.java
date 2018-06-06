package com.problem.arrays;

public class DuplicateNumberInArray {
	
	/* find the actual sum and expected sum and subtract expected sum from the actual sum
	 * and we can find the duplicate number in the array*/
	private static int duplicateNumberInArray() {
		int a[] = {1,2,3,4,5,3};
		int expectedSum=0,actualSum=0;
		for(int i=0;i<a.length;i++) {
			actualSum+=a[i];
		}
		
		for(int i=1;i<=5;i++) {
			expectedSum+=i;
		}
		
		return actualSum-expectedSum;
		
	}

	public static void main(String[] args) {
		System.out.println("duplicate number in the array is "+duplicateNumberInArray());

	}

}
