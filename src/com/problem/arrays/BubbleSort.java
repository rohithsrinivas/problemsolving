package com.problem.arrays;

public class BubbleSort {
	
	public int[] bubbleSort(int[] input) {
		int temp;
		for(int i = 0 ; i < input.length - 1; i++) 
			for(int j = i + 1 ; j < input.length; j++) 
				if(input[i] > input[j]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			
		return input;
	}
	
	public static void main(String[] args) {
		int[] bubbleSort = new BubbleSort().bubbleSort(new int[] {1,6,9,2,5,32,56,21});
		for(int i : bubbleSort) System.out.println(i + " ");
	}

}
