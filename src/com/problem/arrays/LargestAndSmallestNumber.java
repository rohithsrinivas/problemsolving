package com.problem.arrays;

public class LargestAndSmallestNumber {
	
	/*assume that the first or last element of the array is the smallest and the 
	 * largest, loop through the list and check if any other number is greater than
	 * the greatest or smaller than the smallest, if the first is true, then second 
	 * can never be true, hence use if-else time complexity is O(n)  */
	private static void findLargestAndSmallestNumberInUnsortedArray() {
		int a[]= {245,99,100,18,129,222,26,28,32,40};
		int largest = a[a.length-1];
		int smallest = a[a.length-1];
		for(int i=a.length-1;i>=0;i--) {
			if(a[i]>largest)
				largest = a[i];
			else if(a[i]<smallest)
				smallest = a[i];
		}
		
		System.out.println("largest number is "+largest);
		System.out.println("smallest number is "+smallest);
		
	}

	public static void main(String[] args) {
		findLargestAndSmallestNumberInUnsortedArray();
	}

}
