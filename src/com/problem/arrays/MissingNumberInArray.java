package com.problem.arrays;

public class MissingNumberInArray {
	
	/* the idea is to find the expected sum by looping from lower bound value
	 * to the upper bound value and finding the actual sum by adding all the elements of the 
	 * array, the difference of the expected sum and the actual sum will give us the missing
	 * number in the array time complexity is O(n) */
	private static int findMissingNumber() {
		int a[]= {1,2,3,4,5,7,8,9};
		int actualSum=0,expectedSum=0;
		for(int i=0;i<a.length;i++) {
			actualSum+=a[i];
		}
		for(int i=1;i<=9;i++) {
			expectedSum+=i;
		}
		
		
		return expectedSum-actualSum;
			
	}
	
	public static void main(String[] args) {
		System.out.println("missing number is "+findMissingNumber());;
	}

}
