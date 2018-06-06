package com.problem.arrays;

public class LinearSearch {
	
	private static void findElementByLinearSearch(int key) {
		int a[]= {7,4,9,2,11,92};
		int keyIndex = 0;
		for(int i=0;i<a.length;i++) {
			if(key == a[i]) {
				keyIndex = i;
			}
		}
		if(keyIndex == 0)
			System.out.println("key could not be found in the array");
		else
			System.out.println("key found at "+keyIndex);
	}

	public static void main(String[] args) {
		findElementByLinearSearch(92);
	}

}
