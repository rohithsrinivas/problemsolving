package com.problem.arrays;

public class BinarySearchRecursion {
	
	public void search(int key, int[] input) {
		int binarySearch = binarySearch(0, input.length-1, key, input);
		if(binarySearch == -1)
			System.out.println("element not found");
		else
			System.out.println("element found at"+binarySearch);
	}
	
	public int binarySearch(int low, int high,int key, int[] input) {
		if(low <= high) {
			int mid = (low+high)/2;
			if(key < input[mid]) {
				return binarySearch(low, mid-1, key, input);
			}
			else if(key>input[mid]) {
				return binarySearch(mid+1, high, key, input);
			}
			else if(key == input[mid]) {
				return mid;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int input[]= {2,9,10,18,19,22,26,28,32,40};
		BinarySearchRecursion binarySearchRecursion = new BinarySearchRecursion();
		binarySearchRecursion.search(40,input);
	}

}
