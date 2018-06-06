package com.problem.arrays;

public class BinarySearch {
	
	
	/* binary search splits the sorted array in half and decides which half to search
	 * for based on the value of the key and the middle element, we either loop from
	 * low to mid or mid+1 to high based on key, time complexity is O(log n) */
	public static void findElementUsingBinarySearchWithoutForLoop(int key) {
		int a[]= {2,9,10,18,19,22,26,28,32,40};
		int low=0,high = a.length-1;
		while(low<=high) {
		int mid = (low+high)/2;
		if(key > a[mid]) {
			//search in second half
			low = mid+1;
		}
		else if(key<a[mid]) {
			//search in first half
			high = mid-1;
		}
		else if(key==a[mid]) {
			System.out.println("key found at "+mid);
			return;
		}
		
		}
		System.out.println("key could not be found in the array..");
		
	}
	
	/* same as above approach but a little different, though both of them use 
	 * one loop only */
	private static void findElementUsingBinarySearchWithForLoop(int key) {
		int a[]= {2,9,10,18,19,22,26,28,32,40};
		int low=0,high = a.length-1;
		int mid = (low+high)/2;
		if(key > a[mid]) {
			//search in second half
			low = mid+1;
		}
		else if(key<a[mid]) {
			//search in first half
			high = mid-1;
		}
		else if(key==a[mid]) {
			System.out.println("key found at "+mid);
			return;
		}
		
		for(int i=low;i<=high;i++) {
			if(a[i] == key) {
				System.out.println("key found at "+i);
				return;
			}
		}
		
		System.out.println("key could not be found in the array..");
		
	}
	

	public static void main(String[] args) {
		findElementUsingBinarySearchWithoutForLoop(32);
		findElementUsingBinarySearchWithForLoop(40);
	}

}
