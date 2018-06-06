package com.problem.arrays;

public class IntersectionOfTwoArrays {

	
	public static void main(String[] args) {
		findCommonElementsInArrays();
	}
/*assuming both the arrays are sorted, then we can use this approach of checking if
 * element of first array is greater than the elements of second array and increment
 * the index of first or second array based on which of the two is greater, if we find 
 * a match, then both should be incremented*/
	private static void findCommonElementsInArrays() {
		int a[] = {1,3,6,8,9,11};
		int b[] = {4,6,8,11,67};
		int i=0,j=0;
		while(i<a.length && j<b.length) {
			if(a[i] == b[j]) {
				System.out.println(a[i]);
				i++;
				j++;
			}
			else if(a[i] < b[j])
				i++;
			else
				j++;
		}
		
	}
}
