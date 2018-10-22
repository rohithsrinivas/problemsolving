package com.problem.arrays;

public class ReverseTheArray {

	private int[] reverseTheElementsOfArray(int[] input) {
		int start = input[0];
		int end = input[input.length - 1];
		for (int i = 0, j = input.length - 1; i < (input.length / 2) && j > (input.length / 2); i++, j--) {
			int temp = input[i];
			input[i] = input[j];
			input[j] = temp;
		}
		
		return input;
	}
	
	private void printArray(int[] input) {
		for(int i = 0;i<input.length;i++) {
			System.out.println(input[i]);
		}
	}
	
	

	public static void main(String[] args) {
		int a[] = { 2, 8, 1, 78, 43, 23 ,90};
		ReverseTheArray array = new ReverseTheArray();
		array.printArray(a);
		int[] newArray = array.reverseTheElementsOfArray(a);
		System.out.println("after reversing array ");
		array.printArray(newArray);
	}

}
